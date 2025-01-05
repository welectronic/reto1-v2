package lite.thinking.taller01.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Clase que representa a un estudiante, heredando de Persona.
 */
@Data
@EqualsAndHashCode(callSuper = true) // Genera equals y hashCode incluyendo atributos de Persona
public class Estudiante extends Persona {
    private int numeroEstudiante;
    private double promedioNotas;
    private List<String> listadoAsignaturas; // Lista de asignaturas cursadas
    private List<String> seminariosTomados; // Lista de seminarios asistidos
}
