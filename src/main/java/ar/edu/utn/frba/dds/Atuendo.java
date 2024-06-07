package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class Atuendo {
  private final List<Prenda> prendas;

  public Atuendo() {
    this.prendas = new ArrayList<>();
  }

  public void agregarPrenda(Prenda prenda) {
    this.prendas.add(prenda);
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }
}
