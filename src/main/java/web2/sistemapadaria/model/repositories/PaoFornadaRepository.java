package web2.sistemapadaria.model.repositories;

import org.springframework.stereotype.Repository;
import web2.sistemapadaria.model.entities.FornadaPao;
import web2.sistemapadaria.model.entities.Pao;
import web2.sistemapadaria.util.ConnectionManager;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@Repository
public class PaoFornadaRepository implements GenericRepository<FornadaPao, Integer> {


    private final PaoRepository paoRepository;

    public PaoFornadaRepository(PaoRepository paoRepository) {
        this.paoRepository = paoRepository;
    }

    @Override
    public FornadaPao create(FornadaPao pf) throws ClassNotFoundException, SQLException {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));

        String sql = "INSERT INTO pao_fornada (pao, fornada, quantidade_pao) VALUES (?,?,?) RETURNING hora_entrada";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, pf.getPao().getId());
            ps.setInt(2, pf.getFornada().getId());
            ps.setInt(3, pf.getQuantidadePao());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pf.setHoraEntrada(rs.getTimestamp("hora_entrada", cal));

                    Pao pao = paoRepository.read(pf.getPao().getId());
                    pf.setPao(pao);
                    long segundos = pao.getTempoPreparo().toLocalTime().toSecondOfDay();

                    Timestamp horaSaidaCalculada = new Timestamp(pf.getHoraEntrada().getTime() + segundos * 1000);
                    pf.setHoraSaida(horaSaidaCalculada);

                    String sqlUpdate = "UPDATE pao_fornada SET hora_saida = ? WHERE pao = ? AND fornada = ?";
                    try (PreparedStatement ps2 = conn.prepareStatement(sqlUpdate)) {
                        ps2.setTimestamp(1, pf.getHoraSaida());
                        ps2.setInt(2, pf.getPao().getId());
                        ps2.setInt(3, pf.getFornada().getId());
                        ps2.executeUpdate();
                    }
                }
            }
        }

        return pf;
    }

    @Override
    public void update(FornadaPao pf) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE pao_fornada SET quantidade_pao = ? WHERE pao = ? AND fornada = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, pf.getQuantidadePao());
            ps.setInt(2, pf.getPao().getId());
            ps.setInt(3, pf.getFornada().getId());
            ps.executeUpdate();
        }
    }

    @Override
    public FornadaPao read(Integer k) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public void delete(FornadaPao pf) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM pao_fornada WHERE fornada = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, pf.getFornada().getId());
            ps.executeUpdate();
        }
    }

    public void deletePao(FornadaPao pf) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM pao_fornada WHERE fornada = ? AND pao = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, pf.getFornada().getId());
            ps.setInt(2, pf.getPao().getId());
            ps.executeUpdate();
        }
    }

    @Override
    public List<FornadaPao> readAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }
}
