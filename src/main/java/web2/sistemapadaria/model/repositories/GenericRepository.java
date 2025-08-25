package web2.sistemapadaria.model.repositories;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepository <CLASS, KEY>{

    public CLASS create(CLASS c)throws ClassNotFoundException, SQLException;
    public void update(CLASS c)throws ClassNotFoundException, SQLException;
    public CLASS read(KEY k)throws ClassNotFoundException, SQLException;
    public void delete(CLASS c)throws ClassNotFoundException, SQLException;
    public List<CLASS> readAll()throws ClassNotFoundException, SQLException;

}
