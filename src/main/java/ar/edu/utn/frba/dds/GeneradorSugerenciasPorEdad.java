package ar.edu.utn.frba.dds;

import java.util.List;

public class GeneradorSugerenciasPorEdad extends GeneradorSugerencias {

  @Override
  public List<Atuendo> generarSugerenciasCon(List<Prenda> prendas, Integer edad) {
    if (edad <= 55) {
      return super.generarSugerenciasCon(prendas, edad);
    }
    // Si es mayor a 55, se filtran las prendas informales.
    var prendasNoInformales = prendas.stream().filter(prenda -> !prenda.esInformal()).toList();
    return super.generarSugerenciasCon(prendasNoInformales, edad);
  }
}
