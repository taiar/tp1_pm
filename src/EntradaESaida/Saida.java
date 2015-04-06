package EntradaESaida;

import Pesquisadores.Pesquisador;
import VeiculosDePublicacao.VeiculoDePublicacao;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Saida {

    public void popularidadePesquisador(ArrayList<Pesquisador> pesquisadores) {
        Path arquivo = Paths.get("./popularidade_pesquisador.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(arquivo)){
            for(Pesquisador p: pesquisadores){
                String linha =
                        p.getTipo() + ";" +
                        String.valueOf(p.getId()) + ";" +
                                String.valueOf(p.getPopularidade()) + ";" +
                                String.valueOf(p.getPeso())  + ";" +
                                String.valueOf(p.getNumeroArtigos())  + ";" +
                                String.valueOf(p.getCitacoes())  + ";(" +
                                p.autoria[0] + "," + p.autoria[1] + "," + p.autoria[2] + "," + p.autoria[3] + "," + p.autoria[4] + ")";
                writer.write(linha);
                writer.newLine();
                System.out.println(linha);
            }
        }
        catch (IOException e) {}
    }

    public void fatorImpactoVeiculo(ArrayList<VeiculoDePublicacao> veiculos) {
        Path arquivo = Paths.get("./fatorImpacto_veiculo.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(arquivo)){
            for(VeiculoDePublicacao v: veiculos){
                String linha = v.getId() + ";" + String.valueOf(v.fatorDeImpacto());
                writer.write(linha);
                writer.newLine();
                System.out.println(linha);
            }
        }
        catch (IOException e) {}
    }

}
