package Vista;

import Controlador.CtMascota;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class ListarMascotas extends javax.swing.JFrame {

    CtMascota CtMascota;
    DefaultTableModel mascotasTabla = new DefaultTableModel();

    public ListarMascotas() {
        initComponents();
        CtMascota = new CtMascota();

        mascotasTabla.addColumn("Id");
        mascotasTabla.addColumn("Código");
        mascotasTabla.addColumn("Nombre");
        mascotasTabla.addColumn("Edad");
        mascotasTabla.addColumn("Peso");
        mascotasTabla.addColumn("Especie");
        mascotasTabla.addColumn("idCliente");
        listarMascotas.setModel(mascotasTabla);

        String[][] listaMascotas = CtMascota.retornarAllMascotas();
        int filas = listaMascotas.length;

        String[] datos = new String[7];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < 7; j++) {
                datos[j] = listaMascotas[i][j];

            }
            mascotasTabla.addRow(datos);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listarMascotas = new javax.swing.JTable();
        mascotasExcel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        filtrarIdCliente = new javax.swing.JTextField();
        filtrarNombre = new javax.swing.JTextField();
        filtrarEdad = new javax.swing.JTextField();
        filtrarEspecie = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listarMascotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(listarMascotas);

        mascotasExcel.setText("Excel");
        mascotasExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mascotasExcelActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtrar por idCliente:");

        jLabel2.setText("Filtrar por nombre:");

        jLabel3.setText("Filtrar por edad:");

        jLabel4.setText("Filtrar por especie:");

        filtrarIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarIdClienteActionPerformed(evt);
            }
        });
        filtrarIdCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filtrarIdClienteKeyTyped(evt);
            }
        });

        filtrarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarNombreActionPerformed(evt);
            }
        });
        filtrarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filtrarNombreKeyTyped(evt);
            }
        });

        filtrarEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filtrarEdadKeyTyped(evt);
            }
        });

        filtrarEspecie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filtrarEspecieKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(filtrarEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(filtrarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(filtrarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(filtrarIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mascotasExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(filtrarIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(filtrarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(filtrarEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(filtrarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(mascotasExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mascotasExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mascotasExcelActionPerformed
        try {
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("Hoja 1");
            Row rowCol = sheet.createRow(0);
            for (int i = 0; i < listarMascotas.getColumnCount(); i++) {
                Cell cell = rowCol.createCell(i);
                cell.setCellValue(listarMascotas.getColumnName(i));
            }
            for (int i = 0; i < listarMascotas.getRowCount(); i++) {
                Row row = sheet.createRow(i + 1);
                for (int j = 0; j < listarMascotas.getColumnCount(); j++) {
                    Cell cell = row.createCell(j);
                    if (listarMascotas.getValueAt(i, j) != null) {
                        cell.setCellValue(listarMascotas.getValueAt(i, j).toString());
                    }
                }
            }
            String nombre = JOptionPane.showInputDialog("Nombre del archivo: ");
            FileOutputStream out = new FileOutputStream(new File(nombre + ".xlsx"));
            wb.write(out);
            wb.close();
            out.close();
            System.out.println(out);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException io) {
            System.out.println(io);
        }
    }//GEN-LAST:event_mascotasExcelActionPerformed

    TableRowSorter trs;
    DefaultTableModel mT = new DefaultTableModel();
    private void filtrarIdClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtrarIdClienteKeyTyped

        filtrarIdCliente.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs.setRowFilter(RowFilter.regexFilter(filtrarIdCliente.getText(), 6));
                //"(?i)"+filtrarIdCliente.getText()
            }
        });

        trs = new TableRowSorter(mascotasTabla);
        listarMascotas.setRowSorter(trs);


    }//GEN-LAST:event_filtrarIdClienteKeyTyped

    private void filtrarIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtrarIdClienteActionPerformed

    private void filtrarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtrarNombreActionPerformed

    private void filtrarNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtrarNombreKeyTyped
                filtrarNombre.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs.setRowFilter(RowFilter.regexFilter(filtrarNombre.getText(), 2));
                //"(?i)"+filtrarIdCliente.getText()
            }
        });

        trs = new TableRowSorter(mascotasTabla);
        listarMascotas.setRowSorter(trs);


    }//GEN-LAST:event_filtrarNombreKeyTyped

    private void filtrarEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtrarEdadKeyTyped
                filtrarEdad.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs.setRowFilter(RowFilter.regexFilter(filtrarEdad.getText(), 3));
                //"(?i)"+filtrarIdCliente.getText()
            }
        });

        trs = new TableRowSorter(mascotasTabla);
        listarMascotas.setRowSorter(trs);


    }//GEN-LAST:event_filtrarEdadKeyTyped

    private void filtrarEspecieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtrarEspecieKeyTyped
                filtrarEspecie.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {

                trs.setRowFilter(RowFilter.regexFilter(filtrarEspecie.getText(), 5));
                //"(?i)"+filtrarIdCliente.getText()
            }
        });

        trs = new TableRowSorter(mascotasTabla);
        listarMascotas.setRowSorter(trs);


    }//GEN-LAST:event_filtrarEspecieKeyTyped

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
            java.util.logging.Logger.getLogger(ListarMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarMascotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField filtrarEdad;
    private javax.swing.JTextField filtrarEspecie;
    private javax.swing.JTextField filtrarIdCliente;
    private javax.swing.JTextField filtrarNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listarMascotas;
    private javax.swing.JButton mascotasExcel;
    // End of variables declaration//GEN-END:variables
}
