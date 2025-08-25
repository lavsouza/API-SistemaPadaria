package web2.sistemapadaria.model.repositories;

import org.springframework.stereotype.Repository;
import web2.sistemapadaria.model.entities.Fornada;

import java.sql.SQLException;
import java.util.List;

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

    public static RepositoryFacade getCurrentInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new RepositoryFacade();
        }
        return instance;
    }


    //METODOS FORNADA
    public void createFornada(Fornada f) throws SQLException, ClassNotFoundException {
        fornadaRepository.create(f);
    }

    public void updateFornada(Fornada f) throws SQLException, ClassNotFoundException {
        fornadaRepository.update(f);
    }

    public Fornada readFornada(int id) throws SQLException, ClassNotFoundException {
        return fornadaRepository.read(id);
    }

    public void deleteFornada(Fornada f) throws SQLException, ClassNotFoundException {
        fornadaRepository.delete(f);
    }

    public List<Fornada> readAllFornadas() throws SQLException, ClassNotFoundException {
        return fornadaRepository.readAll();
    }



}
