import VeiculosDePublicacao.*;
import Pesquisadores.*;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Tp1_pm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graduado g = new Graduado(1, 6, 9);

        System.out.println(g.popularidade());

        Mestre m = new Mestre(1, 6, 9, 1);
        System.out.println(m.popularidade());

        Doutor d = new Doutor(1, 6, 9, 1, 1, 1);
        System.out.println(d.popularidade());

        // Main directory of the project
        /*String workingDir = System.getProperty("user.dir");
        System.out.println("Current working directory : " + workingDir);*/

        File f = new File("src/data/pesquisadores.txt");

        Scanner fs = null;

        try {
            fs = new Scanner(f);
        }catch (FileNotFoundException e){
            System.out.println("Arquivo pesquisadores.txt nao encontrado");
        }

        while(fs.hasNextLine()){
            System.out.println(fs.nextLine());
        }
    }
}
