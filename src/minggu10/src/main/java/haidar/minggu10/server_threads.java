/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haidar.minggu10;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haida
 */
public class server_threads implements Runnable {
    int parseport = 0;
    server_threads(String s){
        this.parseport = Integer.parseInt(s);
    }
    
    @Override
    public void run() {
        String connected = null;
        try {
            ServerSocket ss = new ServerSocket(parseport);
            boolean keadaan = true;
            int urut = 1;
            while (keadaan) {
                new server(ss.accept(), urut).start();
                if (connected == null) {
                    connected = "client ke-" + urut + "Masuk\n";
                } else {
                    connected = "client ke-" + urut + "Masuk\n";
                }
//                System.out.println("client ke-" + urut + "Masuk");
                urut++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Server_Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
