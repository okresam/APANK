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
@Table(name = "statusankete")
public class StatusAnkete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_statusa_ankete")
    private Long idStatusaAnkete;

    @Column(name = "naziv_statusa", nullable = false)
    private String nazivStatusa;

}
