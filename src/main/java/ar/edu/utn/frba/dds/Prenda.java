package ar.edu.utn.frba.dds;

public class Prenda {
  private final Tipo tipo;
  private final Material material;
  private final Trama trama;
  private final Color colorPrincipal;
  private final Color colorSecundario;
  private final Formalidad formalidad;
  private final Integer temperaturaMaxima;

  public Prenda(Tipo tipo,
                Material material,
                Color colorPrincipal,
                Color colorSecundario,
                Trama trama,
                Formalidad formalidad, Integer temperaturaMaxima) {
    this.tipo = tipo;
    this.material = material;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorPrincipal;
    this.trama = trama;
    this.formalidad = formalidad;
    this.temperaturaMaxima = temperaturaMaxima;
  }

  public Categoria obtenerCategoria() {
    return this.tipo.getCategoria();
  }

  public Trama getTrama() {
    return trama;
  }

  public Color getColorPrincipal() {
    return colorPrincipal;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }

  public Material getMaterial() {
    return material;
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
