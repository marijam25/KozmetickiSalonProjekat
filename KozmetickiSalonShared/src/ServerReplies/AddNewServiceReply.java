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
public class AddNewServiceReply implements Serializable{
    boolean success;

    public AddNewServiceReply(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
    
    
}
