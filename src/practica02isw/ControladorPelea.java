/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica02isw;

import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 * @author Borre
 */
public class ControladorPelea {
   private ControladorPeleadores ctrlPeleadores;
   private final ControladorVista ctrlVista;
   private ControladorJugadores ctrlJugadores;
   private final ControladorRankings ctrlRankings;
   private ControladorTiempo ctrltiempo;
   private final int TIEMPO_DEFAULT = 120;
   int tiempo;
   private Jugador jugador;
   private SuperHeroe superHeroePlayer,superHeroeCPU;
   private String nombreHeroePlayer,nombreHeroeCPU;
   private boolean seleccionCompleta;
   private boolean peleaEnCurso = false;
   boolean timeover = false;

    public ControladorPelea(ControladorVista ctrlVista) throws IOException {
        this.ctrlPeleadores = new ControladorPeleadores();
        this.ctrlJugadores = new ControladorJugadores();
        this.ctrlRankings = new ControladorRankings(ctrlJugadores);
        this.ctrltiempo = new ControladorTiempo(this,TIEMPO_DEFAULT);
        ctrlJugadores.cargarArchivo();
        this.seleccionCompleta = false;
        this.ctrlVista = ctrlVista;
    }

    public ControladorPeleadores getCtrlPeleadores() {
        return ctrlPeleadores;
    }

    public ControladorTiempo getCtrltiempo() {
        return ctrltiempo;
    }

    public void setCtrltiempo(ControladorTiempo ctrltiempo) {
        this.ctrltiempo = ctrltiempo;
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
   
    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public boolean isTimeover() {
        return timeover;
    }

    public void setTimeover(boolean timeover) {
        this.timeover = timeover;
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

    public ControladorVista getCtrlVista() {
        return ctrlVista;
    }

    public ControladorRankings getCtrlRankings() {
        return ctrlRankings;
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
    
public void iniciarPelea(){
 setTiempo(TIEMPO_DEFAULT);
 setPeleaEnCurso(true);
}

public void reiniciar() throws IOException{
setTiempo(TIEMPO_DEFAULT);
ctrlVista.getVstPrincipal().habilitarBotonInicio();
ctrlPeleadores.eliminarPeleadores();
}

public void registrarAtaque(int i) throws IOException{
    if (isPeleaEnCurso()) {
    Random rnd = new Random();
    ctrlVista.setLog(superHeroePlayer.atacar(i, superHeroeCPU));
    ctrlVista.setLog(superHeroeCPU.atacar(rnd.nextInt(3), superHeroePlayer));
    }
    if (isTimeover()) {
        setPeleaEnCurso(false);
        declararGanador();
    } if (superHeroePlayer.getVida()<= 0) {
        declararGanador();
    }  if (superHeroeCPU.getVida()<= 0) {
        declararGanador();
    } 
    
    }

    void declararGanador() throws IOException {
    if (superHeroePlayer.getVida() > superHeroeCPU.getVida()) {
            getCtrltiempo().getTimer().stop();
            JOptionPane.showMessageDialog(null,"El Jugador ha ganado");
            getCtrltiempo().setTiempo(TIEMPO_DEFAULT);
            getCtrlVista().getVstPrincipal().desabilitarBtnGolpes();
            superHeroeCPU.setVida(0);
            ctrlJugadores.getJugadores().get(getJugador().getId()).setGanadas(getJugador().getGanadas()+1);
            ctrlJugadores.guardarArchivo();
            reiniciar();
        }else{
            getCtrltiempo().getTimer().stop();   
            JOptionPane.showMessageDialog(null,"El Jugador ha perdido");
            getCtrlVista().getVstPrincipal().desabilitarBtnGolpes();
            getCtrltiempo().setTiempo(TIEMPO_DEFAULT);
            superHeroePlayer.setVida(0);
            getJugador().setPerdidas(getJugador().getPerdidas()+1);
            reiniciar();
        }
    }
}