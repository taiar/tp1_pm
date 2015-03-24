/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp1_pm;

import tp1_pm.VeiculosDePublicacao.*;
import tp1_pm.Pesquisadores.*;

/**
 *
 * @author ghapereira
 */
public class Tp1_pm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conferencia c = new Conferencia(8);
        Revista r = new Revista(5);
        
        System.out.println(c);
        System.out.println(r);
        
        Graduado g = new Graduado(1, 2, 3, 1);
        
        g.printMeuPeso();
    }
    
}
