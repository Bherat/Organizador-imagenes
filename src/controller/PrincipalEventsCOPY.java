
package controller;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import model.PrincipalDB;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.Categorias;
import model.Elementos;
import model.ElementosDB;
import view.ElementoVista;
import view.NCategoria;
import view.Principal;
import view.UIElementosModel;

/**
 *
 * @author Foo
 */
public class PrincipalEventsCOPY {
    Principal principal;
    PrincipalDB prinDB;
    NCategoria newCategoria;
    UIElementosModel UIElementos;
    ElementoVista elemenVista;
    ElementosDB elemenDB;
    
    
    private int dmnsX = 0;
    private int dmnsY = 0;
    
    ArrayList<ElementoVista> prueba;
    

    public PrincipalEventsCOPY(Principal principal, NCategoria nCate, UIElementosModel UIElementos) 
    {
        this.principal = principal;
        this.prinDB = new PrincipalDB();
        this.newCategoria = nCate;
        this.UIElementos = UIElementos;
        this.elemenVista = new ElementoVista();
        this.elemenDB = new ElementosDB();
        
        
        acciones();
    }
    
    private void acciones() 
    {
        this.principal.getBtAgregarCategoria().addActionListener((ActionEvent ae) -> {
                nuevaCategoria(ae);
        });
        
        this.principal.getBtEliminarCategoria().addActionListener((ActionEvent ae) -> {
            eliminarCategoria(ae);
        });
        
        this.principal.getCbCategorias().addActionListener(al -> {
            actionComboBox(al);
        });
        
        this.principal.getBtAgregarElemento().addActionListener(al -> {
            nuevoElemento(al);
        });
        
        this.principal.getBtEliminarElemento().addActionListener(al -> {
            eliminarElemento(al);
        });

        
        this.principal.getTfBuscar().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                filtrarElementos(ke);
            }
        });
        
    }
    
    
    private void nuevaCategoria(ActionEvent ae)
    {
        int width = this.principal.getWidth() - this.newCategoria.getWidth();
        int height = this.principal.getHeight() - this.newCategoria.getHeight();
        
        this.principal.getDesktop().add(this.newCategoria, 0);
        this.newCategoria.setLocation(width / 2, height / 2);
        
        this.principal.getBtEliminarCategoria().setEnabled(false);
        this.principal.getBtAgregarCategoria().setEnabled(false);
        this.principal.getBtAgregarElemento().setEnabled(false);
        this.principal.getBtEliminarElemento().setEnabled(false);
        
        this.newCategoria.setVisible(true);
        this.newCategoria.toFront();
    }
    
    private void eliminarCategoria(ActionEvent ae) 
    {
        String categoria = String.valueOf(this.principal.getCBModel().getSelectedItem());
        if(!categoria.equals("Seleccione una categoria.") && !categoria.equals("null")) {
            if(!this.newCategoria.isVisible()) {
                
                int option = JOptionPane.showConfirmDialog(null, "¿Está usted seguro que desea eliminar la categoria " +categoria+ " y todos sus elementos?");
                
                if(option == JOptionPane.YES_OPTION) {
                   int resultado = prinDB.deleteCategory(categoria);
                   
                   if(resultado >= 1) {
                       this.principal.getCBModel().removeElement(categoria);
                       this.principal.getPanelImagenes().removeAll();
                       this.principal.getPanelImagenes().updateUI();
                       JOptionPane.showMessageDialog(this.principal, "Categoria " +categoria+ " eliminada.");                       
                   }
                }
            }
        }
    }
    
    private void actionComboBox(ActionEvent ae) 
    {
        String selected = String.valueOf(this.principal.getCBModel().getSelectedItem());
        if(!selected.equals("null") && !selected.equals("Seleccione una categoria")) {
            this.principal.getBtEliminarCategoria().setEnabled(true);
            this.principal.getBtAgregarElemento().setEnabled(true);
            this.principal.getBtEliminarElemento().setEnabled(true);
            
            Categorias cateTemp = this.prinDB.getCategory().stream().filter(cate -> selected.equals(cate.getName()))
                    .findAny().orElse(null);
            
            
            ArrayList<Elementos> elementos = this.elemenDB.getElements(cateTemp.getId());
            
            
            this.principal.getPanelImagenes().removeAll();
            this.principal.getPanelImagenes().updateUI();
            
            elementos.stream().forEach(elem -> {
                filtroYAcomodamiento(elem);
            });
            
            cateTemp = null;
            elementos = null;
            
        } else {
            this.principal.getBtEliminarCategoria().setEnabled(false);
            this.principal.getBtAgregarElemento().setEnabled(false);
            this.principal.getBtEliminarElemento().setEnabled(false);
        }
        if(selected.equals("null")) {
            this.principal.getCBModel().setSelectedItem("Seleccione una categoria");
        }
        
        
    }
    
    private void nuevoElemento(ActionEvent ae) 
    {
        int posX = (this.principal.getWidth() - this.UIElementos.getSize().width) / 2;
        int posY = (this.principal.getHeight()- this.UIElementos.getSize().height) / 2;
        
        this.principal.getDesktop().add(this.UIElementos, 0);
        this.UIElementos.setLocation(posX, posY);
        this.UIElementos.setVisible(true);
        this.UIElementos.toFront();
    }
    
    private void eliminarElemento(ActionEvent ae) 
    {
        
    }
    
    
    private void acomodarElementos(ElementoVista nuevoElemento) {
        nuevoElemento.setPreferredSize(new Dimension(dmnsX, dmnsY));
        
        nuevoElemento.getTxtTitulo().setSize(new Dimension(dmnsX -2, 
                            nuevoElemento.getTxtTitulo().getSize().height));
        
        nuevoElemento.getTxtTitulo().setLocation(1, nuevoElemento.getPreferredSize().height - 21);
        


        this.principal.getPanelImagenes().add(nuevoElemento);

        this.principal.getPanelImagenes().updateUI();
    }
    

    
    private void filtroYAcomodamiento(Elementos e) {
        if(e.getImagen() != null) {
            try {
                BufferedImage buffImag = ImageIO.read(e.getImagen());
                //160, 200
                Image imagenReescalada = buffImag.getScaledInstance(this.dmnsX - 2, this.dmnsY - 2, 1);

                ElementoVista eleVis = new ElementoVista(new ImageIcon(imagenReescalada));

                eleVis.addTitulo(e.getNombre());
                acomodarElementos(eleVis);
                
                eleVis = null;
                buffImag = null;
                imagenReescalada = null;
                
            } catch(IOException ex) {
                System.out.println(ex.getMessage());
            }

        } else {
            ElementoVista eleVis = new ElementoVista("Image not found.");
            eleVis.addTitulo(e.getNombre());
            acomodarElementos(eleVis);
            
            eleVis = null;
        }
        
        e = null;
        
    }
    
    private void filtrarElementos(KeyEvent ke) {
        
       
        String txtBuscar = this.principal.getTfBuscar().getText();
        String categoSelec = String.valueOf(this.principal.getCBModel().getSelectedItem());
        
        Categorias cateTemp = this.prinDB.getCategory().stream().filter(cate -> categoSelec.equals(cate.getName()))
                .findAny().orElse(null);
        
        ArrayList<Elementos> elementosFiltro = this.elemenDB.getElements(cateTemp.getId());
        
        this.principal.getPanelImagenes().removeAll();
        this.principal.getPanelImagenes().updateUI();
        
        
        elementosFiltro.stream().forEach(filter -> {
            String elemen = filter.getNombre().toLowerCase();
            String buscar = txtBuscar.toLowerCase();
            
            if(elemen.startsWith(buscar)) {
                filtroYAcomodamiento(filter);
            }
            
        });
        cateTemp = null;
        elementosFiltro = null;
        
    }
    
    
}
