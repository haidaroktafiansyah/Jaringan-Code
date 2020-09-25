/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haidar.jarkom;

/**
 *
 * @author haida
 */
public class inheexpro extends inhepro{
    
    private String nama = null;
    private String penyakit = null;
    public double tambahan = 0;
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


    public String getPenyakit() {
        return penyakit;
    }

    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }
    
    public void printall(){
        System.out.println("");
        System.out.println("nama :"+nama);
        System.out.println("penyakit :"+penyakit);
        System.out.println("ruangan :"+getRuangan());
        System.out.println("biaya perawatan + tambahan harga :"+ (getCost()+tambahan));
    }
}
