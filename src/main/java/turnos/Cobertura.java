package turnos;

record Cobertura(double porcentajeGeneral, double porcentajeJubilado) {

  double porcentajePaciente(boolean esJubilado) {
    return esJubilado ? porcentajeJubilado : porcentajeGeneral;
  }
}
