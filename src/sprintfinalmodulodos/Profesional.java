package sprintfinalmodulodos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Profesional extends Usuario implements Asesoria{
    
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

    //*******************************************
    //METODOS
    //metodo fecha
    public String obtenerFechaIngreso(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "dd/mm/yyyy");
        return this.fechaIngreso.format(formatter);
    }
        
    @Override
    public void analizarUsuario(){
        System.out.println("El nombre del usuario es: " + super.getNombre() 
                + " " + ", Título: " + titulo 
                + ", Fecha de ingreso: " + obtenerFechaIngreso());
    }
        
    @Override
    public String toString() {
        return super.toString() + ", Título: " + titulo 
                + ", Fecha de ingreso: " + obtenerFechaIngreso();
    }
    
    
}
