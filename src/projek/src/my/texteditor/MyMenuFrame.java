package my.texteditor;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class MyMenuFrame extends JFrame implements ActionListener {
    private TextArea textArea = new TextArea("", 0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
    // first, create a MenuBar item
    private MenuBar menuBar = new MenuBar();
    private Menu file = new Menu();
    private Menu edit = new Menu();
    private Menu print = new Menu();
    private Menu help = new Menu();
    // File objects
    // open option
    private MenuItem open = new MenuItem();
    //  save option
    private MenuItem save = new MenuItem();
    // close option!
    private MenuItem close = new MenuItem();

    // Edit objects
    // color option
    private MenuItem color = new MenuItem();
    // font option
    private MenuItem font = new MenuItem();
    // print object
    private MenuItem printSend= new MenuItem();
    // help objects
    private MenuItem about= new MenuItem();
    private MenuItem home=new MenuItem();

    public MyMenuFrame() {
        // set the initial size of the window
        this.setSize(600, 400);
        // set the title of the window
        this.setTitle("MyNotepad");
        // set the default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // set a default font for the TextArea
        this.textArea.setFont(new Font("Century Gothic", Font.BOLD, 12));
        // this is why we didn't have to worry about the size of the TextArea!
        this.getContentPane().setLayout(new BorderLayout());
        // the BorderLayout bit makes it fill it automatically
        this.getContentPane().add(textArea);

        // add our menu bar into the GUI
        this.setMenuBar(this.menuBar);
        this.menuBar.add(this.file);
        this.menuBar.add(this.edit);
        this.menuBar.add(this.print);
        this.menuBar.add(this.help);

        // create file drop down menu
        this.file.setLabel("File");

        // create open option
        this.open.setLabel("Open");
        //action listener to know when it's been clicked
        this.open.addActionListener(this);
        // keyboard shortcut
        this.open.setShortcut(new MenuShortcut(KeyEvent.VK_O, false));
        // add it to the "File" menu
        this.file.add(this.open);

        // create save option
        this.save.setLabel("Save");
        //action listener to know when it's been clicked
        this.save.addActionListener(this);
        // keyboard shortcut
        this.save.setShortcut(new MenuShortcut(KeyEvent.VK_S, false));
        // add it to the "File" menu
        this.file.add(this.save);

        // create close option
        this.close.setLabel("Exit");
        // action listener to know when it's been clicked
        this.close.setShortcut(new MenuShortcut(KeyEvent.VK_X, false));
        // keyboard shortcut
        this.close.addActionListener(this);
        // add it to the "File" menu
        this.file.add(this.close);

        // create edit drop down menu
        this.edit.setLabel("Edit");
        this.edit.addActionListener(this);
        this.color.setLabel("Color");
        this.font.setLabel("Font");
        this.color.setShortcut(new MenuShortcut(KeyEvent.VK_C,false));
        // color and font change buttons added
        this.edit.add(this.color);
        this.edit.add(this.font);

        // print menu
        this.print.setLabel("Print");
        this.print.addActionListener(this);
        this.printSend.setLabel("Send to Printer");
        // send to printer button and shortcut keys added
        this.print.add(this.printSend);
        this.printSend.setShortcut(new MenuShortcut(KeyEvent.VK_P,false));

        // help menu
        this.help.setLabel("Help");
        this.about.setLabel("About");
        this.home.setLabel("Visit Home");
        this.about.setShortcut(new MenuShortcut(KeyEvent.VK_A,false));
        this.home.setShortcut(new MenuShortcut(KeyEvent.VK_H,false));
        this.help.addActionListener(this);
        // about and homepage buttons added
        this.help.add(this.about);
        this.help.add(this.home);

    }
    public void actionPerformed (ActionEvent e) {
        // if the source of the event was our "close" option
        if (e.getSource() == this.close)
            this.dispose(); // dispose all resources and close the application

            // if the source was the "open" option
        else if (e.getSource() == this.open) {
            JFileChooser open = new JFileChooser(); // open up a file chooser (a dialog for the user to browse files to open)
            int option = open.showOpenDialog(this); // get the option that the user selected (approve or cancel)
            // NOTE: because we are OPENing a file, we call showOpenDialog~
            // if the user clicked OK, we have "APPROVE_OPTION"
            // so we want to open the file
            if (option == JFileChooser.APPROVE_OPTION) {
                // clear the TextArea before applying the file contents
                this.textArea.setText("");
                try {
                    // create a scanner to read the file
                    Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
                    // while there's still something to read
                    while (scan.hasNext())
                        this.textArea.append(scan.nextLine() + "\n"); // append the line to the TextArea
                }
                catch (Exception ex) { // catch any exceptions
                    //write to the debug console
                    System.out.println(ex.getMessage());
                }
            }
        }

        //if the source of the event was the "save" option
        else if (e.getSource() == this.save) {
            //open a file chooser
            JFileChooser save = new JFileChooser();
            // similar to the open file, only this time we call
            int option = save.showSaveDialog(this);
            // showSaveDialog instead of showOpenDialog
            // if the user clicked OK
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    // create a buffered writer to write to a file
                    BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
                    // write the contents of the TextArea to the file
                    out.write(this.textArea.getText());
                    // close the file stream
                    out.close();
                }
                catch (Exception ex) { //catch any exceptions
                    //write to the debug console
                    System.out.println(ex.getMessage());
                }
            }
        }

        else if(e.getSource()==this.color){


        }

        else if(e.getSource()==this.font){
            JFileChooser font= new JFileChooser();
        }

        else if(e.getSource()==this.printSend){
            JFileChooser printSend= new JFileChooser();
        }

        else if(e.getSource()==this.about){
            JFileChooser about= new JFileChooser();
        }

        else if(e.getSource()==this.home){
            JFileChooser home= new JFileChooser();
        }


    }
}