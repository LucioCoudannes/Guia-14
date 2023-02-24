package Servicio;

import Entidades.Autor;
import Entidades.Libro;
import Persistencia.AutorDAO;
import Persistencia.LibroDAO;
import java.util.List;
//import Persistencia.DAO;
import java.util.Scanner;
import java.util.UUID;

public class AutorService {

    AutorDAO AD = new AutorDAO();
    LibroDAO ld = new LibroDAO();

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
    
    public List <Autor> imprimirAutores(){
        
        List <Autor> au = AD.mostrarAutores();
        
        
        
        for (int i = 0; i < au.size(); i++) {
            
            System.out.println((i+1) + ". " + au.get(i).getNombre());
            
        }
        
        System.out.println((au.size()+1) + ". Crear autor");
        
        return au;
        
    }
    
    public void editarAutor(){
        
        System.out.println("Indique el numero del Autor");
        List <Autor> al = imprimirAutores();
        int op = leer.nextInt()-1;
        
        Autor aux = buscarAutorPorNombre(al.get(op).getNombre());
        
        System.out.println("Ingrese el nuevo nombre de Autor");
        aux.setNombre(leer.next());
       
        AD.editar(aux);
        
    }
    
    public void eliminarAutor(){
        
        System.out.println("Indique el numero del Autor");
        List <Autor> al = imprimirAutores();
        int op = leer.nextInt()-1;
        
        List<Libro> lib = ld.buscarPorAutor(al.get(op).getNombre());
        
        System.out.println("Se eleminaran los siguientes libros asociados al autor");
        
        for (Libro libro : lib) {
            
            System.out.println(libro.getTitulo());
            
        }
        
        for (int i = 0; i < lib.size(); i++) {
            
            ld.eliminar(lib.get(i));
            
        }
        
        AD.eliminar(buscarAutorPorNombre(al.get(op).getNombre()));
        
        
        
    }
    
   

}
