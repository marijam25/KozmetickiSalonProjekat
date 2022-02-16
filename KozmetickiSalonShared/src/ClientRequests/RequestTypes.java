package ClientRequests;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author milic
 */
public class RequestTypes implements Serializable{
    public static final int ADD_NEW_CLIENT_REQUEST = 1;
    public static final int ADD_NEW_COSMETIC_REQUEST = 2;
    public static final int DELETE_COSMETIC_REQUEST = 3;
    public static final int ADD_NEW_SERVICE_REQUEST = 4;
    public static final int DELETE_SERVICE_REQUEST = 5;
    public static final int ADD_NEW_APPOINTMENT_REQUEST = 6;
    public static final int DELETE_APPOINTMENT_REQUEST = 7;
    public static final int UPDATE_COSMETIC_REQUEST = 8;
    public static final int SEARCH_SERVICE_REQUEST = 9;
    public static final int UPDATE_APPOINTMENT_REQUEST = 10;
    public static final int GET_ALL_COSMETIC_REQUEST = 11;
    public static final int VRATI_SVE_KATEGORIJE_USLUGA_ZAHTEV = 12;
}
