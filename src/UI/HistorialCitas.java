/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author param
 */
public class HistorialCitas extends javax.swing.JFrame {

    private final LineBorder border = new LineBorder((new Color(107, 179, 35)), 5);
    int xx, xy;
    /**
     * Creates new form HistorialCitas
     */
    DefaultTableModel modelo1 = new DefaultTableModel() {
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    };
    
    public HistorialCitas() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getRootPane().setBorder(border);
        completarTabla();
    }
    

    private static class HeaderRenderer implements TableCellRenderer {

        DefaultTableCellRenderer renderer;

        public HeaderRenderer(JTable table) {
            renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int col) {
            return renderer.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, col);
        }
    }

    private void completarTabla() {
        modelo1.addColumn("Codigo");
        modelo1.addColumn("Especialidad del Médico");
        modelo1.addColumn("Fecha");
        modelo1.addColumn("Hora");

        TableColumnModel columnModel1 = tablaCita.getColumnModel();

        columnModel1.getColumn(0).setPreferredWidth(160);
        columnModel1.getColumn(1).setPreferredWidth(274);
        columnModel1.getColumn(2).setPreferredWidth(160);
        columnModel1.getColumn(3).setPreferredWidth(160);

        JTableHeader header1 = tablaCita.getTableHeader();
        header1.setDefaultRenderer(new HistorialCitas.HeaderRenderer(tablaCita));
        tablaCita.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        modelo1.setRowCount(0);
    }

    protected void leerArchivo(String id) {
        File file;
        FileReader fr = null;
        BufferedReader br;
        file = new File("src/archivos/cita.txt");
        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "El archivo no Existe");
        } else {
            try {
                fr = new FileReader(file);
                br = new BufferedReader(fr);
                Object[] lineaf = br.lines().toArray();
                for (Object linea1 : lineaf) {
                    int ini = linea1.toString().indexOf(" ");
                    if (id.equals(linea1.toString().substring(0, ini))) {
                        String[] row = linea1.toString().substring(ini+2).split("  "); 
                        modelo1.addRow(row);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e);
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (IOException e2) {
                    System.out.println("Error: " + e2);
                }
            }
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

        ButonSalir = new javax.swing.JButton();
        jScrolTest3 = new javax.swing.JScrollPane();
        tablaCita = new javax.swing.JTable(modelo1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        ButonSalir.setText("Safari");
        ButonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonSalirActionPerformed(evt);
            }
        });

        tablaCita.getTableHeader().setResizingAllowed(false);
        tablaCita.getTableHeader().setReorderingAllowed(false);
        tablaCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCitaMouseClicked(evt);
            }
        });
        jScrolTest3.setViewportView(tablaCita);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(279, Short.MAX_VALUE)
                .addComponent(ButonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrolTest3, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jScrolTest3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(ButonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonSalirActionPerformed
        dispose();
    }//GEN-LAST:event_ButonSalirActionPerformed

    private void tablaCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCitaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaCitaMouseClicked

    private void jPanel8MousePressed(java.awt.event.MouseEvent evt) {
        xx = evt.getX();
        xy = evt.getY();
    }

    private void jPanel8MouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }

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
            java.util.logging.Logger.getLogger(HistorialCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistorialCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistorialCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistorialCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistorialCitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButonSalir;
    private javax.swing.JScrollPane jScrolTest3;
    private javax.swing.JTable tablaCita;
    // End of variables declaration//GEN-END:variables
}
