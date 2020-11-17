/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haidar.minngu12;

import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * ClientChat.java
 * Copyright (C) 2016 Rizki Mufrizal <mufrizalrizki@gmail.com>
 *
 * Distributed under terms of the MIT license.
 */

public class ClientChat {

    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private JFrame jFrame = new JFrame("aplikasi chat");
    private JTextField jTextField = new JTextField(40);
    private JTextArea jTextArea = new JTextArea(8, 40);

    public ClientChat() {
        jTextField.setEditable(Boolean.FALSE);
        jTextArea.setEditable(Boolean.FALSE);
        jFrame.setSize(500, 500);
        jFrame.getContentPane().add(jTextField, "North");
        jFrame.getContentPane().add(new JScrollPane(jTextArea), "Center");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation((dimension.width / 2) - (jFrame.getSize().width / 2), (dimension.height / 2) - (jFrame.getSize().height / 2));

        jTextField.addActionListener((ActionEvent e) -> {
            printWriter.println(jTextField.getText());
            jTextField.setText("");
        });
    }

    public String getServerAddress() {
        return JOptionPane.showInputDialog(
            jFrame,
            "masukan ip address",
            "selamat datang di aplikasi chat",
            JOptionPane.QUESTION_MESSAGE
        );
    }

    public String getName() {
        return JOptionPane.showInputDialog(
            jFrame,
            "Masukkan nama anda",
            "selamat datang di aplikasi chat",
            JOptionPane.QUESTION_MESSAGE
        );
    }

    private void run() throws IOException {
        String serverAddress = getServerAddress();
        Socket socket = new Socket(serverAddress, 9001);
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printWriter = new PrintWriter(socket.getOutputStream(), true);

        while (true) {
            String line = bufferedReader.readLine();
            if (line.startsWith("submitname")) {
                printWriter.println(getName());
            } else if (line.startsWith("nameaccepted")) {
                jTextField.setEditable(Boolean.TRUE);
            } else if (line.startsWith("message")) {
                jTextArea.append(line.substring(8) + "\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ClientChat clientChat = new ClientChat();
        clientChat.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientChat.jFrame.setVisible(Boolean.TRUE);
        clientChat.run();
    }

}