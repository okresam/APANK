package hr.fer.projekt.apank.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "odgovor")
public class Odgovor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_odgovora")
    private Long idOdgovora;

    @Column(name = "tekst_odgovora")
    private String tekstOdgovora;

    @Column(name = "datum_odgovora")
    private Date datumOdgovora;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_korisnika")
    private Korisnik korisnik;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pitanja")
    private Pitanje pitanje;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "odgovorsadrziopcije",
            joinColumns = { @JoinColumn(name = "id_odgovora") },
            inverseJoinColumns = { @JoinColumn(name = "id_opcije_pitanja") }
    )
    Set<OpcijaPitanja> opcijePitanja = new HashSet<>();

    public Odgovor() {

    }

    public Long getIdOdgovora() {
        return idOdgovora;
    }

    public String getTekstOdgovora() {
        return tekstOdgovora;
    }

    public void setTekstOdgovora(String tekstOdgovora) {
        this.tekstOdgovora = tekstOdgovora;
    }

    public Date getDatumOdgovora() {
        return datumOdgovora;
    }

    public void setDatumOdgovora(Date datumOdgovora) {
        this.datumOdgovora = datumOdgovora;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Pitanje getPitanje() {
        return pitanje;
    }

    public void setPitanje(Pitanje pitanje) {
        this.pitanje = pitanje;
    }

    public Set<OpcijaPitanja> getOpcijePitanja() {
        return opcijePitanja;
    }

    public void setOpcijePitanja(Set<OpcijaPitanja> opcijePitanja) {
        this.opcijePitanja = opcijePitanja;
    }
}
