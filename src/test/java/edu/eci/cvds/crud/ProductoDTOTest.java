package edu.eci.cvds.crud;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import edu.eci.cvds.crud.ProductoDTO;



class ProductoDTOTest {

    private static Validator validator;


    @Test
    public void testDefaultConstructor() {
        ProductoDTO producto = new ProductoDTO();
        assertNull(producto.getNombre());
        assertEquals(0.0, producto.getPrecio());
        assertNull(producto.getDescripcion());
    }

    @Test
    public void testConstructorWithoutId() {
        String nombre = "Producto A";
        double precio = 10.5;
        String descripcion = "Descripción A";
        ProductoDTO producto = new ProductoDTO(nombre, precio, descripcion);
        assertEquals(nombre, producto.getNombre());
        assertEquals(precio, producto.getPrecio());
        assertEquals(descripcion, producto.getDescripcion());
    }


    @Test
    public void testGettersAndSetters() {
        ProductoDTO producto = new ProductoDTO();
        producto.setNombre("Producto C");
        producto.setPrecio(30.0);
        producto.setDescripcion("Descripción C");

        assertEquals("Producto C", producto.getNombre());
        assertEquals(30.0, producto.getPrecio());
        assertEquals("Descripción C", producto.getDescripcion());
    }

}