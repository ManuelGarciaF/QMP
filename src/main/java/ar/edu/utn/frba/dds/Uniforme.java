package ar.edu.utn.frba.dds;

public record Uniforme(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
  public Uniforme {
    if (!prendaSuperior.esDeCategoria(Categoria.PARTE_SUPERIOR)
        || !prendaInferior.esDeCategoria(Categoria.PARTE_INFERIOR)
        || !calzado.esDeCategoria(Categoria.CALZADO)) {
      throw new RuntimeException("Las prendas no son de las categorias correctas");
    }
  }
}
