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
public class ControladorRankings {
private ControladorJugadores ctrlJugadores;
private VistaRankings vstRankings;

    public ControladorRankings(ControladorJugadores ctrlJugadores) throws IOException {
        this.ctrlJugadores = ctrlJugadores;
        this.vstRankings = new VistaRankings();
        vstRankings.setDatos(this.obtenerRankings());
    }


    public ControladorJugadores getCtrlJugadores() {
        return ctrlJugadores;
    }

    public void setCtrlJugadores(ControladorJugadores ctrlJugadores) {
        this.ctrlJugadores = ctrlJugadores;
    }

    public VistaRankings getVstRankings() {
        return vstRankings;
    }

    public void setVstRankings(VistaRankings vstRankings) {
        this.vstRankings = vstRankings;
    }
    
 private Object[][] obtenerRankings() throws IOException{
    Jugador[] ranks = new Jugador[getCtrlJugadores().getJugadores().size()];
    ranks = getCtrlJugadores().getJugadores().toArray(ranks);
    
 Jugador temp;
    for (int i = 0; i < ranks.length; i++) {
         for (int j = 0; j < ranks.length; j++) {
             if (ranks[i].getGanadas() > ranks[j].getGanadas()) {
                 temp = ranks[j];
                 ranks[j]=ranks[i];
                 ranks[i] = temp;
             }
         }
     }
 Object[][] r = new Object[ranks.length][3];
  for (int i = 0; i < ranks.length; i++) {
         r[i][0] = ranks[i].getNombre();
         r[i][1] = ranks[i].getGanadas();
         r[i][2] = ranks[i].getPerdidas();  
     }
Object[][] tabla = r;
return tabla;
 }
 
   public void mostrarRankings() throws IOException{
   Object[][] datos = this.obtenerRankings();
   getVstRankings().setDatos(datos);
   getVstRankings().getTablaRank().setModel(
        new javax.swing.table.DefaultTableModel(datos,new String [] {
            "Nombre", "Victorias", "Derrotas"
            }
        ));
   getVstRankings().setVisible(true);
   }
}
