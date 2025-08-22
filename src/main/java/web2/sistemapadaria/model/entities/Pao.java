package web2.sistemapadaria.model.entities;

import java.sql.Time;

public class Pao {
    private int id;
    private String tipo;
    private Time tempoPreparo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(Time tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
