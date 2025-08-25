package web2.sistemapadaria.DTO.response;

import web2.sistemapadaria.model.entities.FornadaPao;
import web2.sistemapadaria.model.entities.Pao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FornadaPaoResponseDTO {
    private int id;
    private String tipo;
    private int quantidade;
    private String horaEntrada;
    private String horaSaida;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    public FornadaPaoResponseDTO(FornadaPao fp) {
        this.id = fp.getPao().getId();
        this.tipo = fp.getPao().getTipo();
        this.quantidade = fp.getQuantidadePao();

        if (fp.getHoraEntrada() != null) {
            this.horaEntrada = formatTimestamp(fp.getHoraEntrada());
        }

        if (fp.getHoraSaida() != null) {
            this.horaSaida = formatTimestamp(fp.getHoraSaida());
        }
    }

    private String formatTimestamp(Timestamp ts) {
        LocalDateTime ldt = ts.toLocalDateTime();
        return ldt.format(FORMATTER);
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }
}
