
package tienda.persistencia;

import tienda.entidades.Fabricante;

public final class FabricanteDAO extends DAO{
    
    public void guardarFabricante(Fabricante fabricante) throws Exception{
    
        try {
            if(fabricante == null){
            throw new Exception ("Debe indicar un fabricante");            
            }
            
            String sql = "INSERT INTO Fabricante(Codigo,Nombre)"
                    + "VALUES ( '" + fabricante.getCodigo() + "' , '" + fabricante.getNombre() + "');";
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
    
    }
    
    public void modificarFabricante(Fabricante fabricante) throws Exception{
    
        try {
            if(fabricante == null){
            throw new Exception ("Debe indicar un fabricante");            
            }
            
            String sql = "UPDATE Fabricante SET"
                    + "Nombre = '" + fabricante.getNombre() + "' WHERE Nombre = '" + fabricante.getNombre() + "');"; // VERIFICAR SI ESTA BIEN
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
    
    }
    
    public void eliminarFabricante(String nombre) throws Exception{
    
        try {
                       
            String sql = "DELETE FROM Fabricante WHERE Nombre = '" + nombre + "'" ; // VERIFICAR SI ESTA BIEN
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
    
    }
    
}
