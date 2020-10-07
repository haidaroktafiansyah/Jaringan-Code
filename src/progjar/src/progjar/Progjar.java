/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progjar;

import java.io.*;
public class Progjar {

    public static void main(String args[]) {
        if (args.length != 2) // Two parameters are
        {
            System.err.println("Syntax -FileOutputStreamDemo src dest");
            return;
        }
        String source = args[0];
        String destination = args[1];
        try {
            OutputStream output;
            try (InputStream input = new FileInputStream(source)) {
                System.out.println("Opened " + source + "for reading.");
                output = new FileOutputStream(destination); // Ouput output file for output
                System.out.println("Opened " + destination + " for writing.");
                int data = input.read();
                while (data != -1) {
                    output.write(data);
                    data = input.read();
                }
            }
            output.close();
            System.out.println("I/O streams closed");
        } catch (IOException ioe) {
            System.err.println("I/O error - " + ioe);
        }
    }
}
