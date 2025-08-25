package web2.sistemapadaria.model.repositories;

import web2.sistemapadaria.model.entities.Fornada;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepository <CLASS, KEY>{

    public Fornada create(CLASS c)throws ClassNotFoundException, SQLException;
    public void update(CLASS c)throws ClassNotFoundException, SQLException;
    public CLASS read(KEY k)throws ClassNotFoundException, SQLException;
    public void delete(CLASS c)throws ClassNotFoundException, SQLException;
    public List<CLASS> readAll()throws ClassNotFoundException, SQLException;

}
