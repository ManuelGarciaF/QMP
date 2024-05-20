package ar.edu.utn.frba.dds;

import static java.util.Objects.requireNonNull;

public class AgregarPrenda implements PropuestaModificacion {
  private Prenda prenda;

  public AgregarPrenda(Prenda prenda) {
    this.prenda = requireNonNull(prenda);
  }

  @Override
  public void aceptar(Guardarropas guardarropas) {
    guardarropas.agregarPrenda(prenda);
  }

  @Override
  public void deshacer(Guardarropas guardarropas) {
    guardarropas.removerPrenda(prenda);
  }
}
