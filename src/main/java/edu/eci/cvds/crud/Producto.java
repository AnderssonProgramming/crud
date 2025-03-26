package edu.eci.cvds.crud;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa el modelo de un producto para la colección "productos".
 */
@Document(collection = "productos")
public class Producto {

    @Id
    private String idProducto;
    private String nombre;
    private double precio;
    private String descripcion;

    /**
     * Constructor por defecto.
     */
    public Producto() {
    }

    /**
     * Constructor para crear un producto.
     * 
     * @param nombre      nombre del producto
     * @param precio      precio del producto
     * @param descripcion descripción del producto
     */
    public Producto(String nombre, double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    // Getters y Setters

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

// http://localhost:8080/swagger-ui/index.html#/