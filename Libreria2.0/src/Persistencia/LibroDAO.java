
package Persistencia;

import Entidades.Libro;
import java.util.List;



public class LibroDAO extends DAO<Libro>{
    
   
    @Override
    public void guardar(Libro objeto){
        super.guardar(objeto);
    }
    
    @Override
    public void editar(Libro objeto){
        super.editar(objeto);
    }
    
    @Override
    public void eliminar(Libro objeto){
      super.eliminar(objeto);
    }
    
    public List <Libro> BaseLibros(){
           
        conectar();
        List <Libro> ListaLibro = em.createQuery("SELECT a FROM Libro a").getResultList();
        desconectar();
        
        return ListaLibro;
    }
    
    public Libro buscarPorISBN(Long ISBN) {
        
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT a FROM Libro a WHERE a.isbn = :ISBN").setParameter("ISBN", ISBN).getSingleResult();
        desconectar();
        return libro;
    }
    
     public Libro buscarPorTitulo(String titulo) {
        
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT a FROM Libro a WHERE a.titulo = :titulo").setParameter("titulo", titulo).getSingleResult();
        desconectar();
        return libro;
        
    }
     
      public List <Libro> buscarPorAutor(String autor) {
        
        conectar();
        List <Libro> ListaLibros = em.createQuery("SELECT a FROM Libro a WHERE a.autor.Nombre Like :autor").setParameter("autor", "%"+autor+"%").getResultList();
        desconectar();
        return ListaLibros;
        
    }
      
        public List <Libro> buscarPorEditorial(String edi) {
        
        conectar();
        List <Libro> ListaLibros = em.createQuery("SELECT a FROM Libro a WHERE a.editorial.Nombre Like :edi").setParameter("edi", "%"+edi+"%").getResultList();
        desconectar();
        return ListaLibros;
        
    }
    
    
    
    
    
    
}
