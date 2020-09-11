/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

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
public class nuevaConsulta extends javax.swing.JDialog {
    private LineBorder border = new LineBorder((new Color(107, 179, 35)),5);
    int xx,xy;
    /**
     * Creates new form nuevoMedico
     */
    public nuevaConsulta(){//java.awt.Frame parent, boolean modal) {
        //super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); 
        this.getRootPane().setBorder(border);
    }
    
    void escribir(){
        File file = new File("src/archivos/consultas.txt");
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(file.getAbsoluteFile(), true);
            pw = new PrintWriter(fichero);
            
            pw.println(tCodigo.getText() + "  " + jSignos.getText()+ "  "+ jSintomas.getText()+
                    "  "+ jResultados.getText()+ "  " + jDiagnostico.getText());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
    
    public boolean existeConsulta(){
       boolean flag = false;
       int codigoAux, codigoAuxTextField;
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
               codigoAux = Integer.parseInt(row[0]);              
               codigoAuxTextField = Integer.parseInt(tCodigo.getText());
        
               if(codigoAux == codigoAuxTextField ){
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jSintomas = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jSignos = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jDiagnostico = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jResultados = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        bCancelar = new javax.swing.JButton();
        bReceta = new javax.swing.JButton();
        bGrabar1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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

        jLabel2.setText("Codigo de cita:");

        jLabel3.setText("Signos:");

        jLabel6.setText("Síntomas:");

        tCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tCodigoKeyTyped(evt);
            }
        });

        jSintomas.setColumns(20);
        jSintomas.setRows(5);
        jScrollPane1.setViewportView(jSintomas);

        jSignos.setColumns(20);
        jSignos.setRows(5);
        jScrollPane3.setViewportView(jSignos);

        jDiagnostico.setColumns(20);
        jDiagnostico.setRows(5);
        jScrollPane4.setViewportView(jDiagnostico);

        jResultados.setColumns(20);
        jResultados.setRows(5);
        jScrollPane5.setViewportView(jResultados);

        jLabel4.setText("Resultados:");

        jLabel5.setText("Diagnóstico:");

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

        bGrabar1.setText("Grabar");
        bGrabar1.setMaximumSize(new java.awt.Dimension(100, 30));
        bGrabar1.setMinimumSize(new java.awt.Dimension(100, 30));
        bGrabar1.setPreferredSize(new java.awt.Dimension(100, 30));
        bGrabar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGrabar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bReceta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(bGrabar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bReceta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bGrabar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        recetaMain nr = new recetaMain ();
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
        if(!tCodigo.getText().isEmpty() &&
           !jSignos.getText().isEmpty() && !jSintomas.getText().isEmpty() &&  
           !jResultados.getText().isEmpty() &&  !jDiagnostico.getText().isEmpty()
           ){
           escribir();  
            int mensaje = JOptionPane.showOptionDialog(null, "Se grabo correctamente", "Grabado", JOptionPane.DEFAULT_OPTION,
                     JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if(mensaje == 0){
                dispose();
            }
            
        }else{
            int mensaje = JOptionPane.showOptionDialog(null, "Error al grabar, falta completar datos", "ERROR", JOptionPane.DEFAULT_OPTION,
                     JOptionPane.ERROR_MESSAGE, null, null, null);   
        }
    }//GEN-LAST:event_bGrabar1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //nuevaConsulta dialog = new nuevaConsulta(new javax.swing.JFrame(), true);
                /*dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);*/
                new nuevaConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bGrabar1;
    private javax.swing.JButton bReceta;
    private javax.swing.JTextArea jDiagnostico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextArea jResultados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jSignos;
    private javax.swing.JTextArea jSintomas;
    public javax.swing.JTextField tCodigo;
    // End of variables declaration//GEN-END:variables
}
