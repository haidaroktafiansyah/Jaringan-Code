/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haidar.minggu10;

import java.net.*;
import java.io.*;



public class serverBasic{
    public static void main(String[] args)throws IOException {
        ServerSocket ss = new ServerSocket(1236);
        boolean keadaan = true;
        int urut = 1;
        while(keadaan){
            new server(ss.accept(), urut).start();
            System.out.println("client ke-" + urut + "Masuk");
            urut++;
        }
    }
}