package VeiculosDePublicacao;

public class Artigo {
    
    private int id;

    private int quantidadeDeCitacoes;

    private VeiculoDePublicacao veiculo;

    public Artigo(int id) {
      this.id = id;
    }

    public void incrementaQuantidadeDeCitacoes(){
        this.quantidadeDeCitacoes++;
    }

    public VeiculoDePublicacao getVeiculoDePublicacao() {
      return this.veiculo;
    }

    public void setVeiculoDePublicacao(VeiculoDePublicacao v) {
      this.veiculo = v;
    }

    public float qualidade() {
      return this.veiculo.fatorDeImpacto() * this.quantidadeDeCitacoes;
    }
}
