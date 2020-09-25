/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author haida
 */
public class Addres_to_Name {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("inputkan IP Adress yang ingin anda cari Nama Hostnya !");
        String in = sc.next();

        try {
            
            InetAddress inet2 = InetAddress.getByName(in);
            
            System.out.println("HostName=" + inet2.getHostName());
            
            
        }
        catch (UnknownHostException uhe) {
        
            uhe.printStackTrace();
                
        }
    }
}
