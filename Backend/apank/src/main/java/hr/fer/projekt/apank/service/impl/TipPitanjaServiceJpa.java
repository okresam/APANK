package hr.fer.projekt.apank.service.impl;

import hr.fer.projekt.apank.model.TipPitanja;
import hr.fer.projekt.apank.repository.TipPitanjaRepository;
import hr.fer.projekt.apank.service.TipPitanjaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipPitanjaServiceJpa implements TipPitanjaService {

    private final TipPitanjaRepository tipPitanjaRepository;

    @Override
    public TipPitanja fetch(Long id) {
        return tipPitanjaRepository.findById(id).get();
    }
}
