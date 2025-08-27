package web2.sistemapadaria.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import web2.sistemapadaria.DTO.request.AdicionarAlterarPaoRequest;
import web2.sistemapadaria.DTO.response.FornadaResponseDTO;
import web2.sistemapadaria.model.entities.Fornada;
import web2.sistemapadaria.model.entities.FornadaPao;
import web2.sistemapadaria.model.entities.Pao;
import web2.sistemapadaria.service.FornadaService;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fornada")
public class FornadaController {
    private final FornadaService fornadaService;

    public FornadaController(FornadaService fornadaService) {
        this.fornadaService = fornadaService;
    }

    @PostMapping("/criar")
    public FornadaResponseDTO criarFornada() throws Exception {
        Fornada f = fornadaService.criarFornada();
        return new FornadaResponseDTO(f);
    }

    @PostMapping("/adicionar-pao")
    public String adicionarPao(@RequestBody AdicionarAlterarPaoRequest request) throws SQLException, ClassNotFoundException {
        Pao pao = new Pao();
        pao.setId(request.getIdPao());

        Fornada fornada = new Fornada();
        fornada.setId(request.getIdFornada());

        int quantidade = request.getQuantidade();

        FornadaPao pf = fornadaService.adicionarPao(pao, fornada, quantidade);
        return "Pão: " + pf.getPao().getTipo() + " incluido com sucesso na fornada: " + pf.getFornada().getId();
    }

    @PutMapping("/alterar-quantidade")
    public String alterarQuantidadePao(@RequestBody AdicionarAlterarPaoRequest request) throws SQLException, ClassNotFoundException {
        Pao pao = new Pao();
        pao.setId(request.getIdPao());

        Fornada fornada = new Fornada();
        fornada.setId(request.getIdFornada());

        int quantidade = request.getQuantidade();

        FornadaPao pf = fornadaService.alterarQuantidadePaoFornada(pao, fornada, quantidade);
        return "Quantidade de pão alterada com sucesso!";
    }

    @GetMapping("/detalhar-fornada/{codFornada}")
    public FornadaResponseDTO detalharFornada(@PathVariable int codFornada) throws SQLException, ClassNotFoundException {
        Fornada fornada = fornadaService.readFornada(codFornada);
        return new FornadaResponseDTO(fornada);
    }

    @GetMapping("/detalhar-fornada-pao/{codPao}")
    public List<FornadaResponseDTO> buscarFornadaPorPao(@PathVariable int codPao) throws SQLException, ClassNotFoundException {
        return fornadaService.buscarFornadaPorPao(codPao)
                .stream()
                .map(FornadaResponseDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/listar-fornadas")
    public List<FornadaResponseDTO> listarFornadas() throws SQLException, ClassNotFoundException {
        return fornadaService.readAllFornadas()
                .stream()
                .map(FornadaResponseDTO::new)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/excluir/{codigo}")
    public String excluirFornada(@PathVariable int codigo) throws SQLException, ClassNotFoundException {
        fornadaService.excluirFornada(codigo);
        return "Fornada excluida com sucesso!";
    }

}
