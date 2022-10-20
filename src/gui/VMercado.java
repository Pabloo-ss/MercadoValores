package gui;

import aplicacion.Empresa;
import aplicacion.Usuario;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class VMercado extends javax.swing.JDialog {

    private final aplicacion.FachadaAplicacion fa;
    private final Usuario uConect;

    public VMercado(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa, Usuario u) {
        super(parent, modal);
        this.fa = fa;
        this.uConect = u;
        initComponents();
        if (uConect.getTipo().name().equals("Inversor")) {
            btnGestionPagos.setVisible(false);
        }

        actualizarComision();
        actualizarTablaVentas();
        actualizarTablaAnuncios();
        actualizarEmpresaBox();
        labelExitoCompra.setVisible(false);

        // Centrado de texto en tablas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tablaVenta.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablaVenta.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tablaVenta.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        tablaAnuncios.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablaAnuncios.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tablaAnuncios.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tablaAnuncios.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVenta = new javax.swing.JTable();
        btnComprar = new javax.swing.JButton();
        btnGestionPagos = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaAnuncios = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        numeroSpinner = new javax.swing.JSpinner();
        textoPrecio = new javax.swing.JTextField();
        comisionLabel = new javax.swing.JLabel();
        labelExitoCompra = new javax.swing.JLabel();
        empresaBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mercado");

        jLabel1.setText("Empresa:");

        jLabel2.setText("Cantidad:");

        jLabel3.setText("Precio máximo:");

        jLabel4.setText("Participaciones en venta:");

        tablaVenta.setModel(new gui.ModeloTablaParticipaciones());
        jScrollPane1.setViewportView(tablaVenta);

        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        btnGestionPagos.setText("Gestionar pagos");
        btnGestionPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionPagosActionPerformed(evt);
            }
        });

        tablaAnuncios.setModel(new gui.ModeloTablaPagos()
        );
        jScrollPane3.setViewportView(tablaAnuncios);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel5.setText("Anuncios:");

        numeroSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        textoPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoPrecioKeyReleased(evt);
            }
        });

        comisionLabel.setForeground(new java.awt.Color(0, 102, 0));

        labelExitoCompra.setForeground(new java.awt.Color(0, 102, 0));
        labelExitoCompra.setText("Compra realizada correctamente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGestionPagos)
                        .addGap(146, 146, 146)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numeroSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)
                            .addComponent(comisionLabel)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(empresaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(labelExitoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comisionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(empresaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numeroSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnComprar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelExitoCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnGestionPagos))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGestionPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionPagosActionPerformed
        fa.iniciarPagos(uConect);
        actualizarComision();
        actualizarTablaVentas();
        actualizarTablaAnuncios();
        actualizarEmpresaBox();
        labelExitoCompra.setVisible(false);
    }//GEN-LAST:event_btnGestionPagosActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        ModeloTablaParticipaciones m = (ModeloTablaParticipaciones) tablaVenta.getModel();
        if (empresaBox.getItemCount() > 0) {
            if ((int) numeroSpinner.getValue() > 0) {
                if (!textoPrecio.getText().isEmpty()) {
                    if (!uConect.getId().equals(empresaBox.getItemAt(empresaBox.getSelectedIndex()))) {
                        if (fa.comprarParticipaciones(uConect.getId(), empresaBox.getItemAt(empresaBox.getSelectedIndex()), (int) numeroSpinner.getValue(),
                                Float.parseFloat(textoPrecio.getText()))) {
                            labelExitoCompra.setVisible(true);
                        } else {
                            labelExitoCompra.setVisible(false);
                        }
                    } else {
                        this.fa.muestraExcepcion("La empresa no puede comprar participaciones que ha puesto a la venta ella misma.");
                        labelExitoCompra.setVisible(false);
                    }
                } else {
                    fa.muestraExcepcion("El campo del precio no puede estar vacío.");
                    labelExitoCompra.setVisible(false);
                }
            } else {
                fa.muestraExcepcion("El campo de cantidad no puede estar vacío.");
                labelExitoCompra.setVisible(false);
            }
        } else {
            fa.muestraExcepcion("No hay ninguna participación a la venta.");
            labelExitoCompra.setVisible(false);
        }

        actualizarComision();
        actualizarTablaVentas();
        actualizarTablaAnuncios();
        actualizarEmpresaBox();
    }//GEN-LAST:event_btnComprarActionPerformed

    private void textoPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoPrecioKeyReleased
        try {
            if (!textoPrecio.getText().isEmpty()) {
                Float.parseFloat(textoPrecio.getText());
            }
            btnComprar.setEnabled(true);
        } catch (NumberFormatException e) {
            btnComprar.setEnabled(false);
        }
    }//GEN-LAST:event_textoPrecioKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnGestionPagos;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel comisionLabel;
    private javax.swing.JComboBox<String> empresaBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelExitoCompra;
    private javax.swing.JSpinner numeroSpinner;
    private javax.swing.JTable tablaAnuncios;
    private javax.swing.JTable tablaVenta;
    private javax.swing.JTextField textoPrecio;
    // End of variables declaration//GEN-END:variables

    private void actualizarTablaAnuncios() {
        ModeloTablaPagos m = (ModeloTablaPagos) tablaAnuncios.getModel();
        m.setFilas(fa.buscarAnunciosPagoBeneficios(""));
    }

    private void actualizarTablaVentas() {
        ModeloTablaParticipaciones m = (ModeloTablaParticipaciones) tablaVenta.getModel();

        m.setFilas(fa.consultarMercado());

        if (m.getRowCount() > 0) {
            tablaVenta.setRowSelectionInterval(0, 0);
            btnComprar.setEnabled(true);
        } else {
            btnComprar.setEnabled(false);
        }
    }

    private void actualizarComision() {
        comisionLabel.setText("Comisión actual: " + Float.toString(fa.obtenerComisionActual()) + " %");
    }

    private void actualizarEmpresaBox() {
        java.util.List<Usuario> empresas = fa.obtenerEmpresasEnMercado();
        Empresa e;
        String[] idsEmpresas = new String[empresas.size()];

        empresaBox.removeAllItems();
        for (int i = 0; i < empresas.size(); i++) {
            e = (Empresa) empresas.get(i);
            idsEmpresas[i] = e.getId();
        }

        for (String s : idsEmpresas) {
            empresaBox.insertItemAt(s, empresaBox.getItemCount());
        }

        if (empresaBox.getItemCount() > 0) {
            empresaBox.setSelectedIndex(0);
        }
    }
}
