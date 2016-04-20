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
public interface Heroe {
    
    public String atacar(int i,SuperHeroe enemigo);
    public String golpe(SuperHeroe enemigo);
    public String patada(SuperHeroe enemigo);
    public String tecnicaEsp(SuperHeroe enemigo);
    
}
