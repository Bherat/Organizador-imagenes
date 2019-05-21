/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.PrincipalDB;
import model.ElementosDB;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import model.Categorias;
import view.Principal;
import view.UIElementosModel;

/**
 *
 * @author Foo
 */
public class UIElementosEvents 
{
    
    UIElementosModel UIElement;
    Principal principal;
    ElementosDB elemDB;
    PrincipalDB prinDB;
    
    Image imagenEscalada;
    File file;
    InputStream inputStream = null;
    byte[] imageByte;

    public UIElementosEvents(Principal principal, UIElementosModel UIElement) {
        this.principal = principal;
        this.UIElement = UIElement;
        this.elemDB = new ElementosDB();
        this.prinDB = new PrincipalDB();
        
        acciones();
    }
    
    private void acciones() 
    {
        this.UIElement.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent ife) {
                windowsClosed(ife);
            }
        });
                
                
        this.UIElement.getImagen().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                imagenClick(me); 
            }
        });
        
        this.UIElement.getBtAceptar().addActionListener(al -> {
            cargarElementoADB(al);
        });
    }
    
    private void imagenClick(MouseEvent ma) {
        JFileChooser chooser = this.UIElement.getFileChooser();
        int fileSeleccion = chooser.showOpenDialog(UIElement);
        
        if(fileSeleccion == JFileChooser.APPROVE_OPTION) {
            this.file = new File(chooser.getSelectedFile().getAbsolutePath());
            try {
                BufferedImage image = ImageIO.read(this.file);
                this.inputStream = new FileInputStream(this.file);

                ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
                byte[] buff = new byte[1024];

                for (int read; (read = inputStream.read(buff)) != -1 ;) {
                    byteOutputStream.write(buff, 0, read);
                }

                this.imageByte = byteOutputStream.toByteArray();


                if(image != null) {
                    JPanel panel = this.UIElement.getPanelImagen();
                    this.imagenEscalada = image.getScaledInstance(panel.getWidth(), panel.getHeight(), 0);

                    this.UIElement.getImagen().setIcon(new ImageIcon(this.imagenEscalada));
                    this.UIElement.getImagen().setText("");
                }
                
                
            } catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
            fileSeleccion = 0;
        }
        
    }
    
    private void cargarElementoADB(ActionEvent ae) {
        String nombre = this.UIElement.getFieldNombre().getText();
        String link = this.UIElement.getFieldLink().getText();
        String desc = this.UIElement.getAreaDescripcion().getText();
        String categoSeleccionada = String.valueOf(this.principal.getCBModel().getSelectedItem());
        int id = this.elemDB.getLastId() + 1;
        
        Categorias cateTemp = this.prinDB.getCategory().stream().filter(cate -> categoSeleccionada.equals(cate.getName()))
                .findAny().orElse(null);
        
        
        if(id != -1) {
            if(cateTemp != null) {
                int resultado = -1;
                resultado = elemDB.addElement(id, nombre, desc, cateTemp.getId(), this.imageByte, link);

                if(resultado == 1) {
                    JOptionPane.showMessageDialog(UIElement, "Carga exitosa.");
                    this.UIElement.getFieldNombre().setText("");
                    this.UIElement.getFieldLink().setText("");
                    this.UIElement.getAreaDescripcion().setText("");
                    this.UIElement.getImagen().setText("IMAGEN");
                    this.UIElement.getImagen().setIcon(null);
                    this.imageByte = null;
                    this.UIElement.dispose();
                } else {
                    JOptionPane.showMessageDialog(UIElement, "Ya hay un elemento con el mismo nombre.\nDebes cambiar el nombre del nuevo elemento para poder continuar.");
                }
            } else  JOptionPane.showMessageDialog(UIElement, "Selecciona una categoria.");
        
        } else JOptionPane.showMessageDialog(this.UIElement, "Error al conectar a la base de datos.");
        
        
    }
    
    private void windowsClosed(InternalFrameEvent ife) {
        this.UIElement.getFieldNombre().setText("");
        this.UIElement.getFieldLink().setText("");
        this.UIElement.getAreaDescripcion().setText("");
        this.UIElement.getImagen().setText("IMAGEN");
        this.UIElement.getImagen().setIcon(null);
        this.imageByte = null;
    }
    
    
    
    
}
