package ar.edu.utn.frba.dds;

public abstract class PropuestaModificacion {

  private EstadoPropuesta estadoPropuesta;

  public PropuestaModificacion() {
    this.estadoPropuesta = EstadoPropuesta.PENDIENTE;
  }

  public void aceptarEn(Guardarropas guardarropas) {
    this.estadoPropuesta = EstadoPropuesta.ACEPTADA;
  };

  public void rechazarEn(Guardarropas guardarropas) {
    this.estadoPropuesta = EstadoPropuesta.RECHAZADA;
  }

  public void deshacerEn(Guardarropas guardarropas) {
    if (estadoPropuesta != EstadoPropuesta.ACEPTADA) {
      throw new RuntimeException("Se intento deshacer una propuesta que no fue aceptaea");
    }
  }
}
