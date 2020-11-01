/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prorcet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dharma
 */
public class WriteFileWithThread extends Thread {

    private final String nama;
    private final String data;

    public WriteFileWithThread(String nama, String data) {
        this.nama = nama;
        this.data = data;
    }

    @Override
    public void run() {
        try {
            String str = data;
            FileWriter fileWritter = new FileWriter(nama, true);
            try ( BufferedWriter writer = new BufferedWriter(fileWritter)) {
                writer.write(str);
            }

        } catch (IOException e) {
            Logger.getLogger(MenuGUI.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Could not create file");
        }

    }

}
