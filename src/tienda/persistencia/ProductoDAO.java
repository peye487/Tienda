
package tienda.persistencia;

import tienda.entidades.Producto;

public final class ProductoDAO extends DAO {
    
    public void guardarProducto (Producto producto) throws Exception{
    
        try {
            if(producto == null){
            
            throw new Exception ("Debe indicar un Producto");
            }
           
            
            
        } catch (Exception e) {
            throw e;
        }
    }
    
}
