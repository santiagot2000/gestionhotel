package com.taller.gestionhotel.domain.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.taller.gestionhotel.domain.enums.EstadoReserva;

/**
 * Entidad principal que administra la reserva de alojamiento.
 * Relaciona al cliente, las habitaciones reservadas y el pago del servicio.
 * 
 * @author Sistema Gestión Hotelera
 * @version 1.0
 */
public class Reserva {
    /** Identificador único de la reserva (UUID). */
    private final String idReserva;
    /** Fecha pactada para el inicio del hospedaje (Check-in). */
    private Date fechaInicio;
    /** Fecha pactada para la salida del hospedaje (Check-out). */
    private Date fechaFin;
    /** Estado de la reserva (PENDIENTE, CONFIRMADA, CANCELADA). */
    private EstadoReserva estadoReserva;
    /** Valor total calculado de la reserva. */
    private double montoTotal;

    /** Cliente titular de la reserva. */
    private Cliente cliente;
    /** Lista de habitaciones asociadas a la reserva. */
    private List<Habitacion> habitaciones;
    /** Transacción de pago vinculada a la reserva. */
    private Pago pago;

    /**
     * Constructor para inicializar una nueva reserva asociada a un cliente.
     * 
     * @param fechaInicio Fecha de entrada.
     * @param fechaFin Fecha de salida.
     * @param estadoReserva Estado inicial de la reserva.
     * @param cliente Cliente que efectúa la solicitud.
     */
    public Reserva(Date fechaInicio, Date fechaFin, EstadoReserva estadoReserva, Cliente cliente) {
        this.idReserva = UUID.randomUUID().toString();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoReserva = estadoReserva;
        this.cliente = cliente;
        this.habitaciones = new ArrayList<>();
        this.montoTotal = 0.0;
    }

    /**
     * Añade una habitación a la lista de habitaciones seleccionadas.
     * 
     * @param habitacion Habitación a vincular.
     */
    public void agregarHabitacion(Habitacion habitacion) {
        this.habitaciones.add(habitacion);
    }

    /**
     * Cambia el estado de la reserva a CONFIRMADA.
     * 
     * @return {@code true} confirmando el cambio exitoso.
     */
    public boolean crearReserva() {
        this.estadoReserva = EstadoReserva.CONFIRMADA;
        return true;
    }

    /**
     * Cancela la reserva cambiando su estado a CANCELADA.
     * 
     * @return {@code true} confirmando la cancelación.
     */
    public boolean cancelarReserva() {
        this.estadoReserva = EstadoReserva.CANCELADA;
        return true;
    }

    /**
     * Calcula el valor total sumando la tarifa por noche de cada habitación en la reserva.
     * 
     * @return El monto total a pagar.
     */
    public double calcularMontoTotal() {
        double total = 0;
        for (Habitacion hab : habitaciones) {
            total += hab.getPrecioNoche();
        }
        this.montoTotal = total;
        return total;
    }

    /**
     * Obtiene el identificador único de la reserva.
     * @return ID de la reserva.
     */
    public String getIdReserva() {
        return idReserva;
    }

    /**
     * Obtiene la fecha de inicio del hospedaje.
     * @return Fecha de inicio.
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Actualiza la fecha de inicio del hospedaje.
     * @param fechaInicio Nueva fecha de entrada.
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de salida del hospedaje.
     * @return Fecha fin.
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * Actualiza la fecha de salida del hospedaje.
     * @param fechaFin Nueva fecha de salida.
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene el estado actual de la reserva.
     * @return Estado de la reserva.
     */
    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    /**
     * Actualiza el estado de la reserva.
     * @param estadoReserva Nuevo estado de la reserva.
     */
    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    /**
     * Obtiene el monto total acumulado de la reserva.
     * @return Valor numérico del monto total.
     */
    public double getMontoTotal() {
        return montoTotal;
    }

    /**
     * Obtiene el cliente asociado a la reserva.
     * @return Cliente titular.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Asigna o cambia el cliente titular de la reserva.
     * @param cliente Nuevo cliente titular.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene la lista de habitaciones agregadas a la reserva.
     * @return Lista de habitaciones.
     */
    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    /**
     * Obtiene el pago asociado a la reserva.
     * @return Registro de pago.
     */
    public Pago getPago() {
        return pago;
    }

    /**
     * Asigna la transacción de pago a la reserva.
     * @param pago Transacción de pago realizada.
     */
    public void setPago(Pago pago) {
        this.pago = pago;
    }
}