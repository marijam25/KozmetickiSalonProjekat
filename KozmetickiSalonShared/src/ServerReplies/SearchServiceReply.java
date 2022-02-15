/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerReplies;

import Beans.Usluga;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author milic
 */
public class SearchServiceReply implements Serializable {
    private ArrayList<Usluga> nizUsluga;

    public SearchServiceReply(ArrayList<Usluga> nizUsluga) {
        this.nizUsluga = nizUsluga;
    }

    public ArrayList<Usluga> getNizUsluga() {
        return nizUsluga;
    }
}
