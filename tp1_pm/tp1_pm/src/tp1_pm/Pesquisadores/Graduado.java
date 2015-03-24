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

public class Graduado extends Pesquisador{

    public Graduado(int id, int artigosPrimeiroAutor, int artigosSegundoAutor, 
                    int artigosTerceiroAutor) {
        super(id, artigosPrimeiroAutor, artigosSegundoAutor, 
              artigosTerceiroAutor);
    }

    @Override
    public int popularidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void printMeuPeso(){
        float f = super.peso();
        System.out.println(f);
    }
}
