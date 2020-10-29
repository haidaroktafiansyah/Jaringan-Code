/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prorcet;
import java.awt.Component;
import java.awt.Container;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * http://stackoverflow.com/questions/19435181/how-to-set-default-background-color-for-jtextpane
 */
public class testfile {
  public static void main(String... args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame("Example setting background color on JTextPane");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();
        pane.add(blackJTextPane());
        frame.setSize(800, 600);
        frame.setVisible(true);
      }

      private Component blackJTextPane() {
        JTextPane pane = new JTextPane();
        pane.setBackground(Color.BLACK);
        pane.setForeground(Color.WHITE);
        pane.setText("Here is example text");
        return pane;
      }
    });
  }
}