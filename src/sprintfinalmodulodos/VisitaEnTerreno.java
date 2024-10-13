
package sprintfinalmodulodos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VisitaEnTerreno {
    
    private int identificador;
    private int rutCliente;
    private LocalDate dia;
    private String hora;
    private String lugar;
    private String comentarios;
    
    public VisitaEnTerreno(){};

    public VisitaEnTerreno(
            int identificador,
            int rutCliente, 
            LocalDate dia, 
            String hora,
            String lugar,
            String comentarios
    ) {
        this.identificador = identificador;
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.comentarios = comentarios;
    }
    
    //--------------------
    //IDENTIFICADOR
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
                "dd/MM/yyyy");
        this.dia = LocalDate.parse(dia, formatter);
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
            throw new IllegalArgumentException("El lugar debe tener entre"
                    + " 10 y 50 caracteres.");
        }
        this.lugar = lugar;
    }

    //COMENTARIOS
    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        if (comentarios.length() > 100) {
            throw new IllegalArgumentException("Los comentarios deben tener"
                    + " un máximo de 100 caracteres.");
        }
        this.comentarios = comentarios;
    }
    
    //**********************************

    @Override
    public String toString() {
        return "VisitaEnTerreno{" + "identificador=" + identificador 
                + ", rutCliente=" + rutCliente + ", dia=" + dia 
                + ", hora=" + hora + ", lugar=" + lugar 
                + ", comentarios=" + comentarios + '}';
    }
 
}
