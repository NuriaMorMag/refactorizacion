package entidades;

import java.time.LocalDateTime;

/**
 * Clase que representa una reserva de pista deportiva
 * Contiene información sobre la pista, fecha y duración de la reserva
 * 
 * @author Fran Vigueras
 */
public class Reserva {
    private int idPista;
    private LocalDateTime fecha;
    private int duracion;

    /**
     * Constructor de la clase Reserva
     * 
     * @param idPista Identificador de la pista reservada
     * @param fecha Fecha de la reserva 
     * @param duracion Duración de la reserva en horas
     */
    public Reserva(int idPista, LocalDateTime fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    /**
     * Obtiene el ID de la pista reservada
     * 
     * @return El identificador de la pista
     */
    public int getIdPista() {
        return idPista;
    }

    /**
     * Obtiene la fecha de la reserva
     * 
     * @return La fecha de la reserva
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * Obtiene la duración de la reserva
     * 
     * @return La duración de la reserva en horas
     */
    public int getDuracion() {
        return duracion;
    }
}

