package lite.thinking.taller01.model;

import lombok.Data;

/**
 * Clase que representa la dirección de una persona.
 */
@Data // Genera automáticamente getters, setters, equals, hashCode y toString
public class Direccion {
    private String direccion;
    private String ciudad;
    private String estado;
    private String codigoPostal;
    private String pais;
}
