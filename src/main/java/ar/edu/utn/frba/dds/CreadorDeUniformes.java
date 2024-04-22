package ar.edu.utn.frba.dds;

public abstract class CreadorDeUniformes {
  public Uniforme crearUniforme() {
    return new Uniforme(
        crearParteSuperior(),
        crearParteInferior(),
        crearCalzado()
    );
  }

  public abstract Prenda crearParteInferior();
  public abstract Prenda crearParteSuperior();
  public abstract Prenda crearCalzado();
}

