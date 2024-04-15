package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class Tipo {
  private Categoria categoria;
  private List<String> materialesValidos;
  private List<Trama> tramasValidas;
  private List<String> coloresValidos;

  public Tipo(Categoria categoria, List<String> materialesValidos, List<Trama> tramasValidas,
      List<String> coloresValidos) {
    this.categoria = categoria;
    this.materialesValidos = new ArrayList<>(materialesValidos);
    this.tramasValidas = new ArrayList<>(tramasValidas);
    this.coloresValidos = new ArrayList<>(coloresValidos);
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public Boolean materialEsValido(String material) {
    return materialesValidos.contains(material);
  }

  public Boolean tramaEsValida(Trama trama) {
    return tramasValidas.contains(trama);
  }

  public Boolean colorEsValido(String color) {
    return coloresValidos.contains(color);
  }
}
