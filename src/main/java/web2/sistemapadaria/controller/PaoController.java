package web2.sistemapadaria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web2.sistemapadaria.model.entities.Pao;
import web2.sistemapadaria.service.PaoService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/pao")
public class PaoController {
    private final PaoService paoService;

    public PaoController(PaoService paoService) {
        this.paoService = paoService;
    }

    @GetMapping("/listar")
    public List<Pao> listaPaos() throws SQLException, ClassNotFoundException {
        return paoService.listarPaes();
    }
}
