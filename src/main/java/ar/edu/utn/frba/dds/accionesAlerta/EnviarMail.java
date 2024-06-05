package ar.edu.utn.frba.dds.accionesAlerta;

import ar.edu.utn.frba.dds.AlertaMeteorologica;
import ar.edu.utn.frba.dds.Usuario;
import ar.edu.utn.frba.dds.externo.MailSender;

public class EnviarMail implements AccionAlertaMeteorologica {
  @Override
  public void ejecutar(Usuario usuario, AlertaMeteorologica alerta) {
    MailSender.send(usuario.getEmail(), "Alerta meteorológica: " + alerta.getMensaje());
  }
}
