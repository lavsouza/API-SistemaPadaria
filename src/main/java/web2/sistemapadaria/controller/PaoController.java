package web2.sistemapadaria.controller;

import org.springframework.web.bind.annotation.*;
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

    @DeleteMapping("/excluir-pao-fornada/{pao}/{fornada}")
    public String deletePaoFornada(@PathVariable int pao, @PathVariable int fornada) throws SQLException, ClassNotFoundException {
        paoService.deletarPaoFornada(pao, fornada);
        return "Pao removido da fornada com sucesso!";
    }
}
