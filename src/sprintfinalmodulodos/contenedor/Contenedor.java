package sprintfinalmodulodos.contenedor;


import sprintfinalmodulodos.contenedor.Capacitacion;
import sprintfinalmodulodos.contenedor.Asesoria;
import sprintfinalmodulodos.trabajador.Cliente;
import sprintfinalmodulodos.trabajador.Usuario;
import sprintfinalmodulodos.trabajador.Administrativo;
import sprintfinalmodulodos.trabajador.Profesional;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

        
public class Contenedor {

    private List<Asesoria> clientes;
    private List<Asesoria> profesionales;
    private List<Administrativo> administrativos;
    private List<Asesoria> usuarios;
    private List<Capacitacion> capacitaciones;


    public Contenedor() {
        this.clientes = new ArrayList<>();
        this.profesionales = new ArrayList<>();
        this.administrativos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.capacitaciones = new ArrayList<>();
        
    }
    
    //-------------------------

    public List<Asesoria> getClientes() {
        return clientes;
    }

    public void setClientes(List<Asesoria> clientes) {
        this.clientes = clientes;
    }

    public List<Asesoria> getProfesionales() {
        return profesionales;
    }

    public void setProfesionales(List<Asesoria> profesionales) {
        this.profesionales = profesionales;
    }

    public List<Administrativo> getAdministrativos() {
        return administrativos;
    }

    public void setAdministrativos(List<Administrativo> administrativos) {
        this.administrativos = administrativos;
    }
    
    public List<Asesoria> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Asesoria> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Capacitacion> getCapacitaciones() {
        return capacitaciones;
    }

    public void setCapacitaciones(List<Capacitacion> capacitaciones) {
        this.capacitaciones = capacitaciones;
    }
        
    //*************************************************************
    //METODOS
    //1) Almacenar cliente
    public void almacenarCliente(Cliente cliente) {
        usuarios.add(cliente);
        System.out.println("Cliente ingresado: " + cliente);
    }

    //2) Almacenar profesional
    public void almacenarProfesional(Profesional profesional) {
        usuarios.add(profesional);
        System.out.println("Profesional ingresado: " + profesional);
    }

    //3) Almacenar administrativo
    public void almacenarAdministrativo(Administrativo administrativo) {
        usuarios.add(administrativo);
        System.out.println("Administrativo ingresado: " + administrativo);
    }

    //4) Almacenar capacitación
    public void almacenarCapacitacion(Capacitacion capacitacion) {
        capacitaciones.add(capacitacion);
        System.out.println("Capacitacion ingresada: " + capacitacion);
    }

    //5) Eliminar usuario por RUN
    public void eliminarUsuario(int rut) {
        usuarios.removeIf(usuario -> ((Usuario) usuario).getRut()==(rut));
        System.out.println("Usuario eliminado correctamente");
    }

    //6) Listar todos los usuarios
    public void listarUsuarios() {
        for (Asesoria usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    //7) Listar usuarios por tipo
  /*  public void listarUsuariosPorTipo(String tipoUsuario) {
        for (Asesoria usuario : usuarios) {
            if ((tipoUsuario.equals("cliente") && usuario instanceof Cliente) ||
                (tipoUsuario.equals("administrativo") && usuario instanceof Administrativo) ||
                (tipoUsuario.equals("profesional") && usuario instanceof Profesional)) {
                System.out.println(usuario);
            }
        }
    }*/
    
    public void listarUsuariosPorTipo(String tipoUsuario) {
        for (Asesoria usuario : usuarios) {
            if (tipoUsuario.equalsIgnoreCase("cliente")
                    && usuario instanceof Cliente) {
                System.out.println(usuario);
            } else if (tipoUsuario.equalsIgnoreCase("profesional")
                    && usuario instanceof Profesional) {
                System.out.println(usuario);
            } else if (tipoUsuario.equalsIgnoreCase("administrativo") 
                    && usuario instanceof Administrativo) {
                System.out.println(usuario);
            }
        }
    }


    //8) Listar capacitaciones junto con los datos del cliente asociado
    public void listarCapacitaciones() {
        for (Capacitacion capacitacion : capacitaciones) {
            System.out.println(capacitacion);
        }
    }
    
    
    ////*******************************************
    // Métodos para guardar usuarios y capacitaciones en un archivo
    
    //CLIENTE
    public void guardarClientes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
            oos.writeObject(clientes); // Escribir la lista de clientes completa
        } catch (IOException e) {
            System.out.println("Error al guardar clientes: " + e.getMessage());
        }
    }
    
