package hr.fer.projekt.apank.controller;

import hr.fer.projekt.apank.model.Anketa;
import hr.fer.projekt.apank.model.Korisnik;
import hr.fer.projekt.apank.model.Pitanje;
import hr.fer.projekt.apank.model.dto.*;
import hr.fer.projekt.apank.service.AnketaService;
import hr.fer.projekt.apank.service.KorisnikService;
import hr.fer.projekt.apank.service.StatusAnketeService;
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
@RequestMapping("/anketa")
public class AnketaController {

    private final AnketaService anketaService;
    private final KorisnikService korisnikService;
    private final StatusAnketeService statusAnketeService;

    @PostMapping("/getByUser")
    private List<AnketaListDTO> getAnketeByKorisnik(@RequestBody IdDTO idDTO) {
        List<AnketaListDTO> korisnikoveAnkete = new ArrayList<>();
        for (Anketa anketa : anketaService.getKorisnikAnkete(Long.valueOf(idDTO.getId()))) {
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

    @PostMapping("/add")
    private void addAnketa(@RequestBody AnketaNewDTO anketaNewDTO) {
        Korisnik autor = korisnikService.fetch(anketaNewDTO.getEmail()).get();
        Anketa anketa = Anketa.builder()
                .naslov(anketaNewDTO.getNaslov())
                .opis(anketaNewDTO.getOpis())
                .anonimna(false)
                .datumStvaranja(Date.valueOf(LocalDate.now()))
                .datumZavrsetka(Date.valueOf(LocalDate.now().plusDays(10)))
                .statusAnkete(statusAnketeService.fetch(Long.valueOf("1")))
                .autor(autor)
                .build();

        anketaService.createAnketa(anketa);
    }

    @PostMapping("/get")
    private AnketaDetailsDTO getAnketa(@RequestBody IdDTO idDTO) {
        Anketa anketa = anketaService.getAnketa(Long.valueOf(idDTO.getId()));
        return AnketaDetailsDTO.builder()
                .idAnkete(anketa.getIdAnkete())
                .naslov(anketa.getNaslov())
                .opis(anketa.getOpis())
                .anonimna(anketa.isAnonimna())
                .datumStvaranja(anketa.getDatumStvaranja())
                .datumZavrsetka(anketa.getDatumZavrsetka())
                .idStatusaAnkete(anketa.getStatusAnkete().getIdStatusaAnkete())
                .statusAnkete(anketa.getStatusAnkete().getNazivStatusa())
                .autorId(anketa.getAutor().getIdKorisnika())
                .autorEmail(anketa.getAutor().getEmail())
                .pitanja(anketa.getPitanja())
                .build();
    }

    @PostMapping("/getAutorStatus")
    private AnketaAutorStatusDTO getAnketaAutorStatus(@RequestBody IdDTO idDTO) {
        Anketa anketa = anketaService.getAnketa(Long.valueOf(idDTO.getId()));
        return AnketaAutorStatusDTO.builder()
                .idAnkete(anketa.getIdAnkete())
                .anonimna(anketa.isAnonimna())
                .idStatusaAnkete(anketa.getStatusAnkete().getIdStatusaAnkete())
                .statusAnkete(anketa.getStatusAnkete().getNazivStatusa())
                .autorId(anketa.getAutor().getIdKorisnika())
                .autorEmail(anketa.getAutor().getEmail())
                .build();
    }

    @PostMapping("/getResults")
    private AnketaResultsDTO getAnketaResults(@RequestBody IdDTO idDTO) {
        Anketa anketa = anketaService.getAnketa(Long.valueOf(idDTO.getId()));
        List<PitanjeResultsDTO> pitanja = new ArrayList<>();
        for (Pitanje p : anketa.getPitanja()) {
            PitanjeResultsDTO pitanjeResultsDTO = PitanjeResultsDTO.builder()
                    .idPitanja(p.getIdPitanja())
                    .tekstPitanja(p.getTekstPitanja())
                    .obavezno(p.isObavezno())
                    .tipPitanja(p.getTipPitanja())
                    .odgovori(p.getOdgovori())
                    .build();
            pitanja.add(pitanjeResultsDTO);
        }

        AnketaResultsDTO anketaResultsDTO = AnketaResultsDTO.builder()
                .idAnkete(anketa.getIdAnkete())
                .naslov(anketa.getNaslov())
                .opis(anketa.getOpis())
                .anonimna(anketa.isAnonimna())
                .datumStvaranja(anketa.getDatumStvaranja())
                .datumZavrsetka(anketa.getDatumZavrsetka())
                .statusAnkete(anketa.getStatusAnkete())
                .autor(null)
                .pitanja(pitanja)
                .build();
        return anketaResultsDTO;
    }

    @PostMapping("/delete")
    private void deleteAnketa(@RequestBody IdDTO idDTO) {
        anketaService.deleteAnketa(Long.valueOf(idDTO.getId()));
    }

    @PostMapping("/changestate")
    private void anketaChangeState(@RequestBody IdDTO idDTO) {
        Anketa anketa = anketaService.getAnketa(Long.valueOf(idDTO.getId()));
        Long idNew = Math.min(3, anketa.getStatusAnkete().getIdStatusaAnkete() + 1);
        anketa.setStatusAnkete(statusAnketeService.fetch(idNew));
        anketaService.updateAnketa(anketa);
    }
    
}
