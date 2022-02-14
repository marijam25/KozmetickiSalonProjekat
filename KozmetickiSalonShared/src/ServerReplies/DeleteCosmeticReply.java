/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerReplies;

/**
 *
 * @author milic
 */
public class DeleteCosmeticReply {
    private boolean success;

    public DeleteCosmeticReply(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
  
}
