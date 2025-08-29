package web2.sistemapadaria.service;

import org.springframework.stereotype.Service;
import web2.sistemapadaria.model.entities.Fornada;
import web2.sistemapadaria.model.entities.FornadaPao;
import web2.sistemapadaria.model.entities.Pao;
import web2.sistemapadaria.model.repositories.RepositoryFacade;

import java.sql.SQLException;
import java.util.List;

@Service
public class PaoService {
    private final RepositoryFacade repositoryFacade;

    public PaoService(RepositoryFacade repositoryFacade) {
        this.repositoryFacade = repositoryFacade;
    }

    public List<Pao> listarPaes() throws SQLException, ClassNotFoundException {
        return repositoryFacade.listAllPaos();
    }

    public void deletarPaoFornada(int pao, int fornada) throws ClassNotFoundException, SQLException {
        FornadaPao pf = new FornadaPao();
        Fornada f = new Fornada();
        Pao p = new Pao();
        p.setId(pao);
        f.setId(fornada);
        pf.setFornada(f);
        pf.setPao(p);
        repositoryFacade.deletePaoFornada(pf);
    }
}
