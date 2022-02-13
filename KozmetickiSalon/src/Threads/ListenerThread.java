/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

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
public class ListenerThread extends Thread {
    
    private ServerSocket ss;
    private ArrayList<ClientThread> clients;

    public ListenerThread(int port) {
        try {
            ss = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(ListenerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        clients = new ArrayList<ClientThread>();
        this.run();
    }
    
    @Override
    public void run(){
        while(true){
            try {
                Socket s = ss.accept();
                ClientThread ct = new ClientThread(s);
                clients.add(ct);
            } catch (IOException ex) {
                Logger.getLogger(ListenerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void disconnectAllClients(){
        for(ClientThread ct : clients){
            ct.disconnect();
        }
    }
    
    public void stopListening(){
        try {
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(ListenerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
