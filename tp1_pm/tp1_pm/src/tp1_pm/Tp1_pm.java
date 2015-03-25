package tp1_pm;

import tp1_pm.VeiculosDePublicacao.*;
import tp1_pm.Pesquisadores.*;

public class Tp1_pm {

    public static void main(String[] args) {
        Conferencia c = new Conferencia(8);
        Revista r = new Revista(5);
        
        System.out.println(c);
        System.out.println(r);
        
        Graduado g = new Graduado(1, 2, 3, 1);
        
        g.printMeuPeso();
    }
}
