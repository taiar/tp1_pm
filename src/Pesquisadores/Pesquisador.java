package Pesquisadores;

public abstract class Pesquisador {
    
    protected int id;

    protected int artigosPrimeiroAutor;
    protected int artigosSegundoAutor;
    protected int artigoTerceiroAutor;

    protected int citacoes;

    public Pesquisador(int id){
        this.id = id;
    }

    protected void setArtigosPrimeiroAutor(int artigos){
        this.artigosPrimeiroAutor = artigos;
    }

    protected void setArtigosSegundoAutor(int artigos){
        this.artigosSegundoAutor = artigos;
    }

    protected void setArtigosTerceiroAutor(int artigos){
        this.artigoTerceiroAutor = artigos;
    }

    protected int getNumeroArtigos(){
        return this.artigosPrimeiroAutor + this.artigosSegundoAutor +
                this.artigoTerceiroAutor;
    }

    private float peso(){
        float pesoPrimeiro = this.artigosPrimeiroAutor;
        float pesoSegundo = (float) (this.artigosSegundoAutor / 2.0);
        float pesoTerceiro = (float) (this.artigoTerceiroAutor / 3.0);

        return pesoPrimeiro + pesoSegundo + pesoTerceiro;
    }

    protected float popularidade(){
        return this.peso() + this.getNumeroArtigos(); // + citacoes
    }

    public String toString(){
        return "ID do Pesquisador: " + id;
    }
}

