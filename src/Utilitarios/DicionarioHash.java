package Utilitarios;

import java.util.ArrayList;

/**
 * Created by ghapereira on 4/7/15.
 */
public class DicionarioHash<TipoChave, TipoValor> {
    private ArrayList<HashItem> armazenamento = new ArrayList<HashItem>();

    public void put(TipoChave chave, TipoValor valor){
        this.armazenamento.add(new HashItem<TipoChave, TipoValor>(chave, valor));
    }

    public TipoValor get(TipoChave chave) throws ExcecaoChaveInexistente{
        for(HashItem h : this.armazenamento){
            if(h.getChave().equals(chave)){
                return (TipoValor) h.getValor();
            }
        }

        // Caso nao tenha encontrado nenhum com a chave, excecao
        throw new ExcecaoChaveInexistente();
    }

    public ArrayList<TipoValor> values(){
        ArrayList<TipoValor> values = new ArrayList<TipoValor>();

        for(HashItem h : this.armazenamento){
            values.add((TipoValor) h.getValor());
        }

        return values;
    }

}
