package VeiculosDePublicacao;

/**
 * Revista e um veiculo de publicacao. Ele contem artigos, como sua classe pai
 * e se diferencia de Conferencia pelo calculo do fator de impacto
 */

public class Revista extends VeiculoDePublicacao{

    public Revista(int id) {
        super(id);
    }

    @Override
    public float fatorDeImpacto() {
      return super.fatorDeImpacto() + 2;
    }
    
}
