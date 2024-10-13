
package sprintfinalmodulodos;

//import java.time.LocalDate;

public class Capacitacion{
    
    private int identificador;
    private int rutCliente;
    private String dia;
    private String hora;
    private String lugar;
    private String duracion;
    private int cantidadAsistentes;
    
    public Capacitacion (){};

    public Capacitacion(
            int identificador,
            int rutCliente,
            String dia, 
            String hora, 
            String lugar, 
            String duracion,
            int cantidadAsistentes
    ) {
        this.identificador = identificador;
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.duracion = duracion;
        this.cantidadAsistentes = cantidadAsistentes;
    }

    //------------------------------
    //ID
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    //RUT
    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        this.rutCliente = rutCliente;
    }

    //DIA
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        if (!dia.matches("(?i)^(lunes|martes|miércoles|jueves|viernes|"
                + "sábado|domingo)$")) {
            throw new IllegalArgumentException("El día debe ser un valor"
                    + " permitido entre 'lunes' y 'domingo'.");
        }
        this.dia = dia.substring(0, 1).toUpperCase() 
                + dia.substring(1).toLowerCase();
    }

    //HORA
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        if (!hora.matches("([01]\\d|2[0-3]):([0-5]\\d)")) {
            throw new IllegalArgumentException("La hora debe estar en"
                    + " formato HH:MM, con horas entre 00 y 23, y minutos"
                    + " entre 00 y 59.");
        }
        this.hora = hora;
    }

    //LUGAR
    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
         if (lugar.length() < 10 || lugar.length() > 50) {
            throw new IllegalArgumentException("El lugar debe tener"
                    + " entre 10 y 50 caracteres.");
        }
        this.lugar = lugar;
    }

    //DURACION
    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        if (duracion.length() > 70) {
            throw new IllegalArgumentException("La duración debe tener"
                    + " un máximo de 70 caracteres.");
        }
        this.duracion = duracion;
    }

    //ASISTENTES
    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantidadAsistentes(int cantidadAsistentes) {
        if (cantidadAsistentes >= 1000) {
            throw new IllegalArgumentException("La cantidad de asistentes"
                    + " debe ser menor a 1000.");
        }
        this.cantidadAsistentes = cantidadAsistentes;
    }

    //-----------------------------
    //METODOS:
    
    public void mostrarDetalle(){
        System.out.println("La capacitación será en " + lugar + " a las " 
                + hora + " del día " + dia + ", y durará " 
                + duracion + " minutos");
    }
    
    @Override
    public String toString() {
        return "Capacitación: ID: " + identificador + ", RUT Cliente: " 
                + rutCliente + ", Día: " + dia + ", Hora: " + hora +
                ", Lugar: " + lugar + ", Duración: " + duracion 
                + ", Cantidad de asistentes: " + cantidadAsistentes;
    }
    
}
