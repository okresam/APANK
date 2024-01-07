package hr.fer.projekt.apank.model.dto;

import hr.fer.projekt.apank.model.Odgovor;
import hr.fer.projekt.apank.model.TipPitanja;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PitanjeResultsDTO {

    private Long idPitanja;
    private String tekstPitanja;
    private boolean obavezno;
    private TipPitanja tipPitanja;
    private List<Odgovor> odgovori;
}
