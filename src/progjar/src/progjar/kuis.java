/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progjar;

import java.io.File;
import java.io.FileInputStream;
import java.io.PushbackInputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author haida
 */
public class kuis {

    static JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    public static void main(String[] args) {

        String srcFile = chooser();
        String outputfile = null;
        int karakter = 0;
        int kata = 1;
        int baris = 1;

        try ( PushbackInputStream pis = new PushbackInputStream(new FileInputStream(srcFile))) {
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
                    if ((char) byteData == '\n') {
                        baris++;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }

//        System.out.println(outputfile);
//        System.out.println("karakter : " + karakter);
//        System.out.println("kata : " + kata);
//        System.out.println("baris : " + baris);
        callgui(outputfile, karakter, kata, baris);

    }

    public static String chooser() {

        jfc.setDialogTitle("Select an TXT file");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
        jfc.addChoosableFileFilter(filter);
        int returnValue = jfc.showOpenDialog(null);
        File selectedFile = null;

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = jfc.getSelectedFile();
            return selectedFile.getAbsolutePath();
        } else {
            File f = new File("D:\\decoy.txt");
            return f.getAbsolutePath();
        }
    }

    private static void callgui(String outputfile, int karakter, int kata, int baris) {
        JFrame f = new JFrame("Output");
        JPanel p = new JPanel();
        JLabel l = new JLabel("isi file inputan :");
        JLabel l2 = new JLabel("karakter : "+karakter);
        JLabel l3 = new JLabel("kata : "+kata);
        JLabel l4 = new JLabel("baris : "+baris);
        
         
        JTextArea textArea = new JTextArea(outputfile);
        p.add(l);
        p.add(textArea);
        p.add(l2);
        p.add(l3);
        p.add(l4);

        f.add(p);


        f.pack();
        f.setLocationRelativeTo(null);
        f.setSize(300, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
