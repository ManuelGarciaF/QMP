package ar.edu.utn.frba.dds;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  private List<Prenda> prendas;
  private List<Atuendo> atuendos;
  private Integer edad;

  private GeneradorSugerencias generadorSugerencias;

  /* La prenda en construcción será guardada en el prendaBuilder que sirve como borrador. */
  private PrendaBuilder prendaBuilder;

  public Usuario(Integer edad, GeneradorSugerencias generadorSugerencias) {
    this.edad = requireNonNull(edad);
    this.generadorSugerencias = requireNonNull(generadorSugerencias);
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
  public List<Atuendo> generarSugerencias() {
    return generadorSugerencias.generarSugerenciasCon(this.prendas, this.edad);
  }
}
