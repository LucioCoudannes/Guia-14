
package Servicio;


import Entidades.Editorial;
import Entidades.Libro;
import Persistencia.EditorialDAO;
import Persistencia.LibroDAO;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


public class EditorialService {
    
    EditorialDAO ED = new EditorialDAO();
    LibroDAO ld = new LibroDAO();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public Editorial crearEditorial (){
        
        Editorial edi = new Editorial();
        
         try {
            
            edi.setId(UUID.randomUUID().toString());
            System.out.println("ingrese el nombre de la editorial");
            edi.setNombre(leer.next());
            edi.setAlta(true);
            ED.guardar(edi);
         
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return edi;
    }
    
    public Editorial buscarEditorialPorNombre(String nombreE) {
            
        
                
        try{
             if(nombreE.equalsIgnoreCase(ED.buscarPorNombre(nombreE).getNombre())){
                return ED.buscarPorNombre(nombreE);
            }else return crearEditorial();
            
        }catch (Exception e){
            System.out.println("La editorial no existe, ingresela nuevamente para guardarla");
            return crearEditorial();
        }
        
       
        
    }
    
    public List <Editorial> imprimirEditoriales(){
        
        List <Editorial> el = ED.mostrarEditoriales();
        
        for (int i = 0; i < el.size(); i++) {
            
            System.out.println((i+1) + ". " + el.get(i).getNombre());
            
        }
        System.out.println((el.size()+1) + ". Crear editorial");
        
        return el;
        
    }
    
    public void editarEditorial(){
        
        System.out.println("Indique el numero de la Editorial");
        List <Editorial> al = imprimirEditoriales();
        int op = leer.nextInt()-1;
        
        Editorial aux = buscarEditorialPorNombre(al.get(op).getNombre());
        
        System.out.println("Ingrese el nuevo nombre de la Editorial");
        aux.setNombre(leer.next());
       
        ED.editar(aux);
        
    }
    
    public void eliminarEditorial(){
        
        System.out.println("Indique el numero de la Editorial");
        List <Editorial> al = imprimirEditoriales();
        int op = leer.nextInt()-1;
        
        List<Libro> lib = ld.buscarPorEditorial(al.get(op).getNombre());
        
        System.out.println("Se eleminaran los siguientes libros asociados a la Editorial");
        
        for (Libro libro : lib) {
            
            System.out.println(libro.getTitulo());
            
        }
        
        for (int i = 0; i < lib.size(); i++) {
            
            ld.eliminar(lib.get(i));
            
        }
        
        ED.eliminar(buscarEditorialPorNombre(al.get(op).getNombre()));
        
    }
    
    
    
}
