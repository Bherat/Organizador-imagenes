
package view;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.WrapLayout;

/**
 *
 * @author Foo
 */
public class Principal extends VistaPrincipal {
    
    
    private DefaultComboBoxModel defaultBoxModel;
    private WrapLayout layout;

    public WrapLayout getLayout() {
        return layout;
    }



    public Principal() {
        this.defaultBoxModel = new DefaultComboBoxModel();
        this.layout = new WrapLayout(3);
        
        this.getCbCategorias().setModel(defaultBoxModel);
        
        this.jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);
        
        this.setTitle("Aerus");
        
        this.defaultBoxModel.setSelectedItem("Seleccione una categoria");
        
        this.panelImagenes.setLayout(layout);
        
        
            this.btSizeX1.setForeground(Color.YELLOW);
            //this.btSizeX1.setEnabled(false);
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
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
    }
    
    
    

    public JButton getBtAgregarCategoria() {
        return btAgregarCategoria;
    }

    public JButton getBtBuscar() {
        return btBuscar;
    }

    public JButton getBtEliminarCategoria() {
        return btEliminarCategoria;
    }

    public JComboBox<String> getCbCategorias() {
        return cbCategorias;
    }

    public JDesktopPane getDesktop() {
        return desktop;
    }

    public JPanel getPanelContenedor() {
        return panelContenedor;
    }

    public JTextField getTfBuscar() {
        return tfBuscar;
    }
    
    public DefaultComboBoxModel getCBModel() {
        return this.defaultBoxModel;
    }

    public JButton getBtAgregarElemento() {
        return btAgregarElemento;
    }

    public JButton getBtEliminarElemento() {
        return btEliminarElemento;
    }

    public JPanel getPanelImagenes() {
        return panelImagenes;
    }

    public JButton getBtSizeX1() {
        return btSizeX1;
    }

    public JButton getBtSizeX2() {
        return btSizeX2;
    }

    public JButton getBtSizeX3() {
        return btSizeX3;
    }

    public JButton getBtSizeX4() {
        return btSizeX4;
    }
    

    
    
    
    
    
}
