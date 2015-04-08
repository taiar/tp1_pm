package EntradaESaida;

import Pesquisadores.Doutor;
import Pesquisadores.Graduado;
import Pesquisadores.Mestre;
import Pesquisadores.Pesquisador;
import VeiculosDePublicacao.Artigo;
import VeiculosDePublicacao.Conferencia;
import VeiculosDePublicacao.Revista;
import VeiculosDePublicacao.VeiculoDePublicacao;
import Utilitarios.DicionarioHash;
import Utilitarios.ExcecaoChaveInexistente;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Regula a lógica da leitura da entrada do programa.
 */
public class Entrada {

    private String[] argumentos;
    private File[] entradas;

    /**
     * A ordem definida para a leitura dos arquivos de entrada, e que deve ser obedecida pela linha de comando é:
     *  arg[0] = pesquisadores.txt
     *  arg[1] = grafo_pesquisadores.txt
     *  arg[2] = grafo_artigos_pesquisadores.txt
     *  arg[3] = grafo_citacoes.txt
     *  arg[4] = veiculos.txt
     *  arg[5] = artigos_veiculos.txt
     */
    private static final DicionarioHash<String, Integer> mapeamentoEntrada;
    static {
        mapeamentoEntrada = new DicionarioHash<String, Integer>();
        mapeamentoEntrada.put("pesquisadores", 0);
        mapeamentoEntrada.put("grafo_pesquisadores", 1);
        mapeamentoEntrada.put("grafo_artigos_pesquisadores", 2);
        mapeamentoEntrada.put("grafo_citacoes", 3);
        mapeamentoEntrada.put("veiculos", 4);
        mapeamentoEntrada.put("artigos_veiculos", 5);
    }

    private static final int NUMERO_DE_ARQUIVOS = 6;

    public Entrada(String[] args) {
        this.entradas = new File[NUMERO_DE_ARQUIVOS];
        this.argumentos = args;
    }

    /**
     * Armazena os Pesquisadores lidos da entrada em um arraylist na posição correspondente ao seu ID.
     * @param pesquisadores
     * @return boolean
     */
    public boolean carregaPesquisadores(ArrayList<Pesquisador> pesquisadores) {
        int indiceEntrada = 0;

        try{
            indiceEntrada = mapeamentoEntrada.get("pesquisadores");
        }catch(ExcecaoChaveInexistente e){
            System.out.println("Chave inexistente: pesquisadores");
            return false;
        }

        this.entradas[indiceEntrada] = new File(this.argumentos[indiceEntrada]);
        Scanner fs = null;

        try {
            fs = new Scanner(this.entradas[indiceEntrada]);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo " + this.argumentos[indiceEntrada] + " não encontrado.");
            return false;
        }

        DicionarioHash<Integer, Pesquisador> armazenamento = new DicionarioHash<Integer, Pesquisador>();
        while(fs.hasNextLine()) {
            String[] parametros = fs.nextLine().split(";");
            int id = Integer.parseInt(parametros[0]);
            switch (parametros[1]){
                case "G":
                    Graduado g = new Graduado(id, Integer.parseInt(parametros[2]),
                        Integer.parseInt(parametros[3]));
                    armazenamento.put(id, g);
                    break;

                case "M":
                    Mestre m = new Mestre(id, Integer.parseInt(parametros[2]),
                        Integer.parseInt(parametros[3]),Integer.parseInt(parametros[4]));
                    armazenamento.put(id, m);
                    break;

                case "D":
                    Doutor d = new Doutor(id, Integer.parseInt(parametros[2]),
                        Integer.parseInt(parametros[3]), Integer.parseInt(parametros[4]),
                        Integer.parseInt(parametros[5]), Integer.parseInt(parametros[6]));
                    armazenamento.put(id, d);
                    break;
            }
        }
        pesquisadores.addAll(armazenamento.values());

        return true;
    }

    /**
     * Armazena os Veículos de Publicação lidos da entrada em um arraylist na posição correspondente ao seu ID.
     * @param veiculos
     * @return boolean
     */
    public boolean carregaVeiculosDePublicacao(ArrayList<VeiculoDePublicacao> veiculos) {
        int indiceEntrada = 0;

        try {
            indiceEntrada = mapeamentoEntrada.get("veiculos");
        }catch(ExcecaoChaveInexistente e){
            System.out.println("Chave inexistente: veiculos");
            return false;
        }

        this.entradas[indiceEntrada] = new File(this.argumentos[indiceEntrada]);

        Scanner fs = null;

        try {
            fs = new Scanner(this.entradas[indiceEntrada]);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo " + this.argumentos[indiceEntrada] + " não encontrado.");
            return false;
        }

        DicionarioHash<Integer, VeiculoDePublicacao> armazenamento = new DicionarioHash<>();
        while(fs.hasNextLine()) {
            String[] parametros = fs.nextLine().split(";");
            int id = Integer.parseInt(parametros[0]);
            switch (parametros[1]){
                case "C":
                    Conferencia c = new Conferencia(id);
                    armazenamento.put(id, c);
                    break;

                case "R":
                    Revista r = new Revista(id);
                    armazenamento.put(id, r);
                    break;
            }
        }
        veiculos.addAll(armazenamento.values());

        return true;
    }

