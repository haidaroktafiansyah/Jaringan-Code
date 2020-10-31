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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author haida
 */
public class FileHandler{

    static JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    
    protected File callOpen() {
        
        File srcFile = chooser();

        return srcFile;
    }

    protected void callWrite(String data) {
        
        File fileToSave = chooser();

        writefile(fileToSave.getAbsolutePath(), data);
    }

    
    private static File chooser() {

        jfc.setDialogTitle("Select an JAVA file");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("java", "java");
        jfc.addChoosableFileFilter(filter);
        int returnValue = jfc.showOpenDialog(null);
        File selectedFile = null;

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = jfc.getSelectedFile();
            return selectedFile;
        } else {
            File f = new File("decoy.java");
            return f;
        }
    }

    
    private void writefile(String nama, String data) {
        WriteFile wf = new WriteFile(nama, data);
        wf.start();
    }
    

    protected String readFile(File file){
        
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
            e2.printStackTrace();
        }
        
        return data;
    }
}
