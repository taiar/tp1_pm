package Utilitarios;

/**
 * Created by ghapereira on 4/7/15.
 */
public class ItemDicionario<TipoChave, TipoValor> {

    private TipoChave chave;
    private TipoValor valor;

    public ItemDicionario(TipoChave chave, TipoValor valor){
        this.chave = chave;
        this.valor = valor;
    }

    public TipoChave getChave(){
        return this.chave;
    }
    public TipoValor getValor(){
        return this.valor;
    }

}
