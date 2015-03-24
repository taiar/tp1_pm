/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp1_pm.VeiculosDePublicacao;

/**
 *
 * @author ghapereira
 */
public abstract class VeiculoDePublicacao {
    private int id;
    
    public VeiculoDePublicacao(int id){
        this.id = id;
    }
    
    public String toString(){
        return "ID da publicacao: " + id;
    }
}
