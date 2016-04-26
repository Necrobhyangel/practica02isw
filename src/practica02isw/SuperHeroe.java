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
public class SuperHeroe implements Heroe {
 private   String nombre;
 private   double vida;
 private   double ataque;
 private   String rutaImg;

    public SuperHeroe() {
    }

    
    public SuperHeroe(String nombre, double vida, double ataque, String rutaImg) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.rutaImg = rutaImg;
    }    

    public SuperHeroe(String nombre, double vida, double ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getAtaque() {
        return ataque;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public String getRutaImg() {
        return rutaImg;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }
    
    @Override
    public String golpe(SuperHeroe enemigo) {
    String mensaje = this.getNombre()+" ha golpeado a "+enemigo.getNombre()+" quitandole "+ (int)ataque/4+ " puntos de vida\n";
    enemigo.setVida(enemigo.getVida()-ataque/4);
    System.out.println(mensaje);
    return mensaje;
    }

    @Override
    public String patada(SuperHeroe enemigo) {
    String mensaje = this.getNombre()+" ha pateado a "+enemigo.getNombre()+" quitandole "+ (int)ataque/2+ " puntos de vida\n";
    enemigo.setVida(enemigo.getVida()-ataque/2);
    System.out.println(mensaje);
    return mensaje;
    }

    @Override
    public String tecnicaEsp(SuperHeroe enemigo) {
    String mensaje = "";
    return mensaje;
    }
    
    @Override
    public String atacar(int i, SuperHeroe enemigo) {
        switch (i) {
            case 0:
            return golpe(enemigo);
            case 1:
            return patada(enemigo);
            case 2:
            return tecnicaEsp(enemigo);    
            default:
                throw new AssertionError();
        }
    }
    
    
public String archivar(){
return nombre+","+vida+","+ataque+","+rutaImg;
}

  
}