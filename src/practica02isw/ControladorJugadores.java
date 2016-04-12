/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica02isw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erick
 */
public class ControladorJugadores {
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private File file = new File("src\\jugadores.csv");

    public ControladorJugadores() {
    }
         
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
 public void cargarArchivo() throws FileNotFoundException, IOException{
  
   if (!file.exists()) {
      System.err.println("jugadores.csv NO EXISTE, CREANDO ARCHIVO");
       try {
           file.createNewFile();
       } catch (IOException ex) {
           Logger.getLogger(ControladorPeleadores.class.getName()).log(Level.SEVERE, null, ex);
       }
   } else if (file.exists()==true) {
      System.err.println("ARCHIVO ENCONTRADO");
     
       try (BufferedReader br = new BufferedReader(new FileReader(file))) {
           String line;
           String[] token;
           while ((line = br.readLine()) != null) {
               token=line.split(",");
               jugadores.add(new Jugador(Integer.parseInt(token[0]),token[1],Integer.parseInt(token[2]),Integer.parseInt(token[3])));
               System.out.println(jugadores.get(jugadores.size()-1).archivar());
           }
           System.err.println("IMPORTADOS: "+jugadores.size()+" JUGADORES");
       }
   }   
 }
 
    public void guardarArchivo(){
   String lista = new String();
       for (int i = 0; i < jugadores.size(); i++) {
           lista =lista + jugadores.get(i).archivar()+"\n";
       }
       try {
            file.delete();
            boolean appendToFile = true;
            PrintWriter pw;
            if (appendToFile) {
                pw = new PrintWriter(new FileWriter(file, true));
            } else {
                pw = new PrintWriter(new FileWriter(file));
            }
            pw.print(lista);
            System.out.println(lista);
            pw.flush();
            pw.close();
            
            System.out.println("Archivo actualizado "+ file.lastModified());
        } catch (IOException ex) {
            Logger.getLogger(ControladorPeleadores.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
 
 public void crearJugador(String nombre) throws IOException{
     cargarArchivo();  
     Jugador jugadorNuevo;
       jugadorNuevo = new Jugador(jugadores.size()+1,nombre,0,0);
       jugadores.add(jugadorNuevo);
       guardarArchivo();
 }
 
 public Jugador buscarJugador(int j) throws IOException{
     cargarArchivo();
     return jugadores.get(j);
 }
 
 
}