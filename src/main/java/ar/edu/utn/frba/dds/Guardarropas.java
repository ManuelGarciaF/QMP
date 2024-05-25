package ar.edu.utn.frba.dds;

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

  public void removerPropuesta(PropuestaModificacion propuesta) {
    this.propuestas.remove(propuesta);
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

  public List<Prenda> getPrendas() {
    return prendas;
  }

}
