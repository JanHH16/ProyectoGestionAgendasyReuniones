    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import agendayreuniones.AgendayReuniones;
import agendayreuniones.Dias;
import agendayreuniones.Reunion;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vistas.SoloLetras.NoEsLetraExcepcion;
import static vistas.SoloLetras.pedirCadenaLetras;
import vistas.SoloNumeros.NoEsNumeroExcepcion;
import static vistas.SoloNumeros.pedirCadenaNumeros;


/**
 *
 * @author 56974
 */
public final class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    
     HashMap<String,ArrayList<Dias>>agenda;
   
     DefaultTableModel tabla;
     DefaultTableModel tabla2;
     DefaultTableModel tabla3;
     
    public NewJFrame() throws IOException {
        initComponents();
        agenda = new HashMap<>();
        
        tabla = new DefaultTableModel();
        tabla.addColumn("NOMBRE");
        
        tabla2 = new DefaultTableModel();
        tabla2.addColumn("DIA");
        tabla2.addColumn("MES");
        tabla2.addColumn("AÑO");
       
        tabla2.addColumn("ACTIVIDAD");
        tabla2.addColumn("HORA INICIO");
        tabla2.addColumn("MIN");
        tabla2.addColumn("HORA FINAL");
        tabla2.addColumn("MIN");
        
        llenr_con_datos(agenda);
        mostrarDatos();
        
        
        
        
    }
    
    public static void csv (HashMap<String,ArrayList<Dias>>agenda){
        
      try {
          try (FileWriter writer = new FileWriter("agenda.csv")) {
              ( agenda.keySet( ).stream().map(key -> {
                  try {
                      writer.write(key + "\n");
                  } catch (IOException ex) {
                      Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  return key;
              })).map((String key) -> {
                  agenda.get(key).forEach((Dias sa) -> {
                      
                      try {
                          writer.write("Dia : " + String.valueOf(sa.getNumeroDias())+"\n");
                          writer.write("Mes : " + String.valueOf(sa.getNumeroMes())+"\n");
                          writer.write("Anno : " + String.valueOf(sa.getNumeroAnno())+"\n");
                          writer.write("Actividad : " + sa.getReuniones().get(0).getActividad()+"\n");
                          writer.write("Hora Inicio : " + String.valueOf(sa.getReuniones().get(0).getHoraInicio())+":"+String.valueOf(sa.getReuniones().get(0).getMinInicio()) +"\n");
                          writer.write("Hora Final : " + String.valueOf(sa.getReuniones().get(0).getHoraFinal())+":"+String.valueOf(sa.getReuniones().get(0).getMinFinal()) +"\n");
                          writer.write("\n");
                          writer.write("\n");
                          
                      } catch (IOException ex) {
                          Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      
                     
                  });
                  return key;
              }).forEachOrdered(_item -> {
                  try {
                      writer.write("-----------------------------------\n");
                  } catch (IOException ex) {
                      Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                  }
              });
              
 
          }
          } 
          catch (IOException e) {
         // TODO Auto-generated catch block
          e.printStackTrace();
          }
    
    
    }
    
    public static void llenr_con_datos(HashMap<String,ArrayList<Dias>>agenda) throws IOException{
        
     String file = "datos.csv";
     BufferedReader reader = null;
     String line = "";
     
     
     reader = new BufferedReader(new FileReader(file));
     
     while ((line = reader.readLine()) != null){
         
         String [] row =line.split(",");
         
         errores(row);
         
         
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
    
    public static void errores(String [] a){
        
        String palabra;
        
         try {
                 palabra= pedirCadenaLetras(a[0]);
                 if (palabra.isEmpty())
                     throw new NoEsLetraExcepcion();
                 }catch(NoEsLetraExcepcion ex) {
                     System.out.println(ex.getMessage() + "\n");
                 }finally{
             }
        
         
        try {
                 palabra= pedirCadenaLetras(a[4]);
                 if (palabra.isEmpty())
                     throw new NoEsLetraExcepcion();
                 }catch(NoEsLetraExcepcion ex) {
                     System.out.println(ex.getMessage() + "\n");
                 }finally{
             }
        
        try {
                 palabra= pedirCadenaNumeros(a[1]);
                 if (palabra.isEmpty())
                     throw new NoEsNumeroExcepcion();
                 }catch(NoEsNumeroExcepcion ex) {
                     System.out.println(ex.getMessage() + "\n");
                 }finally{
             }
        
         try {
                 palabra= pedirCadenaNumeros(a[2]);
                 if (palabra.isEmpty())
                     throw new NoEsNumeroExcepcion();
                 }catch(NoEsNumeroExcepcion ex) {
                     System.out.println(ex.getMessage() + "\n");
                 }finally{
             }
         
          try {
                 palabra= pedirCadenaNumeros(a[3]);
                 if (palabra.isEmpty())
                     throw new NoEsNumeroExcepcion();
                 }catch(NoEsNumeroExcepcion ex) {
                     System.out.println(ex.getMessage() + "\n");
                 }finally{
             }
           try {
                 palabra= pedirCadenaNumeros(a[5]);
                 if (palabra.isEmpty())
                     throw new NoEsNumeroExcepcion();
                 }catch(NoEsNumeroExcepcion ex) {
                     System.out.println(ex.getMessage() + "\n");
                 }finally{
             }
           
            try {
                 palabra= pedirCadenaNumeros(a[6]);
                 if (palabra.isEmpty())
                     throw new NoEsNumeroExcepcion();
                 }catch(NoEsNumeroExcepcion ex) {
                     System.out.println(ex.getMessage() + "\n");
                 }finally{
             }
            
             try {
                 palabra= pedirCadenaNumeros(a[7]);
                 if (palabra.isEmpty())
                     throw new NoEsNumeroExcepcion();
                 }catch(NoEsNumeroExcepcion ex) {
                     System.out.println(ex.getMessage() + "\n");
                 }finally{
             }
             
              try {
                 palabra= pedirCadenaNumeros(a[8]);
                 if (palabra.isEmpty())
                     throw new NoEsNumeroExcepcion();
                 }catch(NoEsNumeroExcepcion ex) {
                     System.out.println(ex.getMessage() + "\n");
                 }finally{
             }
        
    }
     
  
 
    
    public void mostrarDatos(){
        
        tabla.setRowCount((agenda.keySet().size()));
        
        int contador = 0;
        Set<String> keys = agenda.keySet();
        for (String key : keys){
            tabla.setValueAt(key, contador, 0);
           
            contador++;
        }
      tabla1.setModel(tabla);
      
     // System.out.println((agenda.keySet()).size());
   
   
    }
    
     public void mostrarDatos(String llave){
        
         tabla2.setRowCount(agenda.get(llave).size());
        
       // int contador=0;
        
        if (agenda.containsKey(llave)){
            
                agenda.get(llave).forEach((Dias dia) -> {
                
                tabla2.setValueAt(dia.getNumeroDias() , agenda.get(llave).indexOf(dia), 0);
                tabla2.setValueAt(dia.getNumeroMes() , agenda.get(llave).indexOf(dia), 1);
                tabla2.setValueAt(dia.getNumeroAnno() , agenda.get(llave).indexOf(dia), 2);
                tabla2.setValueAt(dia.getReuniones().get(0).getActividad(),agenda.get(llave).indexOf(dia),3);
                tabla2.setValueAt(dia.getReuniones().get(0).getHoraInicio(),agenda.get(llave).indexOf(dia),4);
                tabla2.setValueAt(dia.getReuniones().get(0).getMinInicio(),agenda.get(llave).indexOf(dia),5);
                tabla2.setValueAt(dia.getReuniones().get(0).getHoraFinal(),agenda.get(llave).indexOf(dia),6);
                tabla2.setValueAt(dia.getReuniones().get(0).getMinFinal(),agenda.get(llave).indexOf(dia),7);
            //    mostrarDatos(dia.getReuniones());
                         
          });
           
          }
        
        
      tabla_dias.setModel(tabla2);
      
    }
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Fecha = new javax.swing.JTextField();
        Nombre = new javax.swing.JTextField();
        btnguarda = new javax.swing.JButton();
        btnelimina = new javax.swing.JButton();
        btn_cambia2 = new javax.swing.JButton();
        btn_muestra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Inicio = new javax.swing.JTextField();
        Termino = new javax.swing.JTextField();
        Actividad = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_dias = new javax.swing.JTable();
        btnelimina2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_cambia1 = new javax.swing.JButton();
        dato2 = new javax.swing.JTextField();
        dato1 = new javax.swing.JTextField();
        CSV = new javax.swing.JButton();
        datosVarios = new javax.swing.JButton();
        original1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Agenda ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Fecha");

        Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaActionPerformed(evt);
            }
        });

        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });

        btnguarda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnguarda.setText("Guarda");
        btnguarda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardaActionPerformed(evt);
            }
        });

        btnelimina.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnelimina.setText("Eliminar");
        btnelimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminaActionPerformed(evt);
            }
        });

        btn_cambia2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_cambia2.setText("Modificar");
        btn_cambia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cambia2ActionPerformed(evt);
            }
        });

        btn_muestra.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_muestra.setText("Mostrar");
        btn_muestra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_muestraActionPerformed(evt);
            }
        });

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla1);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Inicio");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Termino");

        Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioActionPerformed(evt);
            }
        });

        Termino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerminoActionPerformed(evt);
            }
        });

        Actividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActividadActionPerformed(evt);
            }
        });

        tabla_dias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_dias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_diasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_dias);

        btnelimina2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnelimina2.setText("Eliminar");
        btnelimina2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelimina2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Actividad");

        btn_cambia1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_cambia1.setText("Modificar");
        btn_cambia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cambia1ActionPerformed(evt);
            }
        });

        dato2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dato2ActionPerformed(evt);
            }
        });

        dato1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dato1ActionPerformed(evt);
            }
        });

        CSV.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CSV.setText("CSV");
        CSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSVActionPerformed(evt);
            }
        });

        datosVarios.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        datosVarios.setText("Datos de la agenda");
        datosVarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datosVariosActionPerformed(evt);
            }
        });

        original1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        original1.setText("Manual");
        original1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                original1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnelimina)
                        .addGap(18, 18, 18)
                        .addComponent(btn_muestra))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_cambia1)
                            .addComponent(dato1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnelimina2)
                        .addGap(45, 45, 45)
                        .addComponent(btn_cambia2)
                        .addGap(28, 28, 28)
                        .addComponent(dato2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(235, 235, 235))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(11, 11, 11)
                                .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel2)
                        .addGap(69, 69, 69)
                        .addComponent(btnguarda)))
                .addGap(104, 104, 104)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Actividad, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(Inicio)
                    .addComponent(Termino))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(original1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(CSV)))
                .addContainerGap(187, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(datosVarios)
                .addGap(104, 104, 104))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(493, 493, 493)
                    .addComponent(jLabel8)
                    .addContainerGap(589, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Actividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(btnguarda))))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(Termino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CSV)
                        .addGap(38, 38, 38)
                        .addComponent(original1)
                        .addGap(48, 48, 48)))
                .addComponent(datosVarios)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cambia2)
                    .addComponent(btnelimina2)
                    .addComponent(btnelimina)
                    .addComponent(btn_muestra)
                    .addComponent(dato2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(btn_cambia1)
                        .addGap(29, 29, 29)
                        .addComponent(dato1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(jLabel8)
                    .addContainerGap(576, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cambia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cambia1ActionPerformed
        // TODO add your handling code here:
        int fila_hash;

        if (tabla1.getSelectedRow()<0){
            JOptionPane.showConfirmDialog(null, "Primero seleccione un Nombre");

        }

        else if (tabla1.getSelectedRow()>=0){

            fila_hash = tabla1.getSelectedRow();
            String llave = tabla1.getModel().getValueAt(fila_hash,0).toString();
            String nuevo_nombre = dato1.getText();
            
            try {
                 nuevo_nombre= pedirCadenaLetras(nuevo_nombre);
                 if (nuevo_nombre.isEmpty())
                     throw new NoEsLetraExcepcion();
                 }catch(NoEsLetraExcepcion ex) {
                     System.out.println(ex.getMessage() + "\n");
                 }finally{
             }
            
            agenda.put(nuevo_nombre, agenda.get(llave));



            agenda.remove(llave);

            mostrarDatos();

        }
    }//GEN-LAST:event_btn_cambia1ActionPerformed

    private void btnelimina2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelimina2ActionPerformed
        // TODO add your handling code here:

        if (tabla_dias.getSelectedRow()<0){
            JOptionPane.showConfirmDialog(null, "Primero seleccione una fecha");

        }

        else if(tabla_dias.getSelectedRow()>=0){

            int fila = tabla1.getSelectedRow();
            String llave = tabla1.getModel().getValueAt(fila,0).toString();

            int indexFila;

            indexFila = tabla_dias.getSelectedRow();

            agenda.get(llave).remove(indexFila);

            mostrarDatos(llave);

        }
    }//GEN-LAST:event_btnelimina2ActionPerformed

    private void tabla_diasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_diasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_diasMouseClicked

    private void ActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActividadActionPerformed

    private void TerminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TerminoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TerminoActionPerformed

    private void InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InicioActionPerformed

    private void btn_muestraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_muestraActionPerformed
        // TODO add your handling code here:
        if (tabla1.getSelectedRow()<0){
            JOptionPane.showConfirmDialog(null, "Primero seleccione un contacto");

        }else if(tabla1.getSelectedRow()>=0){

            int fila = tabla1.getSelectedRow();
            String llave = tabla1.getModel().getValueAt(fila,0).toString();

            mostrarDatos(llave);

        }
    }//GEN-LAST:event_btn_muestraActionPerformed

    private void btn_cambia2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cambia2ActionPerformed
        // TODO add your handling code here:
        if (tabla_dias.getSelectedRow()<0){
            JOptionPane.showConfirmDialog(null, "Primero seleccione una fecha");

        }

        else if(tabla_dias.getSelectedRow()>=0){

            int fila = tabla1.getSelectedRow();
            String llave = tabla1.getModel().getValueAt(fila,0).toString();
            String nuevodato = dato2.getText();

            int indexFila;
            int indexcol;

            indexFila = tabla_dias.getSelectedRow();
            indexcol = tabla_dias.getSelectedColumn();
            
            switch (indexcol){
                
                case 0:
                    agenda.get(llave).get(indexFila).setNumeroDias(Integer. parseInt(nuevodato));
                    break;
                case 1:
                    agenda.get(llave).get(indexFila).setNumeroMes(Integer. parseInt(nuevodato));
                    break;
                case 2:
                    agenda.get(llave).get(indexFila).setNumeroAnno(Integer. parseInt(nuevodato));
                    break;
                case 3:
                    agenda.get(llave).get(indexFila).getReuniones().get(0).setActividad(nuevodato);
                    break;
                case 4:
                    agenda.get(llave).get(indexFila).getReuniones().get(0).setHoraInicio(Integer. parseInt(nuevodato));
                    break;
                case 5:
                    agenda.get(llave).get(indexFila).getReuniones().get(0).setMinInicio(Integer. parseInt(nuevodato));
                    break;
                case 6:
                    agenda.get(llave).get(indexFila).getReuniones().get(0).setHoraFinal(Integer. parseInt(nuevodato));
                    break;
                case 7:
                    agenda.get(llave).get(indexFila).getReuniones().get(0).setMinFinal(Integer. parseInt(nuevodato));
                    break;
            }

            

            mostrarDatos(llave);

        }
        

    }//GEN-LAST:event_btn_cambia2ActionPerformed

    private void btneliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminaActionPerformed
        // TODO add your handling code here:

        int fila_hash;

        if (tabla1.getSelectedRow()<0){
            JOptionPane.showConfirmDialog(null, "Primero seleccione un Nombre");

        }

        else if (tabla1.getSelectedRow()>=0){

            fila_hash = tabla1.getSelectedRow();
            String llave = tabla1.getModel().getValueAt(fila_hash,0).toString();
            agenda.remove(llave);

            mostrarDatos();

        }
    }//GEN-LAST:event_btneliminaActionPerformed

    private void btnguardaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardaActionPerformed
        // TODO add your handling code here:

        if (!Nombre.getText().equals(" ") && !Fecha.getText().equals(" ") && !Actividad.getText().equals(" ") && !Inicio.getText().equals(" ") && !Termino.getText().equals(" ")){

            String[] partes=Fecha.getText().split(":");

            int numero=Integer.parseInt(partes[0]);
            int numeroMes=Integer.parseInt(partes[1]);
            int numeroAnno=Integer.parseInt(partes[2]);

            String[] partes_Hora1=Inicio.getText().split(":");
            int horaInicio=Integer.parseInt(partes_Hora1[0]);
            int minInicio=Integer.parseInt(partes_Hora1[1]);

            String[] partes_Hora2=Termino.getText().split(":");
            int horaFinal=Integer.parseInt(partes_Hora2[0]);
            int minFinal=Integer.parseInt(partes_Hora2[1]);

            Dias nuevoDia = new Dias(numero,numeroMes,numeroAnno,Nombre.getText());
            Reunion nuevaReunion= new Reunion(Actividad.getText(),horaInicio,minInicio,horaFinal,minFinal);

            nuevoDia.agregarReunion(nuevaReunion);
            if(nuevoDia.seguridad(nuevoDia.getNumeroAnno())&& nuevoDia.seguridad(nuevoDia.getNumero(), nuevoDia.getNumeroMes()) && nuevaReunion.seguridad(horaInicio, minInicio, horaFinal, minFinal) && nuevaReunion.seguridad(horaInicio,horaFinal) ){

                boolean isKeyPresent = agenda.containsKey(Nombre.getText());

                if (isKeyPresent){
                    agenda.get(Nombre.getText()).add(nuevoDia);

                }else{

                    ArrayList<Dias> cadena = new ArrayList<>();
                    cadena.add(nuevoDia);
                    agenda.put(nuevoDia.getNombreApellido(),cadena);

                }
            }
            mostrarDatos();
        }

        else{

            JOptionPane.showConfirmDialog(null, "Ingrese valores enteros y dentro de los limites");
        }
    }//GEN-LAST:event_btnguardaActionPerformed

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreActionPerformed

    private void FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaActionPerformed

    private void dato2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dato2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dato2ActionPerformed

    private void dato1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dato1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dato1ActionPerformed

    private void CSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSVActionPerformed
        // TODO add your handling code here:
        csv(agenda);
         JOptionPane.showMessageDialog(null, "Archivo .csv creado ", "CSV creado", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_CSVActionPerformed

    private void datosVariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datosVariosActionPerformed
        // TODO add your handling code here:
        int contador=0;
        int meses[] ={0,0,0,0,0,0,0,0,0,0,0,0};
        int lugar=0;
       
        Object[] keys = agenda.keySet().toArray();
         for (Object key : keys) {
             contador++;
       
             for (int i=0;i<agenda.get(key).size();i++){
                 
                   switch (agenda.get(key).get(i).getNumeroMes()){
                 case 1:
                     meses[0]++;
                     break;
                 case 2:
                     meses[1]++;
                     break;
                 case 3:
                    meses[2]++;
                     break;
                 case 4:
                     meses[3]++;
                     break;
                 case 5:
                    meses[4]++;
                     break;
                 case 6:
                    meses[5]++;
                     break;
                 case 7:
                     meses[6]++;
                     break;
                 case 8:
                     meses[7]++;
                     break;
                 case 9:
                     meses[8]++;
                     break;
                 case 10:
                     meses[9]++;
                     break;
                 case 11:
                     meses[10]++;
                     break;
                 case 12:
                     meses[11]++;
                     break;
                     
             }
             }
       
         }
         
        int maxNum = meses[0];
       
        
        for(int j = 0;j<meses.length;j++){
            
            if (meses[j]>maxNum){
                maxNum=meses[j];
                lugar=j;
            }
        }
        
        

   
         
         
         String texto = "El numero de personas en la agenda es de : " + contador+ "\n Los meses ocupados son: \n\n Enero = " + meses[0]+ "\n Febrero = " + meses[1]+ "\n Marzo = " + meses[2]+ "\n Abril = " + meses[3]+ "\n Mayo = " + meses[4]+ "\n Junio = " + meses[5]+ "\n Julio = " + meses[6]+ "\n Agosto = " + meses[7]+ "\n Septiembre = " + meses[8]+ "\n Octubre = " + meses[9]+ "\n Noviembre = " + meses[10]+ "\n Diciembre = " + meses[11]+"\nEL mes mas ocupado por las personas de la agenda, es el mes: " + meses[lugar] + " con "+ maxNum + "eventos";
         
         JOptionPane.showMessageDialog(null,texto,"Datos",JOptionPane.INFORMATION_MESSAGE);
         
         
     
  
    }//GEN-LAST:event_datosVariosActionPerformed

    private void original1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_original1ActionPerformed
        // TODO add your handling code here:
         String Texto = "Algunos datos referentes al proyecto.\n- Se deben ingresar los datos de fechas y las horas en formato\n\n  - DD:MM:AA \n - HH:MM \n\n - Si el CSV fue creado. Para crear otro, se debe cerrar para que se pueda reemplazar.\n\nPara modifica los datos, se debe:\n-Ingresar el nuevo dato en las casilla de modificar\n-Luego, selecionar el dato que se desea cambiar.\n-Luego pulsar el boton modificar.";
        JOptionPane.showMessageDialog(null, Texto, "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_original1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new NewJFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        AgendayReuniones ayR = AgendayReuniones.obtenerInstancia();
        ayR.menu();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Actividad;
    private javax.swing.JButton CSV;
    private javax.swing.JTextField Fecha;
    private javax.swing.JTextField Inicio;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTextField Termino;
    private javax.swing.JButton btn_cambia1;
    private javax.swing.JButton btn_cambia2;
    private javax.swing.JButton btn_muestra;
    private javax.swing.JButton btnelimina;
    private javax.swing.JButton btnelimina2;
    private javax.swing.JButton btnguarda;
    private javax.swing.JTextField dato1;
    private javax.swing.JTextField dato2;
    private javax.swing.JButton datosVarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton original1;
    private javax.swing.JTable tabla1;
    private javax.swing.JTable tabla_dias;
    // End of variables declaration//GEN-END:variables
}
