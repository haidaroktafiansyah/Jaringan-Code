/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haidar.minngu12;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author haida
 */
public class ClientTCP {

    public static void main(String[] args) throws IOException {
        Socket cl = new Socket("localhost", 12345);
        DataOutputStream dos = new DataOutputStream(cl.getOutputStream());
        dos.writeBytes("ini aq");
    }
}
