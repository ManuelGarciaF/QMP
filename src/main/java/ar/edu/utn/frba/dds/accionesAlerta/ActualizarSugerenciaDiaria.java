package ar.edu.utn.frba.dds.accionesAlerta;

import ar.edu.utn.frba.dds.AlertaMeteorologica;
import ar.edu.utn.frba.dds.Usuario;

public class ActualizarSugerenciaDiaria implements AccionAlertaMeteorologica {
  @Override
  public void ejecutar(Usuario usuario, AlertaMeteorologica alerta) {
    usuario.actualizarSugerenciaDiaria();
  }
}
