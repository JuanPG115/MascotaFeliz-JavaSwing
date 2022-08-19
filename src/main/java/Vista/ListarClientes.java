package Vista;

import Controlador.CtCliente;
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

public class ListarClientes extends javax.swing.JFrame {

    CtCliente CtCliente;

    public ListarClientes() {
        initComponents();
        CtCliente = new CtCliente();

        DefaultTableModel clientesTabla = new DefaultTableModel();
        clientesTabla.addColumn("Id");
        clientesTabla.addColumn("Identificación");
        clientesTabla.addColumn("Nombre");
        clientesTabla.addColumn("Apellido");
        clientesTabla.addColumn("Direccion");
        clientesTabla.addColumn("Telefono");
        listarClientes.setModel(clientesTabla);

        String[][] listaClientes = CtCliente.retornarAllClientes();
        int filas = listaClientes.length;

        String[] datos = new String[6];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < 6; j++) {
                datos[j] = listaClientes[i][j];

            }
            clientesTabla.addRow(datos);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listarClientes = new javax.swing.JTable();
        clientesExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listarClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(listarClientes);

        clientesExcel.setText("Excel");
        clientesExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(clientesExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clientesExcel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientesExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesExcelActionPerformed
        try {
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("Hoja 1");
            Row rowCol = sheet.createRow(0);
            for (int i = 0; i < listarClientes.getColumnCount(); i++) {
                Cell cell = rowCol.createCell(i);
                cell.setCellValue(listarClientes.getColumnName(i));
            }
            for (int i = 0; i < listarClientes.getRowCount(); i++) {
                Row row = sheet.createRow(i + 1);
                for (int j = 0; j < listarClientes.getColumnCount(); j++) {
                    Cell cell = row.createCell(j);
                    if (listarClientes.getValueAt(i, j) != null) {
                        cell.setCellValue(listarClientes.getValueAt(i, j).toString());
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
    }//GEN-LAST:event_clientesExcelActionPerformed

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
            java.util.logging.Logger.getLogger(ListarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clientesExcel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listarClientes;
    // End of variables declaration//GEN-END:variables
}
