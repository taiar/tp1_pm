package VeiculosDePublicacao;

import Pesquisadores.Pesquisador;

public class Artigo {
    
    private int id;

    private int quantidadeDeCitacoes;

    private VeiculoDePublicacao veiculo;
    private Pesquisador pesquisador;

    public Artigo(int id) {
      this.id = id;
    }

    public void addCitacao(){
        this.quantidadeDeCitacoes++;
    }

    public VeiculoDePublicacao getVeiculoDePublicacao() {
      return this.veiculo;
    }

    public void setVeiculoDePublicacao(VeiculoDePublicacao v) {
      this.veiculo = v;
    }

    public Pesquisador getPesquisador() {
        return pesquisador;
    }

    public void setPesquisador(Pesquisador pesquisador) {
        this.pesquisador = pesquisador;
    }

    public float qualidade() {
      return this.veiculo.fatorDeImpacto() * this.quantidadeDeCitacoes;
    }
}
