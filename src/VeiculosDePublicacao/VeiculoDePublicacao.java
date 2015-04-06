package VeiculosDePublicacao;

import java.util.ArrayList;

public abstract class VeiculoDePublicacao {
    
    private int id;

    private ArrayList<Artigo> artigos = new ArrayList<Artigo>();

    protected int getNumeroCitacoes() {
        int citacoes = 0;
        for (Artigo a : this.artigos){
            citacoes += a.getQuantidadeDeCitacoes();
        }
        return citacoes;
    }

    protected int getNumeroArtigos() {
        return this.artigos.size();
    }

    public VeiculoDePublicacao(int id){
        this.id = id;
    }

    public void addArtigo(Artigo a) {
        this.artigos.add(a);
    }

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

    public int getId() {
        return this.id;
    }

    public String toString(){
        return "ID da Publicacao: " + id;
    }
}
