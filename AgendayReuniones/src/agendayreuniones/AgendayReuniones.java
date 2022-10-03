/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendayreuniones;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
/**
 *
 * @author 56974
 */
public class AgendayReuniones {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    private static AgendayReuniones instancia = null;
    
    private AgendayReuniones(){
        
    }
    
    public static AgendayReuniones obtenerInstancia(){
        
        if(instancia == null)
            instancia = new AgendayReuniones();
        
        return instancia;
    }
            
        public void menu() throws IOException {
       
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        
         int numero;
         int numeroMes;
         int numeroAnno;
         int horaInicio,minInicio,horaFinal,minFinal;
         Dias nuevoDia;
         String actividad; 
         String nombreYapellido;
         Reunion nuevaReunion;
         String hora, horaDos;
         String fecha;
            
         HashMap<String,ArrayList<Dias>>agenda=new HashMap<>();
         
         llenr_con_datos(agenda);
      
         int caso;
         
         do{
             creaMenu();
             caso = Integer.parseInt(lector.readLine());
                  
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
                 horaDos=lector.readLine();
                 String[] partes_Hora2=horaDos.split(":");
                 horaFinal=Integer.parseInt(partes_Hora2[0]);
                 minFinal=Integer.parseInt(partes_Hora2[1]);
                 
            //     Dias ddia = new Dias();
                             
                 nuevoDia = new Dias(numero,numeroMes,numeroAnno,nombreYapellido);
                 nuevaReunion= new Reunion(actividad,horaInicio,minInicio,horaFinal,minFinal);
                 
                 nuevoDia.agregarReunion(nuevaReunion);
                if(nuevoDia.seguridad(nuevoDia.getNumeroAnno())&& nuevoDia.seguridad(nuevoDia.getNumero(), nuevoDia.getNumeroMes()) && nuevaReunion.seguridad(horaInicio, minInicio, horaFinal, minFinal) && nuevaReunion.seguridad(horaInicio,horaFinal) && minFinal>minInicio ){
                 
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
            
                 break;
                 
             case 2: //mostrar agenda
                 
                 casoDos(agenda);
                 break;
                 
             case 3:
                        
                  casoTres(agenda);
                  break;
         }
         }while(caso!=4);
         
      
    }
    
    public static void creaMenu(){
        
        System.out.println("-----------------------------------");
        
        System.out.println("Menu de operaciones");
        System.out.println("1 - Insertar a la agenda");
        System.out.println("2 - Mostrar agenda de persona");
        System.out.println("3 - Mostrar toda la agenda");
        System.out.println("4 - Salir");
        
        System.out.println("-----------------------------------\n");
    }
    
    public static void llenr_con_datos(HashMap<String,ArrayList<Dias>>agenda) throws FileNotFoundException, IOException{
        
     String file = "datos.csv";
     BufferedReader reader = null;
     String line = "";
     
     
     reader = new BufferedReader(new FileReader(file));
     
     while ((line = reader.readLine()) != null){
         
         String [] row =line.split(",");
         
         
         Dias nuevoDia = new Dias(Integer.parseInt(row[1]) ,Integer.parseInt(row[2]),Integer.parseInt(row[3]),row[0]);
         Reunion nuevaReunion= new Reunion(row[4],Integer.parseInt(row[5]),Integer.parseInt(row[6]),Integer.parseInt(row[7]),Integer.parseInt(row[8]));
         nuevoDia.agregarReunion(nuevaReunion);
         boolean isKeyPresent = agenda.containsKey(row[0]);
         
         if (isKeyPresent){
                     agenda.get(row[0]).add(nuevoDia);
                       
         }else{
                     
         ArrayList<Dias> cadena = new ArrayList<>();
         cadena.add(nuevoDia);
         agenda.put(nuevoDia.getNombreApellido(),cadena);
                     
         }
       
     }
        
 }
    
    public static void casoTres( HashMap<String,ArrayList<Dias>>agenda){
        
        ( agenda.keySet( ).stream().map(key -> {
            System.out.println(key);
            return key;
        })).map(key -> {
                agenda.get(key).forEach((Dias sa) -> {
                    
                    sa.mostrar(sa.getNumeroDias(), sa.getNumeroMes(), sa.getNumeroAnno(), sa.getReuniones());
                });
                return key;
            }).forEachOrdered(_item -> {
                System.out.println("-----------------------------------\n");
            });
    
    }
    
    public static void casoDos(HashMap<String,ArrayList<Dias>>agenda) throws IOException{
        
         BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        
         System.out.println("Busqueda por nombre y apellido");
                 String clave=lector.readLine();
                 
                 if(agenda.isEmpty()){
                     
                 System.out.println("No hay gente en la agenda");    
                    
                 }
                 
                 else if (agenda.containsKey(clave)){
                     
                     agenda.get(clave).forEach(sa -> {
                         
                       sa.mostrar(sa.getNumeroDias(), sa.getNumeroMes(), sa.getNumeroAnno(), sa.getReuniones());
                 });
                     
                 }else{
                     
                     System.out.println("Eta persona no tiene registros");
                 }
    }
}
    

