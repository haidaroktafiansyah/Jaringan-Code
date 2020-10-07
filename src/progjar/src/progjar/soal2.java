/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progjar;

import java.io.*;

/**
 *
 * @author haida
 */
public class soal2 {

    public static void main(String args[]) {
        if (args.length != 2) // Two parameters arerequired, the source and destination
        {
            System.err.println("Syntax -FileOutputStreamDemo src dest");
            return;
        }
        String source = args[0];
        String destination = args[1];
        try {
            // Open source file for input
            InputStream input = new FileInputStream(source);
            System.out.println("Opened " + source + "for reading.");
            OutputStream output = new FileOutputStream(destination); // Ouput output file for output
            System.out.println("Opened " + destination+ " for writing.");
            int data = input.read();
            while (data != -1) {
                // Write byte of data to our file
                output.write(data);
                // Read next byte
                data = input.read();
            }
            // Close both streams
            input.close();
            output.close();
            System.out.println("I/O streams closed");
        } catch (IOException ioe) {
            System.err.println("I/O error - " + ioe);
        }
    }
}
