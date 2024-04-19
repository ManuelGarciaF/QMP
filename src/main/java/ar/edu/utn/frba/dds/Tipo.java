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
}
