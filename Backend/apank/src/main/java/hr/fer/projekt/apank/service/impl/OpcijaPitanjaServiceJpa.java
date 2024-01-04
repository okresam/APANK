package hr.fer.projekt.apank.service.impl;

import hr.fer.projekt.apank.model.OpcijaPitanja;
import hr.fer.projekt.apank.repository.OpcijaPitanjaRepository;
import hr.fer.projekt.apank.service.OpcijaPitanjaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpcijaPitanjaServiceJpa implements OpcijaPitanjaService {

    private final OpcijaPitanjaRepository opcijaPitanjaRepository;


    @Override
    public void createOpcijaPitanja(OpcijaPitanja opcijaPitanja) {
        opcijaPitanjaRepository.save(opcijaPitanja);
    }

    @Override
    public void deleteOpcijaPitanja(Long idOpcijePitanja) {
        opcijaPitanjaRepository.deleteById(idOpcijePitanja);
    }

    @Override
    public void updateOpcijaPitanja(OpcijaPitanja opcijaPitanja) {
        opcijaPitanjaRepository.save(opcijaPitanja);
    }

    @Override
    public OpcijaPitanja fetch(Long idOpcijePitanja) {
        return opcijaPitanjaRepository.findById(idOpcijePitanja).get();
    }
}
