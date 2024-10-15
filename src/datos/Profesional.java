package datos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import contenedor.IAsesoria;

public class Profesional extends Usuario implements IAsesoria{
    
    private String titulo;
    private LocalDate fechaIngreso;
    
    public Profesional (){};

    public Profesional(
            String titulo,
            LocalDate fechaIngreso, 
            String nombre,
            LocalDate fechaNacimiento,
            int rut
    ) {
        super(nombre, fechaNacimiento, rut);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    //---------------------------
    //TITULO
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo.length() < 10 || titulo.length() > 50) {
            throw new IllegalArgumentException("El título debe tener entre"
                    + " 10 y 50 caracteres.");
        }
        this.titulo = titulo;
    }

    //FECHA INGRESO
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "dd/MM/yyyy");
        this.fechaIngreso = LocalDate.parse(fechaIngreso, formatter);
    }
    
    //-----------------
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.titulo);
        hash = 79 * hash + Objects.hashCode(this.fechaIngreso);
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
        final Profesional other = (Profesional) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return Objects.equals(this.fechaIngreso, other.fechaIngreso);
    }

    //*******************************************
    //METODOS
    //metodo fecha
    public String obtenerFechaIngreso(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "dd/mm/yyyy");
        return this.fechaIngreso.format(formatter);
    }
        
   /* @Override
    public void analizarUsuario(){
        System.out.println("El nombre del usuario es: " + super.getNombre() 
                + " " + ", Título: " + titulo 
                + ", Fecha de ingreso: " + obtenerFechaIngreso());
    }*/
    
    @Override
    public String toString() {
        return "Profesional{" 
                + "titulo=" + titulo 
                + ", fechaIngreso=" + fechaIngreso 
                + '}'
                + super.toString();
    }
 
}
