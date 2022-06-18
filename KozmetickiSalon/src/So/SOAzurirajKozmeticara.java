package So;

import Domen.Kozmeticar;
import Domen.OpstiDomenskiObjekat;
import db.DBBroker;

public class SOAzurirajKozmeticara extends OpstaSistemskaOperacija {

    

    public SOAzurirajKozmeticara() {
        
    }

    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        operacijaUspesnoIzvrsena = DBBroker.getInstance().azurirajUBazi(odo);
        return operacijaUspesnoIzvrsena;
    }
}
