package ar.edu.utn.frba.dds;

import static java.util.Objects.requireNonNull;

public class PrendaBuilder {
  private Tipo tipo;
  private Material material;
  private Trama trama = Trama.LISA; // Requerimiento 5
  private Color colorPrincipal;
  private Color colorSecundario;
  private Formalidad formalidad;
  private Integer temperaturaMaxima;

  public PrendaBuilder(Tipo tipo) {
    this.tipo = requireNonNull(tipo);
  }

  public PrendaBuilder conMaterial(Material material) {
    this.material = requireNonNull(material);
    return this;
  }

  public PrendaBuilder conTrama(Trama trama) {
    this.trama = requireNonNull(trama);
    return this;
  }

  public PrendaBuilder conColorPrincipal(Color colorPrincipal) {
    this.colorPrincipal = requireNonNull(colorPrincipal);
    return this;
  }

  public PrendaBuilder conColorSecundario(Color colorSecundario) {
    this.colorSecundario = requireNonNull(colorSecundario);
    return this;
  }

  public PrendaBuilder conFormalidad(Formalidad formalidad) {
    this.formalidad = requireNonNull(formalidad);
    return this;
  }

  public PrendaBuilder conTemperaturaMaxima(Integer temperaturaMaxima) {
    this.temperaturaMaxima = requireNonNull(temperaturaMaxima);
    return this;
  }

  public Prenda construirPrenda() {
    if (tipo == null
        || material == null
        || colorPrincipal == null
        || formalidad == null
        || temperaturaMaxima == null) {
      throw new PrendaInvalidaException("Faltan datos obligatorios");
    }

    return new Prenda(tipo,
        material,
        colorPrincipal,
        colorSecundario,
        trama,
        formalidad,
        temperaturaMaxima);
  }

}
