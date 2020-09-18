/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Clases.Cita;
import Clases.Medico;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Kioshi
 */
public class citaPagar extends javax.swing.JDialog  {
    private LineBorder border = new LineBorder((new Color(107, 179, 35)),5);
    int xx,xy;
    /**
     * Creates new form nuevoMedico
     */
    int CodigoAnterior;
    String horaArchivo ="";
    String fechaArchivo ="";
    Date horaCita;
    float porPagar;
    
    float dinerorecibido;
    float deudaMonto;
    
    float diferenciaDePago;
    float diferenciaDePagoB;
    
    DateFormat hourFormat = new SimpleDateFormat("HH:mm");
       
    public citaPagar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        SpinnerNumberModel nmh = new SpinnerNumberModel();
        nmh.setMaximum(24);
        nmh.setMinimum(0);
        jSpinnerHora.setModel(nmh);
        SpinnerNumberModel nmm = new SpinnerNumberModel();
        nmm.setMaximum(60);
        nmm.setMinimum(0);
        jSpinnerMinutos.setModel(nmm);
        this.setLocationRelativeTo(null); 
        this.getRootPane().setBorder(border);
        ((DefaultEditor) jSpinnerHora.getEditor()).getTextField().setEditable(false);
        ((DefaultEditor) jSpinnerMinutos.getEditor()).getTextField().setEditable(false);
    }
    public void recibeDatos(Cita cita){
        CodigoAnterior = cita.getCodigoHist();
        jCodigo.setText(String.valueOf(cita.getCodigoHist()));
        jDni.setText(String.valueOf(cita.getDNI()));
        jEspecialidad1.setText(cita.getEspecialidad());
        jFecha.setDate(ParseFecha(cita.getFechaCita()));
        String[] horaMinuto = cita.getHoraCita().split(":");
        jSpinnerHora.setValue(Integer.parseInt(horaMinuto[0]));
        jSpinnerMinutos.setValue(Integer.parseInt(horaMinuto[1]));
        porPagar=cita.getPorPagar();
        jDeuda1.setText(String.valueOf(cita.getPorPagar()));
        tporPagar.setText(String.valueOf(cita.getPorPagar()));
         
        String texto1 = tporPagar.getText();
        deudaMonto = Float.parseFloat(texto1);
    }
      
    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
       
    public boolean existeEspecialidad(){
        boolean flag = false;
       File file = null;
       FileReader fr = null;
       BufferedReader br = null;
       try{
           file = new File("src/archivos/medicos.txt");
           fr = new FileReader(file);
           br = new BufferedReader(fr);
           Object[] linea = br.lines().toArray();
           for(int i = 0; i<linea.length;i++){
               String[] row = linea[i].toString().split("  ");
               if(row[7].equals(jEspecialidad1.getText()) ){
                   flag = true;
                   break;  
               }else{
                  flag = false; 
               }
           }
           br.close();
       }catch(Exception e){
           System.out.println("Error: " + e);
       }
       if(flag){
           return true;
       }else{
           return false;
       }
    }
    public boolean existePaciente(){
        boolean flag = false;
       File file = null;
       FileReader fr = null;
       BufferedReader br = null;
       try{
           file = new File("src/archivos/paciente.txt");
           fr = new FileReader(file);
           br = new BufferedReader(fr);
           Object[] linea = br.lines().toArray();
           for(int i = 0; i<linea.length;i++){
               String[] row = linea[i].toString().split("  ");
               if(row[0].equals(jDni.getText()) ){
                   flag = true;
                   break;  
               }else{
                   flag = false; 
               }
           }
           br.close();
       }catch(Exception e){
           System.out.println("Error: " + e);
           //Hasta q se cree archivo paciente dejar el return
           //return true;
       }
       if(flag){
           return true;
       }else{
           return false;
       }
    }   
    public boolean doctorDisponible(){
       boolean flag = true;
       File file = null;
       FileReader fr = null;
       BufferedReader br = null;
       try{
           file = new File("src/archivos/cita.txt");
           fr = new FileReader(file);
           br = new BufferedReader(fr);
           Object[] linea = br.lines().toArray();
           for(int i = 0; i<linea.length;i++){
               String[] row = linea[i].toString().split("  ");
               if(row[2].equals(jEspecialidad1.getText()) ){
                   if(row[4].equals(horaArchivo)){
                       flag = false;
                       break; 
                   }else{
                       flag = true; 
                   }                   
               }else{
                   flag=true;
               }
           }
           br.close();
       }catch(Exception e){
           System.out.println("Error: " + e);
       }
       if(flag){
           return true;
       }else{
           return false;
       }

    }
    
    public void modificar(){
        File fileNuevo = new File("src/archivos/citastemp.txt");
        File fileAntiguo = new File("src/archivos/cita.txt");
        String mensaje = " ";
        String texto = tporPagar.getText();
        dinerorecibido = Float.parseFloat(texto);
        diferenciaDePago = dinerorecibido -deudaMonto;
            if(deudaMonto!=0){
                if(diferenciaDePago<0 && deudaMonto!=0){
                    diferenciaDePago=diferenciaDePago*(-1);
                    tporPagar.setText(String.valueOf(diferenciaDePago));
                }else{
                    diferenciaDePagoB=0;
                    tporPagar.setText(String.valueOf(diferenciaDePagoB));
                }
            }else{
                tporPagar.setText(String.valueOf(deudaMonto));
                diferenciaDePago=0;
            }
            

           BufferedReader br;

           FileWriter fichero = null;
           PrintWriter pw = null;


           try{
               fichero = new FileWriter(fileNuevo.getAbsoluteFile(), true);
               pw = new PrintWriter(fichero);
               FileReader fr =new FileReader(fileAntiguo);
               br = new BufferedReader(fr);    
               if(fileAntiguo.exists()){

                   if(diferenciaDePago==0){
                       mensaje = "No necesita vuelto";
                       
                   }else{
                       int c[] = {50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
                       int s[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                       double v[] = {200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.01};

                       Cita moneda = new Cita();

                       moneda.Voraz(s, v, diferenciaDePago, c);
                       if (moneda.Solucion(s, v, diferenciaDePago, c)) {
                           for (int i = s.length - 1; i >= 0; i--) {
                               if (s[i] > 0) {
                                   mensaje = s[i] + " monedas de " + v[i] + " soles\n" + mensaje;
                               }
                           }

                       } else{
                           mensaje = "No hay saldo disponible en el cajero";
                       }
                   }
                   JOptionPane.showMessageDialog(null, mensaje,"Cambio Pago-Cita",JOptionPane.INFORMATION_MESSAGE); 
                   Object[] linea = br.lines().toArray();
                   for(int i = 0; i<linea.length;i++){
                       String[] row = linea[i].toString().split("  ");
                       if(row[0].equals(String.valueOf(CodigoAnterior))){
                           pw.println(row[0]+"  "+row[1]+"  "+row[2]+"  "+row[3]+"  "+row[4]+"  "+tporPagar.getText());  
                       }else{
                           pw.println(linea[i]);
                       }
                   }  
                   fr.close();
                   br.close();   

               }
               pw.close();
               fichero.close(); 
               fileAntiguo.delete();  
           }catch(Exception e){
               System.out.println("ERROR EN MODIFICAR DE PAGAR CITA");
                   e.printStackTrace();
           }finally{
               try {
                 if (null != fichero){  
                   pw.close();
                   fichero.close(); 

                 }

               } catch (Exception e2) {
                   System.out.println("ERROR EN MODIFICAR DE PAGAR CITA");
                      e2.printStackTrace();
                }
               dispose();

           }   
        
        
    }
    
    
    public void modificar1(){
        
        File  fileAntiguo= new File("src/archivos/citastemp.txt");
        File  fileNuevo= new File("src/archivos/cita.txt");
        
        BufferedReader br;
   
        FileWriter fichero = null;
        PrintWriter pw = null;

        
        try{
            fichero = new FileWriter(fileNuevo, false);
            pw = new PrintWriter(fichero);
            FileReader fr =new FileReader(fileAntiguo);
            br = new BufferedReader(fr);
            if(fileAntiguo.exists()){
                Object[] linea = br.lines().toArray();
                for(int i = 0; i<linea.length;i++){
                    String[] row = linea[i].toString().split("  ");
                    pw.println(linea[i]);
                }  
                
                fr.close();
                br.close();
            } 
            
            pw.close();
            fichero.close(); 
            fileAntiguo.delete();
            //fileAntiguo.renameTo(fileNuevo);
            
            //fileNuevo.delete();
           
             
        }catch(Exception e){
            System.out.println("ERROR EN MODIFICAR 1 DE PAGAR CITA");
                e.printStackTrace();
        }finally{
            try {
              if (null != fichero){  
                pw.close();
                fichero.close(); 
                
              }
                  
            } catch (Exception e2) {
                 System.out.println("ERROR EN MODIFICAR 1 DE PAGAR CITA");
                   e2.printStackTrace();
             }
            dispose();
                
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        bGrabar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jFecha = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jSpinnerMinutos = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        tporPagar = new javax.swing.JTextField();
        jCodigo = new javax.swing.JLabel();
        jDni = new javax.swing.JLabel();
        jEspecialidad = new javax.swing.JLabel();
        jDeuda = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSpinnerHora = new javax.swing.JSpinner();
        jEspecialidad1 = new javax.swing.JLabel();
        jDeuda1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(107, 179, 35));
        jPanel1.setToolTipText("");
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Pago");

        jPanel2.setBackground(new java.awt.Color(239, 251, 239));

        jLabel2.setText("Código de cita: ");

        jLabel3.setText("DNI del usuario: ");

        jLabel4.setText("Fecha: ");

        jLabel6.setText("Especialidad: ");

        jPanel4.setBackground(new java.awt.Color(239, 251, 239));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 94, Short.MAX_VALUE)
        );

        bGrabar.setText("Pagar");
        bGrabar.setMaximumSize(new java.awt.Dimension(100, 30));
        bGrabar.setMinimumSize(new java.awt.Dimension(100, 30));
        bGrabar.setPreferredSize(new java.awt.Dimension(100, 30));
        bGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGrabarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.setMaximumSize(new java.awt.Dimension(100, 30));
        bCancelar.setMinimumSize(new java.awt.Dimension(100, 30));
        bCancelar.setPreferredSize(new java.awt.Dimension(100, 30));
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        jLabel10.setText(":");

        jLabel7.setText("Monto de la deuda:");

        jLabel8.setText("Monto recibido:");

        tporPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tporPagarActionPerformed(evt);
            }
        });

        jLabel5.setText("Hora:");

        jEspecialidad1.setText("jLabel9");

        jDeuda1.setText("jLabel9");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCodigo)
                            .addComponent(jDni)
                            .addComponent(jEspecialidad)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jSpinnerHora, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSpinnerMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jDeuda1)
                                        .addGap(97, 97, 97)
                                        .addComponent(jDeuda))
                                    .addComponent(tporPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jEspecialidad1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCodigo)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jDeuda)
                                .addComponent(jDeuda1)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel10)
                                .addGap(88, 88, 88))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(tporPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDni)
                                    .addComponent(jLabel3))
                                .addGap(55, 55, 55)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jEspecialidad1))
                                .addGap(18, 18, 18)
                                .addComponent(jEspecialidad)
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jSpinnerHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinnerMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGrabarActionPerformed
            modificar();
            modificar1();   
    }//GEN-LAST:event_bGrabarActionPerformed

    private void tporPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tporPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tporPagarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(citaPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(citaPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(citaPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(citaPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                citaPagar dialog = new citaPagar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bGrabar;
    private javax.swing.JLabel jCodigo;
    private javax.swing.JLabel jDeuda;
    private javax.swing.JLabel jDeuda1;
    private javax.swing.JLabel jDni;
    private javax.swing.JLabel jEspecialidad;
    private javax.swing.JLabel jEspecialidad1;
    private com.toedter.calendar.JDateChooser jFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSpinner jSpinnerHora;
    private javax.swing.JSpinner jSpinnerMinutos;
    private javax.swing.JTextField tporPagar;
    // End of variables declaration//GEN-END:variables
}
