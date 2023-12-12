package hr.fer.projekt.apank.controller;

import hr.fer.projekt.apank.model.Korisnik;
import hr.fer.projekt.apank.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/korisnik")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/all")
    public List<Korisnik> listKorisnici() {
        return korisnikService.listAll();
    }


}
