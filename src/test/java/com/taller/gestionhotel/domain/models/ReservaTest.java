package com.taller.gestionhotel.domain.models;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.taller.gestionhotel.domain.enums.EstadoHabitacion;
import com.taller.gestionhotel.domain.enums.EstadoReserva;
import com.taller.gestionhotel.domain.enums.TipoHabitacion;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para validar la lógica de la entidad Reserva.
 */
class ReservaTest {

    private Reserva reserva;

    @BeforeEach
    void setUp() {
        Cliente cliente = new Cliente("10203040", "Carlos", "Pérez", "3001234567", "carlos@gmail.com");
        reserva = new Reserva(new Date(), new Date(), EstadoReserva.PENDIENTE, cliente);
    }

    @Test
    @DisplayName("Debe calcular correctamente el monto total al agregar habitaciones")
    void debeCalcularMontoTotalCorrectamente() {
        Habitacion hab1 = new Habitacion("101", TipoHabitacion.SUITE, 150000.0, EstadoHabitacion.DISPONIBLE);
        Habitacion hab2 = new Habitacion("102", TipoHabitacion.DOBLE, 90000.0, EstadoHabitacion.DISPONIBLE);

        reserva.agregarHabitacion(hab1);
        reserva.agregarHabitacion(hab2);

        double total = reserva.calcularMontoTotal();

        assertEquals(240000.0, total, "La suma total de las habitaciones debe ser 240,000.0");
    }

    @Test
    @DisplayName("Debe cambiar el estado a CONFIRMADA al crear la reserva")
    void debeConfirmarReserva() {
        reserva.crearReserva();
        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstadoReserva());
    }

    @Test
    @DisplayName("Debe cambiar el estado a CANCELADA al cancelar la reserva")
    void debeCancelarReserva() {
        reserva.cancelarReserva();
        assertEquals(EstadoReserva.CANCELADA, reserva.getEstadoReserva());
    }
}