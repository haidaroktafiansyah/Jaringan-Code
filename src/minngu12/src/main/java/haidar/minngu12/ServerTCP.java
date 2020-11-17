/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haidar.minngu12;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author haida
 */
public class ServerTCP {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(12345);
            Socket sk = ss.accept();
//BufferedReader br=new BufferedReader(
// new InputStreamReader(sk.getInputStream()));
//String line=br.readLine();
//System.out.println("ini dari klient ="+line);
            sk.close();
        } catch (Exception e) {
        }
    }
}
