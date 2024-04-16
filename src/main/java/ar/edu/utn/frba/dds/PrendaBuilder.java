package ar.edu.utn.frba.dds;

import static java.util.Objects.requireNonNull;

public class PrendaBuilder {
  private Tipo tipo;
  private Material material;
  private Trama trama = Trama.LISA; // Requerimiento 5
  private Color colorPrincipal;
  private Color colorSecundario;

  public PrendaBuilder(Tipo tipo) {
    this.tipo = requireNonNull(tipo);
  }

  public PrendaBuilder conMaterial(Material material) {
    requireNonNull(material);
    if (!tipo.materialEsValido(material)) {
      throw new PrendaInvalidaException("Material inválido");
    }

    this.material = material;
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

  public Prenda construirPrenda() {
    if (tipo == null || material == null || colorPrincipal == null) {
      throw new PrendaInvalidaException("Faltan datos obligatorios");
    }

    Prenda prenda = new Prenda(tipo, material, colorPrincipal, trama);
    if (colorSecundario != null) {
      prenda.setColorSecundario(colorSecundario);
    }

    return prenda;
  }

}
