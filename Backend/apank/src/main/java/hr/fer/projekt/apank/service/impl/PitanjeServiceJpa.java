package hr.fer.projekt.apank.service.impl;

import hr.fer.projekt.apank.model.Pitanje;
import hr.fer.projekt.apank.repository.PitanjeRepository;
import hr.fer.projekt.apank.service.PitanjeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PitanjeServiceJpa implements PitanjeService {

    private final PitanjeRepository pitanjeRepository;

    @Override
    public void createPitanje(Pitanje pitanje) {
        pitanjeRepository.save(pitanje);
    }

    @Override
    public void deletePitanje(Long idPitanja) {
        pitanjeRepository.deleteById(idPitanja);
    }

    @Override
    public void updatePitanje(Pitanje pitanje) {
        pitanjeRepository.save(pitanje);
    }

    @Override
    public Pitanje fetch(Long idPitanja) {
        return pitanjeRepository.findById(idPitanja).get();
    }
}
