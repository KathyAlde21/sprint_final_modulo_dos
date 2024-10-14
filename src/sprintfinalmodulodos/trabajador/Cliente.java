
package sprintfinalmodulodos.trabajador;

import sprintfinalmodulodos.trabajador.Usuario;
import java.time.LocalDate;
import sprintfinalmodulodos.contenedor.Asesoria;

public class Cliente extends Usuario implements Asesoria {
    
    private int rutCliente;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String afp;
    private int sistemaSalud; //1 fonasa - 2 isapre => solo 1 opcion
    private String direccion;
    private String comuna;
    private int edad;
    
    public Cliente (){};

    public Cliente(
            int rutCliente,
            String nombres,
            String apellidos,
            String telefono,
            String afp,
            int sistemaSalud,
            String direccion,
            String comuna,
            int edad,
            String nombre,
            LocalDate fechaNacimiento,
            int rut
    ) {
        super(nombre, fechaNacimiento, rut);
        this.rutCliente = rutCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
    }
    
    //---------------------------
    //RUT
    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        if (rutCliente >= 99999999) {
            throw new IllegalArgumentException("El RUT debe ser menor a"
                    + " 99.999.999.");
        }
        this.rutCliente = rutCliente;
    }

    //NOMBRE
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        if (nombres.length() < 5 || nombres.length() > 30) {
            throw new IllegalArgumentException("El nombre debe tener"
                    + " entre 5 y 30 caracteres.");
        }
        this.nombres = nombres;
    }

    //APELLIDO
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        if (apellidos.length() < 5 || apellidos.length() > 30) {
            throw new IllegalArgumentException("El apellido debe tener"
                    + " entre 5 y 30 caracteres.");
        }
        this.apellidos = apellidos;
    }

    //TELEFONO
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("El telefono es obligatorio");
        }
        this.telefono = telefono;
    }

    //AFP
    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        if (afp.length() < 4 || afp.length() > 30) {
            throw new IllegalArgumentException("El nombre de la AFP debe tener"
                    + " entre 4 y 30 caracteres.");
        }
        this.afp = afp;
    }

    //SISTEMA SALUD
    public int getSistemaSalud() {
        return sistemaSalud;
    }

    public void setSistemaSalud(int sistemaSalud) {
        if (sistemaSalud != 1 && sistemaSalud != 2) {
            throw new IllegalArgumentException("El sistema de salud debe ser"
                    + " Fonasa (1) o Isapre (2).");
        }
        this.sistemaSalud = sistemaSalud;
    }

    //DIRECCION
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion.length() > 70) {
            throw new IllegalArgumentException("La dirección debe tener un"
                    + " máximo de 70 caracteres.");
        }
        this.direccion = direccion;
    }

    //COMUNA
    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        if (comuna.length() > 50) {
            throw new IllegalArgumentException("La comuna debe tener un"
                    + " máximo de 50 caracteres.");
        }
        this.comuna = comuna;
    }

    //EDAD
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 0 || edad >= 150) {
            throw new IllegalArgumentException("La edad debe ser mayor o"
                    + " igual a 0 y menor a 150.");
        }
        this.edad = edad;
    }
    //-----------------------------
    //METODOS:
    //nombre completo tipo String
    public void obtenerNombre(){
        System.out.println("Nombre: " + nombres + apellidos);
    }
        
    public void obtenerSistemaSalud(){
        System.out.println("Nombre: " + nombres + " " + apellidos 
                + ", Prevision: " + (sistemaSalud == 1 ? "Fonasa" : "Isapre")
                + ", Direccion: " + direccion + ", Comuna " + comuna
                + ", Edad " + edad);
    }
    

    @Override
    public void analizarUsuario(){
        System.out.println("El nombre del usuario es: " + nombres + " " 
                + apellidos + ", RUT: " + rutCliente);
    }
    
    public void mostrarDatosCliente(){
        System.out.println("Nombre: " + nombres + " " + apellidos + ", RUT: "
                + rutCliente + ", AFP: " + afp + ", Prevision: " 
                + (sistemaSalud == 1 ? "Fonasa" : "Isapre")
                + ", Direccion: " + direccion + ", Comuna " + comuna
                + ", Edad " + edad);
    }
        
    @Override
    public String toString() {
        return super.toString() + ", Nombre: " + nombres + " " + apellidos
                + ", Teléfono: " + telefono + ", AFP: " + afp + ", Sistema"
                + " de salud: " + (sistemaSalud == 1 ? "Fonasa" : "Isapre") 
                + ", Dirección: " + direccion + ", Comuna: " + comuna 
                + ", Edad: " + edad + ", RUT: " + rutCliente;
    }
    
}
