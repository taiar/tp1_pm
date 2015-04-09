package Utilitarios;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by ghapereira on 4/7/15.
 */
public class Dicionario<TipoChave, TipoValor> {
    private Vector<ItemDicionario> armazenamento = new Vector<ItemDicionario>();


    // Refatorar esse metodo!!!!!!!!
    public void put(TipoChave chave, TipoValor valor){
        // Caso chave ja exista, insere valor no lugar da mesma
        int indiceAdicao = -1;

        for(ItemDicionario h : this.armazenamento){
            if(h.getChave().equals(chave)){
                indiceAdicao = this.armazenamento.indexOf(h);
            }
        }

        if(indiceAdicao == -1){ // Nao encontrou chave, insira um novo
            this.armazenamento.add(new ItemDicionario<TipoChave, TipoValor>(chave, valor));
        }else{
            // Encontrou chave, insira na posicao
            this.armazenamento.remove(indiceAdicao);
            this.armazenamento.add(indiceAdicao, new ItemDicionario<TipoChave, TipoValor>(chave, valor));
        }

    }

    public TipoValor get(TipoChave chave) throws ExcecaoChaveInexistente{
        for(ItemDicionario h : this.armazenamento){
            if(h.getChave().equals(chave)){
                return (TipoValor) h.getValor();
            }
        }

        // Caso nao tenha encontrado nenhum com a chave, excecao
        throw new ExcecaoChaveInexistente();
    }

    public ArrayList<TipoValor> values(){
        ArrayList<TipoValor> values = new ArrayList<TipoValor>();

        for(ItemDicionario h : this.armazenamento){
            values.add((TipoValor) h.getValor());
        }

        return values;
    }

    public ArrayList<TipoChave> keys(){
        ArrayList<TipoChave> keys = new ArrayList<TipoChave>();

        for(ItemDicionario h : this.armazenamento){
            keys.add((TipoChave) h.getChave());
        }

        return keys;
    }

    public int size(){
        return this.armazenamento.size();
    }

}
