package ar.edu.utn.frba.dds;

import com.google.common.collect.Lists;
import java.util.List;

public class GeneradorSugerencias {

  // La implementacion basica, solo usa la primera de cada categoria.
  public List<Atuendo> generarSugerenciasCon(List<Prenda> prendas, Integer edad) {
    var partesSuperiores = obtenerPrendasDeCategoria(prendas, Categoria.PARTE_SUPERIOR);
    var partesInferiores = obtenerPrendasDeCategoria(prendas, Categoria.PARTE_INFERIOR);
    var calzados = obtenerPrendasDeCategoria(prendas, Categoria.CALZADO);

    var combinaciones = Lists.cartesianProduct(partesSuperiores, partesInferiores, calzados);

    return combinaciones.stream().map(combinacion -> {
      var atuendo = new Atuendo();
      combinacion.forEach(atuendo::agregarPrenda);
      return atuendo;
    }).toList();
  }

  protected List<Prenda> obtenerPrendasDeCategoria(List<Prenda> prendas, Categoria categoria) {
    return prendas.stream().filter(prenda -> prenda.obtenerCategoria() == categoria).toList();
  }
}
