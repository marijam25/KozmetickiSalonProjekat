package Niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerskaNit extends Thread {

    private ServerSocket ss;
    private ArrayList<KlijentskaNit> klijenti;

    public ServerskaNit(int port) {
        try {
            ss = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(ServerskaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        klijenti = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket klijentskiSocket = ss.accept();
                KlijentskaNit kNit = new KlijentskaNit(klijentskiSocket);
                klijenti.add(kNit);
                kNit.start();
            }
        } catch (IOException ex) {
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
            
        }
    }
}
