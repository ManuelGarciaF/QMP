package ar.edu.utn.frba.dds;

import static java.util.Objects.requireNonNull;

import com.google.common.collect.Lists;
import java.util.List;

public class GeneradorSugerencias {
  private final ProveedorClima proveedorClima;

  public GeneradorSugerencias(ProveedorClima proveedorClima) {
    this.proveedorClima = requireNonNull(proveedorClima);
  }

  public List<Atuendo> generarSugerenciasCon(List<Prenda> prendas, Integer edad) {
    // Filtrar prendas que no son aptas para usar a la temperatura actual
    prendas = prendas
        .stream()
        .filter(prenda -> prenda.esAptaaTemperatura(proveedorClima.temperaturaActual()))
        .toList();

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

  private List<Prenda> obtenerPrendasDeCategoria(List<Prenda> prendas, Categoria categoria) {
    return prendas.stream().filter(prenda -> prenda.obtenerCategoria() == categoria).toList();
  }
}
