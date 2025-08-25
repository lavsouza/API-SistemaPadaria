package web2.sistemapadaria.service;

import org.springframework.stereotype.Service;
import web2.sistemapadaria.model.entities.Fornada;
import web2.sistemapadaria.model.repositories.RepositoryFacade;

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
}
