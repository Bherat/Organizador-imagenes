/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Foo
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cbCategorias = new javax.swing.JComboBox<>();
        btAgregarCategoria = new javax.swing.JButton();
        btEliminarCategoria = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        tfBuscar = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        panelContenedor = new javax.swing.JPanel();
        btAgregarElemento = new javax.swing.JButton();
        btEliminarElemento = new javax.swing.JButton();
        panelBtnSize = new javax.swing.JPanel();
        btSizeX1 = new javax.swing.JButton();
        btSizeX2 = new javax.swing.JButton();
        btSizeX3 = new javax.swing.JButton();
        btSizeX4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelImagenes = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktop.setBackground(new java.awt.Color(102, 0, 0));
        desktop.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 51), 1, true));
        desktop.setMinimumSize(new java.awt.Dimension(714, 525));

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 51), 1, true));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        jPanel4.setBackground(new java.awt.Color(102, 0, 0));
        jPanel4.setAlignmentY(0.0F);
        jPanel4.setLayout(null);

        jPanel4.add(cbCategorias);
        cbCategorias.setBounds(90, 10, 180, 20);

        btAgregarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/iconos/Boton-agregar.png"))); // NOI18N
        btAgregarCategoria.setToolTipText("Agregar categoria");
        btAgregarCategoria.setBorder(null);
        btAgregarCategoria.setContentAreaFilled(false);
        btAgregarCategoria.setFocusPainted(false);
        btAgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarCategoriaActionPerformed(evt);
            }
        });
        jPanel4.add(btAgregarCategoria);
        btAgregarCategoria.setBounds(278, 10, 20, 22);

        btEliminarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/iconos/Boton-eliminar.png"))); // NOI18N
        btEliminarCategoria.setToolTipText("Eliminar categoria");
        btEliminarCategoria.setBorder(null);
        btEliminarCategoria.setContentAreaFilled(false);
        btEliminarCategoria.setFocusPainted(false);
        btEliminarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarCategoriaActionPerformed(evt);
            }
        });
        jPanel4.add(btEliminarCategoria);
        btEliminarCategoria.setBounds(300, 10, 30, 22);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Categoria:");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(10, 10, 80, 20);

        jPanel5.setBackground(new java.awt.Color(102, 0, 0));
        jPanel5.setAlignmentY(0.1F);

        btBuscar.setBackground(new java.awt.Color(102, 0, 0));
        btBuscar.setForeground(new java.awt.Color(153, 0, 204));
        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/iconos/Boton-buscar-naranja.png"))); // NOI18N
        btBuscar.setToolTipText("Buscar");
        btBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btBuscar.setFocusPainted(false);
        btBuscar.setMargin(new java.awt.Insets(1, 14, 0, 14));
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscar)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBuscar)
                    .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panelContenedor.setBackground(new java.awt.Color(102, 0, 0));
        panelContenedor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 51), 1, true));

        btAgregarElemento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/iconos/Boton-agregarelemento.png"))); // NOI18N
        btAgregarElemento.setToolTipText("Agregar elemento");
        btAgregarElemento.setBorder(null);
        btAgregarElemento.setContentAreaFilled(false);
        btAgregarElemento.setFocusPainted(false);
        btAgregarElemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarElementoActionPerformed(evt);
            }
        });

        btEliminarElemento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/iconos/Boton-eliminarelemento.png"))); // NOI18N
        btEliminarElemento.setToolTipText("Eliminar elemento");
        btEliminarElemento.setBorder(null);
        btEliminarElemento.setContentAreaFilled(false);
        btEliminarElemento.setFocusPainted(false);
        btEliminarElemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarElementoActionPerformed(evt);
            }
        });

        panelBtnSize.setOpaque(false);
        panelBtnSize.setLayout(new javax.swing.BoxLayout(panelBtnSize, javax.swing.BoxLayout.LINE_AXIS));

        btSizeX1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        btSizeX1.setForeground(new java.awt.Color(255, 153, 51));
        btSizeX1.setText("x1");
        btSizeX1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 255), null, null));
        btSizeX1.setBorderPainted(false);
        btSizeX1.setFocusPainted(false);
        btSizeX1.setFocusable(false);
        btSizeX1.setOpaque(false);
        panelBtnSize.add(btSizeX1);

        btSizeX2.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        btSizeX2.setForeground(new java.awt.Color(255, 153, 51));
        btSizeX2.setText("x2");
        btSizeX2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 255), null, null));
        btSizeX2.setBorderPainted(false);
        btSizeX2.setFocusPainted(false);
        btSizeX2.setFocusable(false);
        btSizeX2.setOpaque(false);
        panelBtnSize.add(btSizeX2);

        btSizeX3.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        btSizeX3.setForeground(new java.awt.Color(255, 153, 51));
        btSizeX3.setText("x3");
        btSizeX3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 255), null, null));
        btSizeX3.setBorderPainted(false);
        btSizeX3.setFocusPainted(false);
        btSizeX3.setFocusable(false);
        btSizeX3.setOpaque(false);
        panelBtnSize.add(btSizeX3);

        btSizeX4.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        btSizeX4.setForeground(new java.awt.Color(255, 153, 51));
        btSizeX4.setText("x4");
        btSizeX4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 255), null, null));
        btSizeX4.setBorderPainted(false);
        btSizeX4.setFocusPainted(false);
        btSizeX4.setFocusable(false);
        btSizeX4.setOpaque(false);
        panelBtnSize.add(btSizeX4);

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btAgregarElemento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btEliminarElemento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBtnSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btAgregarElemento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btEliminarElemento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelBtnSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelImagenes.setBackground(new java.awt.Color(102, 0, 0));
        panelImagenes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 153, 51), new java.awt.Color(255, 153, 51), new java.awt.Color(255, 102, 0), new java.awt.Color(255, 102, 0)));

        javax.swing.GroupLayout panelImagenesLayout = new javax.swing.GroupLayout(panelImagenes);
        panelImagenes.setLayout(panelImagenesLayout);
        panelImagenesLayout.setHorizontalGroup(
            panelImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );
        panelImagenesLayout.setVerticalGroup(
            panelImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelImagenes);

        desktop.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(panelContenedor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAgregarCategoriaActionPerformed

    private void btEliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEliminarCategoriaActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btEliminarElementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarElementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEliminarElementoActionPerformed

    private void btAgregarElementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarElementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAgregarElementoActionPerformed

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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btAgregarCategoria;
    protected javax.swing.JButton btAgregarElemento;
    protected javax.swing.JButton btBuscar;
    protected javax.swing.JButton btEliminarCategoria;
    protected javax.swing.JButton btEliminarElemento;
    protected javax.swing.JButton btSizeX1;
    protected javax.swing.JButton btSizeX2;
    protected javax.swing.JButton btSizeX3;
    protected javax.swing.JButton btSizeX4;
    protected javax.swing.JComboBox<String> cbCategorias;
    protected javax.swing.JDesktopPane desktop;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JPanel jPanel1;
    protected javax.swing.JPanel jPanel4;
    protected javax.swing.JPanel jPanel5;
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JPanel panelBtnSize;
    protected javax.swing.JPanel panelContenedor;
    protected javax.swing.JPanel panelImagenes;
    protected javax.swing.JTextField tfBuscar;
    // End of variables declaration//GEN-END:variables
}
