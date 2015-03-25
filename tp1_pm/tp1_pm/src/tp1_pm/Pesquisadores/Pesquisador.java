package tp1_pm.Pesquisadores;

public abstract class Pesquisador {
    private int id;

    // @todo: criar setters para estes atributos; não são inicializados
    // na criação!
    private int artigosPrimeiroAutor;
    private int artigosSegundoAutor;
    private int artigoTerceiroAutor;

    private int horas_ic;
    private int horas_estagio_docencia;

    public Pesquisador(int id, int horas_ic, int horas_estagio_docencia){

        this.id = id;
        this.horas_ic = horas_ic;
        this.horas_estagio_docencia = horas_estagio_docencia;

    }

    public void setArtigosPrimeiroAutor(int artigos){
        this.artigosPrimeiroAutor = artigos;
    }

    public void setArtigosSegundoAutor(int artigos){
        this.artigosSegundoAutor = artigos;
    }

    public void setArtigosTerceiroAutor(int artigos){
        this.artigoTerceiroAutor = artigos;
    }

    // Alterar para privado quando criar o calculo de popularidade
    private float peso(){
        float pesoPrimeiro = this.artigosPrimeiroAutor;
        float pesoSegundo = (float) (this.artigosSegundoAutor / 2.0);
        float pesoTerceiro = (float) (this.artigoTerceiroAutor / 3.0);

        return pesoPrimeiro + pesoSegundo + pesoTerceiro;
    }

    public int getNumeroArtigos(){
        return this.artigosPrimeiroAutor + this.artigosSegundoAutor +
                this.artigoTerceiroAutor;
    }

    public float popularidade(){
        return this.peso() + this.getNumeroArtigos(); // + citacoes
    }

    /**
     * @return the horas_ic
     */
    public int getHoras_ic() {
        return horas_ic;
    }

    /**
     * @return the horas_estagio_docencia
     */
    public int getHoras_estagio_docencia() {
        return horas_estagio_docencia;
    }
}

