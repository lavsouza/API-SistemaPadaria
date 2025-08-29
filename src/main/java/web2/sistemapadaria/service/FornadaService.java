package web2.sistemapadaria.service;

import org.springframework.stereotype.Service;
import web2.sistemapadaria.model.entities.Fornada;
import web2.sistemapadaria.model.entities.FornadaPao;
import web2.sistemapadaria.model.entities.Pao;
import web2.sistemapadaria.model.repositories.RepositoryFacade;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Service
public class FornadaService {
    private final RepositoryFacade repositoryFacade;

    public FornadaService(RepositoryFacade repositoryFacade) {
        this.repositoryFacade = repositoryFacade;
    }

    public Fornada criarFornada() throws Exception {
        Fornada f = new Fornada();
        repositoryFacade.createFornada(f);
        return f;
    }

    public Fornada readFornada(int id) throws SQLException, ClassNotFoundException {
        return repositoryFacade.readFornada(id);
    }

    public List<Fornada> buscarFornadaPorPao(int id) throws SQLException, ClassNotFoundException {
        return repositoryFacade.buscarFornadaPorPao(id);
    }

    public List<Fornada> readAllFornadas() throws SQLException, ClassNotFoundException {
        return repositoryFacade.readAllFornadas();
    }

    public List<Fornada> readAllFornadasAtivas() throws SQLException, ClassNotFoundException {
        LocalDate hoje = LocalDate.now();

        return repositoryFacade.readAllFornadas().stream()
                .filter(f -> f.getPaes() != null && !f.getPaes().isEmpty())
                .filter(f -> {
                    if (f.getDataHora() == null) return false;
                    LocalDate dataFornada = f.getDataHora().toLocalDateTime().toLocalDate();
                    return dataFornada.equals(hoje);
                })
                .toList();
    }

    public void excluirFornada(int id) throws SQLException, ClassNotFoundException {
        FornadaPao pf = new FornadaPao();
        Fornada f = new Fornada();
        f.setId(id);
        pf.setFornada(f);
        repositoryFacade.deletePaoFornada(pf);
        repositoryFacade.deleteFornada(f);
    }

    public FornadaPao adicionarPao(Pao p, Fornada f, int quantidade) throws SQLException, ClassNotFoundException {
        FornadaPao pf = new FornadaPao();
        pf.setPao(p);
        pf.setFornada(f);
        pf.setQuantidadePao(quantidade);
        repositoryFacade.incluirPaoFornada(pf);
        return pf;
    }

    public FornadaPao alterarQuantidadePaoFornada(Pao p, Fornada f, int quantidade) throws SQLException, ClassNotFoundException {
        FornadaPao pf = new FornadaPao();
        pf.setPao(p);
        pf.setFornada(f);
        pf.setQuantidadePao(quantidade);
        repositoryFacade.alterarQuantidadePaoFornada(pf);
        return pf;
    }
}
