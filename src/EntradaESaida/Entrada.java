package EntradaESaida;

import Pesquisadores.Doutor;
import Pesquisadores.Graduado;
import Pesquisadores.Mestre;
import Pesquisadores.Pesquisador;
import VeiculosDePublicacao.Artigo;
import VeiculosDePublicacao.Conferencia;
import VeiculosDePublicacao.Revista;
import VeiculosDePublicacao.VeiculoDePublicacao;
import Utilitarios.Dicionario;
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
    private static final Dicionario<String, Integer> mapeamentoEntrada;
    static {
        mapeamentoEntrada = new Dicionario<String, Integer>();
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
     * @return @return true caso o carregamento tenha ocorrido corretamente, falso do contrario
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

        Dicionario<Integer, Pesquisador> armazenamento = new Dicionario<Integer, Pesquisador>();
        while(fs.hasNextLine()) {
            String[] parametros = fs.nextLine().split(";");
            int id = Integer.parseInt(parametros[0]);
            switch (parametros[1]){
                // Tratamento de graduados
                case "G":
                    Graduado g = new Graduado(id, Integer.parseInt(parametros[2]),
                        Integer.parseInt(parametros[3]));
                    armazenamento.put(id, g);
                    break;
                // Tratamento de mestres
                case "M":
                    Mestre m = new Mestre(id, Integer.parseInt(parametros[2]),
                        Integer.parseInt(parametros[3]),Integer.parseInt(parametros[4]));
                    armazenamento.put(id, m);
                    break;
                // Tratamento de doutores
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

        Dicionario<Integer, VeiculoDePublicacao> armazenamento = new Dicionario<>();
        while(fs.hasNextLine()) {
            String[] parametros = fs.nextLine().split(";");
            int id = Integer.parseInt(parametros[0]);
            switch (parametros[1]){
                // Tratamento de conferencias
                case "C":
                    Conferencia c = new Conferencia(id);
                    armazenamento.put(id, c);
                    break;
                // Tratamento de revistas
                case "R":
                    Revista r = new Revista(id);
                    armazenamento.put(id, r);
                    break;
            }
        }
        veiculos.addAll(armazenamento.values());

        return true;
    }

    /**
     * Armazena os artigos numa estrutura, bem como os associa aos veiculos e pesquisadores
     * relacionados e processa as citacoes
     * @param artigos
     * @param pesquisadores
     * @param veiculos
     * @return true caso o carregamento tenha ocorrido corretamente, falso do contrario
     */
    public boolean carregaArtigos(ArrayList<Artigo> artigos, ArrayList<Pesquisador> pesquisadores,
                                  ArrayList<VeiculoDePublicacao> veiculos) {
        // Lendo relações entre artigos e pesquisadores
        int indiceEntrada = 0;
        ArrayList<Integer> grafoArtigos = new ArrayList<>();
        ArrayList<Integer> grafoPesquisadores = new ArrayList<>();

        try{
            indiceEntrada = mapeamentoEntrada.get("grafo_artigos_pesquisadores");
        }catch(ExcecaoChaveInexistente e){
            System.out.println("Arquivo grafo_artigos_pesquisadores nao encontrado");
            return false;
        }

        Dicionario<Integer, Artigo> armazenamento = new Dicionario<>();
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
            grafoArtigos.add(id);
            grafoPesquisadores.add(idPesquisador);
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

                armazenamento.get(idArtigoCitado).increaseQuantidadeDeCitacoes();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Arquivo " + this.argumentos[indiceEntrada] + " não encontrado.");
            return false;
        }
        catch(ExcecaoChaveInexistente e){}

        artigos.addAll(armazenamento.values());

        // Adicionando referências aos artigos associados aos Pesquisadores
        for (int i = 0; i < grafoArtigos.size(); i++) {
            pesquisadores.get(grafoPesquisadores.get(i) - 1)
                .adicionaArtigo(artigos.get(grafoArtigos.get(i) - 1));
        }
        return true;
    }

    /**
     * Valida a quantidade de argumentos passados para o programa
     * @return true caso o carregamento tenha ocorrido corretamente, falso do contrario
     */
    public boolean valida() {
        if(NUMERO_DE_ARQUIVOS != this.argumentos.length) {
            this.mostra_ajuda(true);
            return false;
        }
        return true;
    }

    /**
     * Apresenta uma mensagem para o usuario com a informacao do problema encontrado
     */
    private void mostra_ajuda() {
        System.out.println("Foram passados " + this.argumentos.length + " arquivos de " +
            this.NUMERO_DE_ARQUIVOS + " necessarios. O programa sera encerrado.");
    }

    /**
     * Apresenta uma mensagem para o usuario e encerra o programa de acordo com um sinal
     * @param terminate Encerra o programa caso seja true
     */
    private void mostra_ajuda(boolean terminate) {
        this.mostra_ajuda();
        if(terminate)
            System.exit(1);
    }
}
