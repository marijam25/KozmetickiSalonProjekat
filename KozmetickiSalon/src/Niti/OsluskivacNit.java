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
public class OsluskivacNit extends Thread {
    
    private ServerSocket ss;
    private ArrayList<KlijentskaNit> klijenti;

    public OsluskivacNit(int port) {
        try {
            ss = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(OsluskivacNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        klijenti = new ArrayList<KlijentskaNit>();
        this.run();
    }
    
    @Override
    public void run(){
        while(true){
            try {
                Socket s = ss.accept();
                KlijentskaNit ct = new KlijentskaNit(s);
                klijenti.add(ct);
            } catch (IOException ex) {
                Logger.getLogger(OsluskivacNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void raskiniKonekcijuSaSvimKlijentima(){
        for(KlijentskaNit ct : klijenti){
            ct.prekiniKonekciju();
        }
    }
    
    public void zaustaviSlusanje(){
        try {
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(OsluskivacNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
