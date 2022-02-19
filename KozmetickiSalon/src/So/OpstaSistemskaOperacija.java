package So;

import db.DBBroker;

public abstract class OpstaSistemskaOperacija {

    protected boolean operacijaUspesnoIzvrsena;

    public OpstaSistemskaOperacija() {
        operacijaUspesnoIzvrsena = false;
    }

    public abstract boolean proveriPreduslov();

    public abstract void izvrsi();

    public void potvrdi() {
        DBBroker.getInstance().potvrdiTransakciju();
    }

    public void ponisti() {
        DBBroker.getInstance().ponistiTransakciju();
    }

    public boolean isOperacijaUspesnoIzvrsena() {
        return operacijaUspesnoIzvrsena;
    }

}
