package hr.fer.projekt.apank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_ankete")
    private Anketa anketa;

    @OneToMany(mappedBy = "pitanje", cascade = CascadeType.REMOVE)
    private List<OpcijaPitanja> opcijePitanja;

    @JsonIgnore
    @OneToMany(mappedBy = "pitanje", cascade = CascadeType.REMOVE)
    private List<Odgovor> odgovori;

}
