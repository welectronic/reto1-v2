package lite.thinking.taller01.repository;

import lite.thinking.taller01.model.Estudiante;
import lite.thinking.taller01.model.Direccion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Repositorio en memoria para gestionar estudiantes.
 */
@Repository
public class RepositorioEstudiante {
    private final List<Estudiante> estudiantes;

    /**
     * Constructor que inicializa la lista de estudiantes con 10 registros predefinidos.
     */
    public RepositorioEstudiante() {
        this.estudiantes = new ArrayList<>();
        inicializarEstudiantes();
    }

    /**
     * Método para obtener la lista de todos los estudiantes.
     *
     * @return Lista de estudiantes.
     */
    public List<Estudiante> listarTodos() {
        return estudiantes;
    }

    /**
     * Método para agregar un estudiante a la lista.
     *
     * @param estudiante Estudiante a agregar.
     */
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    /**
     * Método privado para inicializar la lista con 10 estudiantes.
     */
    private void inicializarEstudiantes() {
        for (int i = 1; i <= 10; i++) {
            Estudiante estudiante = new Estudiante();
            estudiante.setNumeroEstudiante(i);
            estudiante.setNombre("Estudiante " + i);
            estudiante.setDireccion(generarDireccionAleatoria());
            estudiante.setNumeroCelular("30012345" + i);
            estudiante.setCorreoElectronico("estudiante" + i + "@ejemplo.com");
            estudiante.setPromedioNotas(3.0 + (i * 0.1)); // Generar un promedio diferente para cada estudiante
            estudiante.setListadoAsignaturas(List.of("Asignatura 1", "Asignatura 2"));
            estudiante.setSeminariosTomados(List.of("Seminario 1", "Seminario 2"));
            agregarEstudiante(estudiante);
        }
    }

    /**
     * Método para generar una dirección aleatoria
     */
    private Direccion generarDireccionAleatoria() {
        Random r = new Random();
        Direccion direccion = new Direccion();
        direccion.setDireccion("Calle " + r.nextInt(1000));
        direccion.setCiudad("Ciudad " + r.nextInt(100));
        direccion.setEstado("Estado " + r.nextInt(100));
        direccion.setCodigoPostal("CP " + r.nextInt(100));
        direccion.setPais("País " + r.nextInt(100));
        return direccion;
    }
}
