/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741.Interfaz;

import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import proyecto2_201503741.Clases.Cliente;
import proyecto2_201503741.Clases.Vehiculo;
import proyecto2_201503741.Clases.Conductor;
import proyecto2_201503741.Clases.Nodo_BlockChain;
import proyecto2_201503741.EDD.Lista_Aristas;
import static proyecto2_201503741.Proyecto2_201503741.LeerArchivoClientes;
import static proyecto2_201503741.Proyecto2_201503741.TablaHash_Clientes;
import static proyecto2_201503741.Proyecto2_201503741.LeerArchivoVehiculos;
import static proyecto2_201503741.Proyecto2_201503741.Arbol_Vehiculos;
import static proyecto2_201503741.Proyecto2_201503741.LeerArchivoConductores;
import static proyecto2_201503741.Proyecto2_201503741.ListaCirculoar_Conductores;
import static proyecto2_201503741.Proyecto2_201503741.Grafo;
import static proyecto2_201503741.Proyecto2_201503741.Block_Viajes;

/**
 *
 * @author EDDY
 */
public class Menu_Principal extends javax.swing.JFrame {

    /**
     * Creates new form Menu_Principal
     */
    public Menu_Principal() {
        initComponents();
        CargarImagen();
        CargarCbx_OrigenYDestino();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        lbl_ImagenGrafo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbx_Origen = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbx_Destino = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbx_Clientes = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbx_Conductores = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbx_Vehiculos = new javax.swing.JComboBox<>();
        btn_AceptarViaje = new javax.swing.JButton();
        btn_BuscarViaje = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_llave = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        lbl_ImagenGrafo.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(lbl_ImagenGrafo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Viajes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Lugar de Origen");

        cbx_Origen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Lugar de Destino");

        cbx_Destino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cliente");

        cbx_Clientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbx_Clientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carge a los Clientes" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Conductor");

        cbx_Conductores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbx_Conductores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carge a los Conductores" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Vehiculo");

        cbx_Vehiculos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbx_Vehiculos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carge los Vehiculos" }));

