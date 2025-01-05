package lite.thinking.taller01.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Clase que representa a un profesor, heredando de Persona.
 */
@Data
@EqualsAndHashCode(callSuper = true) // Incluye atributos de Persona en equals y hashCode
public class Profesor extends Persona {
    private double salario; // Salario del profesor
    private List<String> materiasDictadas; // Lista de materias que el profesor dicta
}
