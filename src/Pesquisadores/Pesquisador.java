package Pesquisadores;

public abstract class Pesquisador {
    
    protected int id;

    private int[] autoria = new int[3];

    protected int citacoes;

    public Pesquisador(int id){
        this.id = id;
    }

    public void addArtigo(int ordemAutoria) {
        this.autoria[ordemAutoria] += 1;
    }

    protected int getNumeroArtigos(){
        return autoria[0] + autoria[1] + autoria[2];
    }

    private double peso() {
        return (double) autoria[0] + (autoria[1] / 2.0) + (autoria[2] / 3.0);
    }

    protected double popularidade(){
        return this.peso() + this.getNumeroArtigos(); // + citacoes
    }

    public String toString(){
        return "ID do Pesquisador: " + id;
    }
}

