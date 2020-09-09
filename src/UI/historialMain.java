/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author param
 */
public final class historialMain extends javax.swing.JFrame {

    private final LineBorder border = new LineBorder((new Color(107, 179, 35)), 5);
    int xx, xy;
    Runnable runnable;
    HistorialCitas hcita = new HistorialCitas();
    HistorialConsulta hconsulta = new HistorialConsulta();
    TableRowSorter trs = null;

    DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    };

    /**
     * Creates new form historialMain
     */
    public historialMain() {
        initComponents();
        //Para capturar el tiempo real
        this.runnable = () -> {
            while (true) {
                jLabel4.setText(Fecha());
            }
        };
        Thread hilo = new Thread(runnable);
        hilo.start();
        //Propiedades
        this.setLocationRelativeTo(null);
        this.getRootPane().setBorder(border);
        ButtonConsultas.setEnabled(false);
        ButtonCitas.setEnabled(false);
        bSalir.setIcon(ponerIcono("src/imagenes/principal.png", bSalir));
        //Funciones
        completarTabla();//Completa la tabla con las columnas correspondientes
        leerArchivo();//LLena la tabla con los valores de los archivos
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

    public String Fecha() {
        Calendar f = Calendar.getInstance();
        String di[] = {" ", "domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sábado"};
        String me[] = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
        //Fecha
        int A = f.get(Calendar.YEAR);
        int M = f.get(Calendar.MONTH);
        int D = f.get(Calendar.DAY_OF_MONTH);
        int S = f.get(Calendar.DAY_OF_WEEK);
        //Tiempo
        int hour = f.get(Calendar.HOUR_OF_DAY);
        int minute = f.get(Calendar.MINUTE);
        int second = f.get(Calendar.SECOND);
        //Cadena

        return "\tLima " + di[S] + " " + D + " de " + me[M] + " del " + A + " "
                + (hour < 10 ? "0" : "") + hour + ":"
                + (minute < 10 ? "0" : "") + minute + ":"
                + (second < 10 ? "0" : "") + second;
    }

    private void completarTabla() {

        modelo.addColumn("Dni");
        modelo.addColumn("Apellido paterno");
        modelo.addColumn("Apellido materno");
        modelo.addColumn("Nombre");
        modelo.addColumn("Estado Civil");
        modelo.addColumn("Género");
        modelo.addColumn("Fecha de Nacimiento");
        modelo.addColumn("Telefono");
        modelo.addColumn("Problemas Médicos");

        TableColumnModel columnModel = tablaTest1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(150);
        columnModel.getColumn(5).setPreferredWidth(150);
        columnModel.getColumn(6).setPreferredWidth(150);
        columnModel.getColumn(7).setPreferredWidth(150);
        columnModel.getColumn(8).setPreferredWidth(500);

        JTableHeader header = tablaTest1.getTableHeader();
        header.setDefaultRenderer(new historialMain.HeaderRenderer(tablaTest1));
        tablaTest1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        modelo.setRowCount(0);
    }

    private void leerArchivo() {
        File file;
        FileReader fr = null;
        BufferedReader br;
        file = new File("src/archivos/paciente.txt");
        //file2 = new File("src/archivos/consulta.txt");
        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo no existe", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                fr = new FileReader(file);
                if (fr.read() < 0) {
                    jLabel5.setText("NO EXISTEN PACIENTES ACTUALMENTE PARA MOSTRAR");

                } else {
                    br = new BufferedReader(fr);
                    Object[] lineaf = br.lines().toArray();
                    for (Object linea1 : lineaf) {
                        String[] row = linea1.toString().split("  ");
                        modelo.addRow(row);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e);
            } catch (IOException ex) {
                System.out.println("Error " + ex);
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

    public Icon ponerIcono(String url, JButton boton) {
        ImageIcon icon = new ImageIcon(url);
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_DEFAULT));
        return icono;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textBuscador = new javax.swing.JTextField();
        comboFiltro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrolTest1 = new javax.swing.JScrollPane();
        tablaTest1 = new javax.swing.JTable(modelo);
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ButtonCitas = new javax.swing.JButton();
        ButtonConsultas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel8.setBackground(new java.awt.Color(107, 179, 35));
        jPanel8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel8MouseDragged(evt);
            }
        });
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel8MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HISTORIAL MÉDICO");

        jPanel2.setBackground(new java.awt.Color(239, 251, 239));

        jLabel2.setText("Buscar por: ");

        textBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBuscadorActionPerformed(evt);
            }
        });
        textBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBuscadorKeyTyped(evt);
            }
        });

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Apellido materno", "Apellido paterno", "DNI", "Nombre"}));
        comboFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltroActionPerformed(evt);
            }
        });

        jLabel3.setText("Buscar:");

        jPanel3.setBackground(new java.awt.Color(239, 251, 239));

        tablaTest1.getTableHeader().setResizingAllowed(false);
        tablaTest1.getTableHeader().setReorderingAllowed(false);
        tablaTest1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTest1MouseClicked(evt);
            }
        });
        jScrolTest1.setViewportView(tablaTest1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(java.awt.Color.red);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        ButtonCitas.setText("CITAS");
        ButtonCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCitasActionPerformed(evt);
            }
        });

        ButtonConsultas.setText("CONSULTAS");
        ButtonConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConsultasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(ButtonConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210)
                .addComponent(ButtonCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrolTest1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrolTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        bSalir.setMaximumSize(new java.awt.Dimension(80, 30));
        bSalir.setMinimumSize(new java.awt.Dimension(80, 30));
        bSalir.setPreferredSize(new java.awt.Dimension(80, 30));
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });
        jScrollPane1.setViewportView(bSalir);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel8MousePressed

    private void jPanel8MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel8MouseDragged

    private void ButtonConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConsultasActionPerformed
        hconsulta.setVisible(true);
    }//GEN-LAST:event_ButtonConsultasActionPerformed

    private void ButtonCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCitasActionPerformed
        hcita.setVisible(true);
    }//GEN-LAST:event_ButtonCitasActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        dispose();
    }//GEN-LAST:event_bSalirActionPerformed

    private void tablaTest1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTest1MouseClicked
        int seleccionar= tablaTest1.rowAtPoint(evt.getPoint());
        hcita.leerArchivo(String.valueOf(tablaTest1.getValueAt(seleccionar, 0)));
        ButtonConsultas.setEnabled(true);
        ButtonCitas.setEnabled(true);        
    }//GEN-LAST:event_tablaTest1MouseClicked

    private void comboFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFiltroActionPerformed

    TableRowSorter trs1 = null;
    TableRowSorter trs2 = null;
    private void textBuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscadorKeyTyped

        int a = comboFiltro.getSelectedIndex();
        if (a == 0) {
            textBuscador.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent ke) {
                    trs.setRowFilter(RowFilter.regexFilter("(?i)" + textBuscador.getText(), 2));
                }
            });
        } else if (a == 2) {
            textBuscador.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent ke) {
                    trs.setRowFilter(RowFilter.regexFilter("(?i)" + textBuscador.getText(), 0));
                }
            });
        } else if (a != -1) {
            textBuscador.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent ke) {
                    trs.setRowFilter(RowFilter.regexFilter("(?i)" + textBuscador.getText(), a));
                    //trs1.setRowFilter(RowFilter.regexFilter("(?i)" + textBuscador.getText(), a));
                    //trs2.setRowFilter(RowFilter.regexFilter("(?i)" + textBuscador.getText(), a));
                }
            });
            //trs1 = new TableRowSorter(modelo1);
            //trs2 = new TableRowSorter(modelo2);
            //tablaCita.setRowSorter(trs1);
            //tablaConsulta.setRowSorter(trs2);
        }
        trs = new TableRowSorter(modelo);
        tablaTest1.setRowSorter(trs);
    }//GEN-LAST:event_textBuscadorKeyTyped

    private void textBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscadorActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(historialMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new historialMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCitas;
    private javax.swing.JButton ButtonConsultas;
    private javax.swing.JButton bSalir;
    private javax.swing.JComboBox<String> comboFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrolTest1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTest1;
    private javax.swing.JTextField textBuscador;
    // End of variables declaration//GEN-END:variables
}
