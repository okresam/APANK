package hr.fer.projekt.apank.model;

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
@Table(name = "tippitanja")
public class TipPitanja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipa_pitanja")
    private Long idTipaPitanja;

    @Column(name = "naziv_tipa_pitanja", nullable = false)
    private String nazivTipaPitanja;

}
