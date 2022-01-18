
package tienda.servicios;

import java.util.Collection;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ProductoServicio {
   
    private ProductoDAO dao;

    public ProductoServicio() {
        this.dao = new ProductoDAO();
    }
    
    public void crearProducto(int codigo, String nombre, double precio, int codigoFabricante) throws Exception{
    
        try {
            if(nombre==null){
            
            throw new Exception("Tiene que indicar un nombre para el producto");
            }
          
            Producto producto = new Producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);
            
            dao.guardarProducto(producto);
            
        } catch (Exception e) {
            throw e;
        }
    
    
    
    }
    
    public Collection<Producto>buscarProductos(String nombre) throws Exception{
    
        try {
            
            Collection<Producto> productos = dao.buscarProductos(nombre);
            
            return productos;
            
        } catch (Exception e) {
            throw e;
        }
    
    }
    
    public Collection <Producto>listarProductos() throws Exception{
        try {            
            Collection<Producto> lista = dao.listarProductos();
            
               return lista;
               
        } catch (Exception e) {
            throw e;
        }  
    }
    
    public Collection <Producto>listarNombresProductos() throws Exception{
        try {            
            Collection<Producto> lista = dao.listarNombreProductos();
            
               return lista;
               
        } catch (Exception e) {
            throw e;
        }  
    }
    
    public Collection <Producto> listarEntre() throws Exception{
    
        try {
            Collection<Producto>lista = dao.listaPrecio();
            return lista;
            
        } catch (Exception e) {
            throw e;
        }
    
    }
    
    public Producto mostrarMasBarato () {
    
      
            
            Producto producto = dao.buscaProductoBarato();
            return producto;
   
    
    }
    
    public void imprimirProductos () throws Exception{
    
    try {

            //Listamos los usuarios
            Collection<Producto> productos = listarProductos();

            //Imprimimos los usuarios
            if (productos.isEmpty()) {
                throw new Exception("No existen usuarios para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    
    }
//     public void mostrarEnPantalla () throws Exception{               COMO CREAR UN METODO PARA MOSTRAR EN PANTALLA TODO LO QUE BUSCO 
//                                                                      O TRAIGO AL MAIN EN UN ARRAYLIST, ¿COMO ENVIAR UN ARRAYLIST POR PARAMETRO?
//    try {
//
//            //Listamos los usuarios
//            Collection<Producto> productos = listarProductos();
//
//            //Imprimimos los usuarios
//            if (productos.isEmpty()) {
//                throw new Exception("No existen usuarios para imprimir");
//            } else {
//                for (Producto p : productos) {
//                    System.out.println(p);
//                }
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//    
    
}
