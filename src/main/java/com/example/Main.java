package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server avviato!");
        ServerSocket s1 = new ServerSocket(3000);
       /* do {
            Socket s = s1.accept();
            System.out.println("client collegato");
            MioThread t = new MioThread(s);
            t.start(); 
        } while (true);*/

        Socket s = s1.accept();
        System.out.println("client collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        String stringaRicevuta = new String();
        
        do {

            stringaRicevuta = in.readLine();
            System.out.println("la stringa ricevuta è: " + stringaRicevuta);

            if(stringaRicevuta .equals("exit")){
                stringaRicevuta = "!";
                break;
            }

            String stringaMaiuscola = stringaRicevuta.toUpperCase();
            out.writeBytes(stringaMaiuscola + '\n');
            System.out.println("string inviata");


        } while(!(stringaRicevuta.equals("exit")));
                
        s.close();
        s1.close();

        

    }

}