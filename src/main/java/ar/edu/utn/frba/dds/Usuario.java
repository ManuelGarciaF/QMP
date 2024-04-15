package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  private List<Prenda> prendas;
  private List<Atuendo> atuendos;

  /* La prenda en construcción será guardada en el prendaBuilder,
   * sirve como borrador para el requerimiento 4. */
  private PrendaBuilder prendaBuilder = new PrendaBuilder();

  public Usuario() {
    this.prendas = new ArrayList<>();
    this.atuendos = new ArrayList<>();
  }

  public void agregarPrenda(Prenda prenda) {
    this.prendas.add(prenda);
  }

  public void agregarAtuendo(Atuendo atuendo) {
    this.atuendos.add(atuendo);
  }

  public PrendaBuilder getPrendaBuilder() {
    return prendaBuilder;
  }
}