package ar.edu.utn.frba.dds;

public record Prenda(
    Tipo tipo,
    Material material,
    Trama trama,
    Color colorPrincipal,
    Color colorSecundario,
    Formalidad formalidad,
    Integer temperaturaMaxima
) {

  public Categoria obtenerCategoria() {
    return this.tipo.getCategoria();
  }

  public Boolean esDeCategoria(Categoria categoria) {
    return this.tipo.getCategoria().equals(categoria);
  }

  public Boolean esInformal() {
    return this.formalidad == Formalidad.INFORMAL;
  }

  public Boolean esAptaaTemperatura(Integer temperatura) {
    return temperatura <= this.temperaturaMaxima;
  }

}
