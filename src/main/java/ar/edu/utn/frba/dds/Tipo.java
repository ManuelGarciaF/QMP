package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class Tipo {
  private Categoria categoria;
  private List<Material> materialesValidos;

  public Tipo(Categoria categoria, List<Material> materialesValidos) {
    this.categoria = categoria;
    this.materialesValidos = new ArrayList<>(materialesValidos);
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public Boolean materialEsValido(Material material) {
    return materialesValidos.contains(material);
  }

  public static final Tipo CHOMBA = new Tipo(
      Categoria.PARTE_SUPERIOR,
      List.of(Material.PIQUE, Material.ALGODON));

  public static final Tipo PANTALON = new Tipo(
      Categoria.PARTE_INFERIOR,
      List.of(Material.JEAN, Material.ACETATO));

  public static final Tipo ZAPATILLAS = new Tipo(
      Categoria.CALZADO,
      List.of(Material.CUERO, Material.LONA));
}
