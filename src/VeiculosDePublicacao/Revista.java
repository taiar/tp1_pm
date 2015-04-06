package VeiculosDePublicacao;

public class Revista extends VeiculoDePublicacao{

    public Revista(int id) {
        super(id);
    }

    @Override
    public float fatorDeImpacto() {
      return super.fatorDeImpacto() + 2;
    }
    
}
