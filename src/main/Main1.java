/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Pasos a seguir para uso de programa de clinica odontologica
 * 1 - Se debe crear médicos y pacientes
 * 2 - Se debe crear la cita
 *       Sirve para separar una consulta
 * 3 - Paciente va a consulta
 *       Atender a paciente
 * 4 - Se puede acceder a historial medico (TODOS LOS PACIENTES)
 * 5 - Se puede acceder a tratamiento
 */
public class Main1 {
    public static void main(String[] args) {
        Date horaCita;
        DateFormat hourFormat = new SimpleDateFormat("HH:mm");
        horaCita=new Date(2020,01,01,0,0);
        long horario= 0;
        long minutero=10;
        long hora = horaCita.getTime()+ horario*60*60*1000+ minutero*60*1000;
        horaCita.setTime(hora);
        System.out.println(hourFormat.format(horaCita));
    }
}
