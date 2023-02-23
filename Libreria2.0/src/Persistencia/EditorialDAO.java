
package Persistencia;

import Entidades.Editorial;
import java.util.List;



public class EditorialDAO extends DAO<Editorial>{
    
    @Override
    public void guardar(Editorial objeto){
        super.guardar(objeto);
    }
    
    @Override
    public void editar(Editorial objeto){
        super.editar(objeto);
    }
    
    @Override
    public void eliminar(Editorial objeto){
      super.eliminar(objeto);
    }
    
       public Editorial buscarPorNombre(String nombre) {
        
        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT a FROM Editorial a WHERE a.Nombre like :nombre").setParameter("nombre", "%"+nombre+"%").getSingleResult();
        desconectar();
        return editorial;
    }
       
        public List <Editorial> mostrarEditoriales(){
          
        
        conectar();
        List <Editorial> AuList = em.createQuery("SELECT a FROM Editorial a ").getResultList();
        desconectar();
        return AuList;
      
        
    }
    
    
    
}
