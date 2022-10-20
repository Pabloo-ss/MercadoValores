package gui;

import aplicacion.Prerregistro;
import aplicacion.Inversor;
import aplicacion.Empresa;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

public class VPrerregistro extends javax.swing.JDialog {

    private final aplicacion.FachadaAplicacion fa;

    public VPrerregistro(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa) {
        super(parent, modal);
        this.fa = fa;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TipoBox = new javax.swing.JComboBox();
        solicitar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        Clave = new javax.swing.JLabel();
        Tipo = new javax.swing.JLabel();
        Teléfono = new javax.swing.JLabel();
        telefonoText = new javax.swing.JTextField();
        Direccion = new javax.swing.JLabel();
        direccionText = new javax.swing.JTextField();
        Nombre = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        Apellido_1 = new javax.swing.JLabel();
        ap1text = new javax.swing.JTextField();
        Apellido_2 = new javax.swing.JLabel();
        ap2text = new javax.swing.JTextField();
        DNI = new javax.swing.JLabel();
        dniText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        IDText = new javax.swing.JTextField();
        claveText = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Solicitud de registro");

        TipoBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inversor", "Empresa" }));
        TipoBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TipoBoxItemStateChanged(evt);
            }
        });

        solicitar.setText("Solicitar");
        solicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitarActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        Clave.setText("Clave:");

        Tipo.setText("Tipo:");

        Teléfono.setText("Teléfono:");

        telefonoText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoTextKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telefonoTextKeyReleased(evt);
            }
        });

        Direccion.setText("Dirección:");

        direccionText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                direccionTextKeyTyped(evt);
            }
        });

        Nombre.setText("Nombre:");

        nombreText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreTextKeyTyped(evt);
            }
        });

        Apellido_1.setText("1er apellido:");

        ap1text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ap1textKeyTyped(evt);
            }
        });

        Apellido_2.setText("2º apellido:");

        ap2text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ap2textKeyTyped(evt);
            }
        });

        DNI.setText("DNI:");

        dniText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dniTextKeyTyped(evt);
            }
        });

        jLabel1.setText("ID:");

        IDText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IDTextKeyTyped(evt);
            }
        });

        claveText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                claveTextKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(solicitar)
                        .addGap(33, 33, 33)
                        .addComponent(salir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(IDText, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 8, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(dniText, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Nombre)
                                            .addComponent(Direccion)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DNI)
                                            .addComponent(Teléfono))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telefonoText)
                                    .addComponent(nombreText, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(direccionText))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Clave)
                                .addGap(18, 18, 18)
                                .addComponent(claveText, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(Apellido_1)
                                .addGap(18, 18, 18)
                                .addComponent(ap1text))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(Tipo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(Apellido_2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ap2text, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clave)
                    .addComponent(jLabel1)
                    .addComponent(IDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(claveText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Apellido_1)
                    .addComponent(ap1text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Direccion)
                    .addComponent(direccionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Apellido_2)
                    .addComponent(ap2text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Teléfono)
                    .addComponent(telefonoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tipo)
                    .addComponent(TipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DNI)
                    .addComponent(dniText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salir)
                    .addComponent(solicitar))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void solicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solicitarActionPerformed
        Prerregistro reg = null;
        Boolean error = false;

        if (IDText.getText().isEmpty() || claveText.getText().isEmpty()
                || nombreText.getText().isEmpty() || dniText.getText().isEmpty()) {
            fa.muestraExcepcion("Los campos ID, clave, nombre y número de identificación\nno pueden estar vacíos");
        } else {
            if (TipoBox.getItemAt(TipoBox.getSelectedIndex()).equals("Inversor")) {
                if (ap1text.getText().isEmpty()) {
                    fa.muestraExcepcion("Debe introducirse el primer apellido del inversor");
                    error = true;
                } else {
                    Inversor inv = new Inversor(IDText.getText(),
                            claveText.getText(),
                            0,
                            dniText.getText(),
                            nombreText.getText(),
                            ap1text.getText(),
                            ap2text.getText(),
                            direccionText.getText(),
                            telefonoText.getText());

                    reg = new Prerregistro(inv,
                            (String) TipoBox.getItemAt(TipoBox.getSelectedIndex()),
                            new Timestamp(java.lang.System.currentTimeMillis()));
                }
            } else if (TipoBox.getItemAt(TipoBox.getSelectedIndex()).equals("Empresa")) {
                Empresa emp = new Empresa(IDText.getText(),
                        claveText.getText(),
                        0,
                        dniText.getText(),
                        nombreText.getText(),
                        direccionText.getText(),
                        telefonoText.getText(),
                        0,
                        0);

                reg = new Prerregistro(emp,
                        (String) TipoBox.getItemAt(TipoBox.getSelectedIndex()),
                        new Timestamp(java.lang.System.currentTimeMillis()));
            }

            if (!error) {
                if (fa.insertarPrerregistro(reg)) {
                    JOptionPane.showMessageDialog(null, "Registro solicitado correctamente.");
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_solicitarActionPerformed

    private void TipoBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TipoBoxItemStateChanged
        if (TipoBox.getSelectedIndex() == 0) {
            Apellido_1.setVisible(true);
            Apellido_2.setVisible(true);
            ap1text.setVisible(true);
            ap2text.setVisible(true);
            DNI.setText("DNI:");
        } else if (TipoBox.getSelectedIndex() == 1) {
            Apellido_1.setVisible(false);
            Apellido_2.setVisible(false);
            ap1text.setVisible(false);
            ap2text.setVisible(false);
            DNI.setText("CIF:");
        }
    }//GEN-LAST:event_TipoBoxItemStateChanged

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void IDTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDTextKeyTyped
        if (IDText.getText().length() == 10)
            evt.consume();
    }//GEN-LAST:event_IDTextKeyTyped

    private void claveTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_claveTextKeyTyped
        if (claveText.getText().length() == 30)
            evt.consume();
    }//GEN-LAST:event_claveTextKeyTyped

    private void nombreTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreTextKeyTyped
        if (nombreText.getText().length() == 20)
            evt.consume();
    }//GEN-LAST:event_nombreTextKeyTyped

    private void ap1textKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ap1textKeyTyped
        if (ap1text.getText().length() == 15)
            evt.consume();
    }//GEN-LAST:event_ap1textKeyTyped

    private void ap2textKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ap2textKeyTyped
        if (ap2text.getText().length() == 15)
            evt.consume();
    }//GEN-LAST:event_ap2textKeyTyped

    private void direccionTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionTextKeyTyped
        if (direccionText.getText().length() == 40)
            evt.consume();
    }//GEN-LAST:event_direccionTextKeyTyped

    private void telefonoTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoTextKeyTyped
        if (telefonoText.getText().length() == 10)
            evt.consume();
    }//GEN-LAST:event_telefonoTextKeyTyped

    private void dniTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dniTextKeyTyped
        if (dniText.getText().length() == 9)
            evt.consume();
    }//GEN-LAST:event_dniTextKeyTyped

    private void telefonoTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoTextKeyReleased
        try {
            if (!telefonoText.getText().isEmpty()) {
                Long.parseLong(telefonoText.getText());
            }
            solicitar.setEnabled(true);
        } catch (NumberFormatException e) {
            solicitar.setEnabled(false);
        }
    }//GEN-LAST:event_telefonoTextKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Apellido_1;
    private javax.swing.JLabel Apellido_2;
    private javax.swing.JLabel Clave;
    private javax.swing.JLabel DNI;
    private javax.swing.JLabel Direccion;
    private javax.swing.JTextField IDText;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Teléfono;
    private javax.swing.JLabel Tipo;
    private javax.swing.JComboBox TipoBox;
    private javax.swing.JTextField ap1text;
    private javax.swing.JTextField ap2text;
    private javax.swing.JPasswordField claveText;
    private javax.swing.JTextField direccionText;
    private javax.swing.JTextField dniText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nombreText;
    private javax.swing.JButton salir;
    private javax.swing.JButton solicitar;
    private javax.swing.JTextField telefonoText;
    // End of variables declaration//GEN-END:variables
}
