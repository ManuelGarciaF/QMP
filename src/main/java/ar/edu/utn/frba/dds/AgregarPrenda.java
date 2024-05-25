package ar.edu.utn.frba.dds;

import static java.util.Objects.requireNonNull;

public class AgregarPrenda implements PropuestaModificacion {
  private Prenda prenda;
  private EstadoPropuesta estadoPropuesta;

  public AgregarPrenda(Prenda prenda) {
    this.prenda = requireNonNull(prenda);
    this.estadoPropuesta = EstadoPropuesta.PENDIENTE;
  }

  @Override
  public void aceptarEn(Guardarropas guardarropas) {
    guardarropas.agregarPrenda(prenda);
    this.estadoPropuesta = EstadoPropuesta.ACEPTADA;
  }

  @Override
  public void rechazarEn(Guardarropas guardarropas) {
    this.estadoPropuesta = EstadoPropuesta.RECHAZADA;
  }

  @Override
  public void deshacerEn(Guardarropas guardarropas) {
    if (estadoPropuesta != EstadoPropuesta.ACEPTADA) {
      throw new RuntimeException("Se intento deshacer una propuesta que no fue aceptaea");
    }
    guardarropas.removerPrenda(prenda);
  }
}
