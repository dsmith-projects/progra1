import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * Write a description of class Modelo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Modelo{
    // instance variables - replace the example below with your own
    static ArrayList<String> rutas;
    static ArrayList<String> instituciones;
    static int indice = 0;
    static ArrayList<String> lineas = new ArrayList<String>();
    static ArrayList<String> encabezado = new ArrayList<String>(); // contiene los títulos de las columnas 
    static String linea1; // Encabezado tal y como es leído
    
    int indiceOxigeno = 0;
    int indiceNitrato = 0;
    int indiceFosfato = 0;
    int indiceAcidez = 0;
    
    double oxigeno = 0;
    double nitrato = 0;
    double fosfato = 0;
    double acidez = 0;
    
    String claseOxigeno = "";
    String claseNitrato = "";
    String claseFosfato = "";
    String claseAcidez = "";

    /**
     * Constructor for objects of class Modelo
     */
    public Modelo()    {
        // initialise instance variables
        rutas = new ArrayList<String>(10);
        instituciones = new ArrayList<String>(10);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void agregueRuta(String ruta){
        rutas.add(ruta);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void agregueInstitucion(String institucion){
        instituciones.add(institucion);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public boolean proceseArchivo(File fn){
        boolean exitoso;
        String linea;        
        int contador = 0;
        
        System.out.println("Va bien");
        
        if(fn == null || fn.getName().equals("")){
            exitoso = false;            
        }else{ // Opción 3, el archivo existe y se puede manipular
            try{
                FileReader fr = new FileReader(fn); // toma el nombre del archivo y lo convierte a algo que el Buffer Reader puede procesar
                BufferedReader in = new BufferedReader(fr); // hace una instancia de Buffered Reader que recibe los datos del archivo
                
                while((linea = in.readLine()) != null){
                    
                    
                    if(contador == 0){ // obtiene títulos
                        linea1 = linea;
                        conviertaAArreglo(linea1);                        
                    }else{ // obtiene nombre institución ?????????? falta obtener institución
                        lineas.add(linea);
                    }
                    contador++;
                }
                exitoso = true;
                
            }catch(IOException e){
                exitoso = false;                
            }
        }
        
        return exitoso;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void conviertaAArreglo(String linea){
        String pedazo = "";
        StringTokenizer tokenizedString = new StringTokenizer(linea,";"); //
        
        while(tokenizedString.hasMoreTokens()){
            pedazo = tokenizedString.nextToken();
            encabezado.add(pedazo);
            System.out.println(pedazo + "prueba*");
        }
        
        /*for(String i: encabezado){
            System.out.println(i + "\n");
        }*/
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void determineClase(){ // no se pasa por parámetro porque al han sido establecido en los atributos
        // determina clase del fosfato
        if(getFosfato() == -1){
            claseFosfato = "1, 2 o 3";
        }else if(getFosfato() == 0.01){
            claseFosfato = "4 o 5";
        }else{
            claseFosfato = "No hay dato";
        }
        
        // determina clase del nitrato
        if(getNitrato() < 5){
            claseNitrato = "1";
        }else if(getNitrato() >= 5 && getNitrato() < 10){
            claseNitrato = "2";
        }else if(getNitrato() >= 10 && getNitrato() < 15){
            claseNitrato = "3";
        }else if(getNitrato() >= 15 && getNitrato() < 20){
            claseNitrato = "4";
        }else if(getNitrato() >= 20){
            claseNitrato = "5";
        }else{
            claseNitrato = "No hay dato";
        }
        
        // determina clase del oxigeno
        if(getOxigeno() == -1){
            claseOxigeno = "1, 2, 3, 4 o 5";
        }else{
            claseOxigeno = "No hay dato";
        }
        
        // determina clase del pH
        if((getAcidez() >= 5.5 && getAcidez() < 6) || (getAcidez() > 9 && getAcidez() <= 9.5)){
            claseAcidez = "4 o 5";
        }else if((getAcidez() >= 6 && getAcidez() < 6.5) || (getAcidez() > 8.5 && getAcidez() <= 9)){
            claseAcidez = "2";
        }else if(getAcidez() >= 6.5 && getAcidez() <= 8.5){
            claseAcidez = "3";
        }else{
            claseAcidez = "No hay dato";
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public double getFosfato(){
        return fosfato;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public double getNitrato(){
        return nitrato;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public double getOxigeno(){
        return oxigeno;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public double getAcidez(){
        return acidez;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void setFosfato(double fosfato){
        this.fosfato = fosfato;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void setNitrato(double nitrato){
        this.nitrato = nitrato;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void setOxigeno(double oxigeno){
        this.oxigeno = oxigeno;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void setAcidez(double acidez){
        this.acidez = acidez;
    }



}
