
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;

public final class ProductoDAO extends DAO {
    
    public void guardarProducto (Producto producto) throws Exception{
    
        try {
            if(producto == null){
            
            throw new Exception ("Debe indicar un Producto");
            }
           
            String sql = "INSERT INTO Producto(codigo,nombre,precio,codigo_fabricante)"
                    + "VALUES ( '" + producto.getCodigo() + "' , '" + producto.getNombre() +"', '"+ producto.getPrecio() + "' , '" + producto.getCodigoFabricante()+ "');";
            insertarModificarEliminar(sql);
           
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarProducto(Producto producto) throws Exception{
    
        try {
            if(producto == null){
            throw new Exception ("Debe indicar un Producto");            
            }
            
            String sql = "UPDATE Producto SET"
                    + "Nombre = '" + producto.getNombre() + "' WHERE Nombre = '" + producto.getNombre() + "');"; // COMO CONTINÚA ???? VERIFICAR SI ESTA BIEN
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
    
    }
   
    public void eleminarProducto(String nombre) throws Exception{    
    
        try {
            String sql = "DELETE FROM Producto WHERE '" + nombre + "'";
    
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
        
    
    
    }
    
    public Collection <Producto> buscarProductos(String nombre) throws Exception{
        try {
            
            String sql = "SELECT * FROM Producto WHERE nombre LIKE '%" + nombre + "%'";
            consultarBase(sql);
            
            Producto producto = null;
            Collection <Producto> productos = new ArrayList();
            
            while (resultado.next()) { 
                
                producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                
                productos.add(producto);                         // Lo hago así por que puedo tener varios prodcutos con el mismo nombre
                                                                // por lo tanto los voy guardando en un ArrayList.                
            }
            desconectarBase();
            return productos;
            
        } catch (Exception e) {
            throw e;
        }
        
}
    
    public Collection <Producto> listarProductos() throws Exception{
    
        try {
            
              String sql = "SELECT * FROM producto";
              consultarBase(sql);
              
              Producto producto = null;
            Collection <Producto> productos = new ArrayList();
            
            while (resultado.next()) { 
                
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                
                productos.add(producto);             
                }             
            desconectarBase();
            return productos;            
        }
            catch (Exception e) {
               throw e;
                }
        }
    
    public Collection <Producto> listarNombreProductos() throws Exception{
    
        try {
            
              String sql = "SELECT nombre FROM producto";
              consultarBase(sql);
              
              Producto producto = null;
            Collection <Producto> productos = new ArrayList();
            
            while (resultado.next()) { 
                
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                
                productos.add(producto);             
                }             
            desconectarBase();
            return productos;            
        }
            catch (Exception e) {
               throw e;
                }
        }
         
    public Collection <Producto> listaPrecio () throws Exception{
        try {
            
            String sql = "SELECT nombre, precio FROM producto "+
                         "WHERE precio BETWEEN 120 AND 202;";
            
            consultarBase(sql);
            
            Producto producto = null;
            Collection <Producto> productos = new ArrayList();
            
            while (resultado.next()) {
                
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                
                productos.add(producto);              
            }
            desconectarBase();
            return productos;
            
        } catch (Exception e) {
//            throw e;
            System.out.println(e.getMessage());
            return null;
        }    
    }
    
    public Producto buscaProductoBarato () {
    
        try {
            
            String sql = "SELECT nombre,precio FROM producto ORDER BY precio ASC LIMIT 1;";
            consultarBase(sql);
            
            Producto producto = null;
            
            while (resultado.next()){
                
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));            
            }
            desconectarBase();
            return producto;
            
        } catch (Exception e) {
          System.out.println(e.getMessage());
          return null;
        }
    
    }
    
    
}
