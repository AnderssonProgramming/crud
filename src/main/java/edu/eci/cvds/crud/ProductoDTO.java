package edu.eci.cvds.crud;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

/**
 * Data Transfer Object para Producto.
 */
public class ProductoDTO {

    private String idProducto;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Positive(message = "El precio debe ser mayor que cero")
    private double precio;

    private String descripcion;

    /**
     * Constructor por defecto.
     */
    public ProductoDTO() {
    }

    /**
     * Constructor para crear un producto (sin id).
     * 
     * @param nombre      nombre del producto
     * @param precio      precio del producto
     * @param descripcion descripción del producto
     */
    public ProductoDTO(String nombre, double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    /**
     * Constructor para actualizar un producto (incluye id).
     * 
     * @param idProducto  identificador del producto
     * @param nombre      nombre del producto
     * @param precio      precio del producto
     * @param descripcion descripción del producto
     */
    public ProductoDTO(String idProducto, String nombre, double precio, String descripcion) {
        this.idProducto = idProducto;
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

