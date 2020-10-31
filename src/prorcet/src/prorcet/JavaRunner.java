/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prorcet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haida
 */
public class JavaRunner {

    protected void callRunner() {
        try {

            // print a message
            System.out.println("Executing notepad.exe");

            // create a process and execute notepad.exe
            Process process = Runtime.getRuntime().exec("notepad.exe");

            // print another message
            System.out.println("Notepad should now open.");

        } catch (IOException ex) {
            Logger.getLogger(MenuGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
