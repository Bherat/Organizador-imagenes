package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Foo
 */
public class ElementoVista extends Elemento{

    public ElementoVista() {
    }

    public ElementoVista(String text) {
        Dimension dmsn = this.getPreferredSize();
        this.setSize(dmsn);
        
        this.Imagen.setText(text);
    }
    
    public ElementoVista(ImageIcon icon) {
        Dimension dmsn = this.getPreferredSize();
        this.setSize(dmsn);
        
        
        this.Imagen.setText("");
        this.Imagen.setIcon(icon);
    }
    
    
    public void addTitulo(String text) {
        this.txtTitulo.setText(text);
        this.txtTitulo.setSize(158, 20);
        this.txtTitulo.setLocation(1, 179);
        this.txtTitulo.setFont(new Font("Verdana", Font.BOLD, 10));
        this.txtTitulo.setBackground(new Color(0, 0, 0, 135));
        this.txtTitulo.setForeground(Color.WHITE);
        this.add(txtTitulo, 0);
    }

    public JLabel getImagen() {
        return Imagen;
    }    

    public JLabel getTxtTitulo() {
        return txtTitulo;
    }
    
}
