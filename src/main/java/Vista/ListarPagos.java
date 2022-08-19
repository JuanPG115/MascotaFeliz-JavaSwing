package Vista;

import Controlador.CtPago;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ListarPagos extends javax.swing.JFrame {

    CtPago CtPago;

    public ListarPagos() {
        initComponents();
        CtPago = new CtPago();

        DefaultTableModel pagosTabla = new DefaultTableModel();
        pagosTabla.addColumn("Id");
        pagosTabla.addColumn("Código");
        pagosTabla.addColumn("Fecha");
        pagosTabla.addColumn("NúmeroMascotas");
        pagosTabla.addColumn("idMascota");
        pagosTabla.addColumn("idPlan");

        listarPagos.setModel(pagosTabla);

        String[][] listaPagos = CtPago.retornarAllPagos();
        int filas = listaPagos.length;

        String[] datos = new String[6];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < 6; j++) {
                datos[j] = listaPagos[i][j];

            }
            pagosTabla.addRow(datos);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listarPagos = new javax.swing.JTable();
        pagosExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listarPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(listarPagos);

        pagosExcel.setText("Excel");
        pagosExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagosExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pagosExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pagosExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pagosExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagosExcelActionPerformed
        try {
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("Hoja 1");
            Row rowCol = sheet.createRow(0);
            for (int i = 0; i < listarPagos.getColumnCount(); i++) {
                Cell cell = rowCol.createCell(i);
                cell.setCellValue(listarPagos.getColumnName(i));
            }
            for (int i = 0; i < listarPagos.getRowCount(); i++) {
                Row row = sheet.createRow(i + 1);
                for (int j = 0; j < listarPagos.getColumnCount(); j++) {
                    Cell cell = row.createCell(j);
                    if (listarPagos.getValueAt(i, j) != null) {
                        cell.setCellValue(listarPagos.getValueAt(i, j).toString());
                    }
                }
            }
            String nombre = JOptionPane.showInputDialog("Nombre del archivo: ");
            FileOutputStream out = new FileOutputStream(new File(nombre+".xlsx"));
            wb.write(out);
            wb.close();
            out.close();
            System.out.println(out);
        } catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException io){
            System.out.println(io);
        }
    }//GEN-LAST:event_pagosExcelActionPerformed

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
            java.util.logging.Logger.getLogger(ListarPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarPagos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listarPagos;
    private javax.swing.JButton pagosExcel;
    // End of variables declaration//GEN-END:variables
}
