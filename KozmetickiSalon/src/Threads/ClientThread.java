/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Beans.Kozmeticar;
import Beans.Usluga;
import ClientRequests.AddNewAppointmentRequest;
import ClientRequests.AddNewClientRequest;
import ClientRequests.AddNewCosmeticRequest;
import ClientRequests.AddNewServiceRequest;
import ClientRequests.DeleteAppointmentRequest;
import ClientRequests.DeleteCosmeticRequest;
import ClientRequests.DeleteServiceRequest;
import ClientRequests.RequestTypes;
import ClientRequests.SearchServiceRequest;
import ClientRequests.UpdateAppointmentRequest;
import ClientRequests.UpdateCosmeticRequest;
import Controler.Controler;
import ServerReplies.AddNewAppointmentReply;
import ServerReplies.AddNewClientReply;
import ServerReplies.AddNewCosmeticReply;
import ServerReplies.AddNewServiceReply;
import ServerReplies.DeleteAppointmentReply;
import ServerReplies.DeleteCosmeticReply;
import ServerReplies.DeleteServiceReply;
import ServerReplies.GetAllCosmeticReply;
import ServerReplies.ReplyTypes;
import ServerReplies.SearchServiceReply;
import ServerReplies.UpdateAppointmentReply;
import ServerReplies.UpdateCosmeticReply;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
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
        try {
            this.s = s;
            oos = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());
            this.run();
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {
        Controler c = Controler.getInstance();
        while (true) {
            try {
                int requestType = ois.readInt();

                switch (requestType) {
                    case RequestTypes.ADD_NEW_CLIENT_REQUEST: {
                        AddNewClientRequest request = (AddNewClientRequest) ois.readObject();

                        boolean uspeo = c.dodajNovogKlijenta(request.getKlijent());

                        AddNewClientReply reply = new AddNewClientReply(uspeo);
                        oos.writeInt(ReplyTypes.ADD_NEW_CLIENT_REPLY);
                        oos.writeObject(reply);
                        break;
                    }

                    case RequestTypes.ADD_NEW_COSMETIC_REQUEST: {
                        AddNewCosmeticRequest request = (AddNewCosmeticRequest) ois.readObject();

                        boolean uspeo = c.dodajNovogKozmeticara(request.getKozmeticar());

                        AddNewCosmeticReply reply = new AddNewCosmeticReply(uspeo);
                        oos.writeInt(ReplyTypes.ADD_NEW_COSMETIC_REPLY);
                        oos.writeObject(reply);
                        break;
                    }

                    case RequestTypes.DELETE_COSMETIC_REQUEST: {
                        DeleteCosmeticRequest request = (DeleteCosmeticRequest) ois.readObject();

                        boolean uspeo = c.obrisiKozmeticara(request.getKozmeticar());

                        DeleteCosmeticReply reply = new DeleteCosmeticReply(uspeo);
                        oos.writeInt(ReplyTypes.DELETE_COSMETIC_REPLY);
                        oos.writeObject(reply);
                        break;
                    }

                    case RequestTypes.ADD_NEW_SERVICE_REQUEST: {
                        AddNewServiceRequest request = (AddNewServiceRequest) ois.readObject();

                        boolean uspeo = c.dodajNovuUslugu(request.getUsluga());

                        AddNewServiceReply reply = new AddNewServiceReply(uspeo);
                        oos.writeInt(ReplyTypes.ADD_NEW_SERVICE_REPLY);
                        oos.writeObject(reply);
                        break;
                    }

                    case RequestTypes.DELETE_SERVICE_REQUEST: {
                        DeleteServiceRequest request = (DeleteServiceRequest) ois.readObject();

                        boolean uspeo = c.obrisiUslugu(request.getUsluga());

                        DeleteServiceReply reply = new DeleteServiceReply(uspeo);
                        oos.writeInt(ReplyTypes.DELETE_SERVICE_REPLY);
                        oos.writeObject(reply);
                        break;
                    }

                    case RequestTypes.ADD_NEW_APPOINTMENT_REQUEST: {
                        AddNewAppointmentRequest request = (AddNewAppointmentRequest) ois.readObject();

                        boolean uspeo = c.dodajNoviTermin(request.getTermin());

                        AddNewAppointmentReply reply = new AddNewAppointmentReply(uspeo);
                        oos.writeInt(ReplyTypes.ADD_NEW_APPOINTMENT_REPLY);
                        oos.writeObject(reply);
                        break;
                    }

                    case RequestTypes.DELETE_APPOINTMENT_REQUEST: {
                        DeleteAppointmentRequest request = (DeleteAppointmentRequest) ois.readObject();

                        boolean uspeo = c.obrisiTermin(request.getTermin());

                        DeleteAppointmentReply reply = new DeleteAppointmentReply(uspeo);
                        oos.writeInt(ReplyTypes.DELETE_APPOINTMENT_REPLY);
                        oos.writeObject(reply);
                        break;
                    }

                    case RequestTypes.UPDATE_COSMETIC_REQUEST: {
                        UpdateCosmeticRequest request = (UpdateCosmeticRequest) ois.readObject();

                        boolean uspeo = c.azurirajKozmeticara(request.getKozmeticar());

                        UpdateCosmeticReply reply = new UpdateCosmeticReply(uspeo);
                        oos.writeInt(ReplyTypes.UPDATE_COSMETIC_REPLY);
                        oos.writeObject(reply);
                        break;
                    }

                    case RequestTypes.SEARCH_SERVICE_REQUEST: {
                        SearchServiceRequest request = (SearchServiceRequest) ois.readObject();

                        ArrayList<Usluga> nizUsluga = c.pretraziUsluge(request.getNazivUsluge(), request.getKategorijaID());

                        SearchServiceReply reply = new SearchServiceReply(nizUsluga);
                        oos.writeInt(ReplyTypes.SEARCH_SERVICE_REPLY);
                        oos.writeObject(reply);
                        break;
                    }

                    case RequestTypes.UPDATE_APPOINTMENT_REQUEST: {
                        UpdateAppointmentRequest request = (UpdateAppointmentRequest) ois.readObject();

                        boolean uspeo = c.azurirajTermin(request.getTermin());

                        UpdateAppointmentReply reply = new UpdateAppointmentReply(uspeo);
                        oos.writeInt(ReplyTypes.UPDATE_APPOINTMENT_REPLY);
                        oos.writeObject(reply);
                        break;
                    }

                    case RequestTypes.GET_ALL_COSMETIC_REQUEST: {
                        ArrayList<Kozmeticar> listaKozmeticara = c.vratiSveKozmeticare();

                        GetAllCosmeticReply reply = new GetAllCosmeticReply(listaKozmeticara);
                        oos.writeInt(ReplyTypes.GET_ALL_COSMETIC_REPLY);
                        oos.writeObject(reply);
                        break;
                    }
                }

            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                return;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                return;
            } catch(Exception ex){
                //Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Klijent disconectovan");
                return;
            }
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
