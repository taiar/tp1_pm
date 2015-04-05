import Pesquisadores.*;
import EntradaESaida.*;

import java.util.ArrayList;

public class Tp1_pm {

    public static void main(String[] args) {
        Entrada entrada = new Entrada(args);
        if(entrada.valida()) {
            ArrayList<Pesquisador> pesquisadores = new ArrayList<Pesquisador>();
            entrada.carregaPesquisadores(pesquisadores);

            for (Pesquisador p : pesquisadores){
                System.out.println(p);
            }
        }
    }
}
