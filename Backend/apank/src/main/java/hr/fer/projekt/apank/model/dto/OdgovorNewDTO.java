package hr.fer.projekt.apank.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OdgovorNewDTO {

    private String tekstOdgovora;
    private String emailKorisnika;
    private Long idPitanja;
    private List<Long> idOpcijaPitanja;
}
