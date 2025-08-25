package web2.sistemapadaria.model.repositories;

import org.springframework.stereotype.Repository;
import web2.sistemapadaria.model.entities.Fornada;
import web2.sistemapadaria.model.entities.Pao;
import web2.sistemapadaria.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaoRepository implements GenericRepository<Pao, Integer> {


    @Override
    public Pao create(Pao p) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO pao (tipo, tempo_preparo) VALUES (?,?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, p.getTipo());
            ps.setTimestamp(2, new Timestamp(p.getTempoPreparo().getTime()));
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setId(rs.getInt(1));
                    p.setTipo(rs.getString("tipo"));
                    p.setTempoPreparo(rs.getTime("tempo_preparo"));
                }
            }
        }
        return p;
    }

    @Override
    public void update(Pao c) throws ClassNotFoundException, SQLException {
        //TODO
    }

    @Override
    public Pao read(Integer k) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM pao WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, k);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return DTO(rs, conn);
                }
            }
        }
        return null;
    }

    @Override
    public void delete(Pao c) throws ClassNotFoundException, SQLException {
        //TODO
    }

    @Override
    public List<Pao> readAll() throws ClassNotFoundException, SQLException {
        List<Pao> paes = new ArrayList<>();
        String sql = "SELECT * FROM pao";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                paes.add(DTO(rs, conn));
            }
        }
        return paes;
    }

    private Pao DTO(ResultSet rs, Connection conn) throws SQLException {
        Pao p = new Pao();
        p.setId(rs.getInt("id"));
        p.setTipo(rs.getString("tipo"));
        p.setTempoPreparo(rs.getTime("tempo_preparo"));
        return p;
    }
}
