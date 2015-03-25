package tp1_pm.Pesquisadores;

public class Doutor extends Pesquisador{

    public Doutor(int id, int artigosPrimeiroAutor, int artigosSegundoAutor, int artigosTerceiroAutor) {
        super(id, artigosPrimeiroAutor, artigosSegundoAutor, artigosTerceiroAutor);
    }

    @Override
    public int popularidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}