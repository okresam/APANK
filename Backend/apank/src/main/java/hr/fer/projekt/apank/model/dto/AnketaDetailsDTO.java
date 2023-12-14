package hr.fer.projekt.apank.model.dto;

import hr.fer.projekt.apank.model.Pitanje;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnketaDetailsDTO {

    private Long idAnkete;
    private String naslov;
    private String opis;
    private boolean anonimna;
    private Date datumStvaranja;
    private Date datumZavrsetka;
    private String statusAnkete;
    private Long autorId;
    private String autorEmail;
    private List<Pitanje> pitanja;
}
