/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haidar.minggu10;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haida
 */
class server extends Thread{
    static Socket sc = null;
    int angka = 0;
    server(Socket a, int angka){
        this.angka = angka;
        this.sc = a;
    }
    @Override
    public void run(){
        System.out.println("Client Connect "+sc.getInetAddress() + " onPort " + sc.getPort());
        try{
            PrintWriter out = new PrintWriter(sc.getOutputStream(), true);
            out.println("Sealamat Datang Client ke- " +angka);
        }catch(IOException ex){
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}