package model;

import java.io.InputStream;

/**
 *
 * @author Foo
 */
public class Elementos {
    
    private int id;
    private String nombre;
    private String descripcion;
    private InputStream imagen;
    private int idCategoria;
    private String link;

    public Elementos() {
    }

    public Elementos(int id, String nombre, String descripcion, InputStream imagen, int idCategoria, String link) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.idCategoria = idCategoria;
        this.link = link;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public InputStream getImagen() {
        return imagen;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getLink() {
        return link;
    }
    
    public int getId() {
        return this.id;
    }
    
    
    public String mostrar() {
        return this.id + "/" + this.nombre + "/" + this.descripcion + "/" + this.imagen + "/" + this.idCategoria + "/" + this.link + "";
    }
    
    
}
