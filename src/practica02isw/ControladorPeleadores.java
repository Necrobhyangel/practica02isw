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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import practica02isw.heroes.CaptainAmerica;
import practica02isw.heroes.Hulk;
import practica02isw.heroes.IronMan;
import practica02isw.heroes.Spiderman;
import practica02isw.heroes.Wolverine;

/**
 *
 * @author Erick
 * @author Borre
 */
public class ControladorPeleadores {
    private ArrayList<SuperHeroe> superHeroe = new ArrayList<>();
    Spiderman spiderman;
    IronMan ironman;
    CaptainAmerica capAme;
    Wolverine wolverine;
    Hulk hulk;
    // SuperHeroe heroe;
    private File file = new File("src\\peleadores.csv");

    public ControladorPeleadores() {
    }
 
     
     
   public SuperHeroe seleccionarSuperHeroeP1(int seleccion){
        try {
            cargarArchivo();
        } catch (IOException ex) {
            Logger.getLogger(ControladorPeleadores.class.getName()).log(Level.SEVERE, null, ex);
        }
   SuperHeroe superHeroeSelect = superHeroe.remove(seleccion); 
   return superHeroeSelect;
   }
   
  public SuperHeroe seleccionarSuperHeroeCPU(){
   Random rnd = new Random();     
   int seleccionCPU = rnd.nextInt(superHeroe.size());
   SuperHeroe cpu = superHeroe.remove(seleccionCPU);
   eliminarPeleadores();
   return cpu;   
   }
   
   public void cargarArchivo() throws FileNotFoundException, IOException{
  
   
   if (!file.exists()) {
      System.err.println("peleadores.dat NO EXISTE, CREANDO ARCHIVO");
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
               superHeroe.add(new SuperHeroe(token[0],Double.valueOf(token[1]),Double.valueOf(token[2]),token[3]));
               System.out.println(superHeroe.get(superHeroe.size()-1).archivar());
           }
           
           SuperHeroe[] array = new SuperHeroe[superHeroe.size()];
           array =superHeroe.toArray(array);
           
          spiderman = new Spiderman(array[0].getNombre(),array[0].getVida(),array[0].getAtaque(),array[0].getRutaImg());
          ironman = new IronMan(array[1].getNombre(),array[1].getVida(),array[1].getAtaque(),array[1].getRutaImg());
          capAme = new CaptainAmerica(array[2].getNombre(),array[2].getVida(),array[2].getAtaque(),array[2].getRutaImg());
          wolverine = new Wolverine(array[3].getNombre(),array[3].getVida(),array[3].getAtaque(),array[3].getRutaImg());
          hulk = new Hulk(array[4].getNombre(),array[4].getVida(),array[4].getAtaque(),array[4].getRutaImg());
          
          superHeroe.set(0, spiderman);
          superHeroe.set(1, ironman);
          superHeroe.set(2, capAme);
          superHeroe.set(3, wolverine);
          superHeroe.set(4, hulk);
           
           System.err.println("IMPORTADOS: "+superHeroe.size()+" SUPERHEROES");
       }
   }
   
   }
   public void guardarArchivo(){
   String lista = new String();
       for (int i = 0; i < superHeroe.size(); i++) {
           lista =lista + superHeroe.get(i).archivar()+"\n";
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
  
   public Object[] mostrarNombres() throws IOException{
       cargarArchivo();
       ArrayList nombres = new ArrayList();
       for (int i = 0; i < superHeroe.size(); i++) {
           nombres.add(superHeroe.get(i).getNombre());
       }
       return nombres.toArray();
   }
   
   public void eliminarPeleadores(){
      superHeroe.removeAll(superHeroe);
   }
   
}
