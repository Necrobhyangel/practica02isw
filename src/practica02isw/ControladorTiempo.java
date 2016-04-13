/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica02isw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Erick
 */
public class ControladorTiempo implements ActionListener {
int tiempo;
JLabel label;
Timer timer = new Timer(1000,this);
boolean end = false;

    public ControladorTiempo(int tiempo, JLabel label) {
        this.tiempo = tiempo;
        this.label = label;
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
        }
}
}