package gui;

import aplicacion.Usuario;
import aplicacion.Empresa;
import aplicacion.Inversor;
import aplicacion.Regulador;

public class VAutentificacion extends javax.swing.JFrame {

    private final aplicacion.FachadaAplicacion fa;

    public VAutentificacion(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        initComponents();
        etiquetaFallo.setVisible(false);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textoUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textoClave = new javax.swing.JPasswordField();
        etiquetaFallo = new javax.swing.JLabel();
        btnPrerregistro = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autentificación de usuarios");
        setResizable(false);

        jLabel1.setText("Usuario:");

        textoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoUsuarioKeyPressed(evt);
            }
        });

        jLabel2.setText("Contraseña:");

        textoClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoClaveKeyPressed(evt);
            }
        });

        etiquetaFallo.setForeground(new java.awt.Color(255, 51, 51));
        etiquetaFallo.setText("Autentificación incorrecta");

        btnPrerregistro.setText("Solicitar registro");
        btnPrerregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrerregistroActionPerformed(evt);
            }
        });

        btnCancelar.setText("Salir");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoUsuario)
                            .addComponent(textoClave)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(etiquetaFallo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPrerregistro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etiquetaFallo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar)
                    .addComponent(btnPrerregistro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrerregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrerregistroActionPerformed
        fa.iniciarPrerregistro();
    }//GEN-LAST:event_btnPrerregistroActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        iniciarSesion();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void textoUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoUsuarioKeyPressed
        if (evt.getKeyChar() == '\n') {
            iniciarSesion();
        }
    }//GEN-LAST:event_textoUsuarioKeyPressed

    private void textoClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoClaveKeyPressed
        if (evt.getKeyChar() == '\n') {
            iniciarSesion();
        }
    }//GEN-LAST:event_textoClaveKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPrerregistro;
    private javax.swing.JLabel etiquetaFallo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField textoClave;
    private javax.swing.JTextField textoUsuario;
    // End of variables declaration//GEN-END:variables

    private void iniciarSesion() {
        etiquetaFallo.setVisible(false);
        Usuario u = fa.comprobarAutentificacion(textoUsuario.getText(), textoClave.getText());

        if (u != null) {
            switch (u.getTipo().name()) {
                case "Empresa":
                    fa.iniciarUsuarioNormal((Empresa) u);
                    break;
                case "Inversor":
                    fa.iniciarUsuarioNormal((Inversor) u);
                    break;
                case "Regulador":
                    fa.iniciarRegulador((Regulador) u);
                    break;
            }

            this.dispose();
        } else {
            etiquetaFallo.setVisible(true);
        }
    }

}
