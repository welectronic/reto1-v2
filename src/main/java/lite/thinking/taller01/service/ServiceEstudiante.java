package lite.thinking.taller01.service;

import lite.thinking.taller01.model.Estudiante;
import lite.thinking.taller01.repository.RepositorioEstudiante;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para manejar la lógica de negocio relacionada con los estudiantes.
 */
@Service
public class ServiceEstudiante {

    private final RepositorioEstudiante repositorioEstudiante;

    /**
     * Constructor que inyecta el repositorio.
     *
     * @param repositorioEstudiante Repositorio de estudiantes.
     */
    public ServiceEstudiante(RepositorioEstudiante repositorioEstudiante) {
        this.repositorioEstudiante = repositorioEstudiante;
    }

    /**
     * Devuelve la lista de todos los estudiantes.
     *
     * @return Lista de estudiantes.
     */
    public List<Estudiante> listarEstudiantes() {
        return repositorioEstudiante.listarTodos();
    }

    /**
     * Filtra estudiantes por nombre.
     *
     * @param nombre Nombre a buscar.
     * @return Lista de estudiantes cuyo nombre coincide con el filtro.
     */
    public List<Estudiante> filtrarPorNombre(String nombre) {
        return repositorioEstudiante.listarTodos().stream()
                .filter(estudiante -> estudiante.getNombre().equalsIgnoreCase(nombre))
                .toList(); // Cambio aplicado aquí
    }

    /**
     * Filtra estudiantes por número de celular.
     *
     * @param numeroCelular Número de celular a buscar.
     * @return Lista de estudiantes cuyo número de celular coincide con el filtro.
     */
    public List<Estudiante> filtrarPorNumeroCelular(String numeroCelular) {
        return repositorioEstudiante.listarTodos().stream()
                .filter(estudiante -> estudiante.getNumeroCelular().equals(numeroCelular))
                .toList(); // Cambio aplicado aquí
    }

    /**
     * Ordena estudiantes por promedio de notas en orden descendente.
     *
     * @return Lista de estudiantes ordenada por promedio de notas.
     */
    public List<Estudiante> ordenarPorPromedioNotas() {
        return repositorioEstudiante.listarTodos().stream()
                .sorted((e1, e2) -> Double.compare(e2.getPromedioNotas(), e1.getPromedioNotas()))
                .toList(); // Cambio aplicado aquí
    }
}
