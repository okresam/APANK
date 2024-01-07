package hr.fer.projekt.apank.service.impl;

import hr.fer.projekt.apank.model.Odgovor;
import hr.fer.projekt.apank.repository.OdgovorRepository;
import hr.fer.projekt.apank.service.OdgovorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OdgovorServiceJpa implements OdgovorService {

    private final OdgovorRepository odgovorRepository;

    @Override
    public void createOdgovor(Odgovor odgovor) {
        odgovorRepository.save(odgovor);
    }
}
