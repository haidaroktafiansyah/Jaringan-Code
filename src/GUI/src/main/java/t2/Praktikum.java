/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2;
import java.net.InetAddress ;
import java.net.UnknownHostException ;
/**
 *
 * @author haida
 */
public class Praktikum {

    

    public static void main(String[] args) {
        try {
            InetAddress inet1= InetAddress.getByName("localhost");
            
            System.out.println("HostAddress=" + inet1.getHostAddress());
            
            InetAddress inet2 = InetAddress.getByName("127.0.0.1");
            
            System.out.println("HostName=" + inet2.getHostName());
            
            if (inet1.equals(inet2)) {
                System.out.println("Alamat sama !");
            } else {
                System.out.println("Alamat tidak sama !");
            }
            
        }
        catch (UnknownHostException uhe) {
        
            uhe.printStackTrace();
                
        }
    }
        
}
