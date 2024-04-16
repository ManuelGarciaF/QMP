package ar.edu.utn.frba.dds;

import static java.util.Objects.requireNonNull;

public class PrendaBuilder {
  private Tipo tipo;
  private String material;
  private Trama trama = Trama.LISA; // Requerimiento 5
  private String colorPrincipal;
  private String colorSecundario;

  public PrendaBuilder(Tipo tipo) {
    this.tipo = requireNonNull(tipo);
  }

  public void conMaterial(String material) {
    requireNonNull(material);
    if (!tipo.materialEsValido(material)) {
      throw new PrendaInvalidaException("Material inválido");
    }

    this.material = material;
  }

  public void conTrama(Trama trama) {
    requireNonNull(trama);
    if (!tipo.tramaEsValida(trama)) {
      throw new PrendaInvalidaException("Trama inválida");
    }

    this.trama = trama;
  }

  public void conColorPrincipal(String colorPrincipal) {
    requireNonNull(colorPrincipal);
    if (!tipo.colorEsValido(colorPrincipal)) {
      throw new PrendaInvalidaException("Color inválido");
    }

    this.colorPrincipal = colorPrincipal;
  }

  public void conColorSecundario(String colorSecundario) {
    requireNonNull(colorSecundario);
    if (!tipo.colorEsValido(colorSecundario)) {
      throw new PrendaInvalidaException("Color inválido");
    }

    this.colorSecundario = colorSecundario;
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
