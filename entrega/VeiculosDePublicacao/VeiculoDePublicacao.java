package VeiculosDePublicacao;

import java.util.ArrayList;

/**
 * Um veiculo de publicacao e uma estrutura que contem artigos
 */
public abstract class VeiculoDePublicacao {
    
    private int id;

    private ArrayList<Artigo> artigos = new ArrayList<Artigo>();

    /**
     * @return numero de citacoes do veiculo de publicacao
     */
    protected int getNumeroCitacoes() {
        int citacoes = 0;
        for (Artigo a : this.artigos){
            citacoes += a.getQuantidadeDeCitacoes();
        }
        return citacoes;
    }

    /**
     * @return numero de artigos presente no veiculo
     */
    protected int getNumeroArtigos() {
        return this.artigos.size();
    }

    public VeiculoDePublicacao(int id){
        this.id = id;
    }

    /**
     * @param a artigo a ser adicionado ao veiculo
     */
    public void addArtigo(Artigo a) {
        this.artigos.add(a);
    }

    /**
     * @return fator de impacto do veiculo
     */
    public float fatorDeImpacto() {
        float r;
        try {
            r = (this.getNumeroCitacoes() / (float) this.artigos.size());
        }
        catch (ArithmeticException e) {
            r = 0;
        }
        return r;
    }

    /**
     * @return id do veiculo
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return representacao na forma de string do veiculo de publicacao
     */
    public String toString(){
        return "ID da Publicacao: " + id;
    }
}
