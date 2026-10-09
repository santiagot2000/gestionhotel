package com.taller.gestionhotel.domain.models;

import java.util.UUID;
import com.taller.gestionhotel.domain.enums.RolUsuario;

/**
 * Representa a un usuario del sistema (personal administrativo o recepcionista).
 * Gestiona el inicio de sesión y la asignación de roles de acceso.
 * 
 * @author Sistema Gestión Hotelera
 * @version 1.0
 */
public class Usuario {
    /** Identificador único e inmutable del usuario (UUID). */
    private final String idUsuario;
    /** Nombre de usuario para autenticación. */
    private String nombre;
    /** Contraseña de acceso al sistema. */
    private String contraseña;
    /** Rol del usuario dentro del sistema (ADMINISTRADOR, RECEPCIONISTA). */
    private RolUsuario rol;

    /**
     * Constructor para crear un nuevo usuario con ID generado automáticamente.
     * 
     * @param nombre Nombre de usuario para el inicio de sesión.
     * @param contraseña Contraseña del usuario.
     * @param rol Rol asignado al usuario.
     */
    public Usuario(String nombre, String contraseña, RolUsuario rol) {
        this.idUsuario = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    /**
     * Valida si las credenciales ingresadas coinciden con el usuario y la contraseña.
     * 
     * @param user Nombre de usuario ingresado.
     * @param pass Contraseña ingresada.
     * @return {@code true} si las credenciales son válidas; {@code false} en caso contrario.
     */
    public boolean iniciarSesion(String user, String pass) {
        return this.nombre.equalsIgnoreCase(user) && this.contraseña.equals(pass);
    }

    /**
     * Obtiene el identificador único del usuario.
     * @return ID del usuario.
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * Obtiene el nombre de usuario.
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre de usuario.
     * @param nombre Nuevo nombre de usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return Contraseña actual.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Actualiza la contraseña del usuario.
     * @param contraseña Nueva contraseña.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Obtiene el rol del usuario.
     * @return Rol del usuario.
     */
    public RolUsuario getRol() {
        return rol;
    }

    /**
     * Asigna un nuevo rol al usuario.
     * @param rol Nuevo rol a asignar.
     */
    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }
}