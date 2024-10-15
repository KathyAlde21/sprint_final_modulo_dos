package datos;

import datos.Usuario;
import java.time.LocalDate;
import java.util.Objects;


public class Administrativo extends Usuario{
    
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
    
    //--------------------------------
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.area);
        hash = 13 * hash + Objects.hashCode(this.experienciaPrevia);
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
        final Administrativo other = (Administrativo) obj;
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        return Objects.equals(this.experienciaPrevia, other.experienciaPrevia);
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
