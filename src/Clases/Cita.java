package Clases;

import com.toedter.calendar.JCalendar;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cita {
    private int codigoHist;
    private int DNI;
    private String Especialidad;
    private String fechaCita;
    private String horaCita;
    private float porPagar;
    


    /*----------------------------------------Constructors--------------------------------------*/
    public Cita() {
       
    }
    public Cita(int codigoHist, int DNI, String especialidad,String fechaCita, String horaCita,float porPagar) {
        this.codigoHist = codigoHist;
        this.DNI = DNI;
        Especialidad = especialidad;
        this.fechaCita = fechaCita; // Verificar si es necesario pasar
                                    // por parametro de constructor o poner metodo setDate() dentro de este.
        this.horaCita=horaCita;
        this.porPagar=porPagar;

    }

     /*----------------------------------------Getters and Setters--------------------------------------*/
    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

   
    public int getCodigoHist() {
        return codigoHist;
    }

    public void setCodigoHist(int codigoHist) {
        this.codigoHist = codigoHist;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }
    
    public float getPorPagar() {
        return porPagar;
    }

    public void setPorPagar(float porPagar) {
        this.porPagar = porPagar;
    }
    
    @Override
    public String toString() {
        return codigoHist + "  " + DNI + "  "+Especialidad + "  " + fechaCita + "  "+horaCita +"  "+ porPagar;
    }


    
}
