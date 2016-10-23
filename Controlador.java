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
    
    /**
     * Constructor for objects of class Controlador1
     */
    public Controlador(){
        v = new Visualizador(); // inicializa una instancia del visualizador
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
        String datosArch = "";
        String linea = "";           
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
        
        if(fn == null || fn.getName().equals("")){
            v.muestreError("¡Error!", "Se ha producido un error. El nombre de archivo es inválido, no existe o está corrupto");
        }else{ // Opción 3, el archivo existe y se puede manipular
            try{
                FileReader fr = new FileReader(fn); // toma el nombre del archivo y lo convierte a algo que el Buffer Reader puede procesar
                BufferedReader in = new BufferedReader(fr); // hace una instancia de Buffered Reader que recibe los datos del archivo
                
                while(linea != null){
                    linea = in.readLine();
                    datosArch += linea;
                }
                v.muestre("Datos del archivo: " + datosArch);
            }catch(IOException e){
                v.muestreError("Se ha producido un error. El nombre de archivo es inválido, no existe o está corrupto","¡Error!");
            }
        }

            
        
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



}
