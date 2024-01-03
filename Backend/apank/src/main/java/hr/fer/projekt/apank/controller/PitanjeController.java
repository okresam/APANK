package hr.fer.projekt.apank.controller;

import hr.fer.projekt.apank.model.Anketa;
import hr.fer.projekt.apank.model.Pitanje;
import hr.fer.projekt.apank.model.dto.IdDTO;
import hr.fer.projekt.apank.model.dto.PitanjeNewDTO;
import hr.fer.projekt.apank.model.dto.PitanjeUpdateDTO;
import hr.fer.projekt.apank.service.AnketaService;
import hr.fer.projekt.apank.service.PitanjeService;
import hr.fer.projekt.apank.service.TipPitanjaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pitanje")
public class PitanjeController {

    private final PitanjeService pitanjeService;
    private final AnketaService anketaService;
    private final TipPitanjaService tipPitanjaService;

    @PostMapping("/add")
    private void addPitanje(@RequestBody PitanjeNewDTO pitanjeNewDTO) {
        Anketa anketa = anketaService.getAnketa(pitanjeNewDTO.getIdAnkete());

        Pitanje pitanje = Pitanje.builder()
                .tekstPitanja(pitanjeNewDTO.getTekstPitanja())
                .obavezno(false)
                .tipPitanja(tipPitanjaService.fetch(pitanjeNewDTO.getIdTipaPitanja()))
                .anketa(anketa)
                .build();

        pitanjeService.createPitanje(pitanje);
    }

    @PostMapping("/update")
    private void updatePitanje(@RequestBody PitanjeUpdateDTO pitanjeUpdateDTO) {
        Pitanje existingPitanje = pitanjeService.fetch(pitanjeUpdateDTO.getIdPitanja());
        existingPitanje.setTekstPitanja(pitanjeUpdateDTO.getTekstPitanja());
        pitanjeService.updatePitanje(existingPitanje);
    }

    @PostMapping("/delete")
    private void deletePitanje(@RequestBody IdDTO idDTO) {
        pitanjeService.deletePitanje(Long.valueOf(idDTO.getId()));
    }
}
