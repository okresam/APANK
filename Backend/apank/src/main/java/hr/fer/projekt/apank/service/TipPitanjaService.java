package hr.fer.projekt.apank.service;

import hr.fer.projekt.apank.model.TipPitanja;

import java.util.List;

public interface TipPitanjaService {

    TipPitanja fetch(Long id);

    List<TipPitanja> listAll();
}
