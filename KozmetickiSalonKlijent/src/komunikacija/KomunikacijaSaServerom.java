/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milic
 */
public class KomunikacijaSaServerom {
    private static KomunikacijaSaServerom instanca;
    private Socket soket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public static KomunikacijaSaServerom getInstanca() {
        if(instanca==null)
            instanca = new KomunikacijaSaServerom("localhost", 9000);
        return instanca;
    }
    
    

    private KomunikacijaSaServerom(String host, int port) {
        try {
            soket = new Socket(host, port);
            oos = new ObjectOutputStream(soket.getOutputStream());
            ois = new ObjectInputStream(soket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }
    
    
    
}
