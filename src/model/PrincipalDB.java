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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Foo
 */
public class PrincipalDB {
    
    private final String DB_URL = "jdbc:sqlite:datos.db";
    
    public PrincipalDB() {
    }
    
    
    
    public int addCategory(int id, String name) 
    {
        
        int rstaRegistro = -1;
        
        try(Connection accessDB = DriverManager.getConnection(DB_URL);
            PreparedStatement ps = accessDB.prepareStatement("INSERT INTO categorias(Id ,Nombre) VALUES (?, ?)")) {
            ps.setInt(1, id);
            ps.setString(2, name);
            rstaRegistro = ps.executeUpdate();
            
        } catch(SQLException SQLEx) {
            System.out.println(SQLEx.getMessage());
        }
        
        return rstaRegistro; 
    }
    
    public int deleteCategory(String name) 
    {
        
        int resultado = -1;
        
        try(Connection accessDB = DriverManager.getConnection(DB_URL);
            PreparedStatement ps = accessDB.prepareStatement("DELETE FROM categorias WHERE Nombre = ?")) {
            ps.setString(1, name);
            
            resultado = ps.executeUpdate();

        } catch(SQLException SQLEx) {
            JOptionPane.showMessageDialog(null, SQLEx.getMessage());
        }
        
        return resultado;
    }
    
    public List<Categorias> getCategory() 
    {
        List<Categorias> lista = new ArrayList<>();
        
        try(Connection accessDB = DriverManager.getConnection(DB_URL);
            PreparedStatement ps = accessDB.prepareStatement("SELECT * FROM categorias");
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                lista.add(new Categorias(rs.getInt("Id"), rs.getString("Nombre")));
            }
            
            
        } catch(SQLException SQLEx) {
            JOptionPane.showMessageDialog(null, SQLEx.getMessage());
        }
        
        return lista;
    }
    
        public int getLastId() {
        int id = -1;
        
        try(Connection accessDB = DriverManager.getConnection(DB_URL);
            PreparedStatement ps = accessDB.prepareStatement("Select Id FROM categorias");
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
