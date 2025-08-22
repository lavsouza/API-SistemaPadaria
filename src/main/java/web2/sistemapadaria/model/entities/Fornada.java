package web2.sistemapadaria.model.entities;

import java.sql.Time;
import java.util.List;

public class Fornada {
    private int id;
    private Time dataHora;
    private List<Pao> paos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getDataHora() {
        return dataHora;
    }

    public void setDataHora(Time dataHora) {
        this.dataHora = dataHora;
    }

    public List<Pao> getPaos() {
        return paos;
    }

    public void setPaos(List<Pao> paos) {
        this.paos = paos;
    }
}
