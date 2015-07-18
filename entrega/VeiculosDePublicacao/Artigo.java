package VeiculosDePublicacao;

/**
 * Classe que representa um artigo, item que relaciona pesquisadores por autoria e
 * esta presente em revistas e conferencias
 */
public class Artigo {
    // identificador unico do artigo
    private int id;

    // numero de vezes em que foi citado por outros artigos
    private int quantidadeDeCitacoes;

    // Veiculo de publicacao no qual o artigo foi publicado
    private VeiculoDePublicacao veiculo;

    public Artigo(int id) {
      this.id = id;
    }

    /**
     * @return identificador unico do artigo
     */
    public int getId() {
        return this.id;
    }

    public void increaseQuantidadeDeCitacoes(){
        this.quantidadeDeCitacoes += 1;
    }

    /**
     * @return quantidade de vezes em que um artigo foi citado
     */
    public int getQuantidadeDeCitacoes() {
        return this.quantidadeDeCitacoes;
    }

    /**
     * @return veiculo de publicacao respectivo do artigo
     */
    public VeiculoDePublicacao getVeiculoDePublicacao() {
      return this.veiculo;
    }

    /**
     * @param v veiculo de publicacao respectivo do artigo
     */
    public void setVeiculoDePublicacao(VeiculoDePublicacao v) {
      this.veiculo = v;
    }

    /**
     * @return qualidade do artigo
     */
    public float qualidade() {
      return this.veiculo.fatorDeImpacto() * this.quantidadeDeCitacoes;
    }
}
