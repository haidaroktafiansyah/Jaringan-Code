package projek;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import javax.swing.text.*;

public class Main  {

private JTextPane textPane1;
private JTextPane textPane2;
private Document doc1;
private Document doc2;
private JFrame frame1;
private JFrame frame2;

private MutableAttributeSet black;    
private MutableAttributeSet red;
private AttributeSet attribute;    

public Main() throws BadLocationException {
    textPane1 = new JTextPane();

    black = new SimpleAttributeSet();
    red = new SimpleAttributeSet();
    StyleConstants.setForeground(black, Color.black);
    StyleConstants.setForeground(red, Color.red);
    textPane1.setEditorKit(new StyledEditorKit());                    
    doc1 = textPane1.getDocument();       

    append1("This is a Test!\n");

    //set color = red
    attribute = red;
    append1("Hello world! Hello Stackoverflow\n");        

    //set color = black
    attribute = black;
    append1("the text is black again\n");     


    //IMPORTANT PART: attribute of each character from the styled text will 
    //be transfered to the second textpanel
    StyledDocument styledDocument = textPane1.getStyledDocument();   
    Element element; 

    textPane2 = new JTextPane();
    textPane2.setEditorKit(new StyledEditorKit());

    doc2 = textPane2.getDocument(); 
    for(int i=0; i<styledDocument.getLength();i++) {
        element = styledDocument.getCharacterElement(i);
        AttributeSet attributeNew = element.getAttributes();   
        System.out.println(i);
        append2(styledDocument.getText(i, 1), attributeNew);    
    }

    createFrames();        
}

private void append1(String text){
    try {
        doc1.insertString(doc1.getLength(), text, attribute);
    } catch (BadLocationException ex) {
        ex.printStackTrace();
    }
}

private void append2(String text, AttributeSet attributeNew) {
    try {
        doc2.insertString(doc2.getLength(), text, attributeNew);
    } catch (BadLocationException ex) {
        ex.printStackTrace();
    }
}

private void createFrames() {
    frame1 = new JFrame("frame 1");     
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame1.setSize(400, 300);
    frame1.setLocationRelativeTo(null);
    frame1.getContentPane().add(new JScrollPane(textPane1), BorderLayout.CENTER);
    frame1.setVisible(true);

    frame2 = new JFrame("frame 2");
    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame2.setSize(400, 300);
    frame2.setLocation(300,0);
    frame2.getContentPane().add(new JScrollPane(textPane2), BorderLayout.CENTER);
    frame2.setVisible(true);
}

public static void main(String args[]) throws BadLocationException {
    new Main();     
}
}