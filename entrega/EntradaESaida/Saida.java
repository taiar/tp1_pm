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
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Regula a logica da escrita de arquivos e apresentacao dos dados desejados do programa
 */
public class Saida {

    private DecimalFormat formato;

    public Saida() {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        this.formato = new DecimalFormat("#0.0000", simbolos); // Formato utilizado para os numeros da saida
    }

    /**
     * Metodo responsavel por salvar num arquivo a popularidade dos pesquisadores
     * @param pesquisadores Estrutura contendo listagem dos pesquisadores
     */
    public void popularidadePesquisador(ArrayList<Pesquisador> pesquisadores) {
        Path arquivo = Paths.get("./popularidade_pesquisador.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(arquivo, Charset.defaultCharset())){
            for(Pesquisador p: pesquisadores){
                String linha = String.valueOf(p.getId()) + ";" + String.valueOf(this.formato.format(p.popularidade()));
                writer.write(linha);
                writer.newLine();
// FIXME                System.out.println(linha);
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
                String linha = v.getId() + ";" + String.valueOf(this.formato.format(v.fatorDeImpacto()));
                writer.write(linha);
                writer.newLine();
// FIXME               System.out.println(linha);
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
                String linha = a.getId() + ";" + String.valueOf(this.formato.format(a.qualidade()));
                writer.write(linha);
                writer.newLine();
//  FIXME              System.out.println(linha);
            }
        }
        catch (IOException e) {}
    }
}
