package hr.fer.projekt.apank.model;

import jakarta.persistence.*;

@Entity
@Table(name = "opcijapitanja")
public class OpcijaPitanja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_opcije_pitanja")
    private Long idOpcijePitanja;

    @Column(name = "vrijednost", nullable = false)
    private String vrijednost;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pitanja")
    private Pitanje pitanje;

    public OpcijaPitanja() {

    }

    public Long getIdOpcijePitanja() {
        return idOpcijePitanja;
    }

    public String getVrijednost() {
        return vrijednost;
    }

    public void setVrijednost(String vrijednost) {
        this.vrijednost = vrijednost;
    }

    public Pitanje getPitanje() {
        return pitanje;
    }

    public void setPitanje(Pitanje pitanje) {
        this.pitanje = pitanje;
    }
}
