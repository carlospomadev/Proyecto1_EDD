package com.carlospoma.proyecto1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        // Constructor con 4 parámetros: nombre, DNI, teléfono, email
        // Parametros en orden para coincidir con la clase Cliente.java
        cliente = new Cliente("Carlos", "12345678A", "987654321", "carlos@mail.com");
    }

    @AfterEach
    void tearDown() {
        cliente = null;
    }

    @Test
    void testConstructorYGetters() {
        assertEquals("Carlos", cliente.getNombre());
        assertEquals("12345678A", cliente.getDni());
        assertEquals("987654321", cliente.getTelefono());
        assertEquals("carlos@mail.com", cliente.getEmail());
    }

    @Test
    void testCambioDeNombre() {
        cliente.setNombre("Daniel");
        assertEquals("Daniel", cliente.getNombre());
    }
}