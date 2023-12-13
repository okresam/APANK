package hr.fer.projekt.apank.service.impl;

import hr.fer.projekt.apank.model.Anketa;
import hr.fer.projekt.apank.repository.AnketaRepository;
import hr.fer.projekt.apank.service.AnketaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnketaServiceJpa implements AnketaService {

    private final AnketaRepository anketaRepository;

    @Override
    public void createAnketa(Anketa anketa) {
        anketaRepository.save(anketa);
    }

    @Override
    public List<Anketa> getKorisnikAnkete(Long idAutora) {
        return anketaRepository.findByAutor_IdKorisnika(idAutora);
    }
}
