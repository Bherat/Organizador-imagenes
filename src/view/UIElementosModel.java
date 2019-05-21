/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Foo
 */
public class UIElementosModel extends UIElementos {
    
    

    public UIElementosModel() {
        this.setTitle("Agregar nuevo elemento.");
        
        fileChooser();
    }
    
    private void fileChooser() {
        JFileChooser chooser = super.jFileChooser1;
        
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        FileFilter filtro = new FileNameExtensionFilter("Todos los archivos de imagen", "bmp", "png", "jpg", "gif", "tiff");
        
        chooser.addChoosableFileFilter(filtro);
    }

    public JTextArea getAreaDescripcion() {
        return areaDescripcion;
    }

    public JTextField getFieldLink() {
        return fieldLink;
    }

    public JTextField getFieldNombre() {
        return fieldNombre;
    }

    public JPanel getPanelImagen() {
        return panelImagen;
    }

    public JLabel getImagen() {
        return Imagen;
    }

    public JButton getBtAceptar() {
        return btAceptar;
    }

    public JFileChooser getFileChooser() {
        return jFileChooser1;
    }
    
    
    
}
