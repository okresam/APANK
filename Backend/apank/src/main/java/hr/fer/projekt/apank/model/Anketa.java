package hr.fer.projekt.apank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private List<Pitanje> pitanja;

}
