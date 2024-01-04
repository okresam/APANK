package hr.fer.projekt.apank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "opcijapitanja")
public class OpcijaPitanja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_opcije_pitanja")
    private Long idOpcijePitanja;

    @Column(name = "vrijednost", nullable = false)
    private String vrijednost;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pitanja")
    private Pitanje pitanje;

}
