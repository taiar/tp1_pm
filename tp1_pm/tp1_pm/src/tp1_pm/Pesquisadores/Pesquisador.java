/*
 * Copyright (C) 2015 ghapereira
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package tp1_pm.Pesquisadores;

/**
 *
 * @author ghapereira
 */
public abstract class Pesquisador {
    private int id;
    
    private int artigosPrimeiroAutor;
    private int artigosSegundoAutor;
    private int artigoTerceiroAutor;
    
    
    public Pesquisador(int id, int artigosPrimeiroAutor, int artigosSegundoAutor, 
                       int artigosTerceiroAutor){
        
        this.id = id;
        
        this.artigosPrimeiroAutor = artigosPrimeiroAutor;
        this.artigosSegundoAutor = artigosSegundoAutor;
        this.artigoTerceiroAutor = artigosTerceiroAutor;
        
    }
    
    // Alterar para privado quando criar o calculo de popularidade
    public float peso(){
        float pesoPrimeiro = this.artigosPrimeiroAutor;
        float pesoSegundo = (float) (this.artigosSegundoAutor / 2.0);
        float pesoTerceiro = (float) (this.artigoTerceiroAutor / 3.0);
        
        return pesoPrimeiro + pesoSegundo + pesoTerceiro;
    }
    
    public abstract int popularidade();
}

