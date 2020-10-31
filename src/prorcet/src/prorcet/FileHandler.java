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

/**
 *
 * @author haida
 */
public class FileHandler extends MenuGUI{
    
    
    protected void callOpen(){
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("java", "java");
        chooser.addChoosableFileFilter(filter);
        chooser.addChoosableFileFilter(filter2);
//        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String pathfile = file.getAbsolutePath();

        super.spesification.setText("Spesification : " + file.getName());

        String outputfile = null;
        int karakter = 0;
        int kata = 1;
        int kalimat = 1;
        try ( PushbackInputStream pis = new PushbackInputStream(new FileInputStream(pathfile))) {
            byte byteData;
            while ((byteData = (byte) pis.read()) != -1) {
                //System.out.print((char) byteData);
                if (outputfile == null) {
                    outputfile = "" + (char) byteData;
                } else {
                    outputfile += "" + (char) byteData;
                }

                karakter++;
                if ((char) byteData == ' ' || (char) byteData == '\n') {
                    kata++;
                }
                if ((char) byteData == '.') {
                    kalimat++;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
    
    JFileChooser chooser2 = new JFileChooser();
    protected void callWrite(){
        
        chooser2.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("java", "java");
        chooser2.addChoosableFileFilter(filter);
        chooser2.addChoosableFileFilter(filter2);
        UIManager.put("FileChooser.openButtonText", "Save");
        SwingUtilities.updateComponentTreeUI(chooser2);
//        chooser2.showOpenDialog(null);
        
        File file = fh.chooser2.getSelectedFile();
        String pathfile = file.getAbsolutePath();
        String data = super.textPanel.getText();
        File fileToSave = fh.chooser2.getSelectedFile();
        
        writefile(fileToSave.getAbsolutePath(), data);
    }
        
    public void writefile(String nama, String data) {
        WriteFile wf = new WriteFile(nama,data);
        wf.start();
    }

}
