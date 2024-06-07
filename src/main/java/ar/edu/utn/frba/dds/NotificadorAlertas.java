package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class NotificadorAlertas {
  private final RepoUsuarios repoUsuarios;
  private final ProveedorClima proveedorClima;

  private final List<AlertaMeteorologica> alertas = new ArrayList<>();

  public NotificadorAlertas(RepoUsuarios repoUsuarios, ProveedorClima proveedorClima) {
    this.repoUsuarios = repoUsuarios;
    this.proveedorClima = proveedorClima;
  }

  public void actualizarAlertasyNotificar() {
    alertas.clear();
    alertas.addAll(proveedorClima.obtenerAlertas());
    alertas.forEach(repoUsuarios::avisarAlertaMeteorologica);
  }

  public List<AlertaMeteorologica> getAlertas() {
    return alertas;
  }
}
