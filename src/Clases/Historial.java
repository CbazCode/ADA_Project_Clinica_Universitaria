package Clases;

import java.util.Date;
import java.io.*;

public class Historial {

    private int codigoHist;
    int DNI;
    Date fechaHist;

    //Fecha fechaHist
    /*----------------------------------------Constructors--------------------------------------*/
    public Historial() {

    }

    public Historial(int codigoHist, int DNI, Date fechaHist) {
        this.codigoHist = codigoHist;
        this.DNI = DNI;
        this.fechaHist = fechaHist;
    }

    /*----------------------------------------Getters and Setters--------------------------------------*/
    public int getCodigoHist() {
        return codigoHist;
    }

    public void setCodigoHist(int codigoHist) {
        this.codigoHist = codigoHist;
    }

    public int getDNI() {
        return DNI;
    }

    public Date getFechaHist() {
        return fechaHist;
    }

    public void setFechaHist(Date fechaHist) {
        this.fechaHist = fechaHist;
    }

    public boolean existe_Historial(String DNI) {
        try {
            FileReader fr = new FileReader("src/archivos/historial.txt");
            BufferedReader br = new BufferedReader(fr);
            Object[] linea = br.lines().toArray();
            for (Object linea1 : linea) {
                String[] row = linea1.toString().split(" ");
                if (row[1].equals(DNI)) {
                    return true;
                }
            }
            br.close();
            return false;
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return true;
    }

    public static void escribir(Historial historial) {
        File file;
        FileWriter fichero = null;
        PrintWriter pw;
        try {
            file = new File("src/archivos/historial.txt");
            fichero = new FileWriter(file.getAbsoluteFile(), true);
            pw = new PrintWriter(fichero);
            pw.println(historial.DNI + " " + historial.codigoHist + " " + historial.fechaHist);

        } catch (IOException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException e2) {
                System.out.println("Error: " + e2);
            }
        }
    }

}
