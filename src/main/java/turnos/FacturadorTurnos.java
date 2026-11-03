package turnos;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

public class FacturadorTurnos {

  public String facturar(String obraSocial, int edad, boolean urgencia, boolean feriado) {
    double total = 0;
    if (obraSocial.equals("OSDE")) {
      if (edad >= 65) {
        total = 10000 * 0.3;
        if (urgencia) {
          total = total + 5000 * 0.3;
        }
        if (feriado) {
          total = total + 2000 * 0.3;
        }
      } else {
        total = 10000 * 0.4;
        if (urgencia) {
          total = total + 5000 * 0.4;
        }
        if (feriado) {
          total = total + 2000 * 0.4;
        }
      }
    } else if (obraSocial.equals("PAMI")) {
      if (edad >= 65) {
        total = 0;
      } else {
        total = 10000 * 0.5;
        if (urgencia) {
          total = total + 5000 * 0.5;
        }
        if (feriado) {
          total = total + 2000 * 0.5;
        }
      }
    } else if (obraSocial.equals("SWISS")) {
      if (edad >= 65) {
        total = 10000 * 0.35;
        if (urgencia) {
          total = total + 5000 * 0.35;
        }
        if (feriado) {
          total = total + 2000 * 0.35;
        }
      } else {
        total = 10000 * 0.45;
        if (urgencia) {
          total = total + 5000 * 0.45;
        }
        if (feriado) {
          total = total + 2000 * 0.45;
        }
      }
    } else {
      total = 10000;
      if (urgencia) {
        total = total + 5000;
      }
      if (feriado) {
        total = total + 2000;
      }
    }
    Map<String, String> valores = new HashMap<>();
    valores.put("os", obraSocial);
    valores.put("total", String.valueOf(total));
    StringSubstitutor sub = new StringSubstitutor(valores);
    return sub.replace("Obra social: ${os} - Total: ${total}");
  }

  public double presupuestar(String obraSocial, int edad, boolean urgencia, boolean feriado) {
    double total = 0;
    if (obraSocial.equals("OSDE")) {
      if (edad >= 65) {
        total = 10000 * 0.3;
        if (urgencia) {
          total = total + 5000 * 0.3;
        }
        if (feriado) {
          total = total + 2000 * 0.3;
        }
      } else {
        total = 10000 * 0.4;
        if (urgencia) {
          total = total + 5000 * 0.4;
        }
        if (feriado) {
          total = total + 2000 * 0.4;
        }
      }
    } else if (obraSocial.equals("PAMI")) {
      if (edad >= 65) {
        total = 0;
      } else {
        total = 10000 * 0.5;
        if (urgencia) {
          total = total + 5000 * 0.5;
        }
        if (feriado) {
          total = total + 2000 * 0.5;
        }
      }
    } else if (obraSocial.equals("SWISS")) {
      if (edad >= 65) {
        total = 10000 * 0.35;
        if (urgencia) {
          total = total + 5000 * 0.35;
        }
        if (feriado) {
          total = total + 2000 * 0.35;
        }
      } else {
        total = 10000 * 0.45;
        if (urgencia) {
          total = total + 5000 * 0.45;
        }
        if (feriado) {
          total = total + 2000 * 0.45;
        }
      }
    } else {
      total = 10000;
      if (urgencia) {
        total = total + 5000;
      }
      if (feriado) {
        total = total + 2000;
      }
    }
    return total;
  }
}
