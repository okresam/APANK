package hr.fer.projekt.apank.controller;

import hr.fer.projekt.apank.model.OpcijaPitanja;
import hr.fer.projekt.apank.model.Pitanje;
import hr.fer.projekt.apank.model.dto.IdDTO;
import hr.fer.projekt.apank.model.dto.OpcijaPitanjaNewDTO;
import hr.fer.projekt.apank.model.dto.OpcijaPitanjaUpdateDTO;
import hr.fer.projekt.apank.service.OpcijaPitanjaService;
import hr.fer.projekt.apank.service.PitanjeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/opcijapitanja")
public class OpcijaPitanjaController {

    private final OpcijaPitanjaService opcijaPitanjaService;
    private final PitanjeService pitanjeService;

    @PostMapping("/add")
    private OpcijaPitanja addOpcijaPitanja(@RequestBody OpcijaPitanjaNewDTO opcijaPitanjaNewDTO) {
        Pitanje pitanje = pitanjeService.fetch(opcijaPitanjaNewDTO.getIdPitanja());
        OpcijaPitanja opcijaPitanja = OpcijaPitanja.builder()
                .vrijednost(opcijaPitanjaNewDTO.getVrijednost())
                .pitanje(pitanje)
                .build();

        opcijaPitanjaService.createOpcijaPitanja(opcijaPitanja);
        return opcijaPitanja;
    }

    @PostMapping("/delete")
    private void deleteOpcijaPitanja(@RequestBody IdDTO idDTO) {
        opcijaPitanjaService.deleteOpcijaPitanja(Long.valueOf(idDTO.getId()));
    }

    @PostMapping("/update")
    private void updateOpcijaPitanja(@RequestBody OpcijaPitanjaUpdateDTO opcijaPitanjaUpdateDTO) {
        OpcijaPitanja existingOpcijaPitanja = opcijaPitanjaService.fetch(opcijaPitanjaUpdateDTO.getIdOpcijePitanja());
        existingOpcijaPitanja.setVrijednost(opcijaPitanjaUpdateDTO.getVrijednost());
        opcijaPitanjaService.updateOpcijaPitanja(existingOpcijaPitanja);
    }
}
