package com.taller.gestionhotel.domain.models;

import java.util.UUID;

/**
 * Representa a un cliente dentro del sistema hotelero.
 * Contiene la información personal y los datos de contacto necesarios
 * para realizar reservas y registros en el hotel.
 * 
 * @author Sistema Gestión Hotelera
 * @version 1.0
 */
public class Cliente {
    /** Identificador único del cliente (UUID). */
    private final String idCliente;
    /** Documento de identidad o cédula del cliente. */
    private String documento;
    /** Nombre del cliente. */
    private String nombre;
    /** Apellido del cliente. */
    private String apellido;
    /** Número telefónico de contacto. */
    private String telefono;
    /** Dirección de correo electrónico. */
    private String email;

    /**
     * Constructor para registrar un nuevo cliente con ID generado automáticamente.
     * 
     * @param documento Documento de identidad.
     * @param nombre Nombre del cliente.
     * @param apellido Apellido del cliente.
     * @param telefono Teléfono de contacto.
     * @param email Correo electrónico.
     */
    public Cliente(String documento, String nombre, String apellido, String telefono, String email) {
        this.idCliente = UUID.randomUUID().toString();
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    /**
     * Confirma el registro del cliente en el sistema.
     * 
     * @return {@code true} si el cliente se registró correctamente.
     */
    public boolean registrarCliente() {
        return true;
    }

    /**
     * Obtiene el identificador único del cliente.
     * @return ID del cliente.
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Obtiene el documento de identidad.
     * @return Documento del cliente.
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * Actualiza el documento de identidad del cliente.
     * @param documento Nuevo documento de identidad.
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * Obtiene el nombre del cliente.
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * @param nombre Nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del cliente.
     * @return Apellido del cliente.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del cliente.
     * @param apellido Nuevo apellido del cliente.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el teléfono de contacto.
     * @return Teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Actualiza el teléfono de contacto del cliente.
     * @param telefono Nuevo número telefónico.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     * @return Email del cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Actualiza el correo electrónico del cliente.
     * @param email Nuevo correo electrónico.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}