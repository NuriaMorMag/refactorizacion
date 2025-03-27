package servicios;

import java.util.ArrayList;
import java.util.List;
import entidades.Reserva;
import java.time.LocalDateTime;

/**
 * Clase que gestiona las reservas de pistas deportivas
 * Permite realizar, cancelar y verificar reservas, así como administrar la iluminación de las pistas
 * 
 * @author Fran Vigueras
 */
public class SistemaReservasDeportivas {

    private List<Reserva> reservas;
    private GestorIluminacion data = new GestorIluminacion();
	private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas

    /**
     * Constructor. Inicializa la lista de reservas y el estado de iluminación de las pistas
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        data.iluminacion = new boolean[MAX_PISTAS];
    }

    
    /**
     * Reserva una pista deportiva
     * 
     * @param idPista Identificador de la pista a reservar
     * @param fecha Fecha de la reserva 
     * @param duracion Duración de la reserva en horas
     * @return true si la reserva se realiza con éxito, y false si la pista ya está reservada o el ID es inválido
     */
    public boolean reservarPista(Reserva reserva) {
        if (reserva.getIdPista() < 0 || reserva.getIdPista() >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == reserva.getIdPista() && r.getFecha().equals(reserva.getFecha())) {
                return false; // La pista ya está reservada en esa fecha
            }
        }
        reservas.add(reserva);
        return true;
    }

    
    /**
     * Cancela una reserva 
     * 
     * @param idReserva Identificador de la reserva a cancelar
     * @return true si la reserva fue cancelada, false si no se encontró
     */
    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }

    
    /**
     * Activa la iluminación de una pista 
     * 
     * @param idPista Identificador de la pista
     * @return true si la iluminación fue activada con éxito, false si el ID es inválido
     */
    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        data.iluminacion[idPista] = true;
        return true;
    }

    
    /**
     * Desactiva la iluminación de una pista 
     * 
     * @param idPista Identificador de la pista
     * @return true si la iluminación fue desactivada con éxito, false si el ID es inválido
     */
    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        data.iluminacion[idPista] = false;
        return true;
    }

    
    /**
     * Verifica la disponibilidad de una pista en una fecha y hora 
     * 
     * @param idPista Identificador de la pista
     * @param fecha Fecha de la reserva 
     * @param hora Hora en la que se quiere reservar la pista
     * @return true si la pista está disponible, false si está reservada
     */
    public boolean verificarDisponibilidad(int idPista, LocalDateTime fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista no está disponible en esa fecha
            }
        }
        return true; // La pista está disponible
    }
}
