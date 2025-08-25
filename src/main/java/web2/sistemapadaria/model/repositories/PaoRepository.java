package web2.sistemapadaria.model.repositories;

import org.springframework.stereotype.Repository;
import web2.sistemapadaria.model.entities.Fornada;
import web2.sistemapadaria.model.entities.Pao;

import java.sql.SQLException;
import java.util.List;

@Repository
public class PaoRepository implements GenericRepository<Pao, Integer> {


    @Override
    public Fornada create(Pao c) throws ClassNotFoundException, SQLException {

        return null;
    }

    @Override
    public void update(Pao c) throws ClassNotFoundException, SQLException {

    }

    @Override
    public Pao read(Integer k) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public void delete(Pao c) throws ClassNotFoundException, SQLException {

    }

    @Override
    public List<Pao> readAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }
}
