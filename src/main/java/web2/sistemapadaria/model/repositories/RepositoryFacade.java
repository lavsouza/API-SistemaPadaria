package web2.sistemapadaria.model.repositories;

import org.springframework.stereotype.Repository;
import web2.sistemapadaria.model.entities.Fornada;

import java.sql.SQLException;
import java.util.List;

@Repository
public class RepositoryFacade {

    private final FornadaRepository fornadaRepository;
    private final PaoFornadaRepository paoFornadaRepository;
    private final PaoRepository paoRepository;

    public RepositoryFacade(FornadaRepository fornadaRepository,
                            PaoFornadaRepository paoFornadaRepository,
                            PaoRepository paoRepository) {
        this.fornadaRepository = fornadaRepository;
        this.paoFornadaRepository = paoFornadaRepository;
        this.paoRepository = paoRepository;
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
