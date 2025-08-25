package web2.sistemapadaria.DTO.request;

public class AdicionarAlterarPaoRequest {
    private int idPao;
    private int idFornada;
    private int quantidade;

    public int getIdPao() {
        return idPao;
    }

    public void setIdPao(int idPao) {
        this.idPao = idPao;
    }

    public int getIdFornada() {
        return idFornada;
    }

    public void setIdFornada(int idFornada) {
        this.idFornada = idFornada;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
