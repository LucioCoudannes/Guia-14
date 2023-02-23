

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Servicio.AutorService;


public class Principal {
    
  

    public static void main(String[] args) {
        
//        AutorService as = new AutorService();
//        
//        as.crearAutor();

          private final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("LibreriaPU");
          private EntityManager em = EMF.createEntityManager();

    }
}
