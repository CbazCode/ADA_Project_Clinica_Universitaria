/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Clases.Medico;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author Kioshi
 */
public class editaMedico extends javax.swing.JDialog {
    int DniAnterior;
    private LineBorder border = new LineBorder((new Color(107, 179, 35)),5);
    
    int xx,xy;
    public ArrayList<String> nombre = new ArrayList<String>();
    public ArrayList<String> apellidoP = new ArrayList<String>();
    public ArrayList<String> apellidoM = new ArrayList<String>();
    public ArrayList<String> centroMedico = new ArrayList<String>();
    public ArrayList<String> especialidad = new ArrayList<String>();
    
    
    /**
     * Creates new form nuevoMedico
     */
    
  
    
    public editaMedico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); 
        this.getRootPane().setBorder(border);
        nombre.add(" ");
        apellidoP.add(" ");
        apellidoM.add(" ");
        centroMedico.add(" ");
        especialidad.add(" ");
    }
    public void recibeDatos(Medico medico){
        DniAnterior = medico.getDniMedico();
        tDNI.setText(String.valueOf(medico.getDniMedico()));
        tNombre.setText(medico.getNombreMedico());
        tApellidoP.setText(medico.getApellidoPaternoMedico());
        tApellidoM.setText(medico.getApellidoMaternoMedico());
        tTelefono.setText(String.valueOf(medico.getTelefonoMedico()));
        tCorreo.setText(medico.getCorreoElectronicoMedico());
        tCentroMedico.setText(medico.getCentroDeEstudioMedico());
        tEspecialidad.setText(medico.getEspecialidadMedico());
        
        
    }
    
    public void modificar(){
        
        File fileNuevo = new File("src/archivos/medicostemp.txt");
        File fileAntiguo = new File("src/archivos/medicos.txt");
        
        
        BufferedReader br;
   
        FileWriter fichero = null;
        PrintWriter pw = null;

        
        try{
            fichero = new FileWriter(fileNuevo.getAbsoluteFile(), true);
            pw = new PrintWriter(fichero);
            FileReader fr =new FileReader(fileAntiguo);
            br = new BufferedReader(fr);
            if(fileAntiguo.exists()){
                Object[] linea = br.lines().toArray();
                for(int i = 0; i<linea.length;i++){
                    String[] row = linea[i].toString().split("  ");
                    if(row[0].equals(String.valueOf(DniAnterior))){
                        pw.println(tDNI.getText() + "  " + tNombre.getText()+ "  "+ tApellidoP.getText()+"  "+tApellidoM.getText()+"  "+tTelefono.getText()+"  " + tCorreo.getText()+"  "+tCentroMedico.getText()+"  "+tEspecialidad.getText() );
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
            //fileAntiguo.renameTo(fileNuevo);
            
            //fileNuevo.delete();
            
            
            
             
        }catch(Exception e){
                e.printStackTrace();
        }finally{
            try {
              if (null != fichero){  
                pw.close();
                fichero.close(); 
                
              }
                  
            } catch (Exception e2) {
                   e2.printStackTrace();
             }
            dispose();
                
        }
    }
    
    public void modificar1(){
        
        File  fileAntiguo= new File("src/archivos/medicostemp.txt");
        File  fileNuevo= new File("src/archivos/medicos.txt");
        
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
                e.printStackTrace();
        }finally{
            try {
              if (null != fichero){  
                pw.close();
                fichero.close(); 
                
              }
                  
            } catch (Exception e2) {
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tDNI = new javax.swing.JTextField();
        tNombre = new javax.swing.JTextField();
        tApellidoP = new javax.swing.JTextField();
        tApellidoM = new javax.swing.JTextField();
        tTelefono = new javax.swing.JTextField();
        tCorreo = new javax.swing.JTextField();
        tCentroMedico = new javax.swing.JTextField();
        tEspecialidad = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        bCancelar = new javax.swing.JButton();
        bGrabar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(107, 179, 35));
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
        jLabel1.setText("Registro de Médico");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(239, 251, 239));

        jLabel2.setText("DNI:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellido paterno:");

        jLabel5.setText("Apellido materno:");

        jLabel6.setText("Teléfono:");

        jLabel7.setText("Correo electronico:");

        jLabel8.setText("Centro médico:");

        jLabel9.setText("Especialidad:");

        tDNI.setEnabled(false);
        tDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tDNIKeyTyped(evt);
            }
        });

        tNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tNombreKeyTyped(evt);
            }
        });

        tApellidoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tApellidoPKeyTyped(evt);
            }
        });

        tApellidoM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tApellidoMKeyTyped(evt);
            }
        });

        tTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tTelefonoKeyTyped(evt);
            }
        });

        tCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tCorreoKeyTyped(evt);
            }
        });

        tCentroMedico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tCentroMedicoKeyTyped(evt);
            }
        });

        tEspecialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tEspecialidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(7, 7, 7)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tNombre)
                                    .addComponent(tTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tCorreo)
                            .addComponent(tCentroMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tApellidoM)
                    .addComponent(tEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tCentroMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(tEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(tApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        jPanel4.setBackground(new java.awt.Color(239, 251, 239));

        bCancelar.setText("Cancelar");
        bCancelar.setMaximumSize(new java.awt.Dimension(100, 30));
        bCancelar.setMinimumSize(new java.awt.Dimension(100, 30));
        bCancelar.setPreferredSize(new java.awt.Dimension(100, 30));
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        bGrabar.setText("Grabar");
        bGrabar.setMaximumSize(new java.awt.Dimension(100, 30));
        bGrabar.setMinimumSize(new java.awt.Dimension(100, 30));
        bGrabar.setPreferredSize(new java.awt.Dimension(100, 30));
        bGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGrabarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void tDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tDNIKeyTyped
        if (tDNI.getText().length()== 8) {
            evt.consume(); 
        } 
        if(evt.getKeyChar()<'0' || evt.getKeyChar()>'9' && evt.getKeyChar()!='\b'){
            evt.consume();
        }
        
    }//GEN-LAST:event_tDNIKeyTyped

    private void tTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tTelefonoKeyTyped
        if (tTelefono.getText().length()== 9) {
            evt.consume(); 
        }
        if(evt.getKeyChar()<'0' || evt.getKeyChar()>'9' && evt.getKeyChar()!='\b'){
            evt.consume();
        }
    }//GEN-LAST:event_tTelefonoKeyTyped
    
    
    int contadorNombre = 1;
    private void tNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNombreKeyTyped
        nombre.add(String.valueOf(evt.getKeyChar()));
        if (tNombre.getText().length()== 30) {
            evt.consume();
        }
        if (tNombre.getText().length()== 30) {
            evt.consume();
        }
        if(evt.getKeyChar()== ' ' && nombre.get(contadorNombre-1).equals(" ")){
            evt.consume();
        }
        contadorNombre++;     
    }//GEN-LAST:event_tNombreKeyTyped
    int contadorApellidoP = 1;
    private void tApellidoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tApellidoPKeyTyped
        apellidoP.add(String.valueOf(evt.getKeyChar()));
        if (tApellidoP.getText().length()== 30) {
            evt.consume();
        }
        if (tApellidoP.getText().length()== 30) {
            evt.consume();
        }
        if(evt.getKeyChar()== ' ' && apellidoP.get(contadorApellidoP-1).equals(" ")){
            evt.consume();
        }
        contadorApellidoP++;
    }//GEN-LAST:event_tApellidoPKeyTyped
    int contadorApellidoM = 1;
    private void tApellidoMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tApellidoMKeyTyped
        apellidoM.add(String.valueOf(evt.getKeyChar()));
        if (tApellidoM.getText().length()== 30) {
            evt.consume();
        }
        if (tApellidoM.getText().length()== 30) {
            evt.consume();
        }
        if(evt.getKeyChar()== ' ' && apellidoM.get(contadorApellidoM-1).equals(" ")){
            evt.consume();
        }
        contadorApellidoM++;
    }//GEN-LAST:event_tApellidoMKeyTyped

    private void tCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCorreoKeyTyped
        if(evt.getKeyChar()== ' '){
            evt.consume();
        }
        if (tCorreo.getText().length()== 30) {
            evt.consume();
        }
    }//GEN-LAST:event_tCorreoKeyTyped
    int contadorCentro = 1;
    private void tCentroMedicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCentroMedicoKeyTyped
        centroMedico.add(String.valueOf(evt.getKeyChar()));
        if (tCentroMedico.getText().length()== 30) {
            evt.consume();
        }
        if (tCentroMedico.getText().length()== 30) {
            evt.consume();
        }
        if(evt.getKeyChar()== ' ' && centroMedico.get(contadorCentro-1).equals(" ")){
            evt.consume();
        }
        contadorCentro++;
    }//GEN-LAST:event_tCentroMedicoKeyTyped
    int contadorEspecialidad = 1;
    private void tEspecialidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tEspecialidadKeyTyped
        especialidad.add(String.valueOf(evt.getKeyChar()));
        if (tEspecialidad.getText().length()== 30) {
            evt.consume();
        }
        if (tEspecialidad.getText().length()== 30) {
            evt.consume();
        }
        if(evt.getKeyChar()== ' ' && especialidad.get(contadorEspecialidad-1).equals(" ")){
            evt.consume();
        }
        contadorEspecialidad++;
    }//GEN-LAST:event_tEspecialidadKeyTyped

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
            java.util.logging.Logger.getLogger(editaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                editaMedico dialog = new editaMedico(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField tApellidoM;
    private javax.swing.JTextField tApellidoP;
    private javax.swing.JTextField tCentroMedico;
    private javax.swing.JTextField tCorreo;
    private javax.swing.JTextField tDNI;
    private javax.swing.JTextField tEspecialidad;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTextField tTelefono;
    // End of variables declaration//GEN-END:variables
}
