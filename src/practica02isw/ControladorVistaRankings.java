/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica02isw;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Erick
 */
public class ControladorVistaRankings {
ControladorJugadores ctrlJugadores = new ControladorJugadores();

    public ControladorVistaRankings(ControladorJugadores ctrlJugadores) {
        this.ctrlJugadores = ctrlJugadores;
    }

 public ControladorVistaRankings() throws IOException {
ctrlJugadores.cargarArchivo();
 }


 public Object[][] obtenerRankings() throws IOException{
 
 ArrayList<Jugador> ranks = ctrlJugadores.getJugadores();
         
 Jugador temp;
    for (int i = 0; i < ranks.size(); i++) {
         for (int j = 0; j < ranks.size(); j++) {
             if (ranks.get(i).getGanadas() > ranks.get(j).getGanadas()) {
                 temp = ranks.get(j);
                 ranks.set(j,ranks.get(i));
                 ranks.set(i, temp);
             }
         }
     }
 Object[][] r = new Object[ranks.size()][3];
  for (int i = 0; i < ranks.size(); i++) {
         r[i][0] = ranks.get(i).getNombre();
         r[i][1] = ranks.get(i).getGanadas();
         r[i][2] = ranks.get(i).getPerdidas();  
     }
Object[][] tabla = r;
return tabla;
 }
}
