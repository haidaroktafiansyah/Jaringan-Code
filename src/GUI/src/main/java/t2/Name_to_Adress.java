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
public class Name_to_Adress {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("inputkan Nama Host yang ingin anda cari alamat IP hostnya !");
        String in = sc.next();
         
        try {
            InetAddress inet1 = InetAddress.getByName(in);

            System.out.println("HostAddress atau Alamat hostnya Adalah=" + inet1.getHostAddress());


        } catch (UnknownHostException uhe) {

            uhe.printStackTrace();

        }
    }
}
