package So;

import Domen.StavkaZakazivanja;
import Domen.Termin;
import Domen.ZakazivanjeTermina;
import db.DBBroker;

public class SOZapamtiTermin extends OpstaSistemskaOperacija {

    private StavkaZakazivanja stavkaZakazivanja;
    private ZakazivanjeTermina zakazivanjeTermina;
    private Termin termin;

    public SOZapamtiTermin(StavkaZakazivanja stavkaZakazivanja, ZakazivanjeTermina zakazivanjeTermina, Termin termin) {
        this.stavkaZakazivanja = stavkaZakazivanja;
        this.zakazivanjeTermina = zakazivanjeTermina;
        this.termin = termin;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        /*try {
            String upit = "insert into Termin(DatumTermina, VremeTermina) values (?,?)";
            PreparedStatement ps = DBBroker.getInstance().getKonekcija().prepareStatement(upit);
            java.sql.Date sqlDate = new java.sql.Date(termin.getDatumTermina().getTime());
            java.sql.Time sqlTime = new java.sql.Time(termin.getVremeTermina().getTime());
            ps.setDate(1, sqlDate);
            ps.setTime(2, sqlTime);
            ps.executeUpdate();

            upit = "insert into ZakazivanjeTermina(KozmeticarId, KlijentId) values (?,?)";
            ps = DBBroker.getInstance().getKonekcija().prepareStatement(upit);
            ps.setInt(1, zakazivanjeTermina.getKozmeticarId());
            ps.setInt(2, zakazivanjeTermina.getKlijentId());
            ps.executeUpdate();

            upit = "insert into StavkaZakazivanja(ZakazivanjeID,TerminID,UslugaID) VALUES ((select max(ZakazivanjeID) from zakazivanjetermina), (SELECT max(TerminID) from termin), ?)";
            ps = DBBroker.getInstance().getKonekcija().prepareStatement(upit);
            ps.setInt(1, stavkaZakazivanja.getUslugaId());
            ps.executeUpdate();

            operacijaUspesnoIzvrsena = true;
        } catch (SQLException ex) {
            operacijaUspesnoIzvrsena = false;
            Logger.getLogger(SODodajNoviTermin.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        operacijaUspesnoIzvrsena = DBBroker.getInstance().upisiUBazu(termin);
        if(!operacijaUspesnoIzvrsena)
            return;
        operacijaUspesnoIzvrsena = DBBroker.getInstance().upisiUBazu(zakazivanjeTermina);
        if(!operacijaUspesnoIzvrsena)
            return;
        int maxTermin = DBBroker.getInstance().vratiMaxId(termin);
        int maxZakaz = DBBroker.getInstance().vratiMaxId(zakazivanjeTermina);
        stavkaZakazivanja.setTerminId(maxTermin);
        stavkaZakazivanja.setZakazivanjeId(maxZakaz);
        operacijaUspesnoIzvrsena = DBBroker.getInstance().upisiUBazu(stavkaZakazivanja);
        
    }

}
