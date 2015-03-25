package tp1_pm.Pesquisadores;

public class Mestre extends Pesquisador{

    public Mestre(int id, int artigosPrimeiroAutor, int artigosSegundoAutor, int artigosTerceiroAutor) {
        super(id, artigosPrimeiroAutor, artigosSegundoAutor, artigosTerceiroAutor);
    }

    @Override
    public int popularidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
