/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agendayreuniones;

/**
 *
 * @author janho
 */
public class Reunion {
    
    String actividad;
    int horaInicio;
    int minInicio;
    int horaFinal;
    int minFinal;
    
 
    public Reunion(String actividad,int horaInicio, int minInicio, int horaFinal, int minFinal) {
        this.horaInicio = horaInicio;
        this.minInicio = minInicio;
        this.horaFinal = horaFinal;
        this.minFinal = minFinal;
        this.actividad = actividad;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getMinInicio() {
        return minInicio;
    }

    public void setMinInicio(int minInicio) {
        this.minInicio = minInicio;
    }

    public int getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(int horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getMinFinal() {
        return minFinal;
    }

    public void setMinFinal(int minFinal) {
        this.minFinal = minFinal;
    }
    
    /**
     *
     * @param a
     * @param b
     * @param c
     
     */
    public void data_toda(int a, int b, int c){
        
         System.out.println(  "Dias = " + a +"\n"+"Mes = " + b + "\n" + "Año = " +c+ "\n"+"\n" +"Actividad: " + actividad + "\n" + "Hora Inicio: " + horaInicio + ":"+minInicio + "\n" + "Hora Termino: "+ horaInicio + ":"+minInicio +"\n");
    
    
    }

     
    // metodo para corroborar que la hora de inicio de la actividad sea valida
    public  boolean seguridad(int hi, int mi,int hf, int mf){
        
        return (hi>=0 && hi<=23) && (mi>=0 && mi<=60) && (hf>=0 && hf<=23) && (mf>=0 && mf<=60);
    }
    
    // metodo para corroborar que la hora final de la actividad sea mayor a la hora inicial
    public boolean seguridad(int hi, int hf){
        
        return (hf>=hi);
    
    
    }
}
