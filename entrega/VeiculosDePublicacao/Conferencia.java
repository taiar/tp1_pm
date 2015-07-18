package VeiculosDePublicacao;

/**
 * Conferencia e um veiculo de publicacao. Ele contem artigos, como sua classe pai,
 * e se diferencia de Revista pelo calculo do fator de impacto
 */
public class Conferencia extends VeiculoDePublicacao{

    public Conferencia(int id) {
        super(id);
    }

    @Override
    public float fatorDeImpacto() {
      return super.fatorDeImpacto() + 1;
    }
    
}
