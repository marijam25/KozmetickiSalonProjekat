/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import ClientRequests.AddNewClientRequest;
import ClientRequests.AddNewCosmeticRequest;
import ClientRequests.RequestTypes;
import Controler.Controler;
import ServerReplies.AddNewClientReply;
import ServerReplies.AddNewCosmeticReply;
import ServerReplies.ReplyTypes;
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
public class ClientThread extends Thread {

    private Socket s;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public ClientThread(Socket s) {
        this.s = s;
        this.run();
    }

    @Override
    public void run() {
        Controler c = Controler.getInstance();
        try {
            int requestType = ois.readInt();

            switch (requestType) {
                case RequestTypes.ADD_NEW_CLIENT_REQUEST: {
                    AddNewClientRequest request = (AddNewClientRequest) ois.readObject();

                    boolean uspeo = c.dodajNovogKlijenta(request.getKlijent());

                    AddNewClientReply reply = new AddNewClientReply(uspeo);
                    oos.write(ReplyTypes.ADD_NEW_CLIENT_REPLY);
                    oos.writeObject(reply);
                }

                case RequestTypes.ADD_NEW_COSMETIC_REQUEST: {
                    AddNewCosmeticRequest request = (AddNewCosmeticRequest) ois.readObject();

                    boolean uspeo = c.dodajNovogKozmeticara(request.getKozmeticar());

                    AddNewCosmeticReply reply = new AddNewCosmeticReply(uspeo);
                    oos.write(ReplyTypes.ADD_NEW_COSMETIC_REPLY);
                    oos.writeObject(reply);
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void disconnect() {
        try {
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
