package ar.edu.utn.frba.dds;

public class Prenda {
  private Tipo tipo;
  private Material material;
  private Trama trama;
  private Color colorPrincipal;
  private Color colorSecundario;

  public Prenda(Tipo tipo, Material material, Color colorPrincipal, Trama trama) {
    this.tipo = tipo;
    this.material = material;
    this.colorPrincipal = colorPrincipal;
    this.trama = trama;
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

  public void setColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public Boolean esDeCategoria(Categoria categoria) {
    return this.tipo.getCategoria().equals(categoria);
  }
}
