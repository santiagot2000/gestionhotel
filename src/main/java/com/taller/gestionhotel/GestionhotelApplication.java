package com.taller.gestionhotel;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.taller.gestionhotel.domain.enums.EstadoHabitacion;
import com.taller.gestionhotel.domain.enums.EstadoPago;
import com.taller.gestionhotel.domain.enums.EstadoReserva;
import com.taller.gestionhotel.domain.enums.MetodoPago;
import com.taller.gestionhotel.domain.enums.RolUsuario;
import com.taller.gestionhotel.domain.enums.TipoHabitacion;
import com.taller.gestionhotel.domain.models.Cliente;
import com.taller.gestionhotel.domain.models.Habitacion;
import com.taller.gestionhotel.domain.models.Pago;
import com.taller.gestionhotel.domain.models.Reserva;
import com.taller.gestionhotel.domain.models.Usuario;

@SpringBootApplication
public class GestionhotelApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GestionhotelApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n=============================================");
        System.out.println("   SISTEMA DE GESTIÓN HOTELERA - PRUEBAS     ");
        System.out.println("=============================================\n");

        // 1. Probar autenticación de Usuario
        System.out.println("--- 1. AUTENTICACIÓN ---");
        Usuario recepcionista = new Usuario("admin", "1234", RolUsuario.ADMINISTRADOR);
        
        boolean loginExitoso = recepcionista.iniciarSesion("ADMIN", "1234");
        if (loginExitoso) {
            System.out.println("-> Inicio de sesión exitoso. Bienvenido " + recepcionista.getNombre() + "!");
        } else {
            System.out.println("-> Credenciales incorrectas.");
        }
        System.out.println();

        // 2. Crear Cliente
        System.out.println("--- 2. REGISTRO DE CLIENTE ---");
        Cliente cliente1 = new Cliente("10203040", "Carlos", "Pérez", "3001234567", "carlos@gmail.com");
        cliente1.registrarCliente();
        System.out.println("   ID Cliente: " + cliente1.getIdCliente());
        System.out.println();

        // 3. Crear Habitaciones
        System.out.println("--- 3. REGISTRO DE HABITACIONES ---");
        Habitacion hab101 = new Habitacion("101", TipoHabitacion.SUITE, 150000.0, EstadoHabitacion.DISPONIBLE);
        Habitacion hab102 = new Habitacion("102", TipoHabitacion.DOBLE, 90000.0, EstadoHabitacion.DISPONIBLE);
        
        System.out.println("-> Habitación " + hab101.getNumero() + " (" + hab101.getTipo() + ") - $" + hab101.getPrecioNoche());
        System.out.println("-> Habitación " + hab102.getNumero() + " (" + hab102.getTipo() + ") - $" + hab102.getPrecioNoche());
        System.out.println();

        // 4. Crear Reserva
        System.out.println("--- 4. CREACIÓN DE RESERVA ---");
        Date fechaInicio = new Date();
        Date fechaFin = new Date(fechaInicio.getTime() + (1000 * 60 * 60 * 24 * 3)); // +3 días

        Reserva reserva1 = new Reserva(fechaInicio, fechaFin, EstadoReserva.PENDIENTE, cliente1);
        reserva1.agregarHabitacion(hab101);
        reserva1.agregarHabitacion(hab102);

        reserva1.crearReserva();
        double total = reserva1.calcularMontoTotal();

        System.out.println("-> Reserva Creada ID: " + reserva1.getIdReserva());
        System.out.println("   Cliente: " + reserva1.getCliente().getNombre() + " " + reserva1.getCliente().getApellido());
        System.out.println("   Habitaciones reservadas: " + reserva1.getHabitaciones().size());
        System.out.println("   Monto Total: $" + total);
        System.out.println("   Estado Reserva: " + reserva1.getEstadoReserva());
        System.out.println();

        // 5. Procesar Pago
        System.out.println("--- 5. PROCESAMIENTO DE PAGO ---");
        Pago pagoReserva = new Pago(total, new Date(), MetodoPago.TARJETA, EstadoPago.PENDIENTE);
        pagoReserva.procesarPago();
        reserva1.setPago(pagoReserva);

        System.out.println(pagoReserva.generarComprobante());
        System.out.println("\n=============================================");
        System.out.println("        ¡PRUEBA COMPLETADA CON ÉXITO!        ");
        System.out.println("=============================================\n");
    }
}