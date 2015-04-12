package EntradaESaida;

import Pesquisadores.Pesquisador;
import VeiculosDePublicacao.Artigo;
import VeiculosDePublicacao.VeiculoDePublicacao;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Regula a logica da escrita de arquivos e apresentacao dos dados desejados do programa
 */
public class Saida {
    /**
     * Metodo responsavel por salvar num arquivo a popularidade dos pesquisadores
     * @param pesquisadores Estrutura contendo listagem dos pesquisadores
     */
    public void popularidadePesquisador(ArrayList<Pesquisador> pesquisadores) {
        Path arquivo = Paths.get("./popularidade_pesquisador.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(arquivo, Charset.defaultCharset())){
            for(Pesquisador p: pesquisadores){
                String linha =
                        p.getTipo() + ";" +
                        String.valueOf(p.getId()) + ";" +
                                String.valueOf(p.popularidade()) + ";" +
                                String.valueOf(p.getPeso())  + ";" +
                                String.valueOf(p.getNumeroArtigos())  + ";" +
                                String.valueOf(p.getCitacoes())  + ";(" +
                                p.getAutorias() + ")";

                writer.write(linha);
                writer.newLine();
                System.out.println(linha);
            }
        }
        catch (IOException e) {}
    }

    /**
     * Metodo responsavel por salvar num arquivo o fator de impacto dos veiculos
     * @param veiculos Estrutura contendo listagem dos veiculos
     */
    public void fatorImpactoVeiculo(ArrayList<VeiculoDePublicacao> veiculos) {
        Path arquivo = Paths.get("./fatorImpacto_veiculo.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(arquivo, Charset.defaultCharset())){
            for(VeiculoDePublicacao v: veiculos){
                String linha = v.getId() + ";" + String.valueOf(v.fatorDeImpacto());
                writer.write(linha);
                writer.newLine();
                System.out.println(linha);
            }
        }
        catch (IOException e) {}
    }

    /**
     * Metodo responsavel por salvar num arquivo a pontuacao (qualidade) dos artigos
     * @param artigos Estrutura contendo a listagem dos artigos
     */
    public void pontuacaoArtigo(ArrayList<Artigo> artigos) {
        Path arquivo = Paths.get("./pontuacao_artigo.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(arquivo, Charset.defaultCharset())){
            for(Artigo a: artigos){
                String linha = a.getId() + ";" + String.valueOf(a.qualidade());
                writer.write(linha);
                writer.newLine();
                System.out.println(linha);
            }
        }
        catch (IOException e) {}
    }
}
