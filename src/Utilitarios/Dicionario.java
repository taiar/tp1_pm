package Utilitarios;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Classe que emula a interface de um HashMap. Inicialmente o utilizavamos, mas apos
 * obter a informacao de que isto nao seria possivel esta classe foi desenvolvida
 * para que os mesmos metodos pudessem ser utilizados. Ela nao e uma implementacao
 * de um Hash, apenas da possibilidade de se indexar um valor atraves de uma chave,
 * ambos parametrizados
 */
public class Dicionario<TipoChave, TipoValor> {
    /* Estrutura que armazena os itens. Optou-se pelo uso de um Vector
     * em detrimento de um ArrayList porque o Vector nos permite adicionar itens
     * a posicoes indexadas especificas. A adicao no ArrayList 'empurra'
     * objetos para outras posições */
    private Vector<ItemDicionario> armazenamento = new Vector<ItemDicionario>();


    /**
     * Insere um valor respectivo a uma chave na estrutura
     * @param chave
     * @param valor
     */
    public void put(TipoChave chave, TipoValor valor){
        int indiceAdicao = -1;

        // Encontra posicao para adicao
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

    /**
     * @param chave
     * @return valor respectivo a chave passada
     * @throws ExcecaoChaveInexistente
     */
    public TipoValor get(TipoChave chave) throws ExcecaoChaveInexistente{
        for(ItemDicionario h : this.armazenamento){
            if(h.getChave().equals(chave)){
                return (TipoValor) h.getValor();
            }
        }

        // Caso nao tenha encontrado nenhum com a chave, excecao
        throw new ExcecaoChaveInexistente();
    }

    /**
     * @return Valores existentes no dicionario, sem as chaves
     */
    public ArrayList<TipoValor> values(){
        ArrayList<TipoValor> values = new ArrayList<TipoValor>();

        for(ItemDicionario h : this.armazenamento){
            values.add((TipoValor) h.getValor());
        }

        return values;
    }

    /**
     * @return Todas as chaves existentes no dicionario
     */
    public ArrayList<TipoChave> keys(){
        ArrayList<TipoChave> keys = new ArrayList<TipoChave>();

        for(ItemDicionario h : this.armazenamento){
            keys.add((TipoChave) h.getChave());
        }

        return keys;
    }

    /**
     * @return Quantidade de itens no dicionario
     */
    public int size(){
        return this.armazenamento.size();
    }

}
