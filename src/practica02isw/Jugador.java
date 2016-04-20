/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica02isw;

/**
 *
 * @author Erick
 * @author Borre
 */
public class Jugador {
    private int id;
    private String nombre;
    private int ganadas;
    private int perdidas;

    public Jugador(int id,String nombre, int ganadas, int perdidas) {
        this.id = id;
        this.nombre = nombre;
        this.ganadas = ganadas;
        this.perdidas = perdidas;
    }


    public Jugador() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGanadas() {
        return ganadas;
    }

    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }
    
    public String archivar(){
    return id+","+nombre+","+ganadas+","+perdidas;
    }

    public int compararRank(Jugador t) {
    int  r = 0; 
        if (this.getGanadas() > t.getGanadas()) {
        r = 1;    
        }
        if (this.getGanadas() < t.getGanadas()) {
        r = -1;    
        }
        if (this.getGanadas() == t.getGanadas()) {
        r = 0;    
        }
    
   return r;
    }

    
}
