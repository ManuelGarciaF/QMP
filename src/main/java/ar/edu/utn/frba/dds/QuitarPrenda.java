package ar.edu.utn.frba.dds;

import static java.util.Objects.requireNonNull;

public class QuitarPrenda implements PropuestaModificacion {
  private Prenda prenda;

  public QuitarPrenda(Prenda prenda) {
    this.prenda = requireNonNull(prenda);
  }

  @Override
  public void aceptar(Guardarropas guardarropas) {
    guardarropas.removerPrenda(prenda);
  }

  @Override
  public void deshacer(Guardarropas guardarropas) {
    guardarropas.agregarPrenda(prenda);
  }
}
