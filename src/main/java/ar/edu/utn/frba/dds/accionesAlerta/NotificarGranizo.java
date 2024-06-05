package ar.edu.utn.frba.dds.accionesAlerta;

import ar.edu.utn.frba.dds.AlertaMeteorologica;
import ar.edu.utn.frba.dds.Usuario;
import ar.edu.utn.frba.dds.externo.NotificationService;

public class NotificarGranizo implements AccionAlertaMeteorologica {
  @Override
  public void ejecutar(Usuario usuario, AlertaMeteorologica alerta) {
    if (alerta == AlertaMeteorologica.GRANIZO) {
      NotificationService.notify("Hay granizo, no salgas en auto");
    }
  }
}
