package So;


import Domen.OpstiDomenskiObjekat;
import db.DBBroker;

public class SOZapamtiKozmeticara extends OpstaSistemskaOperacija {

    

    public SOZapamtiKozmeticara() {
        
    }

    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        operacijaUspesnoIzvrsena = DBBroker.getInstance().upisiUBazu(odo);
        return operacijaUspesnoIzvrsena;
    }

}
