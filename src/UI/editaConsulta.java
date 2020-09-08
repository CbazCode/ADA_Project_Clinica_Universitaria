/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Clases.Medico;
import Clases.Consulta;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Kioshi
 */
public class editaConsulta extends javax.swing.JDialog {
    int CodigoAnterior;
    private LineBorder border = new LineBorder((new Color(107, 179, 35)),5);
    int xx,xy;
    /**
     * Creates new form nuevoMedico
     */
    
  
    
    public editaConsulta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); 
        this.getRootPane().setBorder(border);
    }
    public void recibeDatos(Consulta consulta){
        CodigoAnterior = consulta.getCodigoCit();
        tCodigo.setText(String.valueOf(consulta.getCodigoCit()));
        jSignos.setText(consulta.getSignos().trim().replaceAll("\\s[*]","\n *" ));
        jSintomas.setText(consulta.getSintomas().trim().replaceAll("\\s[*]","\n *" ));      
        jResultados.setText(consulta.getResultados().trim().replaceAll("\\s[*]","\n *" ));
        jDiagnostico.setText(consulta.getDiagnostico().trim().replaceAll("\\s[*]","\n *" )); 
    }
    
    public void modificar(){
        
        File fileNuevo = new File("src/archivos/consultastemp.txt");
        File fileAntiguo = new File("src/archivos/consultas.txt");
        
        
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
                    if(row[0].equals(String.valueOf(CodigoAnterior))){
                         pw.println(tCodigo.getText() + "  " + jSignos.getText().trim().replaceAll("\\s{1,10}"," " )+ "  "+ jSintomas.getText().trim().replaceAll("\\s{1,10}"," " )
                         + "  " + jResultados.getText().trim().replaceAll("\\s{1,10}"," " )+ "  " + jDiagnostico.getText().trim().replaceAll("\\s{1,10}"," " ));
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
        
        File  fileAntiguo= new File("src/archivos/consultastemp.txt");
        File  fileNuevo= new File("src/archivos/consultas.txt");
        
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
            
            fileNuevo.delete();
            
            
            
             
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

        bGrabar1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jResultados = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jSignos = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jSintomas = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jDiagnostico = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        bCancelar = new javax.swing.JButton();
        bReceta = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        bGrabar2 = new javax.swing.JButton();

        bGrabar1.setText("Grabar");
        bGrabar1.setMaximumSize(new java.awt.Dimension(100, 30));
        bGrabar1.setMinimumSize(new java.awt.Dimension(100, 30));
        bGrabar1.setPreferredSize(new java.awt.Dimension(100, 30));
        bGrabar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGrabar1ActionPerformed(evt);
            }
        });

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
        jLabel1.setText("Registro de Consulta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(239, 251, 239));

        jLabel2.setText("Código de cita:");

        jLabel3.setText("Signos:");

        jLabel6.setText("Resultados:");

        tCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tCodigoKeyTyped(evt);
            }
        });

        jResultados.setColumns(20);
        jResultados.setRows(5);
        jScrollPane1.setViewportView(jResultados);

        jSignos.setColumns(20);
        jSignos.setRows(5);
        jScrollPane2.setViewportView(jSignos);

        jSintomas.setColumns(20);
        jSintomas.setRows(5);
        jScrollPane3.setViewportView(jSintomas);

        jDiagnostico.setColumns(20);
        jDiagnostico.setRows(5);
        jScrollPane4.setViewportView(jDiagnostico);

        jLabel7.setText("Diagnóstico:");

        jLabel5.setText("Síntomas:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addComponent(jScrollPane3))
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addContainerGap())
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

        bReceta.setText("Receta");
        bReceta.setMaximumSize(new java.awt.Dimension(100, 30));
        bReceta.setMinimumSize(new java.awt.Dimension(100, 30));
        bReceta.setPreferredSize(new java.awt.Dimension(100, 30));
        bReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRecetaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Recuerda colocar un (*) cuando presiones enter");

        bGrabar2.setText("Grabar");
        bGrabar2.setMaximumSize(new java.awt.Dimension(100, 30));
        bGrabar2.setMinimumSize(new java.awt.Dimension(100, 30));
        bGrabar2.setPreferredSize(new java.awt.Dimension(100, 30));
        bGrabar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGrabar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(bReceta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(bGrabar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bReceta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bGrabar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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

    private void bRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRecetaActionPerformed
        editaReceta nr = new editaReceta(new javax.swing.JFrame(),true);
        nr.setVisible(true);
    }//GEN-LAST:event_bRecetaActionPerformed

    private void tCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCodigoKeyTyped
        if (tCodigo.getText().length()== 8) {
            evt.consume(); 
        } 
        if(evt.getKeyChar()<'0' || evt.getKeyChar()>'9' && evt.getKeyChar()!='\b'){
            evt.consume();
        }
        
    }//GEN-LAST:event_tCodigoKeyTyped

    private void bGrabar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGrabar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bGrabar1ActionPerformed

    private void bGrabar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGrabar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bGrabar2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                editaConsulta dialog = new editaConsulta(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bGrabar1;
    private javax.swing.JButton bGrabar2;
    private javax.swing.JButton bReceta;
    private javax.swing.JTextArea jDiagnostico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextArea jResultados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jSignos;
    private javax.swing.JTextArea jSintomas;
    private javax.swing.JTextField tCodigo;
    // End of variables declaration//GEN-END:variables
}
