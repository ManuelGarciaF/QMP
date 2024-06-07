package ar.edu.utn.frba.dds;

import static java.util.Objects.requireNonNull;

public class QuitarPrenda extends PropuestaModificacion {
  private Prenda prenda;

  public QuitarPrenda(Prenda prenda) {
    super();
    this.prenda = requireNonNull(prenda);
  }

  @Override
  public void aceptarEn(Guardarropas guardarropas) {
    super.aceptarEn(guardarropas);
    guardarropas.removerPrenda(prenda);
  }

  @Override
  public void deshacerEn(Guardarropas guardarropas) {
    super.deshacerEn(guardarropas);
    guardarropas.agregarPrenda(prenda);
  }

}
