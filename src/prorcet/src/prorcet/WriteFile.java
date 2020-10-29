/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prorcet;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dharma
 */
public class WriteFile extends Thread {

    private final String text;
    private final String file;

    public WriteFile(String text, String file) {
        this.text = text;
        this.file = file;
    }

    @Override
    public void run() {
        BufferedOutputStream writer = null;
        try {
            if (!text.isEmpty() && !text.isBlank()) {
                writer = new BufferedOutputStream(new FileOutputStream(file));
                writer.write(text.getBytes());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (writer != null) {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
