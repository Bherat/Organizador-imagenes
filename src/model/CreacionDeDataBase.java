/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Foo
 */
public class CreacionDeDataBase {

    private File file;
    
    private final String crearTablaCategorias = "Create TABLE IF NOT EXISTS categorias("
            + "Id INTEGER(4) NOT NULL,"
            + "Nombre VARCHAR(25) NOT NULL UNIQUE,"
            + "CONSTRAINT PK_Categorias PRIMARY KEY(Id)"
            + ");";
    
    private final String crearTablaElementos = "CREATE TABLE IF NOT EXISTS elementos("
            + "Id INTEGER(4) NOT NULL,"
            + "Nombre VARCHAR(70) NOT NULL,"
            + "Descripcion VARCHAR(500),"
            + "Imagen BLOB,"
            + "idCategoria INTEGER(4) NOT NULL,"
            + "Links LINK,"
            + "CONSTRAINT PK_Elementos PRIMARY KEY(Id)"
            //+ "CONSTRAINT FK_Elementos_Categorias FOREIGN KEY(Id) REFERENCES categorias(idCategoria) ON DELETE CASCADE"
            + ");";
    
    private final String crearTrigger = "CREATE TRIGGER [delete_categorias] "
            + "BEFORE DELETE ON categorias "
            + "FOR EACH ROW "
            + "BEGIN "
            + "DELETE FROM elementos WHERE elementos.idCategoria = old.Id; "
            + "END;";
    
    public CreacionDeDataBase() {
        file = new File(".\\datos.db");
        
        if(!file.exists()) {
            JOptionPane.showMessageDialog(null, "Creando base de datos...");
            try(Connection accesDB = DriverManager.getConnection("jdbc:sqlite:.\\datos.db");
                PreparedStatement ps = accesDB.prepareStatement(this.crearTablaCategorias);
                PreparedStatement ps2 = accesDB.prepareStatement(this.crearTablaElementos)) {
                    ps.execute();
                    ps2.execute();
                        
                    JOptionPane.showMessageDialog(null, "Base de datos creada.");
                
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        
    }
    
    public int crearTrigger() {
        
        int triggerRes = -1;
        
        try(Connection accessDB = DriverManager.getConnection("jdbc:sqlite:datos.db");
            PreparedStatement trigger = accessDB.prepareStatement(this.crearTrigger)) {
            triggerRes = trigger.executeUpdate();
        } catch(SQLException ex) {
            ex.getMessage();
        }
        
        return triggerRes;
    }
    
    
    
}
