package camisas;

public class Produto {
    private String nomeProduto;
    private String tamanho;
    private String cor;
    private String tipo;

    public Produto(String nomeProduto, String tamanho, String cor, String tipo) {
        this.nomeProduto = nomeProduto;
        this.tamanho = tamanho;
        this.cor = cor;
        this.tipo = tipo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "\nProduto = " + nomeProduto + "\nTamanho = " + tamanho + ""
        		+ "\nCor = " + cor + "\nTipo = " + tipo + "\n";
    }
}
