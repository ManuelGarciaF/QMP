package ar.edu.utn.frba.dds;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  private List<Prenda> prendas;
  private List<Atuendo> atuendos;
  private Integer edad;
  // Varios usuarios pueden tener referencias al mismo guardarropas, compartiendolo.
  private List<Guardarropas> guardarropas;

  private GeneradorSugerencias generadorSugerencias;

  /* La prenda en construcción será guardada en el prendaBuilder que sirve como borrador. */
  private PrendaBuilder prendaBuilder;

  public Usuario(Integer edad,
                 List<Guardarropas> guardarropas,
                 GeneradorSugerencias generadorSugerencias) {
    this.edad = requireNonNull(edad);
    this.guardarropas = requireNonNull(guardarropas);
    this.generadorSugerencias = requireNonNull(generadorSugerencias);
    this.prendas = new ArrayList<>();
    this.atuendos = new ArrayList<>();
  }

  public void agregarPrenda(Prenda prenda) {
    this.prendas.add(prenda);
  }

  public void agregarAtuendo(Atuendo atuendo) {
    this.atuendos.add(atuendo);
  }

  public void agregarGuardarropas(Guardarropas guardarropas) {
    this.guardarropas.add(guardarropas);
  }

  public void comenzarConstruccionDePrenda(Tipo tipo) {
    this.prendaBuilder = new PrendaBuilder(tipo);
  }

  public void terminarConstruccionDePrenda() {
    this.prendas.add(this.prendaBuilder.construirPrenda());
    this.prendaBuilder = null;
  }

  public List<Atuendo> generarSugerencias() {
    return generadorSugerencias.generarSugerenciasCon(this.prendas, this.edad);
  }

  // Crear un guardarropas y compartirlo con otros usuarios.
  public void crearGuardarropasCon(List<Usuario> otrosUsuarios) {
    var guardarropas = new Guardarropas();
    this.guardarropas.add(guardarropas);
    otrosUsuarios.forEach(usuario -> usuario.agregarGuardarropas(guardarropas));
  }
}

