/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica02isw.heroes;

import practica02isw.SuperHeroe;

/**
 *
 * @author Erick
 * @author Borre
 */
public class Hulk extends SuperHeroe  {

    public Hulk() {
    }

    public Hulk(String nombre, double vida, double ataque, String rutaImg) {
        super(nombre, vida, ataque, rutaImg);
    }

    public Hulk(String nombre, double vida, double ataque) {
        super(nombre, vida, ataque);
    }
    
    public String impactPunch(SuperHeroe enemigo)
    {
    String mensaje = this.getNombre()+" ha hecho su ataque IMPACT PUNCH contra "+enemigo.getNombre()+" quitandole "+ (int)super.getAtaque()+ " puntos de vida\n";
    enemigo.setVida(enemigo.getVida()-super.getAtaque());
    System.out.println(mensaje);
    return mensaje;
    }    
    
    @Override
    public String tecnicaEsp(SuperHeroe enemigo) {
    return this.impactPunch(enemigo);
    }
    
}
