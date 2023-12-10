package hr.fer.projekt.apank.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "pitanje")
public class Pitanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pitanja")
    private Long idPitanja;

    @Column(name = "tekst_pitanja")
    private String tekstPitanja;

    @Column(name = "obavezno")
    private boolean obavezno;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipa_pitanja")
    private TipPitanja tipPitanja;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_ankete")
    private Anketa anketa;

    @OneToMany(mappedBy = "pitanje")
    private Set<OpcijaPitanja> opcijePitanja;

    @OneToMany(mappedBy = "pitanje")
    private Set<Odgovor> odgovori;

    public Pitanje() {

    }

    public Long getIdPitanja() {
        return idPitanja;
    }

    public String getTekstPitanja() {
        return tekstPitanja;
    }

    public void setTekstPitanja(String tekstPitanja) {
        this.tekstPitanja = tekstPitanja;
    }

    public boolean isObavezno() {
        return obavezno;
    }

    public void setObavezno(boolean obavezno) {
        this.obavezno = obavezno;
    }

    public TipPitanja getTipPitanja() {
        return tipPitanja;
    }

    public void setTipPitanja(TipPitanja tipPitanja) {
        this.tipPitanja = tipPitanja;
    }

    public Anketa getAnketa() {
        return anketa;
    }

    public void setAnketa(Anketa anketa) {
        this.anketa = anketa;
    }

    public Set<OpcijaPitanja> getOpcijePitanja() {
        return opcijePitanja;
    }

    public void setOpcijePitanja(Set<OpcijaPitanja> opcijePitanja) {
        this.opcijePitanja = opcijePitanja;
    }

    public Set<Odgovor> getOdgovori() {
        return odgovori;
    }

    public void setOdgovori(Set<Odgovor> odgovori) {
        this.odgovori = odgovori;
    }
}
