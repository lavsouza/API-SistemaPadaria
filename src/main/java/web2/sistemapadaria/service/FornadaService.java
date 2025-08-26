package web2.sistemapadaria.service;

import org.springframework.stereotype.Service;
import web2.sistemapadaria.model.entities.Fornada;
import web2.sistemapadaria.model.entities.FornadaPao;
import web2.sistemapadaria.model.entities.Pao;
import web2.sistemapadaria.model.repositories.RepositoryFacade;

import java.sql.SQLException;
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

    public List<Fornada> readAllFornadas() throws SQLException, ClassNotFoundException {
        return repositoryFacade.readAllFornadas();
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
        repositoryFacade.incluirPao(pf);
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
