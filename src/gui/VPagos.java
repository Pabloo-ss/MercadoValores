package gui;

import aplicacion.PagoBeneficios;
import aplicacion.Usuario;
import javax.swing.JOptionPane;

public class VPagos extends javax.swing.JDialog {

    private final aplicacion.FachadaAplicacion fa;
    private final Usuario uConect;

    public VPagos(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa, Usuario u) {
        super(parent, modal);
        this.fa = fa;
        this.uConect = u;
        initComponents();
        actualizarVisibilidad();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelCantidad = new javax.swing.JLabel();
        labelImporte = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAnunciar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        textoImportePart = new javax.swing.JTextField();
        boxPreferencia = new javax.swing.JComboBox();
        selectorFecha = new com.toedter.calendar.JDateChooser();
        cantidadSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de pago de beneficios");

        jLabel1.setText("Fecha:");

        labelCantidad.setText("Cantidad de participaciones:");

        labelImporte.setText("Importe por participación:");

        jLabel4.setText("Preferencia pago:");

        btnAnunciar.setText("Anunciar");
        btnAnunciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnunciarActionPerformed(evt);
            }
        });

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        textoImportePart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoImportePartKeyReleased(evt);
            }
        });

        boxPreferencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Saldo", "Participaciones", "Ambas" }));
        boxPreferencia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxPreferenciaItemStateChanged(evt);
            }
        });

        cantidadSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        cantidadSpinner.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnunciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPagar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxPreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelImporte)
                            .addComponent(labelCantidad))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoImportePart, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(cantidadSpinner))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCantidad)
                    .addComponent(cantidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(boxPreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(selectorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelImporte)
                        .addComponent(textoImportePart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnunciar)
                    .addComponent(btnPagar)
                    .addComponent(btnVolver))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAnunciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnunciarActionPerformed
        PagoBeneficios pb;
        boolean error = false;

        if (selectorFecha.getDate() == null) {
            fa.muestraExcepcion("Se debe seleccionar una fecha de pago");
        } else {
            pb = new PagoBeneficios(uConect.getId(), new java.sql.Timestamp(selectorFecha.getDate().getTime()));
            
            long fecha = selectorFecha.getDate().getTime();
            java.util.Date fechaHoy = java.util.Calendar.getInstance().getTime();

            if ((fecha - fechaHoy.getTime()) < 1000 * 60 * 60 * 24) {
                error = true;
                fa.muestraExcepcion("Introduce una fecha dos días posterior a la actual.");
            }
            
            switch (boxPreferencia.getSelectedIndex()) {
                case 0: // Solo saldo
                    if (textoImportePart.getText().isEmpty()) {
                        fa.muestraExcepcion("El campo del importe no puede estar vacío");
                        error = true;
                    } else {
                        pb.setImporteParticipacion(Float.parseFloat(textoImportePart.getText()));
                    }
                    break;
                case 1: // Solo participaciones
                    if ((int) cantidadSpinner.getValue() < 1) {
                        fa.muestraExcepcion("Introduce una cantidad distinta de 0");
                        error = true;
                    } else {
                        pb.setParticipacionesPorUsuario((int) cantidadSpinner.getValue());
                    }
                    break;
                case 2: // Ambos
                    if (textoImportePart.getText().isEmpty()) {
                        fa.muestraExcepcion("El campo del importe no puede estar vacío");
                        error = true;
                    } else {
                        pb.setImporteParticipacion(Float.parseFloat(textoImportePart.getText()));
                        pb.setParticipacionesPorUsuario((int) cantidadSpinner.getValue());
                    }
                    break;
                default:
                    System.out.println("Nunca debería chegar a aquí");
            }

            if (!error) {
                if (fa.anunciarPago(pb)) {
                    JOptionPane.showMessageDialog(null, "Pago de beneficios anunciado correctamente.");

                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_btnAnunciarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        PagoBeneficios pb = new PagoBeneficios(uConect.getId(), null);
        boolean error = false;

        switch (boxPreferencia.getSelectedIndex()) {
            case 0: // Solo saldo
                if (textoImportePart.getText().isEmpty()) {
                    fa.muestraExcepcion("El campo del importe no puede estar vacío");
                    error = true;
                } else {
                    pb.setImporteParticipacion(Float.parseFloat(textoImportePart.getText()));
                }
                break;
            case 1: // Solo participaciones
                if ((int) cantidadSpinner.getValue() < 1) {
                    fa.muestraExcepcion("Introduce una cantidad distinta de 0");
                    error = true;
                } else {
                    pb.setParticipacionesPorUsuario((int) cantidadSpinner.getValue());
                }
                break;
            case 2: // Ambos
                if (textoImportePart.getText().isEmpty()) {
                    fa.muestraExcepcion("El campo del importe no puede estar vacío");
                    error = true;
                } else {
                    pb.setImporteParticipacion(Float.parseFloat(textoImportePart.getText()));
                    pb.setParticipacionesPorUsuario((int) cantidadSpinner.getValue());
                }
                break;
            default:
                System.out.println("Nunca debería chegar a aquí");
        }

        if (!error) {
            if (fa.pagarBeneficios(pb)) {
                JOptionPane.showMessageDialog(null, "Beneficios pagados correctamente.");

                this.dispose();
            }
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void boxPreferenciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxPreferenciaItemStateChanged
        actualizarVisibilidad();
    }//GEN-LAST:event_boxPreferenciaItemStateChanged

    private void textoImportePartKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoImportePartKeyReleased
        try {
            if (!textoImportePart.getText().isEmpty()) {
                Float.parseFloat(textoImportePart.getText());
            }
            btnAnunciar.setEnabled(true);
            btnPagar.setEnabled(true);
        } catch (NumberFormatException e) {
            btnAnunciar.setEnabled(false);
            btnPagar.setEnabled(false);
        }
    }//GEN-LAST:event_textoImportePartKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxPreferencia;
    private javax.swing.JButton btnAnunciar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JSpinner cantidadSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelImporte;
    private com.toedter.calendar.JDateChooser selectorFecha;
    private javax.swing.JTextField textoImportePart;
    // End of variables declaration//GEN-END:variables

    private void actualizarVisibilidad() {
        switch (boxPreferencia.getSelectedIndex()) {
            case 0: // Solo saldo
                cantidadSpinner.setEnabled(false);
                textoImportePart.setEnabled(true);
                break;
            case 1: // Solo participaciones
                cantidadSpinner.setEnabled(true);
                textoImportePart.setEnabled(false);
                break;
            case 2: // Ambos
                cantidadSpinner.setEnabled(true);
                textoImportePart.setEnabled(true);
                break;
            default:
                System.out.println("Nunca debería chegar a aquí");
        }
    }

}
