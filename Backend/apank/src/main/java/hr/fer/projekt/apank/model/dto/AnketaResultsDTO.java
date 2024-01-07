package hr.fer.projekt.apank.model.dto;

import hr.fer.projekt.apank.model.Korisnik;
import hr.fer.projekt.apank.model.StatusAnkete;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnketaResultsDTO {

    private Long idAnkete;
    private String naslov;
    private String opis;
    private boolean anonimna;
    private Date datumStvaranja;
    private Date datumZavrsetka;
    private StatusAnkete statusAnkete;
    private Korisnik autor;
    private List<PitanjeResultsDTO> pitanja;
}
