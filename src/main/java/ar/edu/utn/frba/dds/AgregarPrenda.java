package ar.edu.utn.frba.dds;

import static java.util.Objects.requireNonNull;

public class AgregarPrenda extends PropuestaModificacion {
  private Prenda prenda;

  public AgregarPrenda(Prenda prenda) {
    super();
    this.prenda = requireNonNull(prenda);
  }

  @Override
  public void aceptarEn(Guardarropas guardarropas) {
    super.aceptarEn(guardarropas);
    guardarropas.agregarPrenda(prenda);
  }

  @Override
  public void deshacerEn(Guardarropas guardarropas) {
    super.deshacerEn(guardarropas);
    guardarropas.removerPrenda(prenda);
  }
}
