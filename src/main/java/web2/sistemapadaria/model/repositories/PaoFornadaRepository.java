package web2.sistemapadaria.model.repositories;

import web2.sistemapadaria.model.entities.FornadaPao;

import java.sql.SQLException;
import java.util.List;

public final class PaoFornadaRepository implements GenericRepository<FornadaPao, Integer> {


    @Override
    public void create(FornadaPao c) throws ClassNotFoundException, SQLException {

    }

    @Override
    public void update(FornadaPao c) throws ClassNotFoundException, SQLException {

    }

    @Override
    public FornadaPao read(Integer k) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public void delete(FornadaPao c) throws ClassNotFoundException, SQLException {

    }

    @Override
    public List<FornadaPao> readAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }
}
