/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author claudiastenberg
 */
public class BilClient {
    
    BilClient() {
        String hostName = "127.0.0.1";  //localhost
        int portNumber = 12555; // den samma portnumret som i servern

        try (Socket addressSocket = new Socket(hostName, portNumber); // en klient som vill koppla upp en förbindelse till en server
                //då skapas en Socket från klientens sida
                //i parametrarna anges serverns adress och portnummer
                PrintWriter out = new PrintWriter(addressSocket.getOutputStream(), true); // skickar ström med data från den andra datorn
                //då förbindelsen är klar anropas metoderna InputStream och OutputStream i klassen socket
                //detta för att få tillgång till två strömmar i förbindelsen, en ström för varje kommunikationsriktning.
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(addressSocket.getInputStream())); // läsa ström med data från den andra datorn
                ) {

            // detta ovan är allt som behövs göras från klients-sidan för att uprrätthålla förbindelsen 
            String fromServer;
            String fromUser;
            BufferedReader stdIn
                    = new BufferedReader(new InputStreamReader(System.in));// läser det användaren matar in 

            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer); // serverns user-kommunikation

                fromUser = stdIn.readLine(); // läser in det användaren matat in
                if (fromUser != null) { // om det användaren matat in inte är null
                    System.out.println("Client: " + fromUser); // användarens user-kommunikation
                    out.println(fromUser);
                }
            }
        } catch (UnknownHostException e) { // catchar Exceptions kap 11
            System.err.println("Don't know about host " + hostName);
            System.exit(1);

        } catch (IOException e) { // catchar Exceptions kap 11
            System.err.println("Couldn't get I/O for the connection to "
                    + hostName);
            System.exit(1);
        }

    }

    public static void main(String[] args) { // main hos client
        BilClient c = new BilClient();
    }
}
