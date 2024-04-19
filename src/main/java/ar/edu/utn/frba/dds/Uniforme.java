package ar.edu.utn.frba.dds;

public class Uniforme {
  private Prenda prendaSuperior;
  private Prenda prendaInferior;
  private Prenda calzado;

  public Uniforme(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
    if (!prendaSuperior.esDeCategoria(Categoria.PARTE_SUPERIOR)
        || !prendaInferior.esDeCategoria(Categoria.PARTE_INFERIOR)
        || !calzado.esDeCategoria(Categoria.CALZADO)) {
      throw new RuntimeException("Las prendas no son de las categorias correctas");
    }

    this.prendaSuperior = prendaSuperior;
    this.prendaInferior = prendaInferior;
    this.calzado = calzado;
  }

  public Prenda getPrendaSuperior() {
    return prendaSuperior;
  }

  public Prenda getPrendaInferior() {
    return prendaInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }
}
