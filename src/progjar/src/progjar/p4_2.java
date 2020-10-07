/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progjar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.LineNumberInputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author haida
 */
public class p4_2 {

    static File selectedFile = null;
    //File Chooser
    static JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    public static void main(String[] args) throws IOException {
        //open file chooser
        selectedFile = chooser();
        count(selectedFile);
    }

    public static File chooser() {

        jfc.setDialogTitle("Select an TXT file");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
        jfc.addChoosableFileFilter(filter);
        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            return selectedFile;
        } else {
            File f = new File("C:\\users\\haida\\Documents\\NetBeansProjects\\progjar\\src\\src\\progjar\\decoy.txt");
            return f;
        }
    }

    public static void count(File file) throws IOException {
        //read file into stream, try-with-resources
        char c;
        int a;

        int ac = 0;
        int ic = 0;
        int uc = 0;
        int ec = 0;
        int oc = 0;
        
        System.out.println("kalimat dalam File :");
        LineNumberInputStream sline = null;
        FileInputStream sinput = null;
        
        try {

            sinput = new FileInputStream(file);
            sline = new LineNumberInputStream(sinput);
            
            while ((a = sline.read()) != -1) {

                c = (char) a;
                if (c == 'a') {
                    ac++;
                } else if (c == 'b') {
                    ic++;
                } else if (c == 'c') {
                    uc++;
                } else if (c == 'd') {
                    ec++;
                } else if (c == 'e') {
                    oc++;
                }
                System.out.print(c); 
            }
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("ERROR Occurs ");
        } finally {
            if (sinput != null) {
                sinput.close();
            }

            if (sline != null) {
                sline.close();
            }
        }
        System.out.println("");
        System.out.println("total huruf");
        System.out.println("a = " + ac);
        System.out.println("i = " + ic);
        System.out.println("u = " + uc);
        System.out.println("e = " + ec);
        System.out.println("o = " + oc);
    }
}
