import Pesquisadores.*;
import EntradaESaida.*;
import VeiculosDePublicacao.Artigo;
import VeiculosDePublicacao.VeiculoDePublicacao;

import java.util.ArrayList;

public class Tp1_pm {

    public static void main(String[] args) {

        ArrayList<Pesquisador> pesquisadores = new ArrayList<Pesquisador>();
        ArrayList<VeiculoDePublicacao> veiculos = new ArrayList<VeiculoDePublicacao>();
        ArrayList<Artigo> artigos = new ArrayList<Artigo>();

        Entrada entrada = new Entrada(args);

        if(entrada.valida()) {
            entrada.carregaPesquisadores(pesquisadores);
            entrada.carregaVeiculosDePublicacao(veiculos);
            entrada.carregaArtigos(artigos, pesquisadores, veiculos);

            Saida saida = new Saida();
            saida.popularidadePesquisador(pesquisadores);
        }
    }
}
