package turnos;

import java.util.Map;

public class FacturadorTurnos {

  private static final double COSTO_BASE = 10000;
  private static final double RECARGO_URGENCIA = 5000;
  private static final double RECARGO_FERIADO = 2000;
  private static final int EDAD_JUBILADO = 65;

  private static final Cobertura PARTICULAR = new Cobertura(1.0, 1.0);

  private static final Map<String, Cobertura> COBERTURAS =
      Map.of(
          "OSDE", new Cobertura(0.4, 0.3),
          "PAMI", new Cobertura(0.5, 0.0),
          "SWISS", new Cobertura(0.45, 0.35));

  public String facturar(String obraSocial, int edad, boolean urgencia, boolean feriado) {
    double total = presupuestar(obraSocial, edad, urgencia, feriado);
    return "Obra social: " + obraSocial + " - Total: " + total;
  }

  public double presupuestar(String obraSocial, int edad, boolean urgencia, boolean feriado) {
    Cobertura cobertura = COBERTURAS.getOrDefault(obraSocial, PARTICULAR);
    double porcentaje = cobertura.porcentajePaciente(edad >= EDAD_JUBILADO);
    return costoBase(porcentaje)
        + recargo(urgencia, RECARGO_URGENCIA, porcentaje)
        + recargo(feriado, RECARGO_FERIADO, porcentaje);
  }

  private double costoBase(double porcentaje) {
    return COSTO_BASE * porcentaje;
  }

  private double recargo(boolean aplica, double monto, double porcentaje) {
    return aplica ? monto * porcentaje : 0;
  }
}
