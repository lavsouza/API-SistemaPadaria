package web2.sistemapadaria.model.repositories;

import web2.sistemapadaria.model.entities.Fornada;

import java.sql.SQLException;
import java.util.List;

public final class FornadaRepository implements GenericRepository<Fornada, Integer> {


    @Override
    public void create(Fornada c) throws ClassNotFoundException, SQLException {

    }

    @Override
    public void update(Fornada c) throws ClassNotFoundException, SQLException {

    }

    @Override
    public Fornada read(Integer k) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public void delete(Fornada c) throws ClassNotFoundException, SQLException {

    }

    @Override
    public List<Fornada> readAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }
}
