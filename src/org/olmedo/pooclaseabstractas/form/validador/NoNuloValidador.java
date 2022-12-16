package org.olmedo.pooclaseabstractas.form.validador;

public class NoNuloValidador extends Validador {

  protected String mensaje = "El campo %s no puede ser nulo";
  @Override
  public void setMensaje(String mensaje){
    this.mensaje = mensaje;

  }

  @Override
  public String getMensaje(){
    return mensaje;
  }
  @Override
  public boolean esValido(String valor){
    return (valor != null);
  }
}
