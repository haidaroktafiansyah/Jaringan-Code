/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prorcet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * 
 * @author Philipp Wilhelm 
 * Provides a JScrollPane with line-numbers
 */
public class EditorScrollPane extends JScrollPane {

  private static final long serialVersionUID = 1L;

  private JTextPane inputArea;
  private String indentation = "  ";
  private JTextPane lineNumbers;

  /*
   * Here the constructor creates a TextPane as an editor-field and another TextPane for the
   * line-numbers.
   */
  public EditorScrollPane(int width, int height) {
    // Editor-field
    inputArea = new JTextPane();
    inputArea.setPreferredSize(new Dimension(width, height));
    Document doc = inputArea.getDocument();

    // Replacing tabs with two spaces
    ((AbstractDocument) doc).setDocumentFilter(new DocumentFilter() {
      public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
          throws BadLocationException {
        super.insertString(fb, offset, text.replace("\t", indentation), attrs);
      }
    });

    // Line-numbers
    lineNumbers = new JTextPane();
    lineNumbers.setBackground(Color.GRAY);
    lineNumbers.setEditable(false);

    // Line-numbers should be right-aligned
    SimpleAttributeSet rightAlign = new SimpleAttributeSet();
    StyleConstants.setAlignment(rightAlign, StyleConstants.ALIGN_RIGHT);
    lineNumbers.setParagraphAttributes(rightAlign, true);

    doc.addDocumentListener(new DocumentListener() {
      @Override
      public void changedUpdate(DocumentEvent e) {
        lineNumbers();
      }

      @Override
      public void insertUpdate(DocumentEvent e) {
        lineNumbers();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        lineNumbers();
      }
    });
    // Setting font
    this.setFont(new Font("Monospaced", 12, Font.PLAIN));

    // Sets the main-component in the JScrollPane. this.add(inputArea) wasn't
    // enough in this case
    this.getViewport().add(inputArea);

    // Adds lineNumbers as row header on the left side of the main JTextPane
    this.setRowHeaderView(lineNumbers);
  }

    EditorScrollPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  private void lineNumbers() {
    try {
      String str = inputArea.getText();

      // Plain Style
      SimpleAttributeSet plain = new SimpleAttributeSet();
      StyleConstants.setFontFamily(plain, "Monospaced");
      StyleConstants.setFontSize(plain, 12);

      // Bold style
      SimpleAttributeSet bold = new SimpleAttributeSet();
      StyleConstants.setBold(bold, true);

      // Remove all from document
      Document doc = lineNumbers.getDocument();
      doc.remove(0, doc.getLength());

      // Calculating the number of lines
      int length = str.length() - str.replaceAll("\n", "").length() + 1;

      // Adding line-numbers
      for (int i = 1; i <= length; i++) {

        // Non-bold line-numbers
        if (i < length) {
          doc.insertString(doc.getLength(), i + "\n", plain);

        // Last line-number bold
        } else {
          doc.insertString(doc.getLength(), i + "\n", bold);
        }
      }
    } catch (BadLocationException e) {
      e.printStackTrace();
    }
  }

  /*
   * Setting indentation size in editor-field
   */
  public void setIndentationSize(int size) {
    String cache = indentation;
    indentation = "";
    for (int i = 0; i < size; i++) {
      indentation += " ";
    }
    // Replace all previous indentations (at beginning of lines)
    inputArea.setText(inputArea.getText().replaceAll(cache, indentation));
  }

  /*
   * Overrides the method getText().
   */
  public String getText() {
    return inputArea.getText();
  }

  /*
   * Overrides the method setText().
   */
  public void setText(String str) {
    inputArea.setText(str);
  }
}