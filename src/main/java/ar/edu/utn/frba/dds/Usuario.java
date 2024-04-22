package ar.edu.utn.frba.dds;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  private List<Prenda> prendas;
  private List<Atuendo> atuendos;

  private static GeneradorSugerencias generadorSugerencias = new GeneradorSugerencias();

  /* La prenda en construcción será guardada en el prendaBuilder que sirve como borrador. */
  private PrendaBuilder prendaBuilder;

  public Usuario() {
    this.prendas = new ArrayList<>();
    this.atuendos = new ArrayList<>();
  }

  public void agregarAtuendo(Atuendo atuendo) {
    this.atuendos.add(atuendo);
  }

  public void comenzarConstruccionDePrenda(Tipo tipo) {
    this.prendaBuilder = new PrendaBuilder(tipo);
  }

  public void terminarConstruccionDePrenda() {
    this.prendas.add(this.prendaBuilder.construirPrenda());
    this.prendaBuilder = null;
  }

  // No se si necesito crear todas las combinaciones posibles, creo una por ahora.
  public Atuendo generarSugerencia() {
    return generadorSugerencias.generarSugerencia(this.prendas);
  }
}