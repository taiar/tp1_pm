package EntradaESaida;

import Pesquisadores.Doutor;
import Pesquisadores.Graduado;
import Pesquisadores.Mestre;
import Pesquisadores.Pesquisador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
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
    private static final HashMap<String, Integer> mapeamentoEntrada;
    static {
        mapeamentoEntrada = new HashMap<String,Integer>();
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

    public boolean carregaPesquisadores(ArrayList<Pesquisador> pesquisadores) {
        int indiceEntrada = mapeamentoEntrada.get("pesquisadores");
        try {
            this.entradas[indiceEntrada] = new File(this.argumentos[indiceEntrada]);
            Scanner fs = new Scanner(this.entradas[indiceEntrada]);
            while(fs.hasNextLine()) {
                String[] parametros = fs.nextLine().split(";");
                switch (parametros[1]){
                    case "G":
                        Graduado g = new Graduado(Integer.parseInt(parametros[0]), Integer.parseInt(parametros[2]),
                            Integer.parseInt(parametros[3]));

                        pesquisadores.add(g);
                        break;

                    case "M":
                        Mestre m = new Mestre(Integer.parseInt(parametros[0]), Integer.parseInt(parametros[2]),
                            Integer.parseInt(parametros[3]),Integer.parseInt(parametros[4]));

                        pesquisadores.add(m);
                        break;

                    case "D":
                        Doutor d = new Doutor(Integer.parseInt(parametros[0]), Integer.parseInt(parametros[2]),
                            Integer.parseInt(parametros[3]), Integer.parseInt(parametros[4]),
                            Integer.parseInt(parametros[5]), Integer.parseInt(parametros[6]));

                        pesquisadores.add(d);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo " + this.argumentos[Entrada.mapeamentoEntrada.get("pesquisadores")] + " não encontrado.");
            return false;
        }
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
