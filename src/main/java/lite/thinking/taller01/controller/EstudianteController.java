package lite.thinking.taller01.controller;

import lite.thinking.taller01.model.Estudiante;
import lite.thinking.taller01.service.ServiceEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar los estudiantes.
 */
@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final ServiceEstudiante serviceEstudiante;

    /**
     * Constructor con inyección del servicio.
     *
     * @param serviceEstudiante Servicio de lógica de negocio para estudiantes.
     */
    @Autowired
    public EstudianteController(ServiceEstudiante serviceEstudiante) {
        this.serviceEstudiante = serviceEstudiante;
    }

    /**
     * Endpoint para listar todos los estudiantes.
     *
     * @return Lista de estudiantes.
     */
    @GetMapping
    public List<Estudiante> listarEstudiantes() {
        return serviceEstudiante.listarEstudiantes();
    }

    /**
     * Endpoint para filtrar estudiantes por nombre.
     *
     * @param nombre Nombre del estudiante.
     * @return Lista de estudiantes cuyo nombre coincide.
     */
    @GetMapping("/filtrar")
    public List<Estudiante> filtrarPorNombre(@RequestParam String nombre) {
        return serviceEstudiante.filtrarPorNombre(nombre);
    }

    /**
     * Endpoint para filtrar estudiantes por número de celular.
     *
     * @param numeroCelular Número de celular del estudiante.
     * @return Lista de estudiantes cuyo número de celular coincide.
     */
    @GetMapping("/filtrar-celular")
    public List<Estudiante> filtrarPorNumeroCelular(@RequestParam String numeroCelular) {
        return serviceEstudiante.filtrarPorNumeroCelular(numeroCelular);
    }

    /**
     * Endpoint para ordenar estudiantes por promedio de notas.
     *
     * @return Lista de estudiantes ordenada por promedio de notas.
     */
    @GetMapping("/ordenar-promedio")
    public List<Estudiante> ordenarPorPromedioNotas() {
        return serviceEstudiante.ordenarPorPromedioNotas();
    }
}
