# Sistema de Gestión Hotelera - Spring Boot

Este proyecto es la implementación en Java / Spring Boot del sistema de gestión hotelera, correspondiente a la entrega académica.

## 🚀 Tecnologías Utilizadas
- **Java 21**
- **Spring Boot** (Spring Data JPA, WebMVC)
- **H2 Database** (Base de datos en memoria)
- **JUnit 5** (Pruebas unitarias)
- **Javadoc** (Documentación de la API)
- **Maven** (Gestor de dependencias)

---

## 📋 Funcionalidades e Implementación
El proyecto implementa las clases del modelo de dominio:
1. `Usuario`: Autenticación e inicio de sesión.
2. `Cliente`: Datos personales del huésped.
3. `Habitacion`: Tipos, precios y estado de disponibilidad.
4. `Reserva`: Lógica para agregar habitaciones, cálculo de montos y estados.
5. `Pago`: Procesamiento de pago y generación de comprobante.

---

## 🧪 Pruebas Unitarias (JUnit 5)
Para ejecutar todas las pruebas desde la consola:
```bash
.\mvnw test