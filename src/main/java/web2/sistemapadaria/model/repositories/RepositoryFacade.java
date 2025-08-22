package web2.sistemapadaria.model.repositories;

import org.springframework.stereotype.Repository;
import web2.sistemapadaria.model.entities.FornadaPao;
import web2.sistemapadaria.model.entities.Pao;

import java.sql.SQLException;

@Repository
public class RepositoryFacade {

    private static RepositoryFacade instance;
    private FornadaRepository fornadaRepository;
    private PaoFornadaRepository paoFornadaRepository;
    private PaoRepository paoRepository;

    private RepositoryFacade() throws ClassNotFoundException, SQLException {
        this.fornadaRepository = new FornadaRepository();
        this.paoFornadaRepository = new PaoFornadaRepository();
        this.paoRepository = new PaoRepository();
    }


    //METODOS
}
