package lite.thinking.taller01.service;

import lite.thinking.taller01.model.Estudiante;
import lite.thinking.taller01.repository.RepositorioEstudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiceEstudianteTest {

    private RepositorioEstudiante repositorioMock;
    private ServiceEstudiante serviceEstudiante;

    @BeforeEach
    void setUp() {
        // Crear un mock del repositorio
        repositorioMock = mock(RepositorioEstudiante.class);
        // Inyectar el mock en el servicio
        serviceEstudiante = new ServiceEstudiante(repositorioMock);
    }

    @Test
    void listarEstudiantes_deberiaDevolverListaCompleta() {
        // Preparar datos simulados
        List<Estudiante> estudiantesSimulados = List.of(
                new Estudiante(), new Estudiante(), new Estudiante()
        );
        when(repositorioMock.listarTodos()).thenReturn(estudiantesSimulados);

        // Ejecutar el método
        List<Estudiante> resultado = serviceEstudiante.listarEstudiantes();

        // Verificar
        assertNotNull(resultado);
        assertEquals(3, resultado.size());
        verify(repositorioMock, times(1)).listarTodos();
    }

    @Test
    void filtrarPorNombre_deberiaDevolverEstudiantesConElNombreEspecifico() {
        // Preparar datos simulados
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombre("Juan");
        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombre("Maria");
        List<Estudiante> estudiantesSimulados = List.of(estudiante1, estudiante2);

        when(repositorioMock.listarTodos()).thenReturn(estudiantesSimulados);

        // Ejecutar el método
        List<Estudiante> resultado = serviceEstudiante.filtrarPorNombre("Juan");

        // Verificar
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Juan", resultado.get(0).getNombre());
        verify(repositorioMock, times(1)).listarTodos();
    }

    @Test
    void filtrarPorNumeroCelular_deberiaDevolverEstudiantesConNumeroEspecifico() {
        // Preparar datos simulados
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNumeroCelular("3001234567");
        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNumeroCelular("3009876543");
        List<Estudiante> estudiantesSimulados = List.of(estudiante1, estudiante2);

        when(repositorioMock.listarTodos()).thenReturn(estudiantesSimulados);

        // Ejecutar el método
        List<Estudiante> resultado = serviceEstudiante.filtrarPorNumeroCelular("3001234567");

        // Verificar
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("3001234567", resultado.get(0).getNumeroCelular());
        verify(repositorioMock, times(1)).listarTodos();
    }

    @Test
    void ordenarPorPromedioNotas_deberiaDevolverListaOrdenada() {
        // Preparar datos simulados
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setPromedioNotas(3.5);
        Estudiante estudiante2 = new Estudiante();
        estudiante2.setPromedioNotas(4.0);
        Estudiante estudiante3 = new Estudiante();
        estudiante3.setPromedioNotas(3.0);
        List<Estudiante> estudiantesSimulados = List.of(estudiante1, estudiante2, estudiante3);

        when(repositorioMock.listarTodos()).thenReturn(estudiantesSimulados);

        // Ejecutar el método
        List<Estudiante> resultado = serviceEstudiante.ordenarPorPromedioNotas();

        // Verificar
        assertNotNull(resultado);
        assertEquals(3, resultado.size());
        assertEquals(4.0, resultado.get(0).getPromedioNotas());
        assertEquals(3.5, resultado.get(1).getPromedioNotas());
        assertEquals(3.0, resultado.get(2).getPromedioNotas());
        verify(repositorioMock, times(1)).listarTodos();
    }
}
