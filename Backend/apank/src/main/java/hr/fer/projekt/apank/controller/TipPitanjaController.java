package hr.fer.projekt.apank.controller;

import hr.fer.projekt.apank.model.TipPitanja;
import hr.fer.projekt.apank.service.TipPitanjaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tippitanja")
public class TipPitanjaController {

    private final TipPitanjaService tipPitanjaService;

    @GetMapping("/all")
    private List<TipPitanja> getAllTipPitanja() {
        return tipPitanjaService.listAll();
    }
}
