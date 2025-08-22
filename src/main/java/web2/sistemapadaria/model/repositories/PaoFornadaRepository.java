package web2.sistemapadaria.model.repositories;

import web2.sistemapadaria.model.entities.FornadaPao;

import java.sql.SQLException;
import java.util.List;

public final class PaoFornadaRepository implements GenericRepository<Integer, FornadaPao> {

    @Override
    public void create(Integer c) throws ClassNotFoundException, SQLException {

    }

    @Override
    public void update(Integer c) throws ClassNotFoundException, SQLException {

    }

    @Override
    public Integer read(FornadaPao k) throws ClassNotFoundException, SQLException {
        return 0;
    }

    @Override
    public void delete(Integer c) throws ClassNotFoundException, SQLException {

    }

    @Override
    public List<Integer> readAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }
}
