package com.taller.gestionhotel.domain.models;

import java.util.UUID;

import com.taller.gestionhotel.domain.enums.EstadoHabitacion;
import com.taller.gestionhotel.domain.enums.TipoHabitacion;

/**
 * Representa una habitación en el inventario del hotel.
 * Almacena su número físico, tipo, tarifa por noche y estado actual de disponibilidad.
 * 
 * @author Sistema Gestión Hotelera
 * @version 1.0
 */
public class Habitacion {
    /** Identificador único de la habitación (UUID). */
    private final String idHabitacion;
    /** Número físico o código de la habitación. */
    private String numero;
    /** Categoría o tipo de habitación (INDIVIDUAL, DOBLE, SUITE). */
    private TipoHabitacion tipo;
    /** Tarifa por noche de la habitación. */
    private double precioNoche;
    /** Estado de la habitación (DISPONIBLE, OCUPADA, MANTENIMIENTO). */
    private EstadoHabitacion estadoHabitacion;

    /**
     * Constructor para inicializar una nueva habitación.
     * 
     * @param numero Número identificador de la habitación.
     * @param tipo Tipo o categoría de la habitación.
     * @param precioNoche Valor del hospedaje por noche.
     * @param estadoHabitacion Estado inicial de disponibilidad.
     */
    public Habitacion(String numero, TipoHabitacion tipo, double precioNoche, EstadoHabitacion estadoHabitacion) {
        this.idHabitacion = UUID.randomUUID().toString();
        this.numero = numero;
        this.tipo = tipo;
        this.precioNoche = precioNoche;
        this.estadoHabitacion = estadoHabitacion;
    }

    /**
     * Cambia el estado actual de la habitación a DISPONIBLE.
     */
    public void cambiarEstado() {
        this.estadoHabitacion = EstadoHabitacion.DISPONIBLE;
    }

    /**
     * Obtiene el identificador único de la habitación.
     * @return ID de la habitación.
     */
    public String getIdHabitacion() {
        return idHabitacion;
    }

    /**
     * Obtiene el número físico de la habitación.
     * @return Número de la habitación.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número físico de la habitación.
     * @param numero Nuevo número de la habitación.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene la categoría o tipo de la habitación.
     * @return Tipo de la habitación.
     */
    public TipoHabitacion getTipo() {
        return tipo;
    }

    /**
     * Asigna un nuevo tipo o categoría a la habitación.
     * @param tipo Nuevo tipo de habitación.
     */
    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el valor por noche de la habitación.
     * @return Precio por noche.
     */
    public double getPrecioNoche() {
        return precioNoche;
    }

    /**
     * Actualiza el valor por noche de la habitación.
     * @param precioNoche Nuevo precio por noche.
     */
    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    /**
     * Obtiene el estado actual de la habitación.
     * @return Estado de la habitación.
     */
    public EstadoHabitacion getEstadoHabitacion() {
        return estadoHabitacion;
    }

    /**
     * Asigna un nuevo estado a la habitación.
     * @param estadoHabitacion Nuevo estado de la habitación.
     */
    public void setEstadoHabitacion(EstadoHabitacion estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }
}