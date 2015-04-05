import Pesquisadores.*;
import EntradaESaida.*;
import VeiculosDePublicacao.Artigo;
import VeiculosDePublicacao.VeiculoDePublicacao;

import java.util.ArrayList;

public class Tp1_pm {

    public static void main(String[] args) {
        Entrada entrada = new Entrada(args);
        if(entrada.valida()) {
            ArrayList<Pesquisador> pesquisadores = new ArrayList<Pesquisador>();
            ArrayList<VeiculoDePublicacao> veiculos = new ArrayList<VeiculoDePublicacao>();
            ArrayList<Artigo> artigos = new ArrayList<Artigo>();

            entrada.carregaPesquisadores(pesquisadores);
            entrada.carregaVeiculosDePublicacao(veiculos);
            entrada.carregaArtigos(artigos, pesquisadores, veiculos);

            for (Pesquisador p : pesquisadores){
                System.out.println(p);
            }
            for (VeiculoDePublicacao p : veiculos){
                System.out.println(p);
            }
        }
    }
}
