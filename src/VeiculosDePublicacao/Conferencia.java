package VeiculosDePublicacao;

public class Conferencia extends VeiculoDePublicacao{

    public Conferencia(int id) {
        super(id);
    }

    public fatorDeImpacto() {
      return super.fatorDeImpacto() + 1;
    }
    
}
