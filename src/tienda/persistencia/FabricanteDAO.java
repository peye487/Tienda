
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
        
    public Fabricante buscarFabricante (String nombre) throws Exception{
    
        try {
            
            String sql = "SELECT * FROM Fabricante" +               // Las comillas dobles "" son para guardar el String en la variable
                         " WHERE nombre = '" + nombre + "'";        // Y las comillas SIMPLES ' son las correspondiente a MYSQL, son las que van    
            consultarBase(sql);                                     // a formar el comando en MySQL como lo veniamos haciendo cdo queriamos especificar 
                                                                    // un "nombre" en particular.
            Fabricante fabricante = null;
            
            while (resultado.next()) {

            fabricante = new Fabricante();            
            fabricante.setCodigo(resultado.getInt(1));
            fabricante.setNombre(resultado.getString(2));           // Esto es para un solo resultado, para mas resultados usamos "ArrayList"
                        
            }
            
            desconectarBase();      //tener en cuenta que quede fuera del while, SINO se desconectaría la base de datos cuando de una vuelta
            return fabricante;      // El return si se pone en lugar equivocado nos indica error NetBeans
          
        } catch (Exception e) {
            desconectarBase();            
            throw e;
        }
    
    }
}
