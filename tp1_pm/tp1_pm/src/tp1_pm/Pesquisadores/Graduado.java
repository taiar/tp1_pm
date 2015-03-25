package tp1_pm.Pesquisadores;

public class Graduado extends Pesquisador{

    public Graduado(int id, int artigosPrimeiroAutor, int artigosSegundoAutor, 
                    int artigosTerceiroAutor) {
        super(id, artigosPrimeiroAutor, artigosSegundoAutor, 
              artigosTerceiroAutor);
    }

    @Override
    public int popularidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void printMeuPeso(){
        float f = super.peso();
        System.out.println(f);
    }
}
