package com.taller.gestionhotel.domain.models;

import java.util.Date;
import java.util.UUID;

import com.taller.gestionhotel.domain.enums.EstadoPago;
import com.taller.gestionhotel.domain.enums.MetodoPago;

/**
 * Gestor de transacciones financieras dentro del sistema.
 * Registra los valores pagados, métodos de pago y comprobantes generados.
 * 
 * @author Sistema Gestión Hotelera
 * @version 1.0
 */
public class Pago {
    /** Identificador único del pago (UUID). */
    private final String idPago;
    /** Monto o valor de la transacción. */
    private double monto;
    /** Fecha en la que se efectúa el pago. */
    private Date fechaPago;
    /** Medio de pago utilizado (EFECTIVO, TARJETA, TRANSFERENCIA). */
    private MetodoPago metodoPago;
    /** Estado del pago (PENDIENTE, COMPLETADO, RECHAZADO). */
    private EstadoPago estadoPago;

    /**
     * Constructor para registrar un intento de pago.
     * 
     * @param monto Monto total a pagar.
     * @param fechaPago Fecha del pago.
     * @param metodoPago Método de pago seleccionado.
     * @param estadoPago Estado inicial del pago.
     */
    public Pago(double monto, Date fechaPago, MetodoPago metodoPago, EstadoPago estadoPago) {
        this.idPago = UUID.randomUUID().toString();
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.estadoPago = estadoPago;
    }

    /**
     * Procesa la transacción actual y cambia su estado a COMPLETADO.
     * 
     * @return {@code true} si el pago se procesó exitosamente.
     */
    public boolean procesarPago() {
        this.estadoPago = EstadoPago.COMPLETADO;
        return true;
    }

    /**
     * Genera la representación textual del comprobante de pago con todos sus detalles.
     * 
     * @return Cadena de texto con la estructura del comprobante.
     */
    public String generarComprobante() {
        return "=== COMPROBANTE DE PAGO ===" +
               "\nID Pago: " + idPago +
               "\nMonto: $" + monto +
               "\nFecha: " + fechaPago +
               "\nMétodo: " + metodoPago +
               "\nEstado: " + estadoPago;
    }

    /**
     * Obtiene el identificador único del pago.
     * @return ID del pago.
     */
    public String getIdPago() {
        return idPago;
    }

    /**
     * Obtiene el monto del pago.
     * @return Valor del monto.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Establece un nuevo monto de pago.
     * @param monto Nuevo monto.
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Obtiene la fecha de realización del pago.
     * @return Fecha del pago.
     */
    public Date getFechaPago() {
        return fechaPago;
    }

    /**
     * Establece la fecha de realización del pago.
     * @param fechaPago Nueva fecha de pago.
     */
    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    /**
     * Obtiene el método de pago utilizado.
     * @return Método de pago.
     */
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    /**
     * Asigna el método de pago utilizado.
     * @param metodoPago Nuevo método de pago.
     */
    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    /**
     * Obtiene el estado actual del pago.
     * @return Estado del pago.
     */
    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    /**
     * Actualiza el estado del pago.
     * @param estadoPago Nuevo estado del pago.
     */
    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }
}