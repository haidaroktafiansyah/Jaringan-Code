/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haidar.minngu12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

/*
 * ServerChat.java
 * Copyright (C) 2016 Rizki Mufrizal <mufrizalrizki@gmail.com>
 *
 * Distributed under terms of the MIT license.
 */

 public class ServerChat {

    private static final int PORT = 9001;
    private static HashSet<String> names = new HashSet<>();
    private static HashSet<PrintWriter> printWriters = new HashSet<>();

    public static void main(String[] args) throws IOException {
        System.out.println("server jalan pada port : " + PORT);
        ServerSocket serverSocket = new ServerSocket(PORT);
        try {
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            serverSocket.close();
        }
    }

    private static class Handler extends Thread {

        private String name;
        private Socket socket;
        private BufferedReader bufferedReader;
        private PrintWriter printWriter;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                printWriter = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    printWriter.println("submitname");
                    name = bufferedReader.readLine();

                    if (name == null) {
                        return;
                    }

                    synchronized (names) {
                    
                        if (!names.contains(name)) {
                            names.add(name);
                            break;
                        }
                    
                    }
                }

                printWriter.println("nameaccepted");
                printWriters.add(printWriter);

                while (true) {
                    String input = bufferedReader.readLine();
                    
                    if (input == null) {
                        return;
                    }
                    
                    printWriters.stream().forEach((pw) -> {
                        pw.println("message " + name + " : " + input);
                    });

                }

            } catch (IOException e) {
                System.out.println(e);
            } finally {

                if (name != null) {
                    names.remove(name);
                }
            
                if (printWriter != null) {
                    printWriters.remove(printWriter);
                }
            
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }
}