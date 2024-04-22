package ar.edu.utn.frba.dds;

import java.util.List;

public class GeneradorSugerencias {

  // La implementacion basica, solo usa la primera de cada categoria.
  public Atuendo generarSugerencia(List<Prenda> prendas) {
    var partesSuperiores = obtenerPrendasDeCategoria(prendas, Categoria.PARTE_SUPERIOR);
    var partesInferiores = obtenerPrendasDeCategoria(prendas, Categoria.PARTE_INFERIOR);
    var calzados = obtenerPrendasDeCategoria(prendas, Categoria.CALZADO);

    var sugerencia = new Atuendo();
    sugerencia.agregarPrenda(partesSuperiores.get(0));
    sugerencia.agregarPrenda(partesInferiores.get(0));
    sugerencia.agregarPrenda(calzados.get(0));
    return sugerencia;
  }

  protected List<Prenda> obtenerPrendasDeCategoria(List<Prenda> prendas, Categoria categoria) {
    return prendas.stream().filter(prenda -> prenda.obtenerCategoria() == categoria).toList();
  }
}
