package web2.sistemapadaria.model.entities;

public class FornadaPao {

    private Pao pao;
    private Fornada fornada;
    private Integer quantidadePao;

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
