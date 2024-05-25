package ar.edu.utn.frba.dds;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  private List<Atuendo> atuendos;
  private Integer edad;
  // Varios usuarios pueden tener referencias al mismo guardarropas,
  // compartiendolo.
  private List<Guardarropas> guardarropas;

  private GeneradorSugerencias generadorSugerencias;

  // La prenda en construcción se guarda en el prendaBuilder.
  private PrendaBuilder prendaBuilder;

  public Usuario(Integer edad,
      List<Guardarropas> guardarropas,
      GeneradorSugerencias generadorSugerencias) {
    this.edad = requireNonNull(edad);
    this.guardarropas = requireNonNull(guardarropas);
    this.generadorSugerencias = requireNonNull(generadorSugerencias);
    this.atuendos = new ArrayList<>();
  }

  public void agregarAtuendo(Atuendo atuendo) {
    this.atuendos.add(atuendo);
  }

  public void comenzarConstruccionDePrenda(Tipo tipo) {
    this.prendaBuilder = new PrendaBuilder(tipo);
  }

  // El usuario tiene muchos guardarroppas, necesitamos decir a cual se agregara
  public void terminarConstruccionDePrenda(Guardarropas guardarropas) {
    guardarropas.agregarPrenda(this.prendaBuilder.construirPrenda());
    this.prendaBuilder = null;
  }

  public List<Atuendo> generarSugerencias() {
    return generadorSugerencias.generarSugerenciasCon(this.getPrendas(), this.edad);
  }

  // Crear un guardarropas y compartirlo con otros usuarios.
  public void crearGuardarropasCon(List<Usuario> otrosUsuarios) {
    var guardarropas = new Guardarropas();
    this.guardarropas.add(guardarropas);
    otrosUsuarios.forEach(usuario -> usuario.agregarGuardarropas(guardarropas));
  }

  public void agregarGuardarropas(Guardarropas guardarropas) {
    this.guardarropas.add(guardarropas);
  }

  private List<Prenda> getPrendas() {
    return this.guardarropas.stream()
        .flatMap(guardarropa -> guardarropa.getPrendas().stream())
        .toList();
  }

}
