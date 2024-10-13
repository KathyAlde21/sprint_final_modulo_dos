package sprintfinalmodulodos;

import java.time.LocalDate;

public class Administrativo extends Usuario {
    
    private String area;
    private String experienciaPrevia;
    
    public Administrativo(){};

    public Administrativo(
            String area,
            String experienciaPrevia,
            String nombre,
            LocalDate fechaNacimiento,
            int rut
    ) {
        super(nombre, fechaNacimiento, rut);
        this.area = area;
        this.experienciaPrevia = experienciaPrevia;
    }
    
    //---------------------------
    //AREA
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        if (area.length() < 5 || area.length() > 20) {
            throw new IllegalArgumentException("El área debe tener entre"
                    + " 5 y 20 caracteres.");
        }
        this.area = area;
    }

    //EXPERIENCIA PREVIA
    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public void setExperienciaPrevia(String experienciaPrevia) {
        if (experienciaPrevia.length() > 100) {
            throw new IllegalArgumentException("La experiencia previa debe"
                    + " tener un máximo de 100 caracteres.");
        }
        this.experienciaPrevia = experienciaPrevia;
    }
    
    //-----------------------------
    //METODOS:
    
    @Override
    public void analizarUsuario(){
        System.out.println("El nombre del usuario es: " + super.getNombre() 
                + ", su fecha de nacimiento es: " 
                + super.obtenerFechaNacimiento() + ", RUT: " + super.rut
                + ", Área a la que pertenece: " + area 
                + ", Experiencia previa: " + experienciaPrevia);
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Área: " + area + ", Experiencia previa: "
                + experienciaPrevia;
    }
    
}
