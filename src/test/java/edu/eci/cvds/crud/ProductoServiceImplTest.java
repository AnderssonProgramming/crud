package edu.eci.cvds.crud;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import edu.eci.cvds.crud.Producto;






class ProductoServiceImplTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoServiceImpl productoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsultarProductos() {
        List<Producto> productos = Arrays.asList(
            new Producto("Producto1", 10.0, "Desc1"),
            new Producto("Producto2", 20.0, "Desc2")
        );
        when(productoRepository.findAll()).thenReturn(productos);
        List<Producto> result = productoService.consultarProductos();
        assertEquals(2, result.size());
        verify(productoRepository).findAll();
    }



    @Test
    void testCrearProducto() {
        String nombre = "ProductoNuevo";
        double precio = 30.0;
        String descripcion = "Nueva descripcion";
        productoService.crearProducto(nombre, precio, descripcion);
        ArgumentCaptor<Producto> productoCaptor = ArgumentCaptor.forClass(Producto.class);
        verify(productoRepository).save(productoCaptor.capture());
        Producto savedProducto = productoCaptor.getValue();
        assertEquals(nombre, savedProducto.getNombre());
        assertEquals(precio, savedProducto.getPrecio());
        assertEquals(descripcion, savedProducto.getDescripcion());
    }


}