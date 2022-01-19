package tienda;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.servicios.FabricanteServicio;
import tienda.servicios.ProductoServicio;

public class Tienda {

    public static void main(String[] args) throws Exception {

        Scanner leer = new Scanner(System.in);

        ProductoServicio prodServ = new ProductoServicio();
        FabricanteServicio fabServ = new FabricanteServicio();
        
        try {
            
            prodServ.crearProducto(9, "Auriculares NICO", 470, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        Producto p = prodServ.mostrarMasBarato();

        if (p != null) {
            System.out.println("PRODUCTO MÁS BARATO DE LA LISTA");
            System.out.println(p);
        } else {
            System.out.println("NO se encontró ningun producto");
        }

        try {
//           
            System.out.println("Ingrese nombre de producto que busca");
            String producto = leer.next();
            
             Collection <Producto> busca = prodServ.buscarProductos(producto);
           
             for (Producto producto1 : busca) {
                 System.out.println(producto1);
                
            }
         
            
//       LISTAR ENTRE 120 y 202
            System.out.println("Lista de productos entre $120 y $202 ");
            System.out.println(prodServ.listarEntre());                     // LO PUEDO HACER ASI PERO ME MUESTRA TODO LOS PRODUCTOS EN LA MISMA LÍNEA
            
            System.out.println("=========================");
            Collection <Producto> lista = prodServ.listarEntre();           //LO REALIZO ASÍ, GUARDANDO EL RESULTADO EN OTRO ARRAYLIST Y LO 
                                                                            //IMPRIMO CON UN FOR EACH PARA QUE QUEDE MAS PROLIJO.
            for (Producto prod : lista) {
                System.out.println(prod);
                System.out.println("===========================");
            }   
            

            prodServ.imprimirProductos();
//            System.out.println(prodServ.listarProductos());
//            prodServ.buscarProductos(producto);
//            prodServ.imprimirProductos();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //CREAR FABRICANTE
        try {
            System.out.println("Ingrese nombre del Fabricante");
            String nomFab = leer.next();
            System.out.println("Ingrese codigo de fabricante");
            int codFab = leer.nextInt();
            fabServ.crearFabricante(codFab, nomFab);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //BUSCAR FABRICANTE
        try {
            System.out.println("Ingrese nombre de fabricante a buscar");
            String nombre = leer.next();
            System.out.println(fabServ.buscarFabricante(nombre));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

}
