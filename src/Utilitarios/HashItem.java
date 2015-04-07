package Utilitarios;

/**
 * Created by ghapereira on 4/7/15.
 */
public class HashItem<TipoChave, TipoValor> {

    private TipoChave chave;
    private TipoValor valor;

    public HashItem(TipoChave chave, TipoValor valor){
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
