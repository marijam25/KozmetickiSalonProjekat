/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Threads.ListenerThread;

/**
 *
 * @author milic
 */
public class Server {
    public static void main(String[] args) {
        new ListenerThread(9000);
    }
}
