package turnos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FacturadorTurnosTest {

  @Test
  @DisplayName("OSDE menor de 65 sin recargos paga el 40%")
  void osdeGeneral_pagaCuarentaPorCiento() {
    // Arrange
    FacturadorTurnos facturador = new FacturadorTurnos();

    // Act
    double total = facturador.presupuestar("OSDE", 40, false, false);

    // Assert
    assertEquals(4000.0, total, 0.001);
  }

  @Test
  @DisplayName("OSDE jubilado con urgencia y feriado paga el 30% de todo")
  void osdeJubiladoConRecargos_pagaTreintaPorCiento() {
    // Arrange
    FacturadorTurnos facturador = new FacturadorTurnos();

    // Act
    double total = facturador.presupuestar("OSDE", 70, true, true);

    // Assert
    assertEquals(5100.0, total, 0.001);
  }

  @Test
  @DisplayName("OSDE menor de 65 con urgencia y feriado paga el 40% de todo")
  void osdeGeneralConRecargos_pagaCuarentaPorCiento() {
    // Arrange
    FacturadorTurnos facturador = new FacturadorTurnos();

    // Act
    double total = facturador.presupuestar("OSDE", 30, true, true);

    // Assert
    assertEquals(6800.0, total, 0.001);
  }

  @Test
  @DisplayName("OSDE jubilado sin recargos paga el 30%")
  void osdeJubiladoSinRecargos_pagaTreintaPorCiento() {
    // Arrange
    FacturadorTurnos facturador = new FacturadorTurnos();

    // Act
    double total = facturador.presupuestar("OSDE", 65, false, false);

    // Assert
    assertEquals(3000.0, total, 0.001);
  }

  @Test
  @DisplayName("PAMI jubilado no paga nada, aunque sea urgencia")
  void pamiJubilado_noPaga() {
    // Arrange
    FacturadorTurnos facturador = new FacturadorTurnos();

    // Act
    double total = facturador.presupuestar("PAMI", 80, true, true);

    // Assert
    assertEquals(0.0, total, 0.001);
  }

  @Test
  @DisplayName("PAMI menor de 65 con recargos paga el 50%")
  void pamiGeneralConRecargos_pagaMitad() {
    // Arrange
    FacturadorTurnos facturador = new FacturadorTurnos();

    // Act
    double total = facturador.presupuestar("PAMI", 50, true, true);

    // Assert
    assertEquals(8500.0, total, 0.001);
  }

  @Test
  @DisplayName("PAMI menor de 65 sin recargos paga el 50%")
  void pamiGeneralSinRecargos_pagaMitad() {
    // Arrange
    FacturadorTurnos facturador = new FacturadorTurnos();

    // Act
    double total = facturador.presupuestar("PAMI", 50, false, false);

    // Assert
    assertEquals(5000.0, total, 0.001);
  }

  @Test
  @DisplayName("SWISS jubilado con recargos paga el 35%")
  void swissJubiladoConRecargos_pagaTreintaYCinco() {
    // Arrange
    FacturadorTurnos facturador = new FacturadorTurnos();

    // Act
    double total = facturador.presupuestar("SWISS", 70, true, true);

    // Assert
    assertEquals(5950.0, total, 0.001);
  }

  @Test
  @DisplayName("SWISS jubilado sin recargos paga el 35%")
  void swissJubiladoSinRecargos_pagaTreintaYCinco() {
    // Arrange
    FacturadorTurnos facturador = new FacturadorTurnos();

    // Act
    double total = facturador.presupuestar("SWISS", 70, false, false);

    // Assert
    assertEquals(3500.0, total, 0.001);
  }

  @Test
  @DisplayName("SWISS menor de 65 con recargos paga el 45%")
  void swissGeneralConRecargos_pagaCuarentaYCinco() {
    // Arrange
    FacturadorTurnos facturador = new FacturadorTurnos();

    // Act
    double total = facturador.presupuestar("SWISS", 30, true, true);

    // Assert
    assertEquals(7650.0, total, 0.001);
  }

  @Test
  @DisplayName("SWISS menor de 65 sin recargos paga el 45%")
  void swissGeneralSinRecargos_pagaCuarentaYCinco() {
    // Arrange
    FacturadorTurnos facturador = new FacturadorTurnos();

    // Act
    double total = facturador.presupuestar("SWISS", 30, false, false);

    // Assert
    assertEquals(4500.0, total, 0.001);
  }

  @Test
  @DisplayName("Particular con urgencia y feriado paga todo completo")
  void particularConRecargos_pagaCompleto() {
    // Arrange
    FacturadorTurnos facturador = new FacturadorTurnos();

    // Act
    double total = facturador.presupuestar("PARTICULAR", 30, true, true);

    // Assert
    assertEquals(17000.0, total, 0.001);
  }

  @Test
  @DisplayName("Particular sin recargos paga el costo base")
  void particularSinRecargos_pagaBase() {
    // Arrange
    FacturadorTurnos facturador = new FacturadorTurnos();

    // Act
    double total = facturador.presupuestar("PARTICULAR", 30, false, false);

    // Assert
    assertEquals(10000.0, total, 0.001);
  }

  @Test
  @DisplayName("La factura muestra la obra social y el total")
  void facturar_armaElTexto() {
    // Arrange
    FacturadorTurnos facturador = new FacturadorTurnos();

    // Act
    String factura = facturador.facturar("OSDE", 40, false, false);

    // Assert
    assertEquals("Obra social: OSDE - Total: 4000.0", factura);
  }
}
