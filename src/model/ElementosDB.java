/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Foo
 */
public class ElementosDB {
    
    private final String DB_URL = "jdbc:sqlite:datos.db";
    
    public int addElement(int id, String name, String description, int idCateg, byte[] imagen, String Link) 
    {
        int resultado = -1;
        
        try(Connection accessDB = DriverManager.getConnection(DB_URL);
            PreparedStatement ps = accessDB.prepareStatement("INSERT INTO "
                    + "elementos(Id, Nombre, Descripcion, Imagen, idCategoria, Links) values (?, ?, ?, ?, ?, ?)")) {
            
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, description);
            ps.setBytes(4, imagen);
            ps.setInt(5, idCateg);
            ps.setString(6, Link);
            resultado = ps.executeUpdate();
            
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return resultado;
    }
        
        
    
    public ArrayList<Elementos> getElements(int idCategoria) 
    {
        ArrayList<Elementos> elemento = new ArrayList<>();
        try(Connection accessDB = DriverManager.getConnection(DB_URL);
            PreparedStatement ps = accessDB.prepareStatement("SELECT * FROM elementos WHERE idCategoria = ?")) {
            ps.setInt(1, idCategoria);
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    elemento.add(new Elementos(
                        rs.getInt("Id"),
                        rs.getString("Nombre"), 
                        rs.getString("Descripcion"),
                        rs.getBinaryStream("Imagen"),
                        rs.getInt("idCategoria"),
                        rs.getString("Links")));
                }
            }
            
        } catch(SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
        }
        return elemento;
    }
    
        
    public int getLastId() {
        int id = -1;
        
        try(Connection accessDB = DriverManager.getConnection(DB_URL);
            PreparedStatement ps = accessDB.prepareStatement("Select Id FROM elementos");
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                id = rs.getInt("Id");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
}
