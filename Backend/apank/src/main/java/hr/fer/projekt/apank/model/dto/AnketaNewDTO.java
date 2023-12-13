package hr.fer.projekt.apank.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnketaNewDTO {

    private String naslov;
    private String opis;
    private boolean anonimna;
    private Date datumZavrsetka;
    private String email;
}
