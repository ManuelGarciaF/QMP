package ar.edu.utn.frba.dds.accionesAlerta;

import ar.edu.utn.frba.dds.AlertaMeteorologica;
import ar.edu.utn.frba.dds.Usuario;
import ar.edu.utn.frba.dds.externo.NotificationService;

public class NotificarParaguas implements AccionAlertaMeteorologica {
  @Override
  public void ejecutar(Usuario usuario, AlertaMeteorologica alerta) {
    if (alerta == AlertaMeteorologica.TORMENTA) {
      NotificationService.notify("Lleva un paraguas, hay una tormenta");
    }
  }
}