        btn_AceptarViaje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_AceptarViaje.setText("Aceptar");
        btn_AceptarViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarViajeActionPerformed(evt);
            }
        });

        btn_BuscarViaje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_BuscarViaje.setText("Buscar");
        btn_BuscarViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarViajeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Obtener Ruta de un viaje");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Ingrese llave");

        txt_llave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_Destino, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_Origen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbx_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_Conductores, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_AceptarViaje)
                        .addGap(103, 103, 103))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(cbx_Vehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_BuscarViaje)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txt_llave, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbx_Origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(5, 5, 5)
                                .addComponent(cbx_Destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbx_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbx_Conductores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_AceptarViaje, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbx_Vehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txt_llave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btn_BuscarViaje, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jMenu1.setText("Clientes");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });

        jMenuItem1.setText("Carga Masiva");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Administrar Clientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Vehiculos");

        jMenuItem3.setText("Carga Masiva");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseClicked(evt);
            }
        });
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Administrar Vehiculos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Conductores");

        jMenuItem5.setText("Carga Masiva");
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem5MouseClicked(evt);
            }
        });
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Administrar Conductores");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Top's 10");
        jMenuBar1.add(jMenu5);

        jMenu6.setText("Reportes");

        jMenuItem7.setText("Reporte Clientes");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuItem8.setText("Reporte Vehiculos");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        jMenuItem9.setText("Reporte Conductores");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem9);

        jMenuItem10.setText("Reporte Grafo");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenuItem11.setText("Reporte BlockChain");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        jMenuBar1.add(jMenu6);

        jMenu4.setText("Acerca de");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static String Ruta_Imagen;

    public static void CargarImagen() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ImageIcon icono;
        icono = new ImageIcon("Grafica_Grafo.png");
        icono.getImage().flush();
        lbl_ImagenGrafo.setIcon(icono);
    }

    public static void CargarCbx_OrigenYDestino() {
        String[] Listado_Vertices = Grafo.ListadoVertices();
        cbx_Origen.setModel(new DefaultComboBoxModel<>(Listado_Vertices));
        cbx_Destino.setModel(new DefaultComboBoxModel<>(Listado_Vertices));
    }

    public static void CargarCbx_Cliente() {
        Cliente[] ListaClientes = TablaHash_Clientes.ListaClientes();
        String[] Cli = new String[ListaClientes.length];
        for (int i = 0; i < ListaClientes.length; i++) {
            if (ListaClientes[i] != null) {
                Cli[i] = ListaClientes[i].getDpi() + " / " + ListaClientes[i].getNombres();
            }
        }
        cbx_Clientes.setModel(new DefaultComboBoxModel<>(Cli));
    }

    public static void CargarCbx_Vehiculos() {
        Vehiculo[] ListaVehiculos = Arbol_Vehiculos.Lista_Vehiculos();
        String[] Vehiculos = new String[ListaVehiculos.length];
        for (int i = 0; i < Vehiculos.length; i++) {
            Vehiculos[i] = ListaVehiculos[i].getPlaca() + " / " + ListaVehiculos[i].getMarca() + " / " + ListaVehiculos[i].getModelo();
        }
        cbx_Vehiculos.setModel(new DefaultComboBoxModel<>(Vehiculos));
    }

    public static void CargarCbx_Conductores() {
        Conductor[] ListaConductores = ListaCirculoar_Conductores.ListadoConductores();
        String[] Conduc = new String[ListaConductores.length];
        for (int i = 0; i < Conduc.length; i++) {
            Conduc[i] = ListaConductores[i].getDpi() + " / " + ListaConductores[i].getNombres();
        }
        cbx_Conductores.setModel(new DefaultComboBoxModel<>(Conduc));
    }

    public static String getFecha() {
        Calendar c = Calendar.getInstance();
        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString(c.get(Calendar.MONTH) + 1);
        return dia + mes + "20";
    }

    public static String getHora() {
        Calendar c = Calendar.getInstance();
        String hora = Integer.toString(c.get(Calendar.HOUR));
        String minutos = Integer.toString(c.get(Calendar.MINUTE));
        return hora + ":" + minutos;
    }
    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        JOptionPane.showMessageDialog(this, "UNIVERSIDAD DE SAN CARLOS DE GUATEMALA \n"
                + "FACULTAD DE INGENIERIA \n"
                + "ESCUELA DE CIENCIAS Y SISTEMAS \n"
                + "Laboratorio de Estructura de Datos \n"
                + "Segundo Proyecto \n"
                + "          Autor: Eddy Alejandro Murga Barillas \n"
                + "          Carnet: 201503741 \n"
                + "Repositorio en Github: \n"
                + "https:/github.com/EmBarillasA94/EDD_PROYECTO2_JUNIO_201503741");
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked

    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MouseClicked
    }//GEN-LAST:event_jMenuItem3MouseClicked

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MouseClicked
    }//GEN-LAST:event_jMenuItem5MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser choser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
        choser.setFileFilter(filter);
        int option = choser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String ruta = choser.getSelectedFile().toString();
            LeerArchivoClientes(ruta);
            TablaHash_Clientes.Graph();
            CargarCbx_Cliente();
            JOptionPane.showMessageDialog(this, "Carga Exitosa");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFileChooser choser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
        choser.setFileFilter(filter);
        int option = choser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String ruta = choser.getSelectedFile().toString();
            LeerArchivoVehiculos(ruta);
            Arbol_Vehiculos.Reporte_ArbolB();
            CargarCbx_Vehiculos();
            JOptionPane.showMessageDialog(this, "Carga Exitosa");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JFileChooser choser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
        choser.setFileFilter(filter);
        int option = choser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String ruta = choser.getSelectedFile().toString();
            LeerArchivoConductores(ruta);
            ListaCirculoar_Conductores.graph();
            CargarCbx_Conductores();
            JOptionPane.showMessageDialog(this, "Carga Exitosa");
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void btn_AceptarViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarViajeActionPerformed
        //optener primero el vertice origen y el vertice destino
        int posOrigen = cbx_Origen.getSelectedIndex();
        String origen = cbx_Origen.getItemAt(posOrigen);
        int posDestino = cbx_Destino.getSelectedIndex();
        String destino = cbx_Destino.getItemAt(posDestino);
        Lista_Aristas rutaTomada = Grafo.Dijstra(origen, destino);
        //buscar el conductor
        int posConductor = cbx_Conductores.getSelectedIndex();
        String DatoCombo = cbx_Conductores.getItemAt(posConductor);
        String[] DatosConductor = DatoCombo.split("/");
        Conductor con = ListaCirculoar_Conductores.Buscar(Long.parseLong(DatosConductor[0].trim()));
        //buscar el cliente
        int posClient = cbx_Clientes.getSelectedIndex();
        String DatosComboCli = cbx_Clientes.getItemAt(posClient);
        String[] Cadena_cli = DatosComboCli.split("/");
        Cliente cli = TablaHash_Clientes.Buscar(Long.parseLong(Cadena_cli[0].trim()));
        //Buscar el vehiculo
        int posVehiculo = cbx_Vehiculos.getSelectedIndex();
        String DatosComboVe = cbx_Vehiculos.getItemAt(posVehiculo);
        String[] Cadena_ve = DatosComboVe.split("/");
        Vehiculo veh = Arbol_Vehiculos.Buscar(Cadena_ve[0].trim());
        //validar la ruta
        if (rutaTomada.getSize() >= 2) {
            System.out.println("Viaje ----------> " + veh.getPlaca() + getFecha() + getHora());
            Nodo_BlockChain viaje = new Nodo_BlockChain(veh.getPlaca() + getFecha() + getHora(), origen, destino, getFecha() + " " + getHora(), cli, con, veh, rutaTomada);
            cli.AumentarViajes();
            veh.AumentarViajes();
            con.AumentarViajes();
            Block_Viajes.Insertar(viaje);
            Block_Viajes.Graph();
            JOptionPane.showMessageDialog(this, "Viaje Registrado");
        } else {
            JOptionPane.showMessageDialog(this, "No es posible conectar el origen con el destino");
        }
    }//GEN-LAST:event_btn_AceptarViajeActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Admin_Clientes admin_cli = new Admin_Clientes();
        admin_cli.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Admin_Vehiculos admin_ve = new Admin_Vehiculos();
        admin_ve.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Admin_Conductores admin_con = new Admin_Conductores();
        admin_con.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btn_BuscarViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarViajeActionPerformed
        if (!txt_llave.getText().equals("")) {
            Nodo_BlockChain block_buscado = Block_Viajes.Buscar(txt_llave.getText());
            if (block_buscado != null) {
                block_buscado.Graph_Ruta();
                Ruta_Imagen = "Grafica_Ruta.png";
                Visor vr = new Visor();
                vr.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "No se encontro ningun viaje con esa llave");
            }
            txt_llave.setText("");
        }else{
            JOptionPane.showMessageDialog(this, "Ingrese una llave");
        }
    }//GEN-LAST:event_btn_BuscarViajeActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        TablaHash_Clientes.Graph();
        Ruta_Imagen = "Grafica_TablaHash.png";
        Visor vr = new Visor();
        vr.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Arbol_Vehiculos.Reporte_ArbolB();
        Ruta_Imagen = "Grafica_ArbolB.png";
        Visor vr = new Visor();
        vr.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        ListaCirculoar_Conductores.graph();
        Ruta_Imagen = "Grafica_Lista_Doble_Circular.png";
        Visor vr = new Visor();
        vr.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Ruta_Imagen = "Grafica_Grafo.png";
        Visor vr = new Visor();
        vr.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        Block_Viajes.Graph();
        Ruta_Imagen = "Grafica_BlockChain.png";
        Visor vr = new Visor();
        vr.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AceptarViaje;
    private javax.swing.JButton btn_BuscarViaje;
    private static javax.swing.JComboBox<String> cbx_Clientes;
    private static javax.swing.JComboBox<String> cbx_Conductores;
    private static javax.swing.JComboBox<String> cbx_Destino;
    private static javax.swing.JComboBox<String> cbx_Origen;
    private static javax.swing.JComboBox<String> cbx_Vehiculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel lbl_ImagenGrafo;
    private javax.swing.JTextField txt_llave;
    // End of variables declaration//GEN-END:variables
}
