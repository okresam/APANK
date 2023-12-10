package hr.fer.projekt.apank.model;

import jakarta.persistence.*;

@Entity
@Table(name = "statusankete")
public class StatusAnkete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_statusa_ankete")
    private Long idStatusaAnkete;

    @Column(name = "naziv_statusa", nullable = false)
    private String nazivStatusa;

    public StatusAnkete() {

    }

    public StatusAnkete(String nazivStatusa) {
        this.nazivStatusa = nazivStatusa;
    }

    public Long getIdStatusaAnkete() {
        return idStatusaAnkete;
    }

    public String getNazivStatusa() {
        return nazivStatusa;
    }

    public void setNazivStatusa(String nazivStatusa) {
        this.nazivStatusa = nazivStatusa;
    }
}
