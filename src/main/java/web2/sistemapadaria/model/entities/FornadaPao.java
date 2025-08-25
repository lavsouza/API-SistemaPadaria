package web2.sistemapadaria.model.entities;

import java.sql.Timestamp;

public class FornadaPao {

    private Pao pao;
    private Fornada fornada;
    private Integer quantidadePao;
    private Timestamp horaEntrada;
    private Timestamp horaSaida;

    public Timestamp getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Timestamp horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Timestamp getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Timestamp horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Pao getPao() {
        return pao;
    }

    public void setPao(Pao pao) {
        this.pao = pao;
    }

    public Fornada getFornada() {
        return fornada;
    }

    public void setFornada(Fornada fornada) {
        this.fornada = fornada;
    }

    public Integer getQuantidadePao() {
        return quantidadePao;
    }

    public void setQuantidadePao(Integer quantidadePao) {
        this.quantidadePao = quantidadePao;
    }
}
