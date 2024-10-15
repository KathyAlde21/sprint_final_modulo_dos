
package contenedor;

import java.util.Objects;


public class Revision {
    
    private int identificador;
    private int identificadorVisita;
    private String nombreRevision;
    private String detalleRevisar;
    private int estado; // 1 sin problemas - 2 con observaciones - 3 no aprueba
    
    public Revision (){};

    public Revision(
            int identificador,
            int identificadorVisita,
            String nombreRevision,
            String detalleRevisar,
            int estado
    ) {
        this.identificador = identificador;
        this.identificadorVisita = identificadorVisita;
        this.nombreRevision = nombreRevision;
        this.detalleRevisar = detalleRevisar;
        this.estado = estado;
    }
    //----------------------------------------
    //IDENTIFICADOR
    public int getIdentificador() {
        return identificador;
    }
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    //IDENTIFICADOR VISITA
    public int getIdentificadorVisita() {
        return identificadorVisita;
    }
    public void setIdentificadorVisita(int identificadorVisita) {
        this.identificadorVisita = identificadorVisita;
    }

    //REVISION
    public String getNombreRevision() {
        return nombreRevision;
    }
    public void setNombreRevision(String nombreRevision) {
        if (nombreRevision.length() < 10 || nombreRevision.length() > 50) {
            throw new IllegalArgumentException("El nombre debe tener"
                    + " entre 10 y 50 caracteres.");
        }
        this.nombreRevision = nombreRevision;
    }
    
    //REVISAR
    public String getDetalleRevisar() {
        return detalleRevisar;
    }
    public void setDetaleRevisar(String detalleRevisar) {
        if (detalleRevisar.length() > 100) {
            throw new IllegalArgumentException("El nombre debe tener"
                    + " entre 10 y 50 caracteres.");
        }
        this.detalleRevisar = detalleRevisar;
    }

    //ESTADO
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        if (estado < 1 || estado > 3) {
            throw new IllegalArgumentException("El estado debe ser 1 (sin"
                    + " problemas), 2 (con observaciones, 3 (no aprueba), "
                    + "solo se pueden ingresar los valores antes indicados.");
        }
        this.estado = estado;
    }

    //----------------------------------------------------
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.identificador;
        hash = 23 * hash + this.identificadorVisita;
        hash = 23 * hash + Objects.hashCode(this.nombreRevision);
        hash = 23 * hash + Objects.hashCode(this.detalleRevisar);
        hash = 23 * hash + this.estado;
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
        final Revision other = (Revision) obj;
        if (this.identificador != other.identificador) {
            return false;
        }
        if (this.identificadorVisita != other.identificadorVisita) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.nombreRevision, other.nombreRevision)) {
            return false;
        }
        return Objects.equals(this.detalleRevisar, other.detalleRevisar);
    }
    
    //**********************************

    @Override
    public String toString() {
        return "Revision{" + "identificador=" + identificador
                + ", identificadorVisita=" + identificadorVisita 
                + ", nombreRevision=" + nombreRevision
                + ", detalleRevisar=" + detalleRevisar 
                + ", estado=" + estado 
                + '}';
    }
}
