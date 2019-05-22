
package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import model.PrincipalDB;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
public class PrincipalEvents {
    Principal principal;
    PrincipalDB prinDB;
    NCategoria newCategoria;
    UIElementosModel UIElementos;
    ElementoVista elemenVista;
    ElementosDB elemenDB;
    
    
    private int dmnsX = 160;
    private int dmnsY = 175;
    private final int sizeViewWidht = 160;
    private final int sizeViewHeight = 175;
    
    private ArrayList<Elementos> elemenLista;
    private Categorias cateTemp;
    

    public PrincipalEvents(Principal principal, NCategoria nCate, UIElementosModel UIElementos) 
    {
        this.principal = principal;
        this.prinDB = new PrincipalDB();
        this.newCategoria = nCate;
        this.UIElementos = UIElementos;
        this.elemenVista = new ElementoVista();
        this.elemenDB = new ElementosDB();
        
        this.elemenLista = new ArrayList<>();
        
        
        
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
        
        this.principal.getBtSizeX1().addActionListener(al -> {
            
            this.dmnsX = this.sizeViewWidht;
            this.dmnsY = this.sizeViewHeight;

            this.principal.getPanelImagenes().removeAll();

            if(!elemenLista.isEmpty()) {
            this.elemenLista.clear();
                elemenDB.getElements(cateTemp.getId()).stream().map((elemento) -> {
                    this.elemenLista.add(elemento);
                    return elemento;
                }).forEachOrdered((elemento) -> {
                    this.filtroYAcomodamiento(elemento);
                });
            }
            
            this.principal.getBtSizeX1().setForeground(Color.YELLOW);
            this.principal.getBtSizeX2().setForeground(new Color(255, 153, 51));
            this.principal.getBtSizeX3().setForeground(new Color(255, 153, 51));
            this.principal.getBtSizeX4().setForeground(new Color(255, 153, 51));
            
            
            this.principal.getBtSizeX1().setEnabled(false);
            this.principal.getBtSizeX2().setEnabled(true);
            this.principal.getBtSizeX3().setEnabled(true);
            this.principal.getBtSizeX4().setEnabled(true);

        
            
        });
        
        this.principal.getBtSizeX2().addActionListener(al -> {
            this.dmnsX = this.sizeViewWidht * 2;
            this.dmnsY = this.sizeViewHeight * 2;

            this.principal.getPanelImagenes().removeAll();

            if(!elemenLista.isEmpty()) {
                this.elemenLista.clear();
                elemenDB.getElements(cateTemp.getId()).stream().map((elemento) -> {
                    this.elemenLista.add(elemento);
                    return elemento;
                }).forEachOrdered((elemento) -> {
                    this.filtroYAcomodamiento(elemento);
                });
            }
            
            this.principal.getBtSizeX1().setForeground(new Color(255, 153, 51));
            this.principal.getBtSizeX2().setForeground(Color.YELLOW);
            this.principal.getBtSizeX3().setForeground(new Color(255, 153, 51));
            this.principal.getBtSizeX4().setForeground(new Color(255, 153, 51));
            
            this.principal.getBtSizeX1().setEnabled(true);
            this.principal.getBtSizeX2().setEnabled(false);
            this.principal.getBtSizeX3().setEnabled(true);
            this.principal.getBtSizeX4().setEnabled(true);
        
        });
        
        this.principal.getBtSizeX3().addActionListener(al -> {
            this.dmnsX = this.sizeViewWidht * 3;
            this.dmnsY = this.sizeViewHeight * 3;

            this.principal.getPanelImagenes().removeAll();

            if(!elemenLista.isEmpty()) {
                this.elemenLista.clear();
                elemenDB.getElements(cateTemp.getId()).stream().map((elemento) -> {
                    this.elemenLista.add(elemento);
                    return elemento;
                }).forEachOrdered((elemento) -> {
                    this.filtroYAcomodamiento(elemento);
                });
            }
            
            this.principal.getBtSizeX1().setForeground(new Color(255, 153, 51));
            this.principal.getBtSizeX2().setForeground(new Color(255, 153, 51));
            this.principal.getBtSizeX3().setForeground(Color.YELLOW);
            this.principal.getBtSizeX4().setForeground(new Color(255, 153, 51));
            
            this.principal.getBtSizeX1().setEnabled(true);
            this.principal.getBtSizeX2().setEnabled(true);
            this.principal.getBtSizeX3().setEnabled(false);
            this.principal.getBtSizeX4().setEnabled(true);
        
        });
        
        this.principal.getBtSizeX4().addActionListener((ActionEvent al) -> {
                this.dmnsX = this.sizeViewWidht * 4;
                this.dmnsY = this.sizeViewHeight * 4;

                this.principal.getPanelImagenes().removeAll();

                if(!elemenLista.isEmpty()) {
                    this.elemenLista.clear();
                    elemenDB.getElements(cateTemp.getId()).stream().map((elemento) -> {
                        this.elemenLista.add(elemento);
                        return elemento;
                    }).forEachOrdered((elemento) -> {
                        this.filtroYAcomodamiento(elemento);
                    });
                }
                
                
            this.principal.getBtSizeX1().setForeground(new Color(255, 153, 51));
            this.principal.getBtSizeX2().setForeground(new Color(255, 153, 51));
            this.principal.getBtSizeX3().setForeground(new Color(255, 153, 51));
            this.principal.getBtSizeX4().setForeground(Color.YELLOW);
                
            this.principal.getBtSizeX1().setEnabled(true);
            this.principal.getBtSizeX2().setEnabled(true);
            this.principal.getBtSizeX3().setEnabled(true);
            this.principal.getBtSizeX4().setEnabled(false);
        
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
            
            this.cateTemp = this.prinDB.getCategory().stream().filter(cate -> selected.equals(cate.getName()))
                    .findAny().orElse(null);            
            
            this.elemenLista = this.elemenDB.getElements(cateTemp.getId());            
            
            this.principal.getPanelImagenes().removeAll();
            this.principal.getPanelImagenes().updateUI();
            
            this.elemenLista.stream().forEach(elem -> {
                filtroYAcomodamiento(elem);
            });            
            
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
                Image imagenReescalada = buffImag.getScaledInstance(this.dmnsX - 2, this.dmnsY - 2, Image.SCALE_SMOOTH);

                this.elemenVista = new ElementoVista(new ImageIcon(imagenReescalada));

                this.elemenVista.addTitulo(e.getNombre());
                this.elemenVista.addDescripcion(e.getDescripcion());
                acomodarElementos(this.elemenVista);
                
            } catch (IOException ex) {
                Logger.getLogger(PrincipalEvents.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.elemenVista = new ElementoVista("Image not found.");
            this.elemenVista.addTitulo(e.getNombre());
            this.elemenVista.addDescripcion(e.getDescripcion());
            acomodarElementos(this.elemenVista);
        }
        
    }
    
    private void filtrarElementos(KeyEvent ke) {
        String txtBuscar = this.principal.getTfBuscar().getText().toLowerCase();
        int cantElementos = this.principal.getPanelImagenes().getComponentCount();
        
        for (int i = 0; i < cantElementos; i++) {
        ElementoVista EP = (ElementoVista)this.principal.getPanelImagenes().getComponent(i);
        String nombre = EP.getTxtTitulo().getText().toLowerCase();
        
        if(!nombre.startsWith(txtBuscar) && !nombre.endsWith(txtBuscar)) {
            EP.setVisible(false);
        }
        
        if(txtBuscar.isEmpty()) {
            EP.setVisible(true);
        }
        
            
            
            
        }
        
        this.principal.getPanelImagenes().updateUI();
        
    }

    
    
}
