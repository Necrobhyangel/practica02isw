/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica02isw;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Erick
 */
public class ControladorPelea {
   ControladorPeleadores ctrlPeleadores;
   private final ControladorVista ctrlVista;
   private ControladorJugadores ctrlJugadores;
   private final ControladorRankings ctrlRankings;
   private int tiempo = 120;
   private Jugador jugador;
   private SuperHeroe superHeroePlayer,superHeroeCPU;
   private String nombreHeroePlayer,nombreHeroeCPU;
   private boolean seleccionCompleta;
   private boolean peleaEnCurso = false;

    public ControladorPelea(ControladorVista ctrlVista) throws IOException {
        this.ctrlPeleadores = new ControladorPeleadores();
        this.ctrlJugadores = new ControladorJugadores();
        this.ctrlRankings = new ControladorRankings(ctrlJugadores);
        this.seleccionCompleta = false;
        this.ctrlVista = ctrlVista;
    }

    public ControladorPeleadores getCtrlPeleadores() {
        return ctrlPeleadores;
    }

    public void setCtrlPeleadores(ControladorPeleadores ctrlPeleadores) {
        this.ctrlPeleadores = ctrlPeleadores;
    }
   
    
   public ControladorJugadores getCtrlJugadores() {
        return ctrlJugadores;
    }

    public void setCtrlJugadores(ControladorJugadores ctrlJugadores) {
        this.ctrlJugadores = ctrlJugadores;
    }

   
    public boolean isPeleaEnCurso() {
        return peleaEnCurso;
    }

    public void setPeleaEnCurso(boolean peleaIniciada) {
        this.peleaEnCurso = peleaIniciada;
    }
   
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
   
    public int getTIEMPO() {
        return tiempo;
    }
    

    
    public SuperHeroe getSuperHeroePlayer() {
        return superHeroePlayer;
    }

    public void setSuperHeroePlayer(SuperHeroe superHeroePlayer) {
        this.superHeroePlayer = superHeroePlayer;
    }

    public SuperHeroe getSuperHeroeCPU() {
        return superHeroeCPU;
    }

    public void setSuperHeroeCPU(SuperHeroe superHeroeCPU) {
        this.superHeroeCPU = superHeroeCPU;
    }

    public String getNombreHeroePlayer() {
        return nombreHeroePlayer;
    }

    public void setNombreHeroePlayer(String nombreHeroePlayer) {
        this.nombreHeroePlayer = nombreHeroePlayer;
    }

    public String getNombreHeroeCPU() {
        return nombreHeroeCPU;
    }

    public void setNombreHeroeCPU(String nombreHeroeCPU) {
        this.nombreHeroeCPU = nombreHeroeCPU;
    }

    public boolean isSeleccionCompleta() {
        return seleccionCompleta;
    }

    public void setSeleccionCompleta(boolean seleccionCompleta) {
        this.seleccionCompleta = seleccionCompleta;
    }
        
    public void obtenerHeroes() throws IOException{
        
    superHeroePlayer = ctrlPeleadores.seleccionarSuperHeroeP1(ctrlVista.getSeleccion());
    setNombreHeroePlayer(superHeroePlayer.getNombre());
    
    superHeroeCPU = ctrlPeleadores.seleccionarSuperHeroeCPU();
    setNombreHeroeCPU(superHeroeCPU.getNombre());
    
    ctrlVista.setNombreHeroePlayer(getNombreHeroePlayer());
    ctrlVista.setNombreHeroeCPU(getNombreHeroeCPU());
    
    setSeleccionCompleta(true);
    }
    
           
public void iniciarConteo(){
while(this.tiempo != 0){
        try {
            this.tiempo--;
          //  System.out.println(tiempo);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public void iniciarPelea(){
 setPeleaEnCurso(true);
 //iniciarConteo();
 
    while(isPeleaEnCurso()==false){
        if (this.tiempo < 0) {
            this.setPeleaEnCurso(false);
        }else if(this.superHeroePlayer.getVida() <= 0){
            this.setPeleaEnCurso(false);
        }else if(this.superHeroeCPU.getVida() <= 0){
            this.setPeleaEnCurso(false);
        }
    }
}

public void verificarEstado(){

}

public void registrarAtaque(int i){
    if (isPeleaEnCurso()==true) {
    Random rnd = new Random();
    ctrlVista.setLog(superHeroePlayer.atacar(i, superHeroeCPU));
    ctrlVista.setLog(superHeroeCPU.atacar(rnd.nextInt(2), superHeroePlayer));
    System.out.println(isPeleaEnCurso());
    }
    }

}
