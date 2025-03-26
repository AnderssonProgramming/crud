// package edu.eci.cvds.crud;


// import edu.eci.cvds.crud.Producto;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// import java.util.ArrayList;
// import java.util.List;





// public class ProductoServiceTest {

//     private ProductoService productoService;

//     @BeforeEach
//     public void setUp() {
//         productoService = new ProductoServiceDummy();
//     }

//     @Test
//     public void testCrearYConsultarProducto() {
//         // Initially, the list should be empty.
//         assertTrue(productoService.consultarProductos().isEmpty());

//         // Create a new product.
//         // productoService.crearProducto("Producto1", 100.0, "Descripcion1");
//         // List<Producto> productos = productoService.consultarProductos();
//         // assertEquals(1, productos.size());

//         // Retrieve the product using its id.
//         Producto p = productos.get(0);
//         Producto retrieved = productoService.consultarProducto(p.getId());
//         assertNotNull(retrieved);
//         assertEquals("Producto1", retrieved.getNombre());
//         assertEquals(100.0, retrieved.getPrecio(), 0.001);
//         assertEquals("Descripcion1", retrieved.getDescripcion());
//     }

//     @Test
//     public void testActualizarProducto() {
//         // Create a product.
//         productoService.crearProducto("Producto2", 200.0, "Descripcion2");
//         Producto p = productoService.consultarProductos().get(0);

//         // Create a DTO with updated data.
//         ProductoDTO dto = new ProductoDTO("Producto2Updated", 250.0, "Descripcion2Updated");
//         productoService.actualizarProducto(p.getId(), dto);

//         // Check that the product has been updated.
//         Producto updated = productoService.consultarProducto(p.getId());
//         assertNotNull(updated);
//         assertEquals("Producto2Updated", updated.getNombre());
//         assertEquals(250.0, updated.getPrecio(), 0.001);
//         assertEquals("Descripcion2Updated", updated.getDescripcion());
//     }

//     @Test
//     public void testEliminarProducto() {
//         // Create a product.
//         productoService.crearProducto("Producto3", 300.0, "Descripcion3");
//         Producto p = productoService.consultarProductos().get(0);
//         assertNotNull(productoService.consultarProducto(p.getId()));

//         // Delete the product.
//         productoService.eliminarProducto(p.getId());
//         // assertNull(productoService.consultarProducto(p.getId()));
//         assertTrue(productoService.consultarProductos().isEmpty());
//     }

//     // Dummy implementation of ProductoService for testing purposes.
//     private class ProductoServiceDummy implements ProductoService {
//         private List<Producto> productos = new ArrayList<>();
//         private int idCounter = 1;

//         @Override
//         public List consultarProductos() {
//             return new ArrayList<>(productos);
//         }

//         @Override
//         public edu.eci.cvds.crud.Producto consultarProducto(String idProducto) {
//             for (Producto p : productos) {
//                 if (p.getId().equals(idProducto)) {
//                     return p;
//                 }
//             }
//             return null;
//         }

//         @Override
//         public void crearProducto(String nombre, double precio, String descripcion) {
//             Producto p = new Producto(String.valueOf(idCounter++), nombre, precio, descripcion);
//             productos.add(p);
//         }

//         @Override
//         public void actualizarProducto(String idProducto, ProductoDTO productoDTO) {
//             for (int i = 0; i < productos.size(); i++) {
//                 Producto p = productos.get(i);
//                 if (p.getId().equals(idProducto)) {
//                     p.setNombre(productoDTO.getNombre());
//                     p.setPrecio(productoDTO.getPrecio());
//                     p.setDescripcion(productoDTO.getDescripcion());
//                     productos.set(i, p);
//                     break;
//                 }
//             }
//         }

//         @Override
//         public void eliminarProducto(String idProducto) {
//             productos.removeIf(p -> p.getId().equals(idProducto));
//         }
//     }

//     // Minimal dummy implementation of Producto.
//     private class Producto {
//         private String id;
//         private String nombre;
//         private double precio;
//         private String descripcion;

//         public Producto(String id, String nombre, double precio, String descripcion) {
//             this.id = id;
//             this.nombre = nombre;
//             this.precio = precio;
//             this.descripcion = descripcion;
//         }

//         public String getId() {
//             return id;
//         }

//         public String getNombre() {
//             return nombre;
//         }

//         public void setNombre(String nombre) {
//             this.nombre = nombre;
//         }

//         public double getPrecio() {
//             return precio;
//         }

//         public void setPrecio(double precio) {
//             this.precio = precio;
//         }

//         public String getDescripcion() {
//             return descripcion;
//         }

//         public void setDescripcion(String descripcion) {
//             this.descripcion = descripcion;
//         }
//     }

//     // Minimal dummy implementation of ProductoDTO.
//     private class ProductoDTO {
//         private String nombre;
//         private double precio;
//         private String descripcion;

//         public ProductoDTO(String nombre, double precio, String descripcion) {
//             this.nombre = nombre;
//             this.precio = precio;
//             this.descripcion = descripcion;
//         }

//         public String getNombre() {
//             return nombre;
//         }

//         public double getPrecio() {
//             return precio;
//         }

//         public String getDescripcion() {
//             return descripcion;
//         }
//     }
// }