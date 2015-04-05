package VeiculosDePublicacao;

public class Revista extends VeiculoDePublicacao{

    public Revista(int id) {
        super(id);
    }

    public fatorDeImpacto() {
      return super.fatorDeImpacto() + 2;
    }
    
}
