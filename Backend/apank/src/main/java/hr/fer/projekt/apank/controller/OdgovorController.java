package hr.fer.projekt.apank.controller;

import hr.fer.projekt.apank.model.Odgovor;
import hr.fer.projekt.apank.model.OpcijaPitanja;
import hr.fer.projekt.apank.model.dto.OdgovorNewDTO;
import hr.fer.projekt.apank.service.KorisnikService;
import hr.fer.projekt.apank.service.OdgovorService;
import hr.fer.projekt.apank.service.OpcijaPitanjaService;
import hr.fer.projekt.apank.service.PitanjeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/odgovor")
public class OdgovorController {

    private final OdgovorService odgovorService;
    //private final KorisnikService korisnikService;
    private final PitanjeService pitanjeService;
    private final OpcijaPitanjaService opcijaPitanjaService;

    @PostMapping("/add")
    private void addOdgovor(@RequestBody List<OdgovorNewDTO> odgovori) {
        for (OdgovorNewDTO odgovor : odgovori) {
            List<OpcijaPitanja> odgovorOpcije = new ArrayList<>();
            for (Long idOpcije : odgovor.getIdOpcijaPitanja()) {
                odgovorOpcije.add(opcijaPitanjaService.fetch(idOpcije));
            }

            Odgovor odgovorNew = Odgovor.builder()
                    .tekstOdgovora(odgovor.getTekstOdgovora())
                    .datumOdgovora(Date.valueOf(LocalDate.now()))
                    .pitanje(pitanjeService.fetch(odgovor.getIdPitanja()))
                    .opcijePitanja(odgovorOpcije)
                    .build();

            odgovorService.createOdgovor(odgovorNew);
        }

    }
}
