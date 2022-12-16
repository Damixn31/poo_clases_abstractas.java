package org.olmedo.pooclaseabstractas.form.elementos;

public class InputForm extends ElementoForm { //cuando hacemos extends de una clase abstracta nos va a saltar erro lo que hay que hacer es implementar el metodo de clase abstracta
  private String tipo = "text";

  public InputForm(String nombre){
    super(nombre);
  }

  public InputForm(String nombre, String tipo){
    super(nombre);
    this.tipo = tipo;
  }

  public String getTipo(){
    return tipo;
  }

  public void setTipo(){
    this.tipo = tipo;
  }

  @Override
  public String dibujarHtml() { // de esta manera implementamos el medoto de la clase abstracta
    return "<input type=\"" + this.tipo 
      + "\" name=\"" + this.nombre 
      + "\" value=\"" + this.valor + "\">";
  }
}
