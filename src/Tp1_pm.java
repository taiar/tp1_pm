import Pesquisadores.*;
import EntradaESaida.*;
import VeiculosDePublicacao.Artigo;
import VeiculosDePublicacao.VeiculoDePublicacao;

import java.util.ArrayList;

/**
 * Ponto de entrada do trabalho pratico 1 da disciplina de
 * Programacao Modular, 1o semestre de 2015 da UFMG.
 * Este trabalho representa uma estrutura de classes
 * que permite armazenar e manipular os dados de uma
 * rede social (ficticia) de pesquisadores
 */
public class Tp1_pm {

    public static void main(String[] args) {

        ArrayList<Pesquisador> pesquisadores = new ArrayList<Pesquisador>();
        ArrayList<VeiculoDePublicacao> veiculos = new ArrayList<VeiculoDePublicacao>();
        ArrayList<Artigo> artigos = new ArrayList<Artigo>();

        Entrada entrada = new Entrada(args);

        if(entrada.valida()) { // Processa apenas casos de entrada valida
            entrada.carregaPesquisadores(pesquisadores);
            entrada.carregaVeiculosDePublicacao(veiculos);
            entrada.carregaArtigos(artigos, pesquisadores, veiculos);

            Saida saida = new Saida();
            saida.popularidadePesquisador(pesquisadores);
            saida.fatorImpactoVeiculo(veiculos);
            saida.pontuacaoArtigo(artigos);
        }
    }
}
