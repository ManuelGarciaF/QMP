package ar.edu.utn.frba.dds;

import java.util.List;

public interface ProveedorClima {
  Integer temperaturaActual();

  List<AlertaMeteorologica> obtenerAlertas();
}
