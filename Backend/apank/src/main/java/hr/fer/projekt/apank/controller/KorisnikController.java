package hr.fer.projekt.apank.controller;

import hr.fer.projekt.apank.model.Anketa;
import hr.fer.projekt.apank.model.Korisnik;
import hr.fer.projekt.apank.model.dto.AnketaListDTO;
import hr.fer.projekt.apank.model.dto.IdDTO;
import hr.fer.projekt.apank.service.KorisnikService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/korisnik")
public class KorisnikController {

    private final KorisnikService korisnikService;

    @GetMapping("/all")
    public List<Korisnik> listKorisnici() {
        return korisnikService.listAll();
    }

    @PostMapping("/ankete")
    public List<AnketaListDTO> listAnkete(@RequestBody IdDTO idDTO) {
        List<AnketaListDTO> korisnikoveAnkete = new ArrayList<>();
        for (Anketa anketa : korisnikService.fetch(idDTO.getId()).get().getAnkete()) {
            korisnikoveAnkete.add(AnketaListDTO.builder()
                            .idAnkete(anketa.getIdAnkete())
                            .naslov(anketa.getNaslov())
                            .opis(anketa.getOpis())
                            .anonimna(anketa.isAnonimna())
                            .datumStvaranja(anketa.getDatumStvaranja())
                            .datumZavrsetka(anketa.getDatumZavrsetka())
                            .statusAnkete(anketa.getStatusAnkete().getNazivStatusa())
                            .build());
        }
        return korisnikoveAnkete;
    }


}
