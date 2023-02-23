package Servicio;

import Entidades.Autor;
import Persistencia.AutorDAO;
import java.util.List;
//import Persistencia.DAO;
import java.util.Scanner;
import java.util.UUID;

public class AutorService {

    AutorDAO AD = new AutorDAO();

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Autor crearAutor() {

        Autor autor = new Autor();

        try {

            autor.setId(UUID.randomUUID().toString());
            System.out.println("ingrese el nombre del autor");
            autor.setNombre(leer.next());
            autor.setAlta(true);
            AD.guardar(autor);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return autor;

    }

    public Autor buscarAutorPorNombre(String nombre) {

     
        try {
            if (nombre.equalsIgnoreCase(AD.buscarPorNombre(nombre).getNombre())) {
                return AD.buscarPorNombre(nombre);
            } else {
                return crearAutor();
            }
        } catch (Exception e) {
            System.out.println("El autor no existe, cargar autor nuevo");
            return crearAutor();
        }

    }
    
    public void imprimirAutores(){
        
        List <Autor> au = AD.mostrarAutores();
        
        
        
        for (int i = 0; i < au.size(); i++) {
            
            System.out.println((i+1) + ". " + au.get(i).getNombre());
            
        }
        
        System.out.println((au.size()+1) + ". Crear autor");
        
    }

}
