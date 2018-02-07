/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author claudiastenberg
 */
public class BilServer {
 Database d = new Database(); // skapar ett objekt av databasen

    public BilServer() {
        int portNumber = 12555;

        try (ServerSocket listenSocket = new ServerSocket(portNumber); 
                // en socket hos servern som lyssnar på om en klient vill ansluta sig    
                // som parameter i konstruktorn anges nummret för den port man skall lyssna på
                Socket clientSocket = listenSocket.accept();
                //för att vänta på ett anslutningsförsök fårn någon klient anropas sedan metoden accept
                //väntar tills en klient vill ansluta sig, returnerar den Socket som skapats av klienten
                
                
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); 
                // skickar ström med data från den andra datorn
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                // läsa ström med data från den andra datorn
                //Vi har nu en ström in och en ström ut för att kommunicera med servern
                ) {

            String inputLine; // linen som skickas/läses in
            String outputLine; // linen som skickas/läses ut

            out.println("Vilket reg vill du få info om?");

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Getting message" + inputLine);
                outputLine = d.getCarReg(inputLine.trim());
                if (outputLine == null) {
                    out.println("Denna person finns inte i databasen");
                } else {
                    out.println(outputLine);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        BilServer ett = new BilServer(); 
    }
    
}
