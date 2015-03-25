import VeiculosDePublicacao.*;
import Pesquisadores.*;

public class Tp1_pm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graduado g = new Graduado(1, 2, 3);

        g.printPopularidade();

        Graduado h = new Graduado(2, 5, 1);

        Graduado j = new Graduado(3, 6, 9);

        h.printPopularidade();
        j.printPopularidade();
    }
}
