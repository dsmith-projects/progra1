import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * Write a description of class Controlador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controlador implements Serializable{
    static Visualizador v;
    static Modelo m;
    static String listaInstituciones;
    static String path;
    static ArrayList<String> paths = new ArrayList<String>();
    static ArrayList<String> lineas = new ArrayList<String>();
    static ArrayList<File> files = new ArrayList<File>(); 
    
    /**
     * Constructor for objects of class Controlador1
     */
    public Controlador(){
        v = new Visualizador(); // inicializa una instancia del visualizador
        m = new Modelo();
        listaInstituciones = "";
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main(String args[]){
        Controlador c = new Controlador();
        int opcion = 0;
        
        v.muestre("Sistema de análisis de datos de calidad de agua");
        
        do{
            c.leaArchivos();

            try{
                opcion = v.leaEntero("Si desea leer otro archivo digite un 1");
            }catch(NumberFormatException e){
                v.muestreError("Entrada no reconocida.","¡Error!");
            }
            
        }while(opcion == 1);
        
        System.exit(0);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void leaArchivos(){
        
        int resultadoVentana ;
        boolean archivoLeido = false;
        
        //v.muestreError("¡check point!", "llega acá ");
        
        JFileChooser fc = new JFileChooser(); // instanciamos a File Chooser.        
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        v.muestre("Seleccione el archivo que desea abrir."); // Sin este diálgo, el programa se queda pegado
        
        resultadoVentana = fc.showOpenDialog(null);
        
        // Opciones posibles: 1. Cancela operación / 2. Escoge un archivo / 3. Error
        // Opción 1, el usuario decide presionar el botón de cancelar
        if(resultadoVentana == 1){ // 1 es equivalente a JFileChooser.CANCEL_OPTION que devuelve una contante
            return;
        }
        
        // Opción 2, el usuario selecciona un archivo
        File fn = fc.getSelectedFile();
        archivoLeido = m.proceseArchivo(fn);
        
        if(archivoLeido){
            v.muestre("Archivo leído correctamente");
        }else{
            v.muestreError("Se ha producido un error. El nombre de archivo es inválido, no existe o está corrupto","¡Error!");
        }
        
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public String leaEncabezado(){
        return lineas.get(0);        
    }

    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void muestreDatosLeidosDeArchivo(int y){
        int opcion = 0;
        
        String instituciones = ""; 
        String institucion = "";
        
        do{
            institucion = v.leaHilera("Se leyeron datos de las siguientes instituciones:" + instituciones + 
            "\nPara obtener los resultados, ingrese el nombre de la institución o las instituciones separados por una coma");
            //mostramos resultados de esa institución
            
        }while(opcion == 1);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void creeArchivoResultados(int y){
        // put your code here
        
    }
    
    public void setPath(String path){
        this.path = path;
    }



}
