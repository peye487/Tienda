
package tienda.servicios;

import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public class FabricanteServicio {
    
    private FabricanteDAO dao;

    public FabricanteServicio() {
        
        this.dao = new FabricanteDAO();
        
    }
    
    public void crearFabricante(int codigo,String nombre) throws Exception{
    
        try {
            
             if(nombre == null  || nombre.trim().isEmpty()){
        
            throw new Exception ("Debe idicar un nombre para el fabricante");
            }
       
             if(dao.buscarFabricante(nombre)!=null){
        
            throw new Exception ("Ya existe un Fabricante con el nombre indicado");
        }
            
             Fabricante fabricante = new Fabricante();
             fabricante.setCodigo(codigo);
             fabricante.setNombre(nombre);
             dao.guardarFabricante(fabricante);
             
        } catch (Exception e) {
            
            throw e;
        }
       
        
        
    }
    
    public Fabricante buscarFabricante(String nombre) throws Exception{
    
        Fabricante fabricante = dao.buscarFabricante(nombre);
        
        return fabricante;
    
    
    }
}
