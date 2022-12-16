package org.olmedo.pooclaseabstractas.form.validador;

public class NumeroValidador extends Validador{
  protected String mensaje = "El campo %s tiene que ser un numero";
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
    try {
      Integer.parseInt(valor);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
