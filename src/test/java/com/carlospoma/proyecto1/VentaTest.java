package com.carlospoma.proyecto1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VentaTest {

    private Cliente cliente;
    private Venta venta;
    private Pajaro pajaro1;
    private Pajaro pajaro2;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Carlos", "carlos@mail.com", "123456789", "Madrid");
        venta = new Venta(cliente);

        pajaro1 = new Pajaro("Canario", "Amarillo", 50.0);
        pajaro2 = new Pajaro("Periquito", "Verde", 30.0);
    }

    @AfterEach
    void tearDown() {
        cliente = null;
        venta = null;
        pajaro1 = null;
        pajaro2 = null;
    }

    @Test
    void testAñadirPajaroYCalcularTotal() {
        venta.añadirPajaro(pajaro1);
        venta.añadirPajaro(pajaro2);

        double totalEsperado = 80.0;
        assertEquals(totalEsperado, venta.calcularTotal(), 0.001);
    }

    @Test
    void testCalcularTotalSinPajaros() {
        assertEquals(0.0, venta.calcularTotal(), 0.001);
    }

    @Test
    void testAñadirUnPajaro() {
        venta.añadirPajaro(pajaro1);
        assertEquals(50.0, venta.calcularTotal(), 0.001);
    }

    @Test
    void testMostrarInfoNoLanzaErrores() {
        venta.añadirPajaro(pajaro1);
        venta.añadirPajaro(pajaro2);

        // Validamos que no lance excepciones al ejecutarse
        assertDoesNotThrow(() -> venta.mostrarInfo());
    }
}
