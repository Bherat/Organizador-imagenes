package controller;

import model.PrincipalDB;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.NCategoria;
import view.Principal;

/**
 *
 * @author Foo
 */
public class NCategoriaEvents {
    
    Principal principal;
    NCategoria nuevCategoria;
    PrincipalDB prinDB;

    public NCategoriaEvents(Principal principal, NCategoria nCate) {
        this.principal = principal;
        this.prinDB = new PrincipalDB();
        this.nuevCategoria = nCate;
        
        acciones();
    }
    
    private void acciones() 
    {
        this.nuevCategoria.getBtAceptar().addActionListener((ae) -> 
            addCategoryToCB(ae));
        
        this.nuevCategoria.getBtCancelar().addActionListener(ae ->
            cancelEvent(ae));
    }
    
    private void addCategoryToCB(ActionEvent ae)
    {
        String contenedor = String.valueOf(this.nuevCategoria.getFieldNombre().getText());
        String categoriaSelec = String.valueOf(this.principal.getCBModel().getSelectedItem());
        int id = this.prinDB.getLastId() + 1;
        
        
        if(id != -1) {
            if(!contenedor.isEmpty()) {
                int registro = this.prinDB.addCategory(id, contenedor);
                if(registro == 1) {
                    JOptionPane.showMessageDialog(this.principal, "Categoria agregada correctamente.");
                    this.nuevCategoria.getFieldNombre().setText("");

                    this.principal.getCBModel().removeAllElements();
                    this.prinDB.getCategory().stream().forEach(cate -> this.principal.getCBModel().addElement(cate.getName()));

                    this.nuevCategoria.dispose();
                    this.principal.getBtAgregarCategoria().setEnabled(true);

                    if(!categoriaSelec.equals("null") && categoriaSelec.equals("Seleccione una categoria")) {
                        this.principal.getBtAgregarElemento().setEnabled(true);
                        this.principal.getBtEliminarElemento().setEnabled(true);
                    }
                } else if(registro == -1) {
                    JOptionPane.showMessageDialog(this.nuevCategoria, "Ya hay una categoria con el mismo nombre.");
                }
                System.out.println(registro);
            } else JOptionPane.showMessageDialog(this.nuevCategoria, "Indique un nombre para la categoria");
        } else JOptionPane.showMessageDialog(this.nuevCategoria, "Error al conectar a la base de datos.");
    }
    
    private void cancelEvent(ActionEvent ae)
    {
        String categoriaSelec = String.valueOf(this.principal.getCBModel().getSelectedItem());
        
        this.principal.getBtAgregarCategoria().setEnabled(true);
        if(!categoriaSelec.equals("null") && !categoriaSelec.equals("Seleccione una categoria")) {
            this.principal.getBtEliminarCategoria().setEnabled(true);
            this.principal.getBtAgregarElemento().setEnabled(true);
            this.principal.getBtEliminarElemento().setEnabled(true);
        }
        
        this.nuevCategoria.dispose();
    }
    
    
    
}
