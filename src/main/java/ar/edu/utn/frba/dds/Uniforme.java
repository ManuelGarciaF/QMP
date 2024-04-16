package ar.edu.utn.frba.dds;

public class Uniforme {
  private Prenda prendaSuperior;
  private Prenda prendaInferior;
  private Prenda calzado;

  public Uniforme(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
    this.prendaSuperior = prendaSuperior;
    this.prendaInferior = prendaInferior;
    this.calzado = calzado;
  }

  public static Uniforme uniformeSanJuan() {
    Prenda prendaSuperior = new PrendaBuilder(Tipo.CHOMBA)
        .conMaterial(Material.PIQUE)
        .conColorPrincipal(Color.VERDE)
        .construirPrenda();

    Prenda prendaInferior = new PrendaBuilder(Tipo.PANTALON)
        .conMaterial(Material.ACETATO)
        .conColorPrincipal(Color.GRIS)
        .construirPrenda();

    Prenda calzado = new PrendaBuilder(Tipo.ZAPATILLAS)
        .conMaterial(Material.CUERO)
        .conColorPrincipal(Color.VERDE)
        .construirPrenda();

    return new Uniforme(prendaSuperior, prendaInferior, calzado);

  }
}
