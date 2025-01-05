package lite.thinking.taller01.repository;

import lite.thinking.taller01.model.Estudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositorioEstudianteTest {

    private RepositorioEstudiante repositorioEstudiante;

    @BeforeEach
    void setUp() {
        // Inicializamos el repositorio antes de cada prueba
        repositorioEstudiante = new RepositorioEstudiante();
    }

    @Test
    void listarTodos_deberiaDevolverListaInicialDeEstudiantes() {
        // Llamamos al método listarTodos()
        List<Estudiante> estudiantes = repositorioEstudiante.listarTodos();

        // Verificamos que la lista no sea nula
        assertNotNull(estudiantes, "La lista de estudiantes no debería ser nula.");

        // Verificamos que la lista contenga los 10 estudiantes inicializados
        assertEquals(10, estudiantes.size(), "La lista debería contener 10 estudiantes iniciales.");

        // Validamos algunos datos del primer estudiante para asegurarnos de que fue inicializado correctamente
        Estudiante primerEstudiante = estudiantes.get(0);
        assertNotNull(primerEstudiante.getNombre(), "El nombre del primer estudiante no debería ser nulo.");
        assertNotNull(primerEstudiante.getNumeroCelular(), "El número de celular del primer estudiante no debería ser nulo.");
    }
}
