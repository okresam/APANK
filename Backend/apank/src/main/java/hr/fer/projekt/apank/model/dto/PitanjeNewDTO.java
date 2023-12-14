package hr.fer.projekt.apank.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PitanjeNewDTO {

    private String tekstPitanja;
    private boolean obavezno;
    private Long idAnkete;
}
