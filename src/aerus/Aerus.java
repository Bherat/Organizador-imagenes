/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerus;

import controller.NCategoriaEvents;
import model.PrincipalDB;
import controller.PrincipalEvents;
import controller.UIElementosEvents;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.CreacionDeDataBase;
import model.ElementosDB;
import view.NCategoria;
import view.Principal;
import view.UIElementosModel;

/**
 *
 * @author Foo
 */
public class Aerus {
    public static void main(String[] args) {
        
        //Views
        Principal principal = new Principal();
        NCategoria cate = new NCategoria();
        
        //Model
        CreacionDeDataBase newDB = new CreacionDeDataBase();
        UIElementosModel UIElem = new UIElementosModel();
        
        //Events
        PrincipalEvents prinEvents = new PrincipalEvents(principal, cate, UIElem);
        PrincipalDB prinDB = new PrincipalDB();
        NCategoriaEvents cateEvents = new NCategoriaEvents(principal, cate);
        ElementosDB eleDB = new ElementosDB();
        UIElementosEvents UIElemEvents = new UIElementosEvents(principal, UIElem);
        
        //Creacion del trigger para eliminar la categoria y los elementos que contiene.
        newDB.crearTrigger();
        
        
        prinDB.getCategory().stream()
                .forEach(names -> principal.getCBModel().addElement(names.getName()));
        
        
        
        principal.getBtEliminarCategoria().setEnabled(false);
        principal.getBtAgregarElemento().setEnabled(false);
        principal.getBtEliminarElemento().setEnabled(false);
        
        principal.setLocationRelativeTo(null);
        principal.pack();
        principal.setVisible(true);
    }
    
}
