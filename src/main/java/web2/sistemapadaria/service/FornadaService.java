package web2.sistemapadaria.service;

import org.springframework.stereotype.Service;
import web2.sistemapadaria.model.entities.Fornada;
import web2.sistemapadaria.model.entities.FornadaPao;
import web2.sistemapadaria.model.entities.Pao;
import web2.sistemapadaria.model.repositories.RepositoryFacade;

import java.sql.SQLException;

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

    public FornadaPao adicionarPao(Pao p, Fornada f, int quantidade) throws SQLException, ClassNotFoundException {
        FornadaPao pf = new FornadaPao();
        pf.setPao(p);
        pf.setFornada(f);
        pf.setQuantidadePao(quantidade);
        repositoryFacade.incluirPao(pf);
        return pf;
    }
}
