package ar.edu.utn.frba.dds;

import java.util.List;

public class RepoUsuarios {
  private List<Usuario> usuarios;

  public RepoUsuarios(List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }

  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  public void agregarUsuario(Usuario usuario) {
    this.usuarios.add(usuario);
  }

  public void actualizarSugerenciasDiarias() {
    usuarios.forEach(Usuario::actualizarSugerenciaDiaria);
  }

  public void avisarAlertasMeteorologicas(List<AlertaMeteorologica> alertas) {
    usuarios.forEach(usuario -> usuario.avisarAlertasMeteorologicas(alertas));
  }

}
