package Servicio;

import Entidades.Autor;
import Entidades.Editorial;
import Entidades.Libro;
import Persistencia.AutorDAO;
import Persistencia.EditorialDAO;
import Persistencia.LibroDAO;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
//import java.util.UUID;

public class LibroService {

    LibroDAO LD = new LibroDAO();
    AutorService as = new AutorService();
    AutorDAO AD = new AutorDAO();
    EditorialService es = new EditorialService();
    EditorialDAO ED = new EditorialDAO();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void crearLibro() {

        try {
            Libro lib = new Libro();
            lib.setId(UUID.randomUUID().toString());
            System.out.println("Elija el autor del libro");
            as.imprimirAutores();
            int op = leer.nextInt();
            if (op == AD.mostrarAutores().size() + 1) {
                as.crearAutor();

            } else {
                lib.setAutor(AD.mostrarAutores().get(op));
            }
            System.out.println("Elija la editorial del libro");
            es.imprimirEditoriales();
            int op2 = leer.nextInt();
            if (op2 == ED.mostrarEditoriales().size() + 1) {
                es.crearEditorial();
            } else {
                lib.setEditorial(ED.mostrarEditoriales().get(op2));
            }

            System.out.println("ingrese el nombre del Libro");
            lib.setTitulo(leer.next());
            System.out.println("Ingrese el año de publicacion");
            lib.setAnio(leer.nextInt());
            System.out.println("Ingrese la cantidad de ejemplares");
            lib.setEjemplares(leer.nextInt());
            lib.setEjemplaresRestantes(lib.getEjemplares());
            System.out.println("Ingrese el codigo ISBN");
            lib.setIsbn(leer.nextLong());

            lib.setAlta(true);

            LD.guardar(lib);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mostrarLibros() {

        List<Libro> lib = LD.BaseLibros();

        for (Libro libro : lib) {

            System.out.println(libro.getTitulo());

        }

    }

    public void buscarLibroxISBN() {

        System.out.println("ingrese el ISBN");
        Long ISBN = leer.nextLong();

        Long isbn2 = LD.buscarPorISBN(ISBN).getIsbn();

        try {
            if (isbn2.equals(ISBN)) {

                System.out.println(LD.buscarPorISBN(ISBN).toString());

            } else {
                System.out.println("El libro no existe");
            }
        } catch (Exception e) {
            System.out.println("Error en sistema");

        }

    }

    public void buscarLibroxTitulo() {

        System.out.println("ingrese el Titulo");
        String titulo = leer.next();

        try {
            if (titulo.equalsIgnoreCase(LD.buscarPorTitulo(titulo).getTitulo())) {

                System.out.println(LD.buscarPorTitulo(titulo));

            } else {
                System.out.println("El libro no existe");
            }
        } catch (Exception e) {
            System.out.println("Error en sistema");

        }

    }

    public void librosxAutor() {

        System.out.println("Ingrese el nombre del autor");
        String autor = leer.next();

        try {

            if (as.buscarAutorPorNombre(autor) != null) {

                List<Libro> libroxautor = LD.buscarPorAutor(autor);

                for (Libro libro : libroxautor) {

                    System.out.println(libro);

                }
            } else {
                System.out.println("No existen libros de ese autor");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void librosxEditorial() {

        System.out.println("Ingrese el nombre de la Editorial");
        String edi = leer.next();

        try {

            if (es.buscarEditorialPorNombre(edi) != null) {

                List<Libro> libroxautor = LD.buscarPorEditorial(edi);

                for (Libro libro : libroxautor) {

                    System.out.println(libro);

                }
            } else {
                System.out.println("No existen libros de esa editorial");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void eliminarLibro() {

        System.out.println("Ingrese el titulo del libro");
        String lib = leer.next();

        try {
            LD.eliminar(LD.buscarPorTitulo(lib));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void editarLibro() {

        System.out.println("Ingrese el titulo del libro");
        String lib = leer.next();

        Libro libro = LD.buscarPorTitulo(lib);
        
        int OP;

        do {

            System.out.println("Ingrese el dato que desee modificar");
            System.out.println("1. Titulo");
            System.out.println("2. Autor");
            System.out.println("3. Editorial");
            System.out.println("4. Cantidad de Ejemplares");
            System.out.println("5. ISBN");
            System.out.println("6. Salir");

            OP = leer.nextInt();

            switch (OP) {

                case 1:
                    System.out.println("Ingrese el nuevo titulo");
                    libro.setTitulo(leer.next());
                    LD.editar(libro);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del Autor");
                    String au = leer.next();
                    Autor autor = as.buscarAutorPorNombre(au);
                    libro.setAutor(autor);
                    LD.editar(libro);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre de la Editorial");
                    String edix = leer.next();
                    Editorial edi = es.buscarEditorialPorNombre(edix);
                    libro.setEditorial(edi);
                    LD.editar(libro);
                    break;
                case 4:
                    System.out.println("Ingrese la cantidad de ejemplares");
                    Integer ejem = leer.nextInt();
                    libro.setEjemplaresRestantes(ejem + libro.getEjemplaresRestantes());
                    LD.editar(libro);
                    break;
                case 5:
                    System.out.println("Ingrese el nuevo ISBN");
                    libro.setIsbn(leer.nextLong());
                    LD.editar(libro);
                    break;

            }

        } while (OP!=6);

    }

}
