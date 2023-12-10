package hr.fer.projekt.apank.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tippitanja")
public class TipPitanja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipa_pitanja")
    private Long idTipaPitanja;

    @Column(name = "naziv_tipa_pitanja", nullable = false)
    private String nazivTipaPitanja;

    public TipPitanja() {

    }

    public TipPitanja(String nazivTipaPitanja) {
        this.nazivTipaPitanja = nazivTipaPitanja;
    }

    public Long getIdTipaPitanja() {
        return idTipaPitanja;
    }

    public String getNazivTipaPitanja() {
        return nazivTipaPitanja;
    }

    public void setNazivTipaPitanja(String nazivTipaPitanja) {
        this.nazivTipaPitanja = nazivTipaPitanja;
    }
}