    //PROFESIONAL
    public void guardarProfesionales() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("profesionales.dat"))) {
            oos.writeObject(profesionales); // Escribir la lista de profesionales completa
        } catch (IOException e) {
            System.out.println("Error al guardar profesionales: " + e.getMessage());
        }
    }
    
    //ADMINISTRATIVO
     public void guardarAdministrativos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("administrativos.dat"))) {
            oos.writeObject(administrativos); // Escribir la lista de administrativos completa
        } catch (IOException e) {
            System.out.println("Error al guardar administrativos: " + e.getMessage());
        }
    }
    
    //USUARIOS
    public void guardarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuarios.dat"))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    //CAPACITACIONES
    public void guardarCapacitaciones() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("capacitaciones.dat"))) {
            oos.writeObject(capacitaciones);
        } catch (IOException e) {
            System.out.println("Error al guardar capacitaciones: " + e.getMessage());
        }
    }
    
    //--------------------------------------------------------------------------

    // Métodos para cargar usuarios y capacitaciones desde un archivo
    //CLIENTE
    public void cargarClientes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
            clientes = (List<Asesoria>) ois.readObject(); // Leer la lista de clientes
        } catch (FileNotFoundException e) {
           // System.out.println("Archivo de clientes no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar clientes: " + e.getMessage());
        }
    }
    
    //PROFESIONAL
     public void cargarProfesionales() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("profesionales.dat"))) {
            profesionales = (List<Asesoria>) ois.readObject(); // Leer la lista de profesionales
        } catch (FileNotFoundException e) {
         //   System.out.println("Archivo de profesionales no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar profesionales: " + e.getMessage());
        }
    }
     
    //ADMINISTRATIVO
    public void cargarAdministrativos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("administrativos.dat"))) {
            administrativos = (List<Administrativo>) ois.readObject(); // Leer la lista de administrativos
        } catch (FileNotFoundException e) {
         //   System.out.println("Archivo de administrativos no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar administrativos: " + e.getMessage());
        }
    }
        
    //USUARIOS
    public void cargarUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.dat"))) {
            usuarios = (List<Asesoria>) ois.readObject();
        } catch (FileNotFoundException e) {
          //  System.out.println("Archivo de usuarios no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }
    }

    //CAPACITACIONES
    public void cargarCapacitaciones() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("capacitaciones.dat"))) {
            capacitaciones = (List<Capacitacion>) ois.readObject();
        } catch (FileNotFoundException e) {
          //  System.out.println("Archivo de capacitaciones no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar capacitaciones: " + e.getMessage());
        }
    }    
    
    public void cargarEliminarUsuarios(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.dat"))) {
            usuarios = (List<Asesoria>) ois.readObject();
        } catch (FileNotFoundException e) {
         //   System.out.println("Archivo de usuarios no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }
    }
    
    public void cargarListarUsuariosPorTipo(){
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.dat"))) {
            usuarios = (List<Asesoria>) ois.readObject();
        } catch (FileNotFoundException e) {
         //  System.out.println("Archivo de usuarios no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }    
    }
    
    public void cargarListarCapacitaciones(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("capacitaciones.dat"))) {
            capacitaciones = (List<Capacitacion>) ois.readObject();
        } catch (FileNotFoundException e) {
          //  System.out.println("Archivo de capacitaciones no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar capacitaciones: " + e.getMessage());
        }
    }
    
}


    /*for (Asesoria usuario : usuarios) {              
                if (usuario instanceof Cliente) 
                    && (Cliente) usuario.getRut().equals(capacitacion.getRutCliente())
                    System.out.println("Datos del Cliente: " + usuario.toString());
                }
    */
    

