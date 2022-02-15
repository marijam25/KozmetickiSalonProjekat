/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientRequests;

import Beans.Kozmeticar;
import java.io.Serializable;

/**
 *
 * @author milic
 */
public class UpdateCosmeticRequest implements Serializable {
    private Kozmeticar kozmeticar;

    public UpdateCosmeticRequest(Kozmeticar kozmeticar) {
        this.kozmeticar = kozmeticar;
    }

    public Kozmeticar getKozmeticar() {
        return kozmeticar;
    }
}
