package com.taller.gestionhotel.domain.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.taller.gestionhotel.domain.enums.RolUsuario;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la entidad Usuario.
 */
class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("admin", "1234", RolUsuario.ADMINISTRADOR);
    }

    @Test
    @DisplayName("Debe iniciar sesión correctamente con credenciales válidas")
    void debeIniciarSesionConCredencialesCorrectas() {
        boolean login = usuario.iniciarSesion("admin", "1234");
        assertTrue(login, "El login debería ser exitoso");
    }

    @Test
    @DisplayName("Debe denegar el acceso si la contraseña es incorrecta")
    void debeDenegarAccesoConPasswordIncorrecto() {
        boolean login = usuario.iniciarSesion("admin", "error");
        assertFalse(login, "El login debería fallar con contraseña errónea");
    }

    @Test
    @DisplayName("Debe ignorar mayúsculas en el nombre de usuario")
    void debeIgnorarMayusculasEnUsuario() {
        boolean login = usuario.iniciarSesion("ADMIN", "1234");
        assertTrue(login, "El nombre de usuario no debe ser sensible a mayúsculas");
    }
}