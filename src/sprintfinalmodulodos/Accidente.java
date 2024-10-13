package sprintfinalmodulodos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Accidente {
    
    private int identificador;
    private int rutCliente;
    private LocalDate dia;
    private String hora;
    private String lugar;
    private String origen;
    private String consecuencias;
    
    public Accidente (){};

    public Accidente(int identificador, int rutCliente, LocalDate dia, String hora, String lugar, String origen, String consecuencias) {
        this.identificador = identificador;
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.origen = origen;
        this.consecuencias = consecuencias;
    }

   
    
    //---------------------
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
    public LocalDate getDia() {
        return dia;
    }

    public void setDia(String dia) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                extracted());
        this.dia = LocalDate.parse(dia, formatter);
    }

    //HORA
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        if (!hora.matches("([01]\\d|2[0-3]):([0-5]\\d)")) {
            throw new IllegalArgumentException("La hora debe estar"
                    + " en formato HH:MM, con horas entre 00 y 23, y"
                    + " minutos entre 00 y 59.");
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

    //ORIGEN
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        if (origen.length() > 100) {
            throw new IllegalArgumentException("El origen debe tener"
                    + " un máximo de 100 caracteres.");
        }
        this.origen = origen;
    }

    //CONSECUENCIAS
    public String getConsecuencias() {
        return consecuencias;
    }

    public void setConsecuencias(String consecuencias) {
        if (consecuencias.length() > 100) {
            throw new IllegalArgumentException("Las consecuencias"
                    + " deben tener un máximo de 100 caracteres.");
        }
        this.consecuencias = consecuencias;
    }
    
    //-----------------------------
    //METODOS:
    @SuppressWarnings("unused")
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                extracted());
        return "Accidente{" + "identificador=" + identificador 
                + ", rutCliente=" + rutCliente + ", dia=" + dia 
                + ", hora=" + hora + ", lugar=" + lugar + ", origen=" 
                + origen + ", consecuencias=" + consecuencias + '}';
    }

    private String extracted() {
        return "dd/MM/yyyy";
    }
  
}
