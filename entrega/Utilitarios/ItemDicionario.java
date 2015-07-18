package Utilitarios;

/**
 * Classe que representa um item no dicionario, valor indexavel por chave
 */
public class ItemDicionario<TipoChave, TipoValor> {

    private TipoChave chave;
    private TipoValor valor;

    public ItemDicionario(TipoChave chave, TipoValor valor){
        this.chave = chave;
        this.valor = valor;
    }

    /**
     * @return chave do item
     */
    public TipoChave getChave(){
        return this.chave;
    }

    /**
     * @return valor respectivo do item
     */
    public TipoValor getValor(){
        return this.valor;
    }

}
