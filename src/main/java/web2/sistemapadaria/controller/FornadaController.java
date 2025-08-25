package web2.sistemapadaria.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web2.sistemapadaria.model.entities.Fornada;
import web2.sistemapadaria.service.FornadaService;

import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/fornada")
public class FornadaController {
    private final FornadaService fornadaService;

    public FornadaController(FornadaService fornadaService) {
        this.fornadaService = fornadaService;
    }

    @PostMapping("/criar")
    public String criarFornada() throws Exception {
        Fornada f = fornadaService.criarFornada();
        return "Fornada " + f.getId() + " criada com sucesso ás: " + f.getDataHora().toLocalDateTime()
                .format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
