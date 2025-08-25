package web2.sistemapadaria.controller;

import org.springframework.web.bind.annotation.*;
import web2.sistemapadaria.DTO.request.AdicionarPaoRequest;
import web2.sistemapadaria.model.entities.Fornada;
import web2.sistemapadaria.model.entities.FornadaPao;
import web2.sistemapadaria.model.entities.Pao;
import web2.sistemapadaria.service.FornadaService;

import java.sql.SQLException;
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

    @PostMapping("/adicionar-pao")
    public String adicionarPao(@RequestBody AdicionarPaoRequest request) throws SQLException, ClassNotFoundException {
        Pao pao = new Pao();
        pao.setId(request.getIdPao());

        Fornada fornada = new Fornada();
        fornada.setId(request.getIdFornada());

        int quantidade = request.getQuantidade();

        FornadaPao pf = fornadaService.adicionarPao(pao, fornada, quantidade);
        return "Pão: " + pf.getPao().getTipo() + " incluido com sucesso na fornada: " + pf.getFornada().getId();
    }
}
