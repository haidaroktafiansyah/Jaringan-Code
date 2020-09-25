/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haidar.jarkom;
import java.util.Scanner;
/**
 *
 * @author haida
 */
public class oop {
    public static void main(String[] args) {
        inheexpro  en = new inheexpro();
        Scanner sc = new Scanner(System.in);
        Scanner sci = new Scanner(System.in);
        
        String temp;
        int temp2;
        System.out.println("masukkan nama :" );
        temp = sc.nextLine();
        en.setNama(temp);
        System.out.println("masukkan penyakit :" );
        temp = sc.nextLine();
        en.setPenyakit(temp);
        System.out.println("masukkan ruangan :" );
        temp = sc.nextLine();
        en.setRuangan(temp);
        System.out.println("masukkan tambahan harga :" );
        temp2 = sci.nextInt();
        en.tambahan = temp2;
        
        en.printall();
    }
}
