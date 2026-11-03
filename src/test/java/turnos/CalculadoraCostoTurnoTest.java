package turnos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculadoraCostoTurnoTest {

  @Test
  @DisplayName("Paciente sin obra social y sin urgencia paga el costo base")
  void sinObraSocialSinUrgencia_pagaCostoBase() {
    // Arrange
    CalculadoraCostoTurno calculadora = new CalculadoraCostoTurno();
    int edad = 30;

    // Act
    double costo = calculadora.calcular(edad, false, false);

    // Assert
    assertEquals(10000, costo);
  }

  @Test
  @DisplayName("Jubilado con obra social tiene 50% de descuento")
  void jubiladoConObraSocial_tieneDescuento() {
    // Arrange
    CalculadoraCostoTurno calculadora = new CalculadoraCostoTurno();
    int edad = 70;

    // Act
    double costo = calculadora.calcular(edad, true, false);

    // Assert
    assertEquals(5000, costo);
  }

  @Test
  @DisplayName("Con 65 años justos ya corresponde el descuento")
  void edadLimite65_tieneDescuento() {
    // Arrange
    CalculadoraCostoTurno calculadora = new CalculadoraCostoTurno();
    int edad = 65;

    // Act
    double costo = calculadora.calcular(edad, true, false);

    // Assert
    assertEquals(5000, costo);
  }

  @Test
  @DisplayName("La urgencia suma el recargo después del descuento")
  void jubiladoConUrgencia_descuentoYRecargo() {
    // Arrange
    CalculadoraCostoTurno calculadora = new CalculadoraCostoTurno();
    int edad = 70;

    // Act
    double costo = calculadora.calcular(edad, true, true);

    // Assert
    assertEquals(10000, costo);
  }

  @Test
  @DisplayName("Una edad negativa lanza excepción")
  void edadNegativa_lanzaExcepcion() {
    // Arrange
    CalculadoraCostoTurno calculadora = new CalculadoraCostoTurno();
    int edadInvalida = -1;

    // Act + Assert
    assertThrows(
        IllegalArgumentException.class, () -> calculadora.calcular(edadInvalida, true, false));
  }
}
