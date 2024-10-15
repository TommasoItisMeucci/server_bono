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
        Socket s = s1.accept();
        System.out.println("client collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        String stringaRicevuta = new String();
        String operazioneScelta = new String();
        
        do {

            //ricevo la stringa
            stringaRicevuta = in.readLine();
            

            //controllo di fine//
            if(stringaRicevuta .equals("exit")){
                stringaRicevuta = "!";
                System.out.println("server chiuso");
                break;
            }
            System.out.println("la stringa ricevuta è: " + stringaRicevuta);

            //ricevo operazione
            operazioneScelta = in.readLine();
            System.out.println("l'operazione scelta è: " + operazioneScelta);
           
            //controllo operazione
            switch (operazioneScelta) {
                case "M":
                        String stringaMaiuscola = stringaRicevuta.toUpperCase();
                        out.writeBytes(stringaMaiuscola + '\n');
                        System.out.println("string inviata");
                    break;
                
                case "m":
                        String stringaMinuscola = stringaRicevuta.toLowerCase();
                        out.writeBytes(stringaMinuscola + '\n');
                        System.out.println("string inviata");
                    break;

                case "r":
                        String stringaRibaltata = new StringBuilder(stringaRicevuta).reverse().toString();
                        out.writeBytes(stringaRibaltata + '\n');
                        System.out.println("string inviata");
                    break;

                case "c":
                        int lettere = 0;
                        lettere = stringaRicevuta.length();
                        out.writeBytes(lettere + "\n");
                        System.out.println("string inviata");
                    break;


                default:
                        String error = "!";
                        out.writeBytes(error + "\n");
                        System.out.println("notifica di errore");
                    break;
            }


        } while(true);
                
        s.close();
    }

}