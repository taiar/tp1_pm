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

        File[] entradas = new File[6];
        for (int i = 0; i < 6; i++) {
            entradas[i] = new File(args[i]);
        }

        Scanner fs = null;

        try {
            for (int i = 0; i < 6; i++) {
                fs = new Scanner(entradas[i]);
                while(fs.hasNextLine()){
                    System.out.println(fs.nextLine());
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Arquivo pesquisadores.txt nao encontrado");
        }
    }
}
