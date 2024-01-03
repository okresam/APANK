package hr.fer.projekt.apank.service;

import hr.fer.projekt.apank.model.Pitanje;

public interface PitanjeService {

    void createPitanje(Pitanje pitanje);

    void deletePitanje(Long idPitanja);

    void updatePitanje(Pitanje pitanje);

    Pitanje fetch(Long idPitanja);
}
