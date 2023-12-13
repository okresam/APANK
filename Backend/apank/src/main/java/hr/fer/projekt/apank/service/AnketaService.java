package hr.fer.projekt.apank.service;

import hr.fer.projekt.apank.model.Anketa;

import java.util.List;

public interface AnketaService {

    void createAnketa(Anketa anketa);

    List<Anketa> getKorisnikAnkete(Long idAutora);
}
