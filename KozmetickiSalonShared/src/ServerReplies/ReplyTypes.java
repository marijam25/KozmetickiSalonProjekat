/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerReplies;

import java.io.Serializable;

/**
 *
 * @author milic
 */
public class ReplyTypes implements Serializable {
    public static final int ADD_NEW_CLIENT_REPLY = 1;
    public static final int ADD_NEW_COSMETIC_REPLY = 2;
    public static final int DELETE_COSMETIC_REPLY = 3;
    public static final int ADD_NEW_SERVICE_REPLY = 4;
    public static final int DELETE_SERVICE_REPLY = 5;
    public static final int ADD_NEW_APPOINTMENT_REPLY = 6;
    public static final int DELETE_APPOINTMENT_REPLY = 7;
    public static final int UPDATE_COSMETIC_REPLY = 8;
    public static final int SEARCH_SERVICE_REPLY = 9;
    public static final int UPDATE_APPOINTMENT_REPLY = 10;
    public static final int GET_ALL_COSMETIC_REPLY = 11;
    public static final int VRATI_SVE_KATEGORIJE_USLUGA_ODGOVOR = 12;
}
