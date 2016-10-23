import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Write a description of class Visualizador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Visualizador extends JOptionPane{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void muestre(String msj){
       this.showMessageDialog(null, msj);
    }
    
    public void muestreError(String titulo, String msj){
       this.showMessageDialog(null, titulo, msj, JOptionPane.ERROR_MESSAGE);
    }
    
    public int leaEntero(String msj){       
       return Integer.parseInt(this.showInputDialog(msj));
    }
    
    public String leaHilera(String msj){       
       return this.showInputDialog(msj);
    }
    
    
}
