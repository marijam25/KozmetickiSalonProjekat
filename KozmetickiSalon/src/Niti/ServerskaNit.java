/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milic
 */
public class ServerskaNit extends Thread {

    private ServerSocket ss;
    private ArrayList<KlijentskaNit> klijenti;

    public ServerskaNit(int port) {
        try {
            ss = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(ServerskaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        klijenti = new ArrayList<KlijentskaNit>();
        //this.run();
    }

    @Override
    public void run() {
        try {
            while(true){
                Socket klijentskiSocket = ss.accept();
                KlijentskaNit kNit = new KlijentskaNit(klijentskiSocket);
                klijenti.add(kNit);
                kNit.start();
            } 
        } 
        catch (IOException ex) {
            System.out.println("Server zaustavljen");
        } 
    }

    public void raskiniKonekcijuSaSvimKlijentima() {
        for (KlijentskaNit ct : klijenti) {
            ct.prekiniKonekciju();
        }
    }
    
    public void zaustaviSlusanje() {
        try {
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerskaNit.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("Server je zaustavljenkkk");
        }
    }
}
