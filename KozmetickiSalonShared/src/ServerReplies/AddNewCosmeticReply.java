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
public class AddNewCosmeticReply implements Serializable {
    private boolean success;

    public AddNewCosmeticReply(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
