
package view;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Foo
 */
public class NCategoria extends NuevaCategoria {

    public NCategoria() {
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    }

    public JButton getBtAceptar() {
        return btAceptar;
    }

    public JButton getBtCancelar() {
        return btCancelar;
    }

    public JTextField getFieldNombre() {
        return fieldNombre;
    }
    
    
    
    
}
