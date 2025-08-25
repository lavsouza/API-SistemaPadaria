package web2.sistemapadaria.model.repositories;

import org.springframework.stereotype.Repository;
import web2.sistemapadaria.model.entities.FornadaPao;

import java.sql.SQLException;
import java.util.List;

@Repository
public class PaoFornadaRepository implements GenericRepository<FornadaPao, Integer> {


    @Override
    public FornadaPao create(FornadaPao c) throws ClassNotFoundException, SQLException {

        return null;
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
