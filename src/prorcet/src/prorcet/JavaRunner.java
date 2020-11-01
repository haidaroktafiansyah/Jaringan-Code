/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prorcet;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haida
 */
public class JavaRunner {
    
    private String filepath;
    
    protected void callCompile() {
        
        try {

            // create a process and execute notepad.exe
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"javac "+filepath+"\"");
        } catch (IOException ex) {
            Logger.getLogger(MenuGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JavaRunner(String path) {
        this.filepath = path;
    }

    void callRun() throws IOException {
        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java "+filepath+"\"");
    }
}
