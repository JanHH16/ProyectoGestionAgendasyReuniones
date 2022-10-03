/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendayreuniones;

/**
 *
 * @author 56974
 */
import java.util.ArrayList;

/**
 *
 * @author 56974
 */
public class Dias {
    
    private ArrayList<Reunion> reuniones; 
    private int numeroDias;
    private int numeroMes;
    private int numeroAnno;
    private String nombreApellido;
    

    public Dias(int numeroDias, int numeroMes, int numeroAnno, String nombreApellido) {
        this.numeroDias = numeroDias;
        this.numeroMes = numeroMes;
        this.numeroAnno = numeroAnno;
        this.nombreApellido=nombreApellido;
        reuniones = new ArrayList();
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }
    
 
    public int getNumero() {
        return numeroDias;
    }

    public void setNumero(int numeroDias) {
        this.numeroDias = numeroDias;
    }
    
    public void agregarReunion(Reunion x){
        reuniones.add(x);
    
    }

    public ArrayList<Reunion> getReuniones() {
        return reuniones;
    }

    public int getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(int numeroDias) {
        this.numeroDias = numeroDias;
    }

    public int getNumeroAnno() {
        return numeroAnno;
    }

    public void setNumeroAnno(int numeroAnno) {
        this.numeroAnno = numeroAnno;
    }

    public int getNumeroMes() {
        return numeroMes;
    }

    public void setNumeroMes(int numeroMes) {
        this.numeroMes = numeroMes;
    }
    

//    @Override
//    public String toString() {
//        return "Dias = " + numeroDias +"\n"+"Mes = " + numeroMes + "\n" + "Año = " +numeroAnno+ "\n" + "Reuniones:\n"+ reuniones;
//    }

    /**
     *
     * @param a
     * @param b
     * @param c
     * @param d
     */

    public void mostrar(int a,int b,int c,ArrayList<Reunion> d){
        
        d.forEach(data -> {
            data.data_toda(a, b, c);
        });
        
    }
    

    
    public  boolean seguridad(int dia, int mes){
        
        return (dia>0 && dia<31) && (mes>0 && mes<13);
    }
    
    public  boolean seguridad(int anno){
        
        return anno>=2022;
    
    }
}
