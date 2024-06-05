package ar.edu.utn.frba.dds.accionesAlerta;

import ar.edu.utn.frba.dds.AlertaMeteorologica;
import ar.edu.utn.frba.dds.Usuario;

public interface AccionAlertaMeteorologica {
  void ejecutar(Usuario usuario, AlertaMeteorologica alerta);
}
