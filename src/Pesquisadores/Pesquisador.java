package Pesquisadores;

import VeiculosDePublicacao.Artigo;

import java.util.ArrayList;

public abstract class Pesquisador {
    
    protected int id;

    /* Como nao existe uma ordem maxima teorica para autoria, cada
     * objeto armazenara qual a sua ordem maxima para poder proceder
     * com o loop do calculo de peso */
    protected int autoriaMaxima;

    protected ArrayList<Integer> autoria = new ArrayList<Integer>();
    protected ArrayList<Artigo> artigos = new ArrayList<Artigo>();

    public Pesquisador(int id){
        this.id = id;
    }

    /* A autoria maxima pode ser modificada apenas utilizando este metodo,
       que e restrito as classes da hierarquia */
    protected void setAutoriaMaxima(int ordemAutoria){
        this.autoriaMaxima = ordemAutoria;
    }

    public int getId() {
        return this.id;
    }

    public void addArtigo(int ordemAutoria) {
        if(ordemAutoria > this.autoriaMaxima){
            this.setAutoriaMaxima(ordemAutoria);
        }

        int numeroAutoria = this.autoria.get(ordemAutoria - 1);
        this.autoria.add(ordemAutoria - 1, numeroAutoria + 1);
    }

    public int getNumeroArtigos(){
        return this.autoria.size();
    }

    protected int getNumeroCitacoes() {
        int citacoes = 0;
        for (Artigo a : this.artigos){
            citacoes += a.getQuantidadeDeCitacoes();
        }
        return citacoes;
    }

    private double peso() {
        double pesoTotal = 0;

        for(int i = 1; i <= this.autoriaMaxima; i++){
            pesoTotal += this.autoria.get(i - 1) / (double) i;
        }

        return pesoTotal;
        /*return (double) autoria[0] + (autoria[1] / 2.0) + (autoria[2] / 3.0) + (autoria[3] / 4.0) + (autoria[4] / 5.0)
                + (autoria[5] / 6.0) + (autoria[6] / 7.0) + (autoria[7] / 8.0) + (autoria[8] / 9.0) +
                (autoria[9] / 10.0);*/
    }

    public double popularidade() {
        return this.peso() + this.getNumeroArtigos() + this.getNumeroCitacoes();
    }

    public double getPopularidade() {
        return this.popularidade();
    }

    public double getPeso() {
        return this.peso();
    }

    public int getCitacoes() {
        return this.getNumeroCitacoes();
    }

    public void adicionaArtigo(Artigo artigo) {
        this.artigos.add(artigo);
    }

    public String toString(){
        return "ID do Pesquisador: " + id;
    }

    public String getTipo() {
        return "Genérico";
    }

    public String getAutorias() {
        String autorias = "";
        //p.autoria[0] + "," + p.autoria[1] + "," + p.autoria[2] + "," + p.autoria[3] + "," + p.autoria[4] + ")";
        for(int i = 0; i < this.autoriaMaxima; i++){
            autorias += String.valueOf(this.autoria.get(i));
            if(i < this.autoriaMaxima - 1){
                autorias += ",";
            }
        }

        return autorias;
    }
}

