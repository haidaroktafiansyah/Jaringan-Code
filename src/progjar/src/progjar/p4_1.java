/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progjar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



/**
 *
 * @author haida
 */
public class p4_1 {

    public static void main(String[] args) throws IOException {
        //readerku
        
        FastReader s = new FastReader();
        System.out.println("input nama");
        String innama = s.nextLine();
        System.out.println("input isi file");
        String inisi = s.nextLine();

        createtxt(innama, inisi);
        
        
    }

    public static void createtxt(String fileName, String data)throws IOException {
        String str = data;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\"+fileName+".txt"))) {
            writer.write(str);
        } 
    }
    
    
    
    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
