package gui;

import aplicacion.*;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class VRegulador extends javax.swing.JFrame {

    private final aplicacion.FachadaAplicacion fa;
    private Regulador uConect;
    private String idAntigua;

    public VRegulador(aplicacion.FachadaAplicacion fa, Regulador r) {
        this.fa = fa;
        this.uConect = r;
        initComponents();
        actualizarPanelCuenta();
        actualizarPanelSaldos();
        actualizarPanelPrerregistros();
        actualizarPanelBajas();
        actualizarBotonesBajas();
        actualizarPanelPagos();
        labelUsuarioConectado.setText("Usuario conectado: " + uConect.getId());

        // Centrado de texto en tablas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tablaSaldos.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablaSaldos.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tablaSaldos.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        tablaPrerregistros.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablaPrerregistros.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tablaPrerregistros.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        tablaBajas.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablaBajas.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tablaBajas.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tablaBajas.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        tablaPagos.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablaPagos.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tablaPagos.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tablaPagos.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelCuenta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textoCambiarID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textoCambiarClave = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        textoCambiarSaldo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textoCambiarComision = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textoCambiarInteres = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnGuardarCuenta = new javax.swing.JButton();
        panelSaldos = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        textoBuscarIDSaldos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSaldos = new javax.swing.JTable();
        btnGuardarSaldos = new javax.swing.JButton();
        buscarSaldos = new javax.swing.JButton();
        panelPrerreg = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaPrerregistros = new javax.swing.JTable();
        labelDNIoCIF = new javax.swing.JLabel();
        textoDNIoCIF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textoDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textoTelefono = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        btnConfirmarRegistro = new javax.swing.JButton();
        btnRechazarRegistro = new javax.swing.JButton();
        panelBajas = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaBajas = new javax.swing.JTable();
        btnConfirmarBaja = new javax.swing.JButton();
        btnRechazarBaja = new javax.swing.JButton();
        panelPagos = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        textoBuscarIDPagos = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPagos = new javax.swing.JTable();
        btnDarBajaAnuncio = new javax.swing.JButton();
        buscarPagos = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        labelUsuarioConectado = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Regulador");

        jLabel1.setText("ID:");

        textoCambiarID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoCambiarIDKeyTyped(evt);
            }
        });

        jLabel2.setText("Clave:");

        textoCambiarClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoCambiarClaveKeyTyped(evt);
            }
        });

        jLabel3.setText("Saldo disponible:");

        textoCambiarSaldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoCambiarSaldoKeyReleased(evt);
            }
        });

        jLabel4.setText("€");

        jLabel5.setText("Comisión de compraventa:");

        textoCambiarComision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoCambiarComisionKeyReleased(evt);
            }
        });

        jLabel6.setText("%");

        jLabel7.setText("Interés de stacking:");

        textoCambiarInteres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoCambiarInteresKeyReleased(evt);
            }
        });

        jLabel8.setText("%");

        btnGuardarCuenta.setText("Guardar cambios");
        btnGuardarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCuentaLayout = new javax.swing.GroupLayout(panelCuenta);
        panelCuenta.setLayout(panelCuentaLayout);
        panelCuentaLayout.setHorizontalGroup(
            panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(textoCambiarID, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(jLabel2))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(textoCambiarSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(btnGuardarCuenta)
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCuentaLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(textoCambiarInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addGroup(panelCuentaLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(textoCambiarComision, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addComponent(textoCambiarClave, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCuentaLayout.setVerticalGroup(
            panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuentaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoCambiarID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(textoCambiarClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textoCambiarSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textoCambiarComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textoCambiarInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(35, 35, 35)
                .addComponent(btnGuardarCuenta)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cuenta", panelCuenta);

        jLabel9.setText("Buscar por ID de usuario: ");

        tablaSaldos.setModel(new gui.ModeloTablaRegSaldos());
        jScrollPane1.setViewportView(tablaSaldos);

        btnGuardarSaldos.setText("Guardar cambios");
        btnGuardarSaldos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarSaldosActionPerformed(evt);
            }
        });

        buscarSaldos.setText("Buscar");
        buscarSaldos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarSaldosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSaldosLayout = new javax.swing.GroupLayout(panelSaldos);
        panelSaldos.setLayout(panelSaldosLayout);
        panelSaldosLayout.setHorizontalGroup(
            panelSaldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSaldosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSaldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addGroup(panelSaldosLayout.createSequentialGroup()
                        .addComponent(btnGuardarSaldos)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelSaldosLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoBuscarIDSaldos, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscarSaldos)))
                .addContainerGap())
        );
        panelSaldosLayout.setVerticalGroup(
            panelSaldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSaldosLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelSaldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textoBuscarIDSaldos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarSaldos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnGuardarSaldos))
        );

        jTabbedPane1.addTab("Saldos", panelSaldos);

        tablaPrerregistros.setModel(new ModeloTablaRegPrerregistros());
        tablaPrerregistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPrerregistrosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaPrerregistros);

        labelDNIoCIF.setText("DNI:");

        textoDNIoCIF.setEditable(false);

        jLabel11.setText("Dirección:");

        textoDireccion.setEditable(false);

        jLabel12.setText("Teléfono:");

        textoTelefono.setEditable(false);

        jLabel13.setText("Nombre:");

        textoNombre.setEditable(false);
        textoNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnConfirmarRegistro.setText("Confirmar registro");
        btnConfirmarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarRegistroActionPerformed(evt);
            }
        });

        btnRechazarRegistro.setText("Rechazar registro");
        btnRechazarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazarRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrerregLayout = new javax.swing.GroupLayout(panelPrerreg);
        panelPrerreg.setLayout(panelPrerregLayout);
        panelPrerregLayout.setHorizontalGroup(
            panelPrerregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrerregLayout.createSequentialGroup()
                .addGroup(panelPrerregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(panelPrerregLayout.createSequentialGroup()
                        .addGroup(panelPrerregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrerregLayout.createSequentialGroup()
                                .addComponent(labelDNIoCIF)
                                .addGap(18, 18, 18)
                                .addComponent(textoDNIoCIF, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel13))
                            .addGroup(panelPrerregLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(textoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelPrerregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrerregLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(textoTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                            .addComponent(textoNombre)))
                    .addGroup(panelPrerregLayout.createSequentialGroup()
                        .addComponent(btnConfirmarRegistro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRechazarRegistro)))
                .addContainerGap())
        );
        panelPrerregLayout.setVerticalGroup(
            panelPrerregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrerregLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelPrerregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDNIoCIF)
                    .addComponent(textoDNIoCIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrerregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(panelPrerregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRechazarRegistro)
                    .addComponent(btnConfirmarRegistro))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Prerregistros", panelPrerreg);

        tablaBajas.setModel(new ModeloTablaRegBajas());
        tablaBajas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBajasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaBajas);

        btnConfirmarBaja.setText("Confirmar baja");
        btnConfirmarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarBajaActionPerformed(evt);
            }
        });

        btnRechazarBaja.setText("Rechazar baja");
        btnRechazarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazarBajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBajasLayout = new javax.swing.GroupLayout(panelBajas);
        panelBajas.setLayout(panelBajasLayout);
        panelBajasLayout.setHorizontalGroup(
            panelBajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBajasLayout.createSequentialGroup()
                .addGroup(panelBajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                    .addGroup(panelBajasLayout.createSequentialGroup()
                        .addComponent(btnConfirmarBaja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRechazarBaja)))
                .addContainerGap())
        );
        panelBajasLayout.setVerticalGroup(
            panelBajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBajasLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelBajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmarBaja)
                    .addComponent(btnRechazarBaja)))
        );

        jTabbedPane1.addTab("Bajas", panelBajas);

        jLabel10.setText("Buscar por ID de usuario:");

        tablaPagos.setModel(new gui.ModeloTablaPagos());
        jScrollPane2.setViewportView(tablaPagos);

        btnDarBajaAnuncio.setText("Dar de baja anuncio");
        btnDarBajaAnuncio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarBajaAnuncioActionPerformed(evt);
            }
        });

        buscarPagos.setText("Buscar");
        buscarPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPagosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPagosLayout = new javax.swing.GroupLayout(panelPagos);
        panelPagos.setLayout(panelPagosLayout);
        panelPagosLayout.setHorizontalGroup(
            panelPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPagosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addGroup(panelPagosLayout.createSequentialGroup()
                        .addComponent(btnDarBajaAnuncio)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelPagosLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(textoBuscarIDPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscarPagos)))
                .addContainerGap())
        );
        panelPagosLayout.setVerticalGroup(
            panelPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPagosLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textoBuscarIDPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarPagos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnDarBajaAnuncio))
        );

        jTabbedPane1.addTab("Pagos", panelPagos);

        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        labelUsuarioConectado.setForeground(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelUsuarioConectado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrarSesion)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrarSesion)
                    .addComponent(labelUsuarioConectado))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        fa.cerrarSesion();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnGuardarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCuentaActionPerformed
        Regulador r = new Regulador(textoCambiarID.getText(),
                textoCambiarClave.getText(),
                Float.parseFloat(textoCambiarSaldo.getText()),
                Float.parseFloat(textoCambiarComision.getText()),
                Float.parseFloat(textoCambiarInteres.getText()));
        if (r.getComisionCompraventa() > 50 || r.getInteresStacking() > 50) {
            fa.muestraExcepcion("Os porcentaxes deben ter un valor inferior ao 50%");
        } else {
            fa.actualizarDatosUsuario(r, idAntigua);
            uConect = r;
            idAntigua = uConect.getId();
        }

        JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.");

        labelUsuarioConectado.setText("Usuario conectado: " + uConect.getId());
        actualizarPanelCuenta();
        actualizarPanelSaldos();
        actualizarPanelPrerregistros();
        actualizarPanelBajas();
        actualizarBotonesBajas();
        actualizarPanelPagos();
    }//GEN-LAST:event_btnGuardarCuentaActionPerformed

    private void btnGuardarSaldosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarSaldosActionPerformed
        ModeloTablaRegSaldos m = (ModeloTablaRegSaldos) tablaSaldos.getModel();

        for (Usuario u : m.getFilas()) {
            fa.actualizarSaldo(u, u.getSaldoDisponible());
            if (u instanceof Regulador) {
                textoCambiarSaldo.setText(Float.toString(u.getSaldoDisponible()));
            }
        }

        JOptionPane.showMessageDialog(null, "Saldos actualizados correctamente.");

        actualizarPanelSaldos();
        actualizarPanelPrerregistros();
        actualizarPanelBajas();
        actualizarBotonesBajas();
        actualizarPanelPagos();
    }//GEN-LAST:event_btnGuardarSaldosActionPerformed

    private void btnConfirmarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarRegistroActionPerformed
        ModeloTablaRegPrerregistros m = (ModeloTablaRegPrerregistros) tablaPrerregistros.getModel();

        fa.confirmarPrerregistro(m.obtenerPrerregistro(tablaPrerregistros.getSelectedRow()));

        JOptionPane.showMessageDialog(null, "Prerregistro confirmado correctamente.");

        actualizarPanelCuenta();
        actualizarPanelSaldos();
        actualizarPanelPrerregistros();
        actualizarPanelBajas();
        actualizarBotonesBajas();
        actualizarPanelPagos();
    }//GEN-LAST:event_btnConfirmarRegistroActionPerformed

    private void btnRechazarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazarRegistroActionPerformed
        ModeloTablaRegPrerregistros m = (ModeloTablaRegPrerregistros) tablaPrerregistros.getModel();

        fa.rechazarPrerregistro(m.obtenerPrerregistro(tablaPrerregistros.getSelectedRow()));

        JOptionPane.showMessageDialog(null, "Prerregistro rechazado correctamente.");

        actualizarPanelCuenta();
        actualizarPanelSaldos();
        actualizarPanelPrerregistros();
        actualizarPanelBajas();
        actualizarBotonesBajas();
        actualizarPanelPagos();
    }//GEN-LAST:event_btnRechazarRegistroActionPerformed

    private void btnConfirmarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarBajaActionPerformed
        ModeloTablaRegBajas m = (ModeloTablaRegBajas) tablaBajas.getModel();

        fa.confirmarBaja(m.obtenerBaja(tablaBajas.getSelectedRow()));

        JOptionPane.showMessageDialog(null, "Baja confirmada correctamente.");

        actualizarPanelCuenta();
        actualizarPanelSaldos();
        actualizarPanelPrerregistros();
        actualizarPanelBajas();
        actualizarBotonesBajas();
        actualizarPanelPagos();
    }//GEN-LAST:event_btnConfirmarBajaActionPerformed

    private void btnRechazarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazarBajaActionPerformed
        ModeloTablaRegBajas m = (ModeloTablaRegBajas) tablaBajas.getModel();

        fa.rechazarBaja(m.obtenerBaja(tablaBajas.getSelectedRow()));

        JOptionPane.showMessageDialog(null, "Baja rechazada correctamente.");

        actualizarPanelCuenta();
        actualizarPanelSaldos();
        actualizarPanelPrerregistros();
        actualizarPanelBajas();
        actualizarBotonesBajas();
        actualizarPanelPagos();
    }//GEN-LAST:event_btnRechazarBajaActionPerformed

    private void btnDarBajaAnuncioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarBajaAnuncioActionPerformed
        ModeloTablaPagos m = (ModeloTablaPagos) tablaPagos.getModel();

        fa.darBajaAnuncio(m.obtenerPagoBeneficios(tablaPagos.getSelectedRow()));

        JOptionPane.showMessageDialog(null, "Anuncio dado de baja correctamente.");

        actualizarPanelCuenta();
        actualizarPanelSaldos();
        actualizarPanelPrerregistros();
        actualizarPanelBajas();
        actualizarBotonesBajas();
        actualizarPanelPagos();
    }//GEN-LAST:event_btnDarBajaAnuncioActionPerformed

    private void buscarSaldosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarSaldosActionPerformed
        ModeloTablaRegSaldos m = (ModeloTablaRegSaldos) tablaSaldos.getModel();

        m.setFilas(fa.buscarUsuarios(textoBuscarIDSaldos.getText()));

        actualizarPanelCuenta();
        actualizarPanelSaldos();
        actualizarPanelPrerregistros();
        actualizarPanelBajas();
        actualizarBotonesBajas();
        actualizarPanelPagos();
    }//GEN-LAST:event_buscarSaldosActionPerformed

    private void buscarPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPagosActionPerformed
        ModeloTablaPagos m = (ModeloTablaPagos) tablaPagos.getModel();

        m.setFilas(fa.buscarAnunciosPagoBeneficios(textoBuscarIDPagos.getText()));

        actualizarPanelCuenta();
        actualizarPanelSaldos();
        actualizarPanelPrerregistros();
        actualizarPanelBajas();
        actualizarBotonesBajas();
        actualizarPanelPagos();
    }//GEN-LAST:event_buscarPagosActionPerformed

    private void tablaPrerregistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPrerregistrosMouseClicked
        actualizarCamposPrerregistros();
    }//GEN-LAST:event_tablaPrerregistrosMouseClicked

    private void tablaBajasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBajasMouseClicked
        actualizarBotonesBajas();
    }//GEN-LAST:event_tablaBajasMouseClicked

    private void textoCambiarIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoCambiarIDKeyTyped
        if (textoCambiarID.getText().length() == 10)
            evt.consume();
    }//GEN-LAST:event_textoCambiarIDKeyTyped

    private void textoCambiarClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoCambiarClaveKeyTyped
        if (textoCambiarClave.getText().length() == 30)
            evt.consume();
    }//GEN-LAST:event_textoCambiarClaveKeyTyped

    private void textoCambiarSaldoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoCambiarSaldoKeyReleased
        try {
            if (!textoCambiarSaldo.getText().isEmpty()) {
                Float.parseFloat(textoCambiarSaldo.getText());
            }
            btnGuardarCuenta.setEnabled(true);
        } catch (NumberFormatException e) {
            btnGuardarCuenta.setEnabled(false);
        }
    }//GEN-LAST:event_textoCambiarSaldoKeyReleased

    private void textoCambiarComisionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoCambiarComisionKeyReleased
        try {
            if (!textoCambiarComision.getText().isEmpty()) {
                Float.parseFloat(textoCambiarComision.getText());
            }
            btnGuardarCuenta.setEnabled(true);
        } catch (NumberFormatException e) {
            btnGuardarCuenta.setEnabled(false);
        }
    }//GEN-LAST:event_textoCambiarComisionKeyReleased

    private void textoCambiarInteresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoCambiarInteresKeyReleased
        try {
            if (!textoCambiarInteres.getText().isEmpty()) {
                Float.parseFloat(textoCambiarInteres.getText());
            }
            btnGuardarCuenta.setEnabled(true);
        } catch (NumberFormatException e) {
            btnGuardarCuenta.setEnabled(false);
        }
    }//GEN-LAST:event_textoCambiarInteresKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnConfirmarBaja;
    private javax.swing.JButton btnConfirmarRegistro;
    private javax.swing.JButton btnDarBajaAnuncio;
    private javax.swing.JButton btnGuardarCuenta;
    private javax.swing.JButton btnGuardarSaldos;
    private javax.swing.JButton btnRechazarBaja;
    private javax.swing.JButton btnRechazarRegistro;
    private javax.swing.JButton buscarPagos;
    private javax.swing.JButton buscarSaldos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelDNIoCIF;
    private javax.swing.JLabel labelUsuarioConectado;
    private javax.swing.JPanel panelBajas;
    private javax.swing.JPanel panelCuenta;
    private javax.swing.JPanel panelPagos;
    private javax.swing.JPanel panelPrerreg;
    private javax.swing.JPanel panelSaldos;
    private javax.swing.JTable tablaBajas;
    private javax.swing.JTable tablaPagos;
    private javax.swing.JTable tablaPrerregistros;
    private javax.swing.JTable tablaSaldos;
    private javax.swing.JTextField textoBuscarIDPagos;
    private javax.swing.JTextField textoBuscarIDSaldos;
    private javax.swing.JPasswordField textoCambiarClave;
    private javax.swing.JTextField textoCambiarComision;
    private javax.swing.JTextField textoCambiarID;
    private javax.swing.JTextField textoCambiarInteres;
    private javax.swing.JTextField textoCambiarSaldo;
    private javax.swing.JTextField textoDNIoCIF;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoTelefono;
    // End of variables declaration//GEN-END:variables

    private void actualizarPanelCuenta() {
        textoCambiarID.setText(uConect.getId());
        textoCambiarClave.setText(uConect.getClave());
        textoCambiarSaldo.setText(Float.toString(uConect.getSaldoDisponible()));
        textoCambiarComision.setText(Float.toString(uConect.getComisionCompraventa()));
        textoCambiarInteres.setText(Float.toString(uConect.getInteresStacking()));

        idAntigua = uConect.getId();
    }

    private void actualizarPanelSaldos() {
        ModeloTablaRegSaldos m = (ModeloTablaRegSaldos) tablaSaldos.getModel();

        m.setFilas(fa.buscarUsuarios(textoBuscarIDSaldos.getText()));

        if (m.getRowCount() > 0) {
            tablaSaldos.setRowSelectionInterval(0, 0);
            btnGuardarSaldos.setEnabled(true);
        } else {
            btnGuardarSaldos.setEnabled(false);
        }
    }

    private void actualizarPanelPrerregistros() {
        ModeloTablaRegPrerregistros m = (ModeloTablaRegPrerregistros) tablaPrerregistros.getModel();

        m.setFilas(fa.obtenerSolicitudesPrerregistros());

        if (m.getRowCount() > 0) {
            tablaPrerregistros.setRowSelectionInterval(0, 0);
            btnConfirmarRegistro.setEnabled(true);
            btnRechazarRegistro.setEnabled(true);
        } else {
            btnConfirmarRegistro.setEnabled(false);
            btnRechazarRegistro.setEnabled(false);
        }

        actualizarCamposPrerregistros();
    }

    private void actualizarCamposPrerregistros() {
        ModeloTablaRegPrerregistros m = (ModeloTablaRegPrerregistros) tablaPrerregistros.getModel();
        Prerregistro p;

        if (m.getRowCount() > 0) {
            p = m.obtenerPrerregistro(tablaPrerregistros.getSelectedRow());
            btnConfirmarRegistro.setEnabled(true);
            btnRechazarRegistro.setEnabled(true);

            if (p.getUsuario() instanceof Inversor) {
                Inversor i = (Inversor) p.getUsuario();
                labelDNIoCIF.setText("DNI");
                textoDNIoCIF.setText(i.getDni());
                textoNombre.setText(i.getNombre() + " " + i.getApellido1());
                if (!i.getApellido2().equals("null")) {
                    textoNombre.setText(textoNombre.getText() + " " + i.getApellido2());
                }
                textoDireccion.setText(i.getDireccion());
                textoTelefono.setText(i.getTelefono());
            } else if (p.getUsuario() instanceof Empresa) {
                Empresa e = (Empresa) p.getUsuario();
                labelDNIoCIF.setText("CIF");
                textoDNIoCIF.setText(e.getCif());
                textoNombre.setText(e.getNombre());
                textoDireccion.setText(e.getDireccion());
                textoTelefono.setText(e.getTelefono());
            } else {
                System.out.println("Nunca debería chegar a aquí");
            }

        } else {
            btnConfirmarRegistro.setEnabled(false);
            btnRechazarRegistro.setEnabled(false);
            textoDNIoCIF.setText("");
            textoNombre.setText("");
            textoDireccion.setText("");
            textoTelefono.setText("");
        }
    }

    private void actualizarPanelBajas() {
        ModeloTablaRegBajas m = (ModeloTablaRegBajas) tablaBajas.getModel();

        m.setFilas(fa.obtenerSolicitudesBaja());

        if (m.getRowCount() > 0) {
            tablaBajas.setRowSelectionInterval(0, 0);
        }
    }

    private void actualizarBotonesBajas() {
        ModeloTablaRegBajas m = (ModeloTablaRegBajas) tablaBajas.getModel();
        Baja b;

        if (m.getRowCount() > 0) {
            b = m.obtenerBaja(tablaBajas.getSelectedRow());

            if (b.getNumPart() > 0 || b.getUsuario().getSaldoDisponible() > 0) {
                btnConfirmarBaja.setEnabled(false);
            } else {
                btnConfirmarBaja.setEnabled(true);
            }
            btnRechazarBaja.setEnabled(true);
        } else {
            btnConfirmarBaja.setEnabled(false);
            btnRechazarBaja.setEnabled(false);
        }
    }

    private void actualizarPanelPagos() {
        ModeloTablaPagos m = (ModeloTablaPagos) tablaPagos.getModel();

        m.setFilas(fa.buscarAnunciosPagoBeneficios(textoBuscarIDPagos.getText()));

        if (m.getRowCount() > 0) {
            tablaPagos.setRowSelectionInterval(0, 0);
            btnDarBajaAnuncio.setEnabled(true);
        } else {
            btnDarBajaAnuncio.setEnabled(false);
        }
    }

}
