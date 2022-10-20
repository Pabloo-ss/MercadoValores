package gui;

import aplicacion.Usuario;
import aplicacion.Participaciones;
import aplicacion.Empresa;
import aplicacion.Inversor;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class VPrincipal extends javax.swing.JFrame {

    private final aplicacion.FachadaAplicacion fa;
    private Usuario uConect;
    private String idAntigua;

    public VPrincipal(aplicacion.FachadaAplicacion fa, Usuario u) {
        this.fa = fa;
        this.uConect = u;
        this.idAntigua = u.getId();
        initComponents();
        actualizarDatosYVisibilidad();
        actualizarParticipaciones();
        actualizarComision();
        labelUsuarioConectado.setText("Usuario conectado: " + uConect.getId());
        etiquetaBaja.setVisible(false);

        // Centrado de texto en tablas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tablaPart.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablaPart.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tablaPart.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tablaPart.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPart = new javax.swing.JTable();
        bntVerMercado = new javax.swing.JButton();
        bnStacking = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textoEmpresa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textoPrecio = new javax.swing.JTextField();
        btnVender = new javax.swing.JButton();
        btnDarBajaVenta = new javax.swing.JButton();
        cantidadlabel = new javax.swing.JLabel();
        daralta = new javax.swing.JButton();
        darbaja = new javax.swing.JButton();
        numeroSpinner = new javax.swing.JSpinner();
        cantidadSpinner = new javax.swing.JSpinner();
        btnFuturos = new javax.swing.JButton();
        comisionLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        DNIlabel = new javax.swing.JLabel();
        textoDNI = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        ap1label = new javax.swing.JLabel();
        textoAp1 = new javax.swing.JTextField();
        ap2label = new javax.swing.JLabel();
        textoAp2 = new javax.swing.JTextField();
        IDlabel = new javax.swing.JLabel();
        textoID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textoTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textoDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        boxTipo = new javax.swing.JTextField();
        btnSolicitarBaja = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        textoClave = new javax.swing.JPasswordField();
        SaldoLabel = new javax.swing.JLabel();
        textoSaldoDisp = new javax.swing.JTextField();
        saldobloqlabel = new javax.swing.JLabel();
        textoSaldoBloq = new javax.swing.JTextField();
        partbloqlabel = new javax.swing.JLabel();
        textoPartBloq = new javax.swing.JTextField();
        etiquetaBaja = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        labelUsuarioConectado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menú principal");

        jLabel11.setText("Cartera de participaciones:");

        tablaPart.setModel(new gui.ModeloTablaCarteraParticipaciones());
        tablaPart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPartMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPart);

        bntVerMercado.setText("Mercado");
        bntVerMercado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVerMercadoActionPerformed(evt);
            }
        });

        bnStacking.setText("Stacking");
        bnStacking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnStackingActionPerformed(evt);
            }
        });

        jLabel1.setText("Empresa:");

        textoEmpresa.setEditable(false);

        jLabel3.setText("Cantidad:");

        jLabel4.setText("Precio:");

        textoPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoPrecioKeyReleased(evt);
            }
        });

        btnVender.setText("Vender");
        btnVender.setEnabled(false);
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        btnDarBajaVenta.setText("Retirar del mercado");
        btnDarBajaVenta.setEnabled(false);
        btnDarBajaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarBajaVentaActionPerformed(evt);
            }
        });

        cantidadlabel.setText("Cantidad:");

        daralta.setText("Dar de alta");
        daralta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daraltaActionPerformed(evt);
            }
        });

        darbaja.setText("Dar de baja");
        darbaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darbajaActionPerformed(evt);
            }
        });

        numeroSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        cantidadSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        btnFuturos.setText("Futuros");
        btnFuturos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuturosActionPerformed(evt);
            }
        });

        comisionLabel.setForeground(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(numeroSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoPrecio))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnVender)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDarBajaVenta))
                                    .addComponent(comisionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 21, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(cantidadlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cantidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(daralta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(darbaja)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bntVerMercado)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFuturos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bnStacking)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(textoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(numeroSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comisionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVender)
                            .addComponent(btnDarBajaVenta))
                        .addGap(31, 31, 31)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadlabel)
                    .addComponent(cantidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntVerMercado)
                    .addComponent(bnStacking)
                    .addComponent(daralta)
                    .addComponent(darbaja)
                    .addComponent(btnFuturos))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Operaciones", jPanel2);

        DNIlabel.setText("DNI:");

        textoDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoDNIKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombre:");

        textoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoNombreKeyTyped(evt);
            }
        });

        ap1label.setText("Apellido 1:");

        textoAp1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoAp1KeyTyped(evt);
            }
        });

        ap2label.setText("Apellido 2:");

        textoAp2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoAp2KeyTyped(evt);
            }
        });

        IDlabel.setText("ID:");

        textoID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoIDKeyTyped(evt);
            }
        });

        jLabel6.setText("Clave:");

        jLabel7.setText("Teléfono:");

        textoTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoTelefonoKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoTelefonoKeyReleased(evt);
            }
        });

        jLabel8.setText("Dirección:");

        textoDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoDireccionKeyTyped(evt);
            }
        });

        jLabel9.setText("Tipo:");

        boxTipo.setEditable(false);

        btnSolicitarBaja.setText("Solicitar baja");
        btnSolicitarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarBajaActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        textoClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoClaveKeyTyped(evt);
            }
        });

        SaldoLabel.setText("Saldo disp.:");

        textoSaldoDisp.setEditable(false);

        saldobloqlabel.setText("Saldo bloq.:");

        textoSaldoBloq.setEditable(false);

        partbloqlabel.setText("Participaciones bloq.:");

        textoPartBloq.setEditable(false);

        etiquetaBaja.setForeground(new java.awt.Color(0, 102, 51));
        etiquetaBaja.setText("Baja solicitada correctamente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textoDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoTelefono))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(IDlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoID))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(SaldoLabel)
                                .addGap(17, 17, 17)
                                .addComponent(textoSaldoDisp))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(DNIlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoDNI))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoNombre)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(saldobloqlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoSaldoBloq))
                            .addComponent(ap1label)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(29, 29, 29)
                                .addComponent(textoClave))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(partbloqlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textoPartBloq))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoAp1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(ap2label)
                                        .addGap(6, 6, 6)
                                        .addComponent(textoAp2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSolicitarBaja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(etiquetaBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDlabel)
                    .addComponent(jLabel6)
                    .addComponent(textoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textoAp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ap1label)))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ap2label)
                        .addComponent(textoAp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DNIlabel)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoSaldoDisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaldoLabel)
                    .addComponent(saldobloqlabel)
                    .addComponent(textoSaldoBloq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(partbloqlabel)
                    .addComponent(textoPartBloq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addComponent(etiquetaBaja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSolicitarBaja)
                    .addComponent(btnGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cuenta", jPanel1);

        btnSalir.setText("Cerrar sesión");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
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
                        .addComponent(btnSalir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(labelUsuarioConectado))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        fa.cerrarSesion();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSolicitarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarBajaActionPerformed
        if (fa.solicitarBaja(uConect)) {
            etiquetaBaja.setVisible(true);
        } else {
            etiquetaBaja.setVisible(false);
        }
        actualizarComision();
    }//GEN-LAST:event_btnSolicitarBajaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Usuario u = null;
        if (uConect instanceof Empresa) {
            u = new Empresa(textoID.getText(), textoClave.getText(), Float.parseFloat(textoSaldoDisp.getText()),
                    textoDNI.getText(), textoNombre.getText(), textoDireccion.getText(), textoTelefono.getText(),
                    Float.parseFloat(textoSaldoBloq.getText()), Integer.parseInt(textoPartBloq.getText()));
        } else if (uConect instanceof Inversor) {
            u = new Inversor(textoID.getText(), textoClave.getText(), Float.parseFloat(textoSaldoDisp.getText()),
                    textoDNI.getText(), textoNombre.getText(), textoAp1.getText(), textoAp2.getText(),
                    textoDireccion.getText(), textoTelefono.getText());
        } else {
            System.out.println("Nunca debería chegar aquí");
        }

        fa.actualizarDatosUsuario(u, idAntigua);

        uConect = u;

        JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.");

        labelUsuarioConectado.setText("Usuario conectado: " + uConect.getId());
        actualizarDatosYVisibilidad();
        actualizarComision();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void bntVerMercadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVerMercadoActionPerformed
        fa.iniciarMercado(uConect);

        actualizarDatosYVisibilidad();
        actualizarParticipaciones();
        actualizarComision();
    }//GEN-LAST:event_bntVerMercadoActionPerformed

    private void bnStackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnStackingActionPerformed
        fa.iniciarStacking(uConect);

        actualizarDatosYVisibilidad();
        actualizarParticipaciones();
        actualizarComision();
    }//GEN-LAST:event_bnStackingActionPerformed

    private void daraltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daraltaActionPerformed
        if ((int) cantidadSpinner.getValue() > 0) {
            fa.darAltaPart(uConect.getId(), (int) cantidadSpinner.getValue());
            JOptionPane.showMessageDialog(null, "Participaciones dadas de alta correctamente.");
        } else {
            fa.muestraExcepcion("Introduce una cantidad distinta de 0");
        }

        actualizarParticipaciones();
        actualizarComision();
    }//GEN-LAST:event_daraltaActionPerformed

    private void darbajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darbajaActionPerformed
        if ((int) cantidadSpinner.getValue() > 0) {
            if (fa.darBajaPart(uConect.getId(), (int) cantidadSpinner.getValue())) {
                JOptionPane.showMessageDialog(null, "Participaciones dadas de baja correctamente.");
            } else {
                fa.muestraExcepcion("La empresa no tiene el número de participaciones indicadas dadas de alta.\nRevíselo.");
            }
        } else {
            fa.muestraExcepcion("Introduce una cantidad distinta de 0");
        }

        actualizarParticipaciones();
        actualizarComision();
    }//GEN-LAST:event_darbajaActionPerformed

    private void tablaPartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPartMouseClicked
        ModeloTablaCarteraParticipaciones m = (ModeloTablaCarteraParticipaciones) tablaPart.getModel();
        textoEmpresa.setText(m.getValueAt(tablaPart.rowAtPoint(evt.getPoint()), 0).toString());
        textoPrecio.setText(String.valueOf(m.getValueAt(tablaPart.rowAtPoint(evt.getPoint()), 2)));
        if (m.getValueAt(tablaPart.rowAtPoint(evt.getPoint()), 2).equals((float) 0)) {
            btnDarBajaVenta.setEnabled(false);
            btnVender.setEnabled(true);
            textoPrecio.setEditable(true);
            numeroSpinner.setEnabled(true);
            numeroSpinner.setValue(0);
        } else {
            btnDarBajaVenta.setEnabled(true);
            btnVender.setEnabled(false);
            textoPrecio.setEditable(false);
            numeroSpinner.setEnabled(false);
            numeroSpinner.setValue(m.getValueAt(tablaPart.rowAtPoint(evt.getPoint()), 1));
        }
        actualizarComision();
    }//GEN-LAST:event_tablaPartMouseClicked

    private void btnDarBajaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarBajaVentaActionPerformed
        ModeloTablaCarteraParticipaciones m = (ModeloTablaCarteraParticipaciones) tablaPart.getModel();
        Participaciones p = m.obtenerParticipacion(tablaPart.getSelectedRow());

        fa.retirarMercado(p.getUsuario(), p.getMarcaTemporalVenta());

        JOptionPane.showMessageDialog(null, "Participaciones retiradas del mercado correctamente.");

        actualizarParticipaciones();
        actualizarComision();
    }//GEN-LAST:event_btnDarBajaVentaActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        if ((int) numeroSpinner.getValue() <= 0 || textoPrecio.getText().isEmpty()
                || Float.parseFloat(textoPrecio.getText()) <= 0.0) {
            fa.muestraExcepcion("Introduce valores positivos en la cantidad y el precio");
        } else {
            if ((int) numeroSpinner.getValue() <= fa.obtenerNumParticipacionesDisponiblesEmpresa(uConect, textoEmpresa.getText())) {
                fa.puestaVentaParticipaciones(uConect, textoEmpresa.getText(), (int) numeroSpinner.getValue(), Float.parseFloat(textoPrecio.getText()));
                JOptionPane.showMessageDialog(null, "Participaciones puestas a la venta correctamente.");
            } else {
                fa.muestraExcepcion("No tienes el número de participaciones indicada para esta empresa.\nRevísalo.");
            }
        }
        actualizarParticipaciones();
        actualizarComision();
    }//GEN-LAST:event_btnVenderActionPerformed

    private void btnFuturosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuturosActionPerformed
        fa.iniciarPactos(uConect);

        actualizarParticipaciones();
        actualizarComision();
    }//GEN-LAST:event_btnFuturosActionPerformed

    private void textoIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoIDKeyTyped
        if (textoID.getText().length() == 10)
            evt.consume();
    }//GEN-LAST:event_textoIDKeyTyped

    private void textoClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoClaveKeyTyped
        if (textoClave.getText().length() == 30)
            evt.consume();
    }//GEN-LAST:event_textoClaveKeyTyped

    private void textoAp1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoAp1KeyTyped
        if (textoAp1.getText().length() == 15)
            evt.consume();
    }//GEN-LAST:event_textoAp1KeyTyped

    private void textoAp2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoAp2KeyTyped
        if (textoAp2.getText().length() == 15)
            evt.consume();
    }//GEN-LAST:event_textoAp2KeyTyped

    private void textoTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoTelefonoKeyTyped
        if (textoTelefono.getText().length() == 10)
            evt.consume();
    }//GEN-LAST:event_textoTelefonoKeyTyped

    private void textoDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoDNIKeyTyped
        if (textoDNI.getText().length() == 9)
            evt.consume();
    }//GEN-LAST:event_textoDNIKeyTyped

    private void textoDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoDireccionKeyTyped
        if (textoDireccion.getText().length() == 40)
            evt.consume();
    }//GEN-LAST:event_textoDireccionKeyTyped

    private void textoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNombreKeyTyped
        if (textoNombre.getText().length() == 20)
            evt.consume();
    }//GEN-LAST:event_textoNombreKeyTyped

    private void textoPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoPrecioKeyReleased
        try {
            if (!textoPrecio.getText().isEmpty()) {
                Float.parseFloat(textoPrecio.getText());
            }
            btnVender.setEnabled(true);
        } catch (NumberFormatException e) {
            btnVender.setEnabled(false);
        }
    }//GEN-LAST:event_textoPrecioKeyReleased

    private void textoTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoTelefonoKeyReleased
        try {
            if (!textoTelefono.getText().isEmpty()) {
                Long.parseLong(textoTelefono.getText());
            }
            btnGuardar.setEnabled(true);
        } catch (NumberFormatException e) {
            btnGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_textoTelefonoKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DNIlabel;
    private javax.swing.JLabel IDlabel;
    private javax.swing.JLabel SaldoLabel;
    private javax.swing.JLabel ap1label;
    private javax.swing.JLabel ap2label;
    private javax.swing.JButton bnStacking;
    private javax.swing.JButton bntVerMercado;
    private javax.swing.JTextField boxTipo;
    private javax.swing.JButton btnDarBajaVenta;
    private javax.swing.JButton btnFuturos;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSolicitarBaja;
    private javax.swing.JButton btnVender;
    private javax.swing.JSpinner cantidadSpinner;
    private javax.swing.JLabel cantidadlabel;
    private javax.swing.JLabel comisionLabel;
    private javax.swing.JButton daralta;
    private javax.swing.JButton darbaja;
    private javax.swing.JLabel etiquetaBaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelUsuarioConectado;
    private javax.swing.JSpinner numeroSpinner;
    private javax.swing.JLabel partbloqlabel;
    private javax.swing.JLabel saldobloqlabel;
    private javax.swing.JTable tablaPart;
    private javax.swing.JTextField textoAp1;
    private javax.swing.JTextField textoAp2;
    private javax.swing.JPasswordField textoClave;
    private javax.swing.JTextField textoDNI;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoEmpresa;
    private javax.swing.JTextField textoID;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoPartBloq;
    private javax.swing.JTextField textoPrecio;
    private javax.swing.JTextField textoSaldoBloq;
    private javax.swing.JTextField textoSaldoDisp;
    private javax.swing.JTextField textoTelefono;
    // End of variables declaration//GEN-END:variables

    private void actualizarDatosYVisibilidad() {
        if (uConect.getTipo().name().equals("Empresa")) {
            Empresa emp = (Empresa) fa.obtenerUsuario(uConect.getId());
            ap1label.setVisible(false);
            textoAp1.setVisible(false);
            ap2label.setVisible(false);
            textoAp2.setVisible(false);
            DNIlabel.setText("CIF");
            textoID.setText(emp.getId());
            textoClave.setText(emp.getClave());
            textoNombre.setText(emp.getNombre());
            textoDNI.setText(emp.getCif());
            textoDireccion.setText(emp.getDireccion());
            textoTelefono.setText(emp.getTelefono());
            boxTipo.setText(emp.getTipo().name());
            textoSaldoDisp.setText(String.valueOf(emp.getSaldoDisponible()));
            textoSaldoBloq.setVisible(true);
            saldobloqlabel.setVisible(true);
            textoPartBloq.setVisible(true);
            partbloqlabel.setVisible(true);
            cantidadlabel.setVisible(true);
            cantidadSpinner.setVisible(true);
            daralta.setVisible(true);
            darbaja.setVisible(true);
            textoPartBloq.setText(String.valueOf(emp.getPartiBloqueadas()));
            textoSaldoBloq.setText(String.valueOf(emp.getSaldoBloqueado()));
            textoSaldoDisp.setText(String.valueOf(emp.getSaldoDisponible()));
            uConect = (Empresa) emp;
        } else if (uConect.getTipo().name().equals("Inversor")) {
            Inversor inv = (Inversor) fa.obtenerUsuario(uConect.getId());
            textoSaldoBloq.setVisible(false);
            saldobloqlabel.setVisible(false);
            textoPartBloq.setVisible(false);
            partbloqlabel.setVisible(false);
            cantidadlabel.setVisible(false);
            cantidadSpinner.setVisible(false);
            daralta.setVisible(false);
            darbaja.setVisible(false);
            DNIlabel.setText("DNI");
            textoID.setText(inv.getId());
            textoClave.setText(inv.getClave());
            textoNombre.setText(inv.getNombre());
            textoDNI.setText(inv.getDni());
            textoDireccion.setText(inv.getDireccion());
            textoTelefono.setText(inv.getTelefono());
            boxTipo.setText(inv.getTipo().name());
            textoAp1.setText(inv.getApellido1());
            textoAp2.setText(inv.getApellido2());
            textoSaldoDisp.setText(String.valueOf(inv.getSaldoDisponible()));
            textoSaldoDisp.setText(String.valueOf(inv.getSaldoDisponible()));
            uConect = (Inversor) inv;
        }

        idAntigua = uConect.getId();
        etiquetaBaja.setVisible(false);
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
            Participaciones p = m.obtenerParticipacion(tablaPart.getSelectedRow());
            if (p.getPrecio() == 0.0) {
                btnDarBajaVenta.setEnabled(false);
                btnVender.setEnabled(true);
                textoPrecio.setEditable(true);
                numeroSpinner.setEnabled(true);
                numeroSpinner.setValue(0);
            } else {
                btnDarBajaVenta.setEnabled(true);
                btnVender.setEnabled(false);
                textoPrecio.setEditable(false);
                numeroSpinner.setEnabled(false);
                numeroSpinner.setValue(p.getCantidad());
            }
            textoEmpresa.setText(p.getEmpresa());
            textoPrecio.setText(String.valueOf(p.getPrecio()));
        }
    }

    private void actualizarComision() {
        comisionLabel.setText("Comisión actual: " + Float.toString(fa.obtenerComisionActual()) + " %");
    }
}
