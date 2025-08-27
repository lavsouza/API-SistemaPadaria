package web2.sistemapadaria.model.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Fornada {
    private int id;
    private Timestamp dataHora;
    private List<FornadaPao> paes = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public List<FornadaPao> getPaes() {
        return paes;
    }

    public void setPaes(List<FornadaPao> paes) {
        this.paes = paes;
    }
}
