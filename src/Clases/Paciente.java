/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author ASISEHACE
 */
public class Paciente {
    private String apellidoPaternoPaciente;
    private String apellidoMaternoPaciente;
    private String nombrePaciente;
    private String estadoCivilPaciente;
    private String generoPaciente;
    private String fecha;
    private int dniPaciente;
    private int telefonoPaciente;
    private String seguroPaciente;
    private String problemasMedicos;

    /*----------------------------------------Constructors--------------------------------------*/
    public Paciente(){
        
    }
    public Paciente(String apellidoPaternoPaciente, String apellidoMaternoPaciente, String nombrePaciente, String estadoCivilPaciente, String generoPaciente, int dniPaciente, int telefonoPaciente, String seguroPaciente, String problemasMedicos, String fecha) {
        this.apellidoPaternoPaciente = apellidoPaternoPaciente;
        this.apellidoMaternoPaciente = apellidoMaternoPaciente;
        this.nombrePaciente = nombrePaciente;
        this.estadoCivilPaciente = estadoCivilPaciente;
        this.generoPaciente = generoPaciente;
        this.dniPaciente = dniPaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.seguroPaciente = seguroPaciente;
        this.problemasMedicos = problemasMedicos;
        this.fecha=fecha;
    }

    

    /*----------------------------------------Getters and Setters--------------------------------------*/
    public String getApellidoPaterno() {
        return apellidoPaternoPaciente;
    }

    public void setApellidoPaterno(String apellidoPaternoPaciente) {
        this.apellidoPaternoPaciente = apellidoPaternoPaciente;
    }

    public String getApellidoMaterno() {
        return apellidoMaternoPaciente;
    }

    public void setApellidoMaterno(String apellidoMaternoPaciente) {
        this.apellidoMaternoPaciente = apellidoMaternoPaciente;
    }

    public String getNombre() {
        return nombrePaciente;
    }

    public void setNombre(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getEstadoCivil() {
        return estadoCivilPaciente;
    }

    public void setEstadoCivil(String estadoCivilPaciente) {
        this.estadoCivilPaciente = estadoCivilPaciente;
    }


    public String getGenero() {
        return generoPaciente;
    }


    public void setGenero(String generoPaciente) {
        this.generoPaciente = generoPaciente;
    }


    public int getDni() {
        return dniPaciente;
    }


    public int getTelefono() {
        return telefonoPaciente;
    }


    public void setTelefono(int telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }


    public String getSeguro() {
        return seguroPaciente;
    }


    public void setSeguro(String seguroPaciente) {
        this.seguroPaciente = seguroPaciente;
    }


    public String getProblemasMedicos() {
        return problemasMedicos;
    }


    public void setProblemasMedicos(String problemasMedicos) {
        this.problemasMedicos = problemasMedicos;
    }
    
    //conexion
    //crud

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
