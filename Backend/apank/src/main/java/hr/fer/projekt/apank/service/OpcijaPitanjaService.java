package hr.fer.projekt.apank.service;

import hr.fer.projekt.apank.model.OpcijaPitanja;

public interface OpcijaPitanjaService {

    void createOpcijaPitanja(OpcijaPitanja opcijaPitanja);

    void deleteOpcijaPitanja(Long idOpcijePitanja);

    void updateOpcijaPitanja(OpcijaPitanja opcijaPitanja);

    OpcijaPitanja fetch(Long idOpcijePitanja);
}
