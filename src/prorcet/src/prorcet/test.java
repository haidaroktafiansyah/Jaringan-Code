/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prorcet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class test {
   public static void main(String args[]) throws BadLocationException {
      JFrame frame = new JFrame("Demo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container container = frame.getContentPane();
      JTextPane textPane = new JTextPane();
      
      textPane.setBackground(Color.red);
      
      SimpleAttributeSet attributeSet = new SimpleAttributeSet();
      StyleConstants.setItalic(attributeSet, true);
      textPane.setCharacterAttributes(attributeSet, true);
      textPane.setText("Learn with Text and "); Font font = new Font("Verdana", Font.BOLD, 22);
      
      textPane.setFont(font);
      StyledDocument doc = textPane.getStyledDocument();
      Style style = textPane.addStyle("", null);
      StyleConstants.setForeground(style, Color.orange);
      StyleConstants.setBackground(style, Color.black);
      
      doc.insertString(doc.getLength(), "Video Tutorials ", style);
      
      JScrollPane scrollPane = new JScrollPane(textPane);
      container.add(scrollPane, BorderLayout.CENTER);
      frame.setSize(550, 300);
      frame.setVisible(true);
   }
}
