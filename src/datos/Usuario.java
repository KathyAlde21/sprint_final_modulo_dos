
package datos;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import contenedor.IAsesoria;
import contenedor.IAsesoria;

public class Usuario implements IAsesoria {
    
    String nombre;
    private LocalDate fechaNacimiento;
    int rut;
    
    //--------------------
    public Usuario (){};

    public Usuario(
            String nombre,
            LocalDate fechaNacimiento,
            int rut) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.rut = rut;
    }
    //------------------

    //NOMBRE
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() < 10 || nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre debe tener"
                    + " entre 10 y 50 caracteres.");
        }
        this.nombre = nombre;
    }

    //FECHA DE NACIMIENTO
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, formatter);
    }

    //RUN
    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        if (rut >= 99999999) {
            throw new IllegalArgumentException("El RUT debe ser menor a"
                    + " 99.999.999.");
        }
        this.rut = rut;
    }
    //--------------------
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 41 * hash + this.rut;
        return hash;
    }
    
    @Override    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.rut != other.rut) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.fechaNacimiento, other.fechaNacimiento);
    }

    //******************************************
    //METODOS:
    public String obtenerFechaNacimiento() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "dd/mm/yyyy");
        return this.fechaNacimiento.format(formatter);
    }
     //----------   
    //mostrar edad - incluye calculo
    public int obtenerEdad(){
        if (this.fechaNacimiento == null) {
            throw new IllegalArgumentException("El RUN debe ser menor a"
                    + " 99.999.999.");
        }
        LocalDate fechaActual = LocalDate.now();
        return Period.between(this.fechaNacimiento,
                fechaActual).getYears();
    }
    
    public void mostrarEdad(){
        System.out.println("El usuario tiene " + obtenerEdad() + "años");
    }
    
    //----------
    
    public void mostrarRut(){
        System.out.println(rut); 
    }
    
    public void mostrarDatosUsuario(){
        System.out.println("Usuario: " + nombre
                + ", fecha de nacimiento: " + fechaNacimiento
                + ", RUT: " + rut); 
    }
    
    @Override //implementada en interface IAsesoria
    public void analizarUsuario(){
        System.out.println("El nombre del usuario es: " + nombre 
                + ", RUT " + rut);
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre
                + ", fechaNacimiento=" + fechaNacimiento
                + ", rut=" + rut + '}';
    }

}
