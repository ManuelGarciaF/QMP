package ar.edu.utn.frba.dds;

import static java.util.Objects.requireNonNull;

import ar.edu.utn.frba.dds.externo.AccuWeatherApi;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class ProveedorClimaAccuWeather implements ProveedorClima {
  // Cada 3 horas, se realizan solo 8 consultas por dia, no superamos el limite gratuito
  private static final int HORAS_ENTRE_ACTUALIZACIONES = 3;

  private final AccuWeatherApi api;
  private final String ciudad;

  private int temperaturaCacheada;
  private LocalDateTime ultimaActualizacion;

  public ProveedorClimaAccuWeather(AccuWeatherApi api, String ciudad) {
    this.api = requireNonNull(api);
    this.ciudad = ciudad;
    this.temperaturaCacheada = obtenerTemperaturaApi();
    this.ultimaActualizacion = LocalDateTime.now();
  }

  @Override
  public Integer temperaturaActual() {
    // Actualizar el valor cacheado solo cuando sea necesario
    if (deboActualizar()) {
      temperaturaCacheada = obtenerTemperaturaApi();
      ultimaActualizacion = LocalDateTime.now();
    }

    return temperaturaCacheada;
  }

  @Override
  public List<AlertaMeteorologica> obtenerAlertas() {
    List<String> alertas = api.getAlerts(ciudad).get("CurrentAlerts");
    return alertas.stream().map(AlertaMeteorologica::fromString).toList();
  }

  private boolean deboActualizar() {
    // Si paso mas de un numero de horas desde la ultima actualizacion
    return ultimaActualizacion.plusHours(HORAS_ENTRE_ACTUALIZACIONES).isBefore(LocalDateTime.now());
  }

  private Integer obtenerTemperaturaApi() {
    // Debo suprimir el warning para poder castear Object a Hashmap
    @SuppressWarnings("unchecked")
    HashMap<String, Object> temp = (HashMap<String, Object>) api
        .getWeather(ciudad)
        .get(0)
        .get("Temperature");

    return (Integer) temp.get("Value");
  }
}
