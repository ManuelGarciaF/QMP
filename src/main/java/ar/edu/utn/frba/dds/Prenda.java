package ar.edu.utn.frba.dds;

public class Prenda {
  private Tipo tipo;
  private String material;
  private String colorPrincipal;
  private String colorSecundario;

  public Prenda(Tipo tipo, String material, String colorPrincipal) {
    this.tipo = tipo;
    this.material = material;
    this.colorPrincipal = colorPrincipal;
  }

  public void setColorSecundario(String colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public Categoria obtenerCategoria() {
    return this.tipo.getCategoria();
  }

  public String getMaterial() {
    return material;
  }

  public String getColorPrincipal() {
    return colorPrincipal;
  }

  public String getColorSecundario() {
    return colorSecundario;
  }
}
