package lite.thinking.taller01.model;

import lombok.Data;

/**
 * Clase que representa a una persona genérica en el sistema.
 */
@Data // Genera automáticamente getters, setters, equals, hashCode y toString
public class Persona {
    private String nombre;
    private String numeroCelular;
    private String correoElectronico;
    private Direccion direccion; // Relación con la clase Direccion

    /**
     * Método que simula la compra de un pase de estacionamiento.
     */
    public String comprarPaseEstacionamiento() {
        return nombre + " ha comprado un pase de estacionamiento.";
    }
}
