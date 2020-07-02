/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741.Interfaz;

import javax.swing.JOptionPane;
import proyecto2_201503741.Clases.Cliente;
import static proyecto2_201503741.Interfaz.Admin_Clientes.Cliente_Buscado;
import proyecto2_201503741.Proyecto2_201503741;
import static proyecto2_201503741.Interfaz.Menu_Principal.CargarCbx_Cliente;
import static proyecto2_201503741.Interfaz.Admin_Clientes.RefrescarTabla;

/**
 *
 * @author EDDY
 */
public class Ventana_Cliente extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Cliente
     */
    public Ventana_Cliente() {
        initComponents();
        CargarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_Dpi = new javax.swing.JTextField();
        txt_Nombres = new javax.swing.JTextField();
        txt_Apellidos = new javax.swing.JTextField();
        txt_Genero = new javax.swing.JTextField();
        txt_Fecha = new javax.swing.JTextField();
        txt_Telefono = new javax.swing.JTextField();
        txt_Direccion = new javax.swing.JTextField();
        btn_Eliminar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cliente");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Cliente");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("DPI");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombres");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Apellidos");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Genero");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Fecha Nacimiento");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Telefono");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Direccion");

        txt_Dpi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_Nombres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_Apellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_Genero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_Fecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_Telefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_Direccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_Eliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });

        btn_Cancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        btn_Modificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Modificar.setText("Modificar");
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Dpi)
                            .addComponent(txt_Nombres)
                            .addComponent(txt_Apellidos)
                            .addComponent(txt_Genero)
                            .addComponent(txt_Fecha)
                            .addComponent(txt_Telefono)
                            .addComponent(txt_Direccion))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(btn_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Dpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_Genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void CargarDatos(){
        txt_Dpi.setText(Cliente_Buscado.getDpi()+"");
        txt_Nombres.setText(Cliente_Buscado.getNombres());
        txt_Apellidos.setText(Cliente_Buscado.getApellidos());
        txt_Genero.setText(Cliente_Buscado.getGenero());
        txt_Fecha.setText(Cliente_Buscado.getFecha_nacimiento());
        txt_Telefono.setText(Cliente_Buscado.getTelefono()+"");
        txt_Direccion.setText(Cliente_Buscado.getDireccion());
    }
    
    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Seguro desea borrar este cliente?", "", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            Proyecto2_201503741.TablaHash_Clientes.Eliminar(Long.parseLong(txt_Dpi.getText().trim()));
            RefrescarTabla();
            CargarCbx_Cliente();
            Cliente_Buscado = null;
            this.dispose();
        }
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
        if (Long.parseLong(txt_Dpi.getText().trim()) == Cliente_Buscado.getDpi()) {
            Cliente_Buscado.setNombres(txt_Nombres.getText());
            Cliente_Buscado.setApellidos(txt_Apellidos.getText());
            Cliente_Buscado.setGenero(txt_Genero.getText());
            Cliente_Buscado.setFecha_nacimiento(txt_Fecha.getText());
            Cliente_Buscado.setTelefono(Integer.parseInt(txt_Telefono.getText()));
            Cliente_Buscado.setDireccion(txt_Direccion.getText());
            JOptionPane.showMessageDialog(this, "Modificado");
            CargarDatos();
            RefrescarTabla();
            CargarCbx_Cliente();
        } else {
            Proyecto2_201503741.TablaHash_Clientes.Eliminar(Cliente_Buscado.getDpi());
            Cliente ClienteModificado = new Cliente(Long.parseLong(txt_Dpi.getText().trim()), txt_Nombres.getText(), txt_Apellidos.getText(), txt_Genero.getText(), txt_Fecha.getText(), Integer.parseInt(txt_Telefono.getText()), txt_Direccion.getText());
            Proyecto2_201503741.TablaHash_Clientes.Insertar(ClienteModificado);
            Cliente_Buscado = Proyecto2_201503741.TablaHash_Clientes.Buscar(ClienteModificado.getDpi());
            JOptionPane.showMessageDialog(this, "Modificado");
            CargarDatos();
            RefrescarTabla();
            CargarCbx_Cliente();
        }
    }//GEN-LAST:event_btn_ModificarActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private static javax.swing.JTextField txt_Apellidos;
    private static javax.swing.JTextField txt_Direccion;
    private static javax.swing.JTextField txt_Dpi;
    private static javax.swing.JTextField txt_Fecha;
    private static javax.swing.JTextField txt_Genero;
    private static javax.swing.JTextField txt_Nombres;
    private static javax.swing.JTextField txt_Telefono;
    // End of variables declaration//GEN-END:variables
}