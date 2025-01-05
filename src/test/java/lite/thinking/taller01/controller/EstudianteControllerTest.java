package lite.thinking.taller01.controller;

import lite.thinking.taller01.model.Estudiante;
import lite.thinking.taller01.service.ServiceEstudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class) // Habilita Mockito en el test
class EstudianteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ServiceEstudiante serviceEstudiante;

    @InjectMocks
    private EstudianteController estudianteController;

    private List<Estudiante> estudiantesSimulados;

    @BeforeEach
    void setUp() {
        // Inicializa MockMvc con el controlador y los mocks
        mockMvc = MockMvcBuilders.standaloneSetup(estudianteController).build();

        // Crear datos simulados
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombre("Juan");
        estudiante1.setNumeroCelular("3001234567");
        estudiante1.setCorreoElectronico("juan@example.com");
        estudiante1.setPromedioNotas(4.5);

        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombre("Maria");
        estudiante2.setNumeroCelular("3009876543");
        estudiante2.setCorreoElectronico("maria@example.com");
        estudiante2.setPromedioNotas(4.0);

        estudiantesSimulados = List.of(estudiante1, estudiante2);
    }

    @Test
    void listarEstudiantes_deberiaDevolverListaCompleta() throws Exception {
        when(serviceEstudiante.listarEstudiantes()).thenReturn(estudiantesSimulados);

        mockMvc.perform(get("/api/estudiantes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombre", is("Juan")))
                .andExpect(jsonPath("$[1].nombre", is("Maria")));
    }

    @Test
    void filtrarPorNombre_deberiaDevolverEstudianteConNombreEspecifico() throws Exception {
        when(serviceEstudiante.filtrarPorNombre("Juan")).thenReturn(List.of(estudiantesSimulados.get(0)));

        mockMvc.perform(get("/api/estudiantes/filtrar")
                        .param("nombre", "Juan"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nombre", is("Juan")));
    }

    @Test
    void filtrarPorNumeroCelular_deberiaDevolverEstudianteConNumeroEspecifico() throws Exception {
        when(serviceEstudiante.filtrarPorNumeroCelular("3001234567")).thenReturn(List.of(estudiantesSimulados.get(0)));

        mockMvc.perform(get("/api/estudiantes/filtrar-celular")
                        .param("numeroCelular", "3001234567"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].numeroCelular", is("3001234567")));
    }

    @Test
    void ordenarPorPromedioNotas_deberiaDevolverListaOrdenada() throws Exception {
        when(serviceEstudiante.ordenarPorPromedioNotas()).thenReturn(estudiantesSimulados);

        mockMvc.perform(get("/api/estudiantes/ordenar-promedio"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].promedioNotas", is(4.5)))
                .andExpect(jsonPath("$[1].promedioNotas", is(4.0)));
    }
}
