package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class RepoUsuarios {
  private final List<Usuario> usuarios = new ArrayList<>();

  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  public void agregarUsuario(Usuario usuario) {
    this.usuarios.add(usuario);
  }

  public void actualizarSugerenciasDiarias() {
    usuarios.forEach(Usuario::actualizarSugerenciaDiaria);
  }

  public void avisarAlertaMeteorologica(AlertaMeteorologica alerta) {
    usuarios.forEach(usuario -> usuario.avisarAlertaMeteorologica(alerta));
  }

}
