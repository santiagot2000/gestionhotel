package com.taller.gestionhotel.domain.models;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.taller.gestionhotel.domain.enums.EstadoPago;
import com.taller.gestionhotel.domain.enums.MetodoPago;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la entidad Pago.
 */
class PagoTest {

    private Pago pago;

    @BeforeEach
    void setUp() {
        pago = new Pago(240000.0, new Date(), MetodoPago.TARJETA, EstadoPago.PENDIENTE);
    }

    @Test
    @DisplayName("Debe procesar el pago y cambiar su estado a COMPLETADO")
    void debeProcesarPagoExitosamente() {
        boolean resultado = pago.procesarPago();

        assertTrue(resultado, "El procesamiento de pago debe retornar true");
        assertEquals(EstadoPago.COMPLETADO, pago.getEstadoPago(), "El estado debe ser COMPLETADO");
    }

    @Test
    @DisplayName("Debe generar el texto del comprobante de pago con el monto correcto")
    void debeGenerarComprobanteDePago() {
        String comprobante = pago.generarComprobante();

        assertNotNull(comprobante, "El comprobante no debe ser nulo");
        assertTrue(comprobante.contains("COMPROBANTE DE PAGO"));
        assertTrue(comprobante.contains("240000.0"));
    }
}