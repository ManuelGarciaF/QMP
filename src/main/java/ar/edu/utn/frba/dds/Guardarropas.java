package ar.edu.utn.frba.dds;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;


public class Guardarropas {
  private List<Prenda> prendas;
  private List<PropuestaModificacion> propuestas;

  public Guardarropas() {
    this.prendas = new ArrayList<>();
    this.propuestas = new ArrayList<>();
  }

  public void agregarPropuesta(PropuestaModificacion propuesta) {
    this.propuestas.add(propuesta);
  }

  public List<PropuestaModificacion> getPropuestas() {
    return this.propuestas;
  }

  public void agregarPrenda(Prenda prenda) {
    this.prendas.add(prenda);
  }

  public void removerPrenda(Prenda prenda) {
    this.prendas.remove(prenda);
  }

}
