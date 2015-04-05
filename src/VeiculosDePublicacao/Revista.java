package VeiculosDePublicacao;

public class Revista extends VeiculoDePublicacao{

    public Revista(int id) {
        super(id);
    }

    public float fatorDeImpacto() {
      return super.fatorDeImpacto() + 2;
    }
    
}