    public boolean carregaArtigos(ArrayList<Artigo> artigos, ArrayList<Pesquisador> pesquisadores,
                                  ArrayList<VeiculoDePublicacao> veiculos) {
        // Lendo relações entre artigos e pesquisadores
        int indiceEntrada = 0;

        try{
            indiceEntrada = mapeamentoEntrada.get("grafo_artigos_pesquisadores");
        }catch(ExcecaoChaveInexistente e){
            System.out.println("Arquivo grafo_artigos_pesquisadores nao encontrado");
            return false;
        }

        DicionarioHash<Integer, Artigo> armazenamento = new DicionarioHash<>();
        this.entradas[indiceEntrada] = new File(this.argumentos[indiceEntrada]);

        Scanner fs = null;

        try {
            fs = new Scanner(this.entradas[indiceEntrada]);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo " + this.argumentos[indiceEntrada] + " não encontrado.");
            return false;
        }

        while(fs.hasNextLine()) {
            String[] parametros = fs.nextLine().split(";");
            int id = Integer.parseInt(parametros[0]);
            int idPesquisador = Integer.parseInt(parametros[1]);
            int ordemAutoria = Integer.parseInt(parametros[2]);
            // Cria novo artigo
            Artigo a = new Artigo(id);
            armazenamento.put(id, a);
            // Adiciona informação sobre autoria ao perfil do pesquisador
            pesquisadores.get(idPesquisador - 1).addArtigo(ordemAutoria);
            try{
                pesquisadores.get(idPesquisador - 1).adicionaArtigo(armazenamento.get(id));
            }catch(ExcecaoChaveInexistente e){
                System.out.println("Id pesquisador inexistente: " + id);
            }

        }


        // Lendo relações entre artigos e veiculos
        try{
            indiceEntrada = mapeamentoEntrada.get("artigos_veiculos");
        }catch(ExcecaoChaveInexistente e){
            System.out.println("Arquivo artigos_veiculos nao encontrado");
            return false;
        }

        this.entradas[indiceEntrada] = new File(this.argumentos[indiceEntrada]);

        try {
            fs = new Scanner(this.entradas[indiceEntrada]);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo " + this.argumentos[indiceEntrada] + " não encontrado.");
            return false;
        }

        while(fs.hasNextLine()) {
            String[] parametros = fs.nextLine().split(";");
            int idArtigo = Integer.parseInt(parametros[0]);
            int idVeiculo = Integer.parseInt(parametros[1]);

            try{
                armazenamento.get(idArtigo).setVeiculoDePublicacao(veiculos.get(idVeiculo - 1));
                // Adiciona informação ao veículo
                veiculos.get(idVeiculo - 1).addArtigo(armazenamento.get(idArtigo));
            }catch(ExcecaoChaveInexistente e){
                System.out.println("Chave inexistente: " + idArtigo);
                return false;
            }
        }


        // Lendo citações ao artigo
        try{
            indiceEntrada = mapeamentoEntrada.get("grafo_citacoes");
        }catch(ExcecaoChaveInexistente e){
            System.out.println("Arquivo grafo_citacoes nao encontrado");
            return false;
        }

        try {
            this.entradas[indiceEntrada] = new File(this.argumentos[indiceEntrada]);
            fs = new Scanner(this.entradas[indiceEntrada]);
            while(fs.hasNextLine()) {
                String[] parametros = fs.nextLine().split(";");
                int idArtigoCitado = Integer.parseInt(parametros[0]);
                armazenamento.get(idArtigoCitado).addQuantidadeDeCitacoes();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Arquivo " + this.argumentos[indiceEntrada] + " não encontrado.");
            return false;
        }
        catch(ExcecaoChaveInexistente e){

        }

        artigos.addAll(armazenamento.values());
        return true;
    }

    public boolean valida() {
        if(NUMERO_DE_ARQUIVOS != this.argumentos.length) {
            this.mostra_ajuda(true);
            return false;
        }
        return true;
    }

    private void mostra_ajuda() {
        System.out.println("Foram passados " + this.argumentos.length + " arquivos de " +
            this.NUMERO_DE_ARQUIVOS + " necessarios. O programa sera encerrado.");
    }

    private void mostra_ajuda(boolean terminate) {
        this.mostra_ajuda();
        if(terminate)
            System.exit(1);
    }
}
