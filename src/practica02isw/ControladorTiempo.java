/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica02isw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Erick
 * @author Borre
 */
public class ControladorTiempo implements ActionListener {
private final ControladorPelea ctrlPelea;
private int tiempo;
private JLabel label;
private Timer timer = new Timer(100,this);
private boolean end = false;

    public ControladorTiempo(ControladorPelea ctrlPelea, int tiempo) {
        this.ctrlPelea = ctrlPelea;
        this.tiempo = tiempo;
    }
    
    

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }


    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }  

    @Override
    public void actionPerformed(ActionEvent ae) {
     tiempo--;
        label.setText(String.valueOf(tiempo));
        if(tiempo<=0)
        {
            timer.stop();
            ctrlPelea.setPeleaEnCurso(false);
            JOptionPane.showMessageDialog(null,"TIEMPO TERMINADO");
            tiempo = ctrlPelea.getTiempo();
            try {
                ctrlPelea.declararGanador();
            } catch (IOException ex) {
                Logger.getLogger(ControladorTiempo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}


}