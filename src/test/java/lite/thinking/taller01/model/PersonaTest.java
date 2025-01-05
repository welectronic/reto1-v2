package lite.thinking.taller01.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Persona.
 */
class PersonaTest {

    private Persona persona;

    @BeforeEach
    void setUp() {
        // Inicializamos una instancia de Persona antes de cada prueba
        persona = new Persona();
    }

    @Test
    void testSetAndGetNombre() {
        persona.setNombre("Juan Pérez");
        assertEquals("Juan Pérez", persona.getNombre());
    }

    @Test
    void testSetAndGetNumeroCelular() {
        persona.setNumeroCelular("3001234567");
        assertEquals("3001234567", persona.getNumeroCelular());
    }

    @Test
    void testSetAndGetCorreoElectronico() {
        persona.setCorreoElectronico("juan.perez@example.com");
        assertEquals("juan.perez@example.com", persona.getCorreoElectronico());
    }

    @Test
    void testComprarPaseEstacionamiento() {
        persona.setNombre("Ana María");
        // Capturamos la salida en consola para validar el método
        String mensajeEsperado = "Ana María ha comprado un pase de estacionamiento.";
        
        // Prueba básica: asegurar que no arroje excepciones al llamarlo
        try {
            assertEquals(mensajeEsperado, persona.comprarPaseEstacionamiento());
        } catch (Exception e) {
            fail("El método comprarPaseEstacionamiento lanzó una excepción inesperada.");
        }
    }
}
