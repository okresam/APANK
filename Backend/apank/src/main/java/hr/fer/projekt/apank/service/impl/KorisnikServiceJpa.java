package hr.fer.projekt.apank.service.impl;

import hr.fer.projekt.apank.model.Korisnik;
import hr.fer.projekt.apank.repository.KorisnikRepository;
import hr.fer.projekt.apank.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class KorisnikServiceJpa implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;


    @Override
    public List<Korisnik> listAll() {
        return korisnikRepository.findAll();
    }

    @Override
    public Korisnik createKorisnik(Korisnik korisnik) {
        Assert.notNull(korisnik, "Mora se predati korisnik!");
        Assert.isNull(korisnik.getIdKorisnika(), "Id korisnika mora biti null!");
        return korisnikRepository.save(korisnik);
    }

    @Override
    public Optional<Korisnik> fetch(String email) {
        return korisnikRepository.findByEmail(email);
    }
}
