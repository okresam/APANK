package hr.fer.projekt.apank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    List<OpcijaPitanja> opcijePitanja = new ArrayList<>();

}
