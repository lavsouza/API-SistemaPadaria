package web2.sistemapadaria.DTO.response;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import web2.sistemapadaria.model.entities.Fornada;

public class FornadaResponseDTO {
    private int idFornada;
    private String dataHora;
    private List<FornadaPaoResponseDTO> paes;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public FornadaResponseDTO(Fornada fornada) {
        this.idFornada = fornada.getId();

        if (fornada.getDataHora() != null) {
            this.dataHora = formatTimestamp(fornada.getDataHora());
        }

        this.paes = fornada.getPaes()
                .stream()
                .map(FornadaPaoResponseDTO::new)
                .collect(Collectors.toList());
    }

    private String formatTimestamp(Timestamp ts) {
        LocalDateTime ldt = ts.toLocalDateTime();
        return ldt.format(FORMATTER);
    }

    public int getIdFornada() {
        return idFornada;
    }

    public void setIdFornada(int idFornada) {
        this.idFornada = this.idFornada;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public List<FornadaPaoResponseDTO> getPaes() {
        return paes;
    }

    public void setPaes(List<FornadaPaoResponseDTO> paes) {
        this.paes = paes;
    }
}