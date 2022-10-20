package gui;

import aplicacion.Usuario;
import aplicacion.Stacked;
import aplicacion.Participaciones;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class VStacking extends javax.swing.JDialog {

    private final aplicacion.FachadaAplicacion fa;
    private final Usuario uConect;

    public VStacking(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa, Usuario u) {
        super(parent, modal);
        this.fa = fa;
        this.uConect = u;
        initComponents();
        actualizarInteres();
        actualizarParticipaciones();
        actualizarStacked();

        // Centrado de texto en tablas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tablaPart.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablaPart.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tablaPart.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tablaPart.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        tablaStac.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablaStac.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tablaStac.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tablaStac.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaStac = new javax.swing.JTable();
        btnDepositar = new javax.swing.JButton();
        btnRetirar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPart = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cantidadSpinner = new javax.swing.JSpinner();
        interesLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de stacking");

        tablaStac.setModel(new gui.ModeloTablaStacking());
        jScrollPane1.setViewportView(tablaStac);

        btnDepositar.setText("Depositar");
        btnDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarActionPerformed(evt);
            }
        });

        btnRetirar.setText("Retirar");
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel1.setText("Cantidad:");

        tablaPart.setModel(new gui.ModeloTablaCarteraParticipaciones());
        jScrollPane2.setViewportView(tablaPart);

        jLabel2.setText("Cartera de participaciones");

        jLabel3.setText("Stacking");

        cantidadSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        interesLabel.setForeground(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cantidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDepositar)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRetirar)
                        .addGap(118, 118, 118)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(141, 141, 141))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(interesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRetirar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDepositar)
                        .addComponent(jLabel1)
                        .addComponent(cantidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(interesLabel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositarActionPerformed
        ModeloTablaCarteraParticipaciones m = (ModeloTablaCarteraParticipaciones) tablaPart.getModel();
        int cant;
        Participaciones p = m.obtenerParticipacion(tablaPart.getSelectedRow());

        if ((cant = (int) cantidadSpinner.getValue()) > fa.obtenerNumParticipacionesDisponiblesEmpresa(uConect, p.getEmpresa())) {
            fa.muestraExcepcion("Cantidad de participaciones insuficiente.");
        } else if (cant == 0) {
            fa.muestraExcepcion("Introduce una cantidad distinta de 0.");
        } else {
            fa.insertarStacking(new Stacked(new java.sql.Timestamp(java.lang.System.currentTimeMillis()), uConect.getId(), p.getEmpresa(), cant));

            JOptionPane.showMessageDialog(null, "Participaciones depositadas para stacking correctamente.");
        }

        actualizarInteres();
        actualizarParticipaciones();
        actualizarStacked();

    }//GEN-LAST:event_btnDepositarActionPerformed

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed
        ModeloTablaStacking m = (ModeloTablaStacking) tablaStac.getModel();
        Stacked s = m.obtenerStacked(tablaStac.getSelectedRow());

        float ganancia = fa.retirarStacking(s);

        System.out.println(ganancia);

        fa.actualizarSaldo(uConect, uConect.getSaldoDisponible() + ganancia);
        uConect.setSaldoDisponible(uConect.getSaldoDisponible() + ganancia);

        JOptionPane.showMessageDialog(null, "Participaciones retiradas del stacking correctamente.");

        actualizarInteres();
        actualizarParticipaciones();
        actualizarStacked();
    }//GEN-LAST:event_btnRetirarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDepositar;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JSpinner cantidadSpinner;
    private javax.swing.JLabel interesLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaPart;
    private javax.swing.JTable tablaStac;
    // End of variables declaration//GEN-END:variables

    private void actualizarStacked() {
        ModeloTablaStacking m = (ModeloTablaStacking) tablaStac.getModel();

        m.setFilas(fa.obtenerStacking(uConect));

        if (m.getRowCount() > 0) {
            tablaStac.setRowSelectionInterval(0, 0);
            btnRetirar.setEnabled(true);
        } else {
            btnRetirar.setEnabled(false);
        }
    }

    private void actualizarParticipaciones() {
        ModeloTablaCarteraParticipaciones m = (ModeloTablaCarteraParticipaciones) tablaPart.getModel();
        List<Participaciones> totales = fa.obtenerParticipacionesEnVenta(uConect);
        List<Participaciones> disponibles = fa.obtenerParticipaciones(uConect);
        for (Participaciones p : disponibles) {
            totales.add(p);
        }
        m.setFilas(totales);

        if (m.getRowCount() > 0) {
            tablaPart.setRowSelectionInterval(0, 0);
            btnDepositar.setEnabled(true);
        } else {
            btnDepositar.setEnabled(false);
        }
    }

    private void actualizarInteres() {
        interesLabel.setText("Interés actual: " + Float.toString(fa.obtenerInteresActual()) + " %");
    }
}
