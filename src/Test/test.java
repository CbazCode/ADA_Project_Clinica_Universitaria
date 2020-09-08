/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.*;


/**
 *
 * @author Kioshi
 */
public class test {
    public static void main(String[] args) {
        
        
       // modificar();
        
        escribir();
        
    }
    
    static void leer(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File ("src/archivos/medicos.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String linea;
           while((linea=br.readLine())!=null)
                System.out.println(linea);
            }
        catch(Exception e){
             e.printStackTrace();
        }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
            try{                    
               if( null != fr ){   
                  fr.close();     
               }                  
            }catch (Exception e2){ 
               e2.printStackTrace();
            }
        }
    }
    static void escribir(){
        File file = new File("src/archivos/medicostemp1.txt");
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(file.getAbsoluteFile(), true);
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++)
                pw.println("Linea " + i);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
     static void modificar(){
        
        File file = new File("src/archivos/medicostemp1.txt");
        File fileAntiguo = new File("src/archivos/medicos.txt");
        
        BufferedReader br;
        
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        
        
        try{
             fichero = new FileWriter(file.getAbsoluteFile(), true);
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++)
                pw.println("Linea " + i);
            
            /*
            if(fileAntiguo.exists()){
                br = new BufferedReader(new FileReader(fileAntiguo));
                Object[] linea = br.lines().toArray();
                for(int i = 0; i<linea.length;i++){
                    String[] row = linea[i].toString().split("  ");
                    if(row[0].equals(String.valueOf(DniAnterior))){
                        System.out.println("Ingresa 1 vez");
            
                    }else{
                        
                    }
                }
                //br.close();
                //fileAntiguo.delete();
                //borrar(fileAntiguo);
                //fileNuevo.renameTo(fileAntiguo);
                
            } */
            
             
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
