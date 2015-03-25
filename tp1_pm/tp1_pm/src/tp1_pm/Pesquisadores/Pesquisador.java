package tp1_pm.Pesquisadores;

public abstract class Pesquisador {

    private int id;
    
    private int artigosPrimeiroAutor;
    private int artigosSegundoAutor;
    private int artigoTerceiroAutor;
    
    
    public Pesquisador(int id, int artigosPrimeiroAutor, int artigosSegundoAutor, 
                       int artigosTerceiroAutor){
        
        this.id = id;
        
        this.artigosPrimeiroAutor = artigosPrimeiroAutor;
        this.artigosSegundoAutor = artigosSegundoAutor;
        this.artigoTerceiroAutor = artigosTerceiroAutor;
        
    }
    
    // Alterar para privado quando criar o calculo de popularidade
    public float peso(){
        float pesoPrimeiro = this.artigosPrimeiroAutor;
        float pesoSegundo = (float) (this.artigosSegundoAutor / 2.0);
        float pesoTerceiro = (float) (this.artigoTerceiroAutor / 3.0);
        
        return pesoPrimeiro + pesoSegundo + pesoTerceiro;
    }
    
    public abstract int popularidade();
}

