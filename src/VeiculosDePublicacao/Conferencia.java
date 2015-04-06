package VeiculosDePublicacao;

public class Conferencia extends VeiculoDePublicacao{

    public Conferencia(int id) {
        super(id);
    }

    @Override
    public float fatorDeImpacto() {
      return super.fatorDeImpacto() + 1;
    }
    
}
