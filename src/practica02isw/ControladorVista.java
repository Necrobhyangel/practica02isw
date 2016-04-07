/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica02isw;

import java.awt.Component;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class ControladorVista {
  ControladorPelea ctrlPelea = new ControladorPelea(this);
  ControladorPeleadores ctrlPeleadores = new ControladorPeleadores();
  String nombreJugador,nombreHeroePlayer,nombreHeroeCPU,log;
  int seleccion;

    public int getSeleccion() {
        return seleccion;
    }

    public ControladorVista(){
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
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

    public ControladorVista(ControladorPelea ctrlPelea) throws IOException {
        this.ctrlPelea = ctrlPelea;
    }


    public ControladorPelea getCtrlPelea() {
        return ctrlPelea;
    }

    public void setCtrlPelea(ControladorPelea ctrlPelea) {
        this.ctrlPelea = ctrlPelea;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
  
    public void obtenerNombreJugador(){
            setNombreJugador(JOptionPane.showInputDialog("Por favor ingresa tu nombre"));
    }
    
    public String obtenerNombreHeroeP1(){
    return ctrlPelea.getNombreHeroePlayer();
    }
    
    public String obtenerNombreHeroeCPU(){
    return ctrlPelea.getNombreHeroeCPU();
    }

    public String getLog(){
        return log;
    }

    public void setLog(String log) {
        this.log = this.log+log;
    }
     
    public void obtenerSeleccion() throws IOException{
    Object[] opciones = ctrlPeleadores.mostrarNombres();
    Component frame = null;
     int n = JOptionPane.showOptionDialog(frame,
    "Selecciona al personaje que peleara contra el CPU",
    "Seleccion de Personaje",
    JOptionPane.YES_NO_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    opciones,
    opciones[0]);
    setSeleccion(n);
    mensajeSeleccion();
    }

    public void obtenerJugador() throws IOException{
  while(true){
        Object[] opciones = {"Crear jugador Nuevo","Ingresar ID de jugador existente"};
    Component frame = null;
    int n = JOptionPane.showOptionDialog(frame,
    "Seleccion o creacion de Jugador",
    "Seleccion de Personaje",
    JOptionPane.YES_NO_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    opciones,
    opciones[0]);
    
        switch (n) {
            case 0:
                String nombre = JOptionPane.showInputDialog(this,"Ingresa el Nombre del jugador");
                ctrlPelea.getCtrlJugadores().crearJugador(nombre);
                break; 
            
            case 1:
             String id = JOptionPane.showInputDialog(this,"Ingresa el ID del jugador");
             Jugador encontrado = null;
             System.out.println(ctrlPelea.getCtrlJugadores().getJugadores().size());
             for (int i = 0; i < ctrlPelea.getCtrlJugadores().getJugadores().size(); i++) {
                    if (id.equals(ctrlPelea.getCtrlJugadores().getJugadores().get(i).getId())) {
                        encontrado = ctrlPelea.getCtrlJugadores().getJugadores().get(i);
                    }
                }
                
                if (encontrado!=null) {
                    ctrlPelea.setJugador(encontrado);
                }else{
                JOptionPane.showMessageDialog(null,"Jugador no encontrado");
                }
                break;
            default:
                throw new AssertionError();
        }
  }
    }
    
    public void mensajeSeleccion(){
    setLog("El jugador selecciono a: "+obtenerNombreHeroeP1()+"\n");
    setLog("El CPU selecciono a: "+ obtenerNombreHeroeCPU()+"\n");
    }


}
