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
 */
public class IronMan extends SuperHeroe  {

    public IronMan() {
    }

    public IronMan(String nombre, double vida, double ataque, String rutaImg) {
        super(nombre, vida, ataque, rutaImg);
    }

    public IronMan(String nombre, double vida, double ataque) {
        super(nombre, vida, ataque);
    }

    @Override
    public String archivar() {
        return super.archivar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String atacar(int i, SuperHeroe enemigo) {
        return super.atacar(i, enemigo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String tecnicaEsp(SuperHeroe enemigo) {
        return super.tecnicaEsp(enemigo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String patada(SuperHeroe enemigo) {
        return super.patada(enemigo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String golpe(SuperHeroe enemigo) {
        return super.golpe(enemigo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRutaImg(String rutaImg) {
        super.setRutaImg(rutaImg); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRutaImg() {
        return super.getRutaImg(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAtaque(double ataque) {
        super.setAtaque(ataque); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getAtaque() {
        return super.getAtaque(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setVida(double vida) {
        super.setVida(vida); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getVida() {
        return super.getVida(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        return super.getNombre(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
