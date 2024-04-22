package ar.edu.utn.frba.dds;

import java.util.List;

public class GeneradorSugerenciasPorEdad extends GeneradorSugerencias {
  private int edadUsuario;

  public GeneradorSugerenciasPorEdad(int edadUsuario) {
    this.edadUsuario = edadUsuario;
  }

  @Override
  public Atuendo generarSugerencia(List<Prenda> prendas) {
    if (edadUsuario <= 55) {
      return super.generarSugerencia(prendas);
    }
    // Si es mayor a 55, se filtran las prendas informales.
    var prendasNoInformales = prendas.stream().filter(prenda -> !prenda.esInformal()).toList();
    return super.generarSugerencia(prendasNoInformales);
  }
}
