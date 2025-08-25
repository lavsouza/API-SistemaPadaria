package web2.sistemapadaria.model.repositories;

import org.springframework.stereotype.Repository;
import web2.sistemapadaria.model.entities.Fornada;
import web2.sistemapadaria.model.entities.FornadaPao;
import web2.sistemapadaria.model.entities.Pao;
import web2.sistemapadaria.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public final class FornadaRepository implements GenericRepository<Fornada, Integer> {

    @Override
    public void create(Fornada c) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO fornada DEFAULT VALUES";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    c.setId(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public Fornada read(Integer id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM fornada WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return DTO(rs, conn);
                }
            }
        }
        return null;
    }

    @Override
    public void update(Fornada c) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE fornada SET data_hora = ? WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setTimestamp(1, c.getDataHora());
            ps.setInt(2, c.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(Fornada c) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM fornada WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public List<Fornada> readAll() throws ClassNotFoundException, SQLException {
        List<Fornada> fornadas = new ArrayList<>();
        String sql = "SELECT * FROM fornada";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                fornadas.add(DTO(rs, conn));
            }
        }
        return fornadas;
    }

    private Fornada DTO(ResultSet rs, Connection conn) throws SQLException {
        Fornada f = new Fornada();
        f.setId(rs.getInt("id"));
        f.setDataHora(rs.getTimestamp("data_hora"));
        f.setPaes(loadPaesFromFornada(f.getId(), conn));
        return f;
    }

    // --- busca os pães da fornada
    private List<FornadaPao> loadPaesFromFornada(int fornadaId, Connection conn) throws SQLException {
        List<FornadaPao> lista = new ArrayList<>();

        String sql = """
        SELECT p.id, p.tipo, p.tempo_preparo, pf.quantidade_pao, pf.hora_entrada
        FROM pao_fornada pf
        JOIN pao p ON p.id = pf.pao
        WHERE pf.fornada = ?
    """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, fornadaId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // monta o pão
                    Pao p = new Pao();
                    p.setId(rs.getInt("id"));
                    p.setTipo(rs.getString("tipo"));
                    p.setTempoPreparo(rs.getTime("tempo_preparo"));

                    // monta a relação
                    FornadaPao fp = new FornadaPao();
                    fp.setPao(p);
                    fp.setQuantidadePao(rs.getInt("quantidade_pao"));
                    fp.setHoraEntrada(Timestamp.valueOf(rs.getTimestamp("hora_entrada").toLocalDateTime()));

                    lista.add(fp);
                }
            }
        }
        return lista;
    }
}