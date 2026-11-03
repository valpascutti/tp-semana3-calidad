package turnos;

public class CalculadoraCostoTurno {

  static final double COSTO_BASE = 10000;
  static final double RECARGO_URGENCIA = 5000;
  static final double DESCUENTO_JUBILADO = 0.5;
  static final int EDAD_JUBILACION = 65;

  public double calcular(int edad, boolean tieneObraSocial, boolean esUrgencia) {
    if (edad < 0) {
      throw new IllegalArgumentException("La edad no puede ser negativa");
    }
    double costo = COSTO_BASE;
    if (tieneObraSocial && edad >= EDAD_JUBILACION) {
      costo = costo * DESCUENTO_JUBILADO;
    }
    if (esUrgencia) {
      costo = costo + RECARGO_URGENCIA;
    }
    return costo;
  }
}
