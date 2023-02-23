
package Servicio;


import Entidades.Editorial;
import Persistencia.EditorialDAO;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


public class EditorialService {
    
    EditorialDAO ED = new EditorialDAO();
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
    
    public void imprimirEditoriales(){
        
        List <Editorial> el = ED.mostrarEditoriales();
        
        
        
        for (int i = 0; i < el.size(); i++) {
            
            System.out.println((i+1) + ". " + el.get(i).getNombre());
            
        }
        System.out.println((el.size()+1) + ". Crear editorial");
        
    }
    
}
