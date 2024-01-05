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
public class AnketaAutorStatusDTO {

    private Long idAnkete;
    private boolean anonimna;
    private Long idStatusaAnkete;
    private String statusAnkete;
    private Long autorId;
    private String autorEmail;
}
