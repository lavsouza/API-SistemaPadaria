package web2.sistemapadaria.model.repositories;

import org.springframework.stereotype.Repository;
import web2.sistemapadaria.model.entities.Fornada;
import web2.sistemapadaria.model.entities.FornadaPao;
import web2.sistemapadaria.model.entities.Pao;

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

    public Fornada readFornada(int id) throws SQLException, ClassNotFoundException {
        return fornadaRepository.read(id);
    }

    public void incluirPaoFornada(FornadaPao pf) throws SQLException, ClassNotFoundException {
        paoFornadaRepository.create(pf);
    }

    public void alterarQuantidadePaoFornada(FornadaPao pf) throws SQLException, ClassNotFoundException {
        paoFornadaRepository.update(pf);
    }

    public void deleteFornada(Fornada f) throws SQLException, ClassNotFoundException {
        fornadaRepository.delete(f);
    }

    public void deleteFornadaPao(FornadaPao pf) throws SQLException, ClassNotFoundException {
        paoFornadaRepository.delete(pf);
    }

    public void deletePaoFornada(FornadaPao pf) throws SQLException, ClassNotFoundException {
        paoFornadaRepository.deletePao(pf);
    }

    public List<Fornada> readAllFornadas() throws SQLException, ClassNotFoundException {
        return fornadaRepository.readAll();
    }

    public List<Fornada> buscarFornadaPorPao(int id) throws SQLException, ClassNotFoundException {
        return fornadaRepository.buscarFornadaPorPao(id);
    }


    //METODOS PAO
    public List<Pao> listAllPaos() throws SQLException, ClassNotFoundException {
        return paoRepository.readAll();
    }

}
