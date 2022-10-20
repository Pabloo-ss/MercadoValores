package gui;

import aplicacion.Pacto;
import aplicacion.Usuario;
import aplicacion.Empresa;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class VPactos extends javax.swing.JDialog {

    private final aplicacion.FachadaAplicacion fa;
    private final Usuario uConect;

    public VPactos(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa, Usuario uConect) {
        super(parent, modal);
        this.fa = fa;
        this.uConect = uConect;
        initComponents();
        actualizarComision();
        actualizarEmpresaBox();
        actualizarTablaPactos(tEmpresaBuscar.getText());
        actualizarTablaMisPactos();
        
        
        // Centrado de texto en tablas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tabla.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tabla.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tabla.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tabla.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        tablaMisOfertas.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablaMisOfertas.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tablaMisOfertas.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tablaMisOfertas.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        tablaYaPactados.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablaYaPactados.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tablaYaPactados.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tablaYaPactados.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tablaYaPactados.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tablaYaPactados.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comisionLabel = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        empresaBox = new javax.swing.JComboBox<>();
        btnOfrecer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        selectorFecha = new com.toedter.calendar.JDateChooser();
        tEmpresaBuscar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        cantidadSpinner = new javax.swing.JSpinner();
        tPrecio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaMisOfertas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaYaPactados = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de contratos de futuros");

        comisionLabel.setForeground(new java.awt.Color(0, 102, 0));

        jLabel8.setText("Empresa:");

        btnOfrecer.setText("Ofrecer");
        btnOfrecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOfrecerActionPerformed(evt);
            }
        });

        tabla.setModel(new gui.ModeloTablaPactos());
        jScrollPane1.setViewportView(tabla);

        jLabel2.setText("Cantidad:");

        jLabel5.setText("Fecha de venta:");

        jLabel1.setText("Buscar por nombre:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        cantidadSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        tPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tPrecioKeyReleased(evt);
            }
        });

        jLabel3.setText("Precio:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cantidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(466, 466, 466))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(3, 3, 3)
                                .addComponent(empresaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnOfrecer))
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(selectorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAceptar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnBuscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tEmpresaBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                        .addGap(28, 28, 28)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tEmpresaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(122, 122, 122)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cantidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(empresaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOfrecer)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Operaciones", jPanel1);

        tablaMisOfertas.setModel(new gui.ModeloTablaPactos());
        jScrollPane3.setViewportView(tablaMisOfertas);

        jLabel4.setText("Ofertas:");

        jLabel7.setText("Ya pactados:");

        tablaYaPactados.setModel(new gui.ModeloTablaPactosAceptados());
        jScrollPane4.setViewportView(tablaYaPactados);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(201, 201, 201))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );

        jTabbedPane1.addTab("Mis pactos", jPanel2);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comisionLabel)
                .addGap(679, 679, 679))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVolver)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comisionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        ModeloTablaPactos m = (ModeloTablaPactos) tabla.getModel();

        Pacto p = m.obtenerPacto(tabla.getSelectedRow());

        if (p.getCantidad() > fa.obtenerNumParticipacionesDisponiblesEmpresa(uConect, p.getIdEmpresa()))
        fa.muestraExcepcion("Número de participaciones insuficiente");
        else {
            p.setVendedor(uConect.getId());
            fa.aceptarPacto(p);
        }

        actualizarComision();
        actualizarEmpresaBox();
        actualizarTablaPactos(tEmpresaBuscar.getText());
        actualizarTablaMisPactos();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        actualizarComision();
        actualizarEmpresaBox();
        actualizarTablaPactos(tEmpresaBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnOfrecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOfrecerActionPerformed
        Pacto p;
        boolean ok = true;
        float precio;
        int cantidad;
        String id;
        long fecha = selectorFecha.getDate().getTime();
        java.util.Date fechaHoy = java.util.Calendar.getInstance().getTime();

        if (tPrecio.getText().isEmpty() || selectorFecha.getDate() == null) {
            ok = false;
            fa.muestraExcepcion("Rellena todos los campos");
        }else{
            if(fecha - fechaHoy.getTime() < 1000*60*60*24){
                ok = false;
                fa.muestraExcepcion("Introduce una fecha dos días posterior a la actual.");
            }
        }

        if ((int) cantidadSpinner.getValue() < 1) {
            ok = false;
            fa.muestraExcepcion("Introduce una cantidad distinta de 0");
        }

        if ((id = fa.obtenerEmpresaPorNombre(empresaBox.getItemAt(empresaBox.getSelectedIndex()))) == null) {
            ok = false;
            System.out.println("Nunca debería chegar a aquí");
        }

        if (ok) {
            precio = Float.parseFloat(tPrecio.getText());
            cantidad = (int) cantidadSpinner.getValue();

            p = new Pacto(new java.sql.Timestamp(java.lang.System.currentTimeMillis()), uConect.getId(), id,
                empresaBox.getItemAt(empresaBox.getSelectedIndex()), cantidad, precio, new java.sql.Timestamp(selectorFecha.getDate().getTime()));

            fa.insertarPacto(p);

            JOptionPane.showMessageDialog(null, "Oferta realizada correctamente.");
        }

        actualizarComision();
        actualizarEmpresaBox();
        actualizarTablaPactos(tEmpresaBuscar.getText());
        actualizarTablaMisPactos();
    }//GEN-LAST:event_btnOfrecerActionPerformed

    private void tPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tPrecioKeyReleased
        try {
            if (!tPrecio.getText().isEmpty()) {
                Float.parseFloat(tPrecio.getText());
            }
            btnOfrecer.setEnabled(true);
        } catch (NumberFormatException e) {
            btnOfrecer.setEnabled(false);
        }
    }//GEN-LAST:event_tPrecioKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnOfrecer;
    private javax.swing.JButton btnVolver;
    private javax.swing.JSpinner cantidadSpinner;
    private javax.swing.JLabel comisionLabel;
    private javax.swing.JComboBox<String> empresaBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser selectorFecha;
    private javax.swing.JTextField tEmpresaBuscar;
    private javax.swing.JTextField tPrecio;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablaMisOfertas;
    private javax.swing.JTable tablaYaPactados;
    // End of variables declaration//GEN-END:variables

    private void actualizarTablaPactos(String empresa) {
        ModeloTablaPactos m = (ModeloTablaPactos) tabla.getModel();

        m.setFilas(fa.buscarPactos(empresa, uConect, false));

        if (m.getRowCount() > 0) {
            tabla.setRowSelectionInterval(0, 0);
            btnAceptar.setEnabled(true);
        } else {
            btnAceptar.setEnabled(false);
        }
    }
    
    private void actualizarTablaMisPactos(){
        ModeloTablaPactos m = (ModeloTablaPactos) tablaMisOfertas.getModel();
        ModeloTablaPactosAceptados m1 = (ModeloTablaPactosAceptados) tablaYaPactados.getModel();

        m.setFilas(fa.buscarPactos("", uConect, true));
        
        m1.setFilas(fa.buscarMisPactos(uConect));

    }
    
    private void actualizarEmpresaBox() {
        java.util.List<Usuario> empresas = fa.obtenerEmpresas();
        Empresa e;
        String [] nombres = new String[empresas.size()];
        
        empresaBox.removeAllItems();
        for (int i = 0; i < empresas.size(); i++) {
            e = (Empresa) empresas.get(i);
            nombres[i] = e.getNombre();
        }
        
        for (String s : nombres)
            empresaBox.insertItemAt(s, empresaBox.getItemCount());
        
        empresaBox.setSelectedIndex(0);
    }

    private void actualizarComision() {
        comisionLabel.setText("Comisión actual: " + Float.toString(fa.obtenerComisionActual()) +" %");
    }
}
