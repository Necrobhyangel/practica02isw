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
 * @author Borre
 */
public class ControladorVista {

    private VistaPrincipal vstPrincipal;
    private ControladorPelea ctrlPelea;
    private String nombreJugador, nombreHeroePlayer, nombreHeroeCPU, log;
    private int seleccion;

    public ControladorVista(VistaPrincipal vstPrincipal) throws IOException {
        this.vstPrincipal = vstPrincipal;
        this.ctrlPelea = new ControladorPelea(this);
        this.log = "";
    }

 
    public int getSeleccion() {
        return seleccion;
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

    public void obtenerNombreJugador() {
        setNombreJugador(JOptionPane.showInputDialog("Por favor ingresa tu nombre"));
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = this.log + log;
    }

    public void obtenerSeleccion() throws IOException {
        Object[] opciones = ctrlPelea.getCtrlPeleadores().mostrarNombres();
       boolean seleccionado = true; 
      
        while(seleccionado){
         int n = JOptionPane.showOptionDialog(null,
                "Selecciona al personaje que peleara contra el CPU",
                "Seleccion de Personaje",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);
          
            if (n!=-1 && n < opciones.length) {
            setSeleccion(n);
            seleccionado = false;
            break;
            }else if(n==-1 && n <opciones.length && n > opciones.length){
                break;
            }
        }
    }

    public void obtenerJugador() throws IOException {
        boolean select = true;
        while (select) {
            Object[] opciones = {"Crear jugador Nuevo", "Ingresar ID de jugador existente"};
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
                    String nombre = JOptionPane.showInputDialog(null, "Ingresa el Nombre del jugador");
             try{
                    if (!nombre.isEmpty()) {
                        ctrlPelea.getCtrlJugadores().crearJugador(nombre);
                        ctrlPelea.setJugador(ctrlPelea.getCtrlJugadores().getJugadores().get(ctrlPelea.getCtrlJugadores().getJugadores().size() - 1));
                        select = false;
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Necesita ingresar un nombre, no se aceptan campos vacios");
                        break;
                    }
             }catch(NullPointerException e){
             JOptionPane.showMessageDialog(null, "Necesita ingresar un nombre, no se aceptan campos vacios");
             break;
             }
                case 1:

                    String id = JOptionPane.showInputDialog(null, "Ingresa el ID del jugador");
     try{
       
                    if (!id.isEmpty() && id.matches("[0-9]+")) {
                        getCtrlPelea().setJugador(getCtrlPelea().getCtrlJugadores().buscarJugador(Integer.parseInt(id)));
                      if (getCtrlPelea().getJugador()==null) {
                        JOptionPane.showMessageDialog(frame, "No se encontro al jugador");
                        select = true;
                        break;
                    }
                        select = false;
                        break;
                    } else if (id.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "No ha ingresado nada");
                        break;
                    } else if (!id.matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(frame, "Solo se pueden ingresar números");
                        break;
                    }
                 
     }catch(NullPointerException e ){
     JOptionPane.showMessageDialog(frame, "No ha ingresado nada, o ha ingresado una ID fuera de los limites");
                        break;
     }catch(NumberFormatException e ){
     JOptionPane.showMessageDialog(frame, "No ha ingresado nada, o ha ingresado una ID fuera de los limites");
                        break;
     }
                default:
                    break;
            }
        }
    }

    public void mensajeSeleccion() {
        setLog("El jugador selecciono a: " + ctrlPelea.getSuperHeroePlayer().getNombre() + "\n");
        setLog("El CPU selecciono a: " + ctrlPelea.getSuperHeroeCPU().getNombre() + "\n");
    }

    void cambiarJugador() throws IOException {
        ctrlPelea.getCtrltiempo().getTimer().stop();
        String id = JOptionPane.showInputDialog(null, "Ingresa el ID del jugador");
        int idNum = Integer.valueOf(id);
        System.out.println(ctrlPelea.getJugador().getId());
        

        if (!id.isEmpty() && ctrlPelea.getJugador().getId()!=idNum) {
            ctrlPelea.setJugador(ctrlPelea.getCtrlJugadores().buscarJugador(Integer.parseInt(id)));
            this.setLog("Jugador cambiado a "+this.getCtrlPelea().getJugador().getNombre()+"\n");
            ctrlPelea.getCtrltiempo().getTimer().start();
            
        }else if (ctrlPelea.getJugador().getId()==idNum) {
            JOptionPane.showMessageDialog(null, "El ID el usuario es el mismo que esta en uso");
        } else if (ctrlPelea.getJugador() == null) {
            JOptionPane.showMessageDialog(null, "No se encontro al jugador");
        }

    }

    public VistaPrincipal getVstPrincipal() {
        return vstPrincipal;
    }

    public void setVstPrincipal(VistaPrincipal vstPrincipal) {
        this.vstPrincipal = vstPrincipal;
    }

    public void iniciarConteo(JLabel label) {
        getCtrlPelea().getCtrltiempo().setLabel(label);
        getCtrlPelea().getCtrltiempo().getTimer().start();
    }

}
