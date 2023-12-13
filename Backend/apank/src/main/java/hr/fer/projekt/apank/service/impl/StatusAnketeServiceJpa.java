package hr.fer.projekt.apank.service.impl;

import hr.fer.projekt.apank.model.StatusAnkete;
import hr.fer.projekt.apank.repository.StatusAnketeRepository;
import hr.fer.projekt.apank.service.StatusAnketeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatusAnketeServiceJpa implements StatusAnketeService {

    private final StatusAnketeRepository statusAnketeRepository;

    @Override
    public StatusAnkete fetch(Long id) {
        return statusAnketeRepository.findById(id).get();
    }
}
