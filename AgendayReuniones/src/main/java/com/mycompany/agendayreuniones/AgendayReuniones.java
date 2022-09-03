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

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//
public class AgendayReuniones {

   /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
   
      
        public static void main(String[] args) throws IOException {
       
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        
        
       
         
         int numero;
         int numeroMes;
         int numeroAnno;
         int horaInicio,minInicio,horaFinal,minFinal;
         Dias nuevoDia;
         String actividad; 
         String nombreYapellido;
         Reunion nuevaReunion;
         String hora;
         String fecha;
         
         
         HashMap<String,ArrayList<Dias>>agenda=new HashMap<>();
         
         llenr_con_datos(agenda);
       
         
      
         
         int caso;
         
       
         do{
             creaMenu();
             caso = Integer.parseInt(lector.readLine());
             
         // switch para poder hacer el menu funcional
         switch(caso){
             
             
             
             
             case 1:// ingresar
                 
                 
                 System.out.println("Nombre y Apellido");
                 nombreYapellido=lector.readLine();
                 System.out.println("Ingrese fecha (dd:mm:aa)");
                 fecha=lector.readLine();
                 String[] partes=fecha.split(":");
                 numero=Integer.parseInt(partes[0]);
                 numeroMes=Integer.parseInt(partes[1]);
                 numeroAnno=Integer.parseInt(partes[2]);
                 
                 System.out.println("Nombre de la actividad");
                 actividad=lector.readLine();
                                 
                 System.out.println("Hora de inicio (HH:MM)");
                 hora=lector.readLine();
                 String[] partes_Hora1=hora.split(":");
                 horaInicio=Integer.parseInt(partes_Hora1[0]);
                 minInicio=Integer.parseInt(partes_Hora1[1]);
                
                 
                 System.out.println("Hora de fin (HH:MM)");
                 hora=lector.readLine();
                 String[] partes_Hora2=hora.split(":");
                 horaFinal=Integer.parseInt(partes_Hora2[0]);
                 minFinal=Integer.parseInt(partes_Hora2[1]);
                             
                 nuevoDia = new Dias(numero,numeroMes,numeroAnno,nombreYapellido);
                 nuevaReunion= new Reunion(actividad,horaInicio,minInicio,horaFinal,minFinal);
                                  
                
                
                 
                 nuevoDia.agregarReunion(nuevaReunion);
                
                 
                 
                if(nuevoDia.seguridad(nuevoDia.getNumeroAnno())&& nuevoDia.seguridad(nuevoDia.getNumero(), nuevoDia.getNumeroMes()) && nuevaReunion.seguridad(horaInicio, minInicio, horaFinal, minFinal) && nuevaReunion.seguridad(horaInicio,horaFinal) ){
                 
                 boolean isKeyPresent = agenda.containsKey(nombreYapellido);
                 
                 if (isKeyPresent){
                     
                      
                     agenda.get(nombreYapellido).add(nuevoDia);
                     
                    
               
                 }else{
                     
                     ArrayList<Dias> cadena = new ArrayList<>();
                     cadena.add(nuevoDia);
                     agenda.put(nuevoDia.getNombreApellido(),cadena);
                     
                 }
                 
                }else{
                    
                    System.out.println("Ingrese valores enteros y dentro de los limites");
                
                }
             //    cadena.clear();
                 break;
                 
             case 2: //mostrar agenda
                 

                 System.out.println("Busqueda por nombre y apellido");
                 String clave=lector.readLine();
                 
                 if(agenda.isEmpty()){
                     
                 System.out.println("No hay gente en la agenda");    
                 break;    
                 }
                 
                 else if (agenda.containsKey(clave)){
                     
                     agenda.get(clave).forEach(sa -> {
                         
                       sa.mostrar(sa.getNumeroDias(), sa.getNumeroMes(), sa.getNumeroAnno(), sa.getReuniones());
                 });
                 }else{
                     
                     System.out.println("Eta persona no tiene registros");
                     break;
                 }
              
                 break;         
         }
         }while(caso!=4);
         
      
    }
    
        // metodo para crear el menu en consola
    public static void creaMenu(){
        
        System.out.println("-----------------------------------");
        
        System.out.println("Menu de operaciones");
        System.out.println("1 - Insertar a la agenda");
        System.out.println("2 - Mostrar agenda de personal");
        
        System.out.println("-----------------------------------\n");
    }
    
    // metodo para tener datos iniciales como lo pedian, SIA 1.4
    public static void llenr_con_datos(HashMap<String,ArrayList<Dias>>agenda){
        
        Random rand = new Random();
        
        String[] nombres={"Roberto Rosas","Luis Perez","Camilo Avila"};
        String[] actividades={"salir","comer","pasear"};
        
        int dia=rand.nextInt((30-1)+1)+1;
        int mes=rand.nextInt((12-1)+1)+1;
        int anno=2022;
        int dado = rand.nextInt(3);
        
        int horaInicio=rand.nextInt(24);
        int minInicio=rand.nextInt(60);
        int horaFinal=rand.nextInt(24);
        int minFinal=rand.nextInt(60);
        
        for(int i= 0; i<5;i++){
            
            Dias nuevoDia = new Dias(dia,mes,anno,nombres[dado]);
            Reunion nuevaReunion= new Reunion(actividades[dado],horaInicio,minInicio,horaFinal,minFinal);
            nuevoDia.agregarReunion(nuevaReunion);
            
            boolean isKeyPresent = agenda.containsKey(nombres[dado]);
            
            if (isKeyPresent){
                      
                     agenda.get(nombres[dado]).add(nuevoDia);
                     
                 }else{
                     
                     ArrayList<Dias> cadena = new ArrayList<>();
                     cadena.add(nuevoDia);
                     agenda.put(nuevoDia.getNombreApellido(),cadena);
                     
                 }
            
            dia=rand.nextInt((30-1)+1)+1;
            mes=rand.nextInt((12-1)+1)+1;
            dado = rand.nextInt(3);
            horaInicio=rand.nextInt(24);
            minInicio=rand.nextInt(60);
            horaFinal=rand.nextInt(24);
            minFinal=rand.nextInt(60);
    }
        
 }
    
}
