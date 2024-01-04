package hr.fer.projekt.apank.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OpcijaPitanjaUpdateDTO {

    private Long idOpcijePitanja;
    private String vrijednost;
}
