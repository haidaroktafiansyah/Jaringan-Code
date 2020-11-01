/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prorcet;

import java.io.File;
import java.io.FileInputStream;
import java.io.PushbackInputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author haida
 */
public class FileControl {

    static JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    boolean append = true;
    FileHandler handler;
    Logger logger;

    public FileControl() throws IOException {

        handler = new FileHandler("default.log", append);

        logger = Logger.getLogger("haidar logger");

        logger.addHandler(handler);

        SimpleFormatter formatter = new SimpleFormatter();

        handler.setFormatter(formatter);
    }

    protected File callOpen() {

        File srcFile = chooser(1);

        return srcFile;
    }

    protected void callWrite(String data) {

        File fileToSave = chooser(2);

        writefile(fileToSave.getAbsolutePath(), data);
    }

    private File chooser(int code) {

        jfc.setDialogTitle("Select an JAVA file");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("java", "java");
        jfc.addChoosableFileFilter(filter);
        int returnValue;
        if (code == 1) {
            returnValue = jfc.showOpenDialog(null);
        }else{
            returnValue = jfc.showSaveDialog(null);
        }
        File selectedFile = null;

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = jfc.getSelectedFile();
            logger.info("success take file");
            return selectedFile;
        } else {
            File f = new File("decoy.java");
            return f;
        }
    }

    private void writefile(String nama, String data) {
        WriteFileWithThread wf = new WriteFileWithThread(nama, data);
        wf.start();
    }

    protected String readFile(File file) {

        String data = null;

        try ( PushbackInputStream pis = new PushbackInputStream(new FileInputStream(file))) {
            byte byteData;
            while ((byteData = (byte) pis.read()) != -1) {
                //System.out.print((char) byteData);
                if (data == null) {
                    data = "" + (char) byteData;
                } else {
                    data += "" + (char) byteData;
                }
            }
        } catch (Exception e2) {
        }

        return data;
    }
}
