
package Persistencia;

import Entidades.Autor;
import java.util.List;
import java.util.Scanner;



public class AutorDAO extends DAO<Autor>{
    
    
    
    
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    @Override
    public void guardar(Autor objeto){
      super.guardar(objeto);
    }
    
    @Override
    public void editar(Autor objeto){
       super.editar(objeto);
    }
    
    @Override
    public void eliminar(Autor objeto){
       super.eliminar(objeto);
    }
    
   
    
    public Autor buscarPorNombre(String nombre) {
        
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.Nombre like :nombre").setParameter("nombre", "%"+nombre+"%").getSingleResult();
        desconectar();
        return autor;
    }
    
    public List <Autor> mostrarAutores(){
          
        
        conectar();
        List <Autor> AuList = em.createQuery("SELECT a FROM Autor a ").getResultList();
        desconectar();
        return AuList;
      
        
    }
    
}
