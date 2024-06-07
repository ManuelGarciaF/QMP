package ar.edu.utn.frba.dds;

import static java.util.Objects.requireNonNull;

import ar.edu.utn.frba.dds.accionesAlerta.AccionAlertaMeteorologica;
import java.util.List;

public class Usuario {
  private final Integer edad;
  // Varios usuarios pueden tener referencias al mismo guardarropas,
  // compartiendolo.
  private final List<Guardarropas> guardarropas;
  private final GeneradorSugerencias generadorSugerencias;
  // La prenda en construcción se guarda en el prendaBuilder.
  private PrendaBuilder prendaBuilder;
  private Atuendo sugerenciaDiaria;

  private final List<AccionAlertaMeteorologica> accionesAnteAlertas;
  private final String email;

  public Usuario(Integer edad,
                 List<Guardarropas> guardarropas,
                 GeneradorSugerencias generadorSugerencias,
                 List<AccionAlertaMeteorologica> accionesAnteAlertas,
                 String email) {
    this.edad = requireNonNull(edad);
    this.guardarropas = requireNonNull(guardarropas);
    this.generadorSugerencias = requireNonNull(generadorSugerencias);
    this.accionesAnteAlertas = requireNonNull(accionesAnteAlertas);
    this.email = requireNonNull(email);
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

  public void agregarGuardarropas(Guardarropas guardarropas) {
    this.guardarropas.add(guardarropas);
  }

  private List<Prenda> getPrendas() {
    return this.guardarropas.stream()
        .flatMap(guardarropa -> guardarropa.getPrendas().stream())
        .toList();
  }

  private Atuendo getSugerenciaDiaria() {
    return sugerenciaDiaria;
  }

  public void actualizarSugerenciaDiaria() {
    this.sugerenciaDiaria = this.generarSugerencias().get(0);
  }

  public void avisarAlertaMeteorologica(AlertaMeteorologica alerta) {
    accionesAnteAlertas.forEach(accion -> accion.ejecutar(this, alerta));
  }

  public String getEmail() {
    return this.email;
  }
}
