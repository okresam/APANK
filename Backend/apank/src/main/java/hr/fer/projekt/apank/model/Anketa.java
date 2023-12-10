package hr.fer.projekt.apank.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "anketa")
public class Anketa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ankete")
    private Long idAnkete;

    @Column(name = "naslov")
    private String naslov;

    @Column(name = "opis")
    private String opis;

    @Column(name = "anonimna")
    private boolean anonimna;

    @Column(name = "datum_stvaranja")
    private Date datumStvaranja;

    @Column(name = "datum_zavrsetka")
    private Date datumZavrsetka;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_statusa_ankete")
    private StatusAnkete statusAnkete;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_autora")
    private Korisnik autor;

    @OneToMany(mappedBy = "anketa")
    private Set<Pitanje> pitanja;

    public Anketa() {

    }

    public Long getIdAnkete() {
        return idAnkete;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean isAnonimna() {
        return anonimna;
    }

    public void setAnonimna(boolean anonimna) {
        this.anonimna = anonimna;
    }

    public Date getDatumStvaranja() {
        return datumStvaranja;
    }

    public void setDatumStvaranja(Date datumStvaranja) {
        this.datumStvaranja = datumStvaranja;
    }

    public Date getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(Date datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public StatusAnkete getStatusAnkete() {
        return statusAnkete;
    }

    public void setStatusAnkete(StatusAnkete statusAnkete) {
        this.statusAnkete = statusAnkete;
    }

    public Korisnik getAutor() {
        return autor;
    }

    public void setAutor(Korisnik autor) {
        this.autor = autor;
    }

    public Set<Pitanje> getPitanja() {
        return pitanja;
    }

    public void setPitanja(Set<Pitanje> pitanja) {
        this.pitanja = pitanja;
    }
}
