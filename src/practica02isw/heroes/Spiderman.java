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
public class Spiderman extends SuperHeroe  {

    public Spiderman() {
    }

    public Spiderman(String nombre, double vida, double ataque, String rutaImg) {
        super(nombre, vida, ataque, rutaImg);
    }

    public Spiderman(String nombre, double vida, double ataque) {
        super(nombre, vida, ataque);
    }

    public String maximumSpider(SuperHeroe enemigo)
    {
    String mensaje = this.getNombre()+" ha hecho su ataque MAXIMUM SPIDER contra "+enemigo.getNombre()+" quitandole "+ (int)super.getAtaque()+ " puntos de vida\n";
    enemigo.setVida(enemigo.getVida()-super.getAtaque());
    System.out.println(mensaje);
    return mensaje;
    }
    
    @Override
    public String tecnicaEsp(SuperHeroe enemigo) {
    return this.maximumSpider(enemigo);
    }
}
