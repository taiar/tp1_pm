package EntradaESaida;

import Pesquisadores.Pesquisador;

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
                writer.write(String.valueOf(p.getId()) + ";" + String.valueOf(p.getPopularidade()));
                writer.newLine();
            }
        }
        catch (IOException e) {}
    }

}
