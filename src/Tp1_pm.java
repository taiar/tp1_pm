import VeiculosDePublicacao.*;
import Pesquisadores.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Tp1_pm {

    public static final int NUMERO_DE_ARQUIVOS = 6;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File[] entradas = new File[NUMERO_DE_ARQUIVOS];
        ArrayList<Pesquisador> pesquisadores = new ArrayList<Pesquisador>();

        // Loop de abertura de arquivos
        for (int i = 0; i < NUMERO_DE_ARQUIVOS; i++) {
            try{
                entradas[i] = new File(args[i]);
            }catch(ArrayIndexOutOfBoundsException e){

                System.out.println(
                        "Foram passados " + args.length + " arquivos de " +
                        Tp1_pm.NUMERO_DE_ARQUIVOS +
                        " necessarios. O programa sera encerrado.");

                System.exit(1);
            }
        }

        Scanner fs = null;

        // Loop de processamento de arquivos
        // Vamos considerar uma certa ordem definida de parametros?
        // Por hora: pesquisadores.txt -> veiculos.txt -> artigos_veiculos.txt
        // -> grafo_pesquisadores.txt -> grafo_artigos_pesquisadores.txt -> grafo_citacoes.txt
        for (int i = 0; i < NUMERO_DE_ARQUIVOS; i++) {
            try {
                fs = new Scanner(entradas[i]);

                switch (i){
                    case 0: // pesquisadores
                        while(fs.hasNextLine()){
                            String[] parametros = fs.nextLine().split(";");
                            switch (parametros[1]){
                                case "G":
                                    Graduado g = new Graduado(Integer.parseInt(parametros[0]),
                                                              Integer.parseInt(parametros[2]),
                                                              Integer.parseInt(parametros[3]));

                                    pesquisadores.add(g);
                                    break;

                                case "M":
                                    Mestre m = new Mestre(Integer.parseInt(parametros[0]),
                                                          Integer.parseInt(parametros[2]),
                                                          Integer.parseInt(parametros[3]),
                                                          Integer.parseInt(parametros[4]));

                                    pesquisadores.add(m);
                                    break;

                                case "D":
                                    Doutor d = new Doutor(Integer.parseInt(parametros[0]),
                                                          Integer.parseInt(parametros[2]),
                                                          Integer.parseInt(parametros[3]),
                                                          Integer.parseInt(parametros[4]),
                                                          Integer.parseInt(parametros[5]),
                                                          Integer.parseInt(parametros[6]));

                                    pesquisadores.add(d);
                                    break;
                            }
                        }
                        break;

                }

            }catch (FileNotFoundException e){
                System.out.println("Arquivo " + entradas[i] + " nao encontrado");
            }
        }

        for (Pesquisador p : pesquisadores){
            System.out.println(p);
        }

    } // End main
}
