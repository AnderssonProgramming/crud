package edu.eci.cvds.crud;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.eci.cvds.crud.Producto;




public class ProductoTest {

    @Test
    public void testDefaultConstructor() {
        Producto producto = new Producto();
        assertNull(producto.getNombre());
        assertEquals(0.0, producto.getPrecio());
        assertNull(producto.getDescripcion());
    }

    @Test
    public void testParameterizedConstructor() {
        String nombre = "Producto1";
        double precio = 15.75;
        String descripcion = "Descripcion del producto";
        Producto producto = new Producto(nombre, precio, descripcion);
        
        // idProducto remains unassigned until set
        assertEquals(nombre, producto.getNombre());
        assertEquals(precio, producto.getPrecio());
        assertEquals(descripcion, producto.getDescripcion());
    }

    @Test
    public void testGettersAndSetters() {
        Producto producto = new Producto();
        String nombre = "Producto2";
        double precio = 20.0;
        String descripcion = "Otra descripcion";

        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setDescripcion(descripcion);

        assertEquals(nombre, producto.getNombre());
        assertEquals(precio, producto.getPrecio());
        assertEquals(descripcion, producto.getDescripcion());
    }
}