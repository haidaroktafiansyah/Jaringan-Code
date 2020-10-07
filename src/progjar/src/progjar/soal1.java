/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progjar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author haida
 */
class soal1 extends JFrame implements ActionListener {

    static JFrame f;
    static JLabel l;
    static JLabel l2;
    private static JTextArea textArea;
    static File selectedFile = null;
    //File Chooser
    static JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    static String data = null;

    public static void main(String args[]) {

        //open file chooser
        selectedFile = chooser();

        f = new JFrame("Read TXT");
        textArea = new JTextArea(5, 25);
        l = new JLabel("isi file inputan :");
        textArea.setText(baca(selectedFile));

        JPanel p = new JPanel();

        p.add(l);
        p.add(textArea);

        l2 = new JLabel("no file selected for open new file");
        JButton button1 = new JButton("open new file");
        JButton button2 = new JButton("save into new file");

        p.add(l2);
        p.add(button1);
        p.add(button2);

        f.add(p);

        soal1 f1 = new soal1();
        button1.addActionListener(f1);
        button2.addActionListener(f1);

        f.setSize(300, 300);

        f.show();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static File chooser() {

        jfc.setDialogTitle("Select an TXT file");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
        jfc.addChoosableFileFilter(filter);
        int returnValue = jfc.showOpenDialog(null);
        File selectedFile = null;

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            return selectedFile;
        } else {
            File f = new File("C:\\users\\haida\\Documents\\NetBeansProjects\\progjar\\src\\src\\progjar\\decoy.txt");
            return f;
        }
//        return selectedFile;
    }

    public static String baca(File selectedFile) {
        
        try {
            // Membuat input stream yang membaca dr file
            Scanner myReader = new Scanner(selectedFile);
            while (myReader.hasNext()) {
                if (data != null) {
                    data = new StringBuilder(String.valueOf(data)).append(myReader.nextLine()).append("\n").toString();
                } else {
                    data = myReader.next();
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("I/O error - ");
        }
        return data;
    }

    public void writefile(String nama, String data) {

        try {
            String str = data;
            try ( BufferedWriter writer = new BufferedWriter(new FileWriter( nama + ".txt"))) {
                writer.write(str);
            }
            System.out.println("File has been written");

        } catch (Exception e) {
            System.out.println("Could not create file");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String com = e.getActionCommand();

        if (com.equals("open new file")) {
            data=null;
            selectedFile = chooser();
            textArea.setText(baca(selectedFile));
            if (selectedFile.getName().equalsIgnoreCase("decoy.txt")) {
                l2.setText("the user cancelled the operation");
            } else {
                l2.setText(selectedFile.getPath());
            }
        } else {
            data = textArea.getText();
            jfc.setDialogTitle("Specify a file to save");
            jfc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
            jfc.addChoosableFileFilter(filter);

            int userSelection = jfc.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = jfc.getSelectedFile();
                System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                writefile(fileToSave.getAbsolutePath(), data);
            }
        }
    }
}
