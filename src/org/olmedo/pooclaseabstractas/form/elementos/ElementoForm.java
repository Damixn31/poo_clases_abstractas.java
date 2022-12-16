package org.olmedo.pooclaseabstractas.form.elementos;

import org.olmedo.pooclaseabstractas.form.validador.LargoValidador;
import org.olmedo.pooclaseabstractas.form.validador.Validador;
import org.olmedo.pooclaseabstractas.form.validador.mensaje.MensajeFormateable;

import java.util.ArrayList;
import java.util.List;

abstract public class ElementoForm { // al tener un metodo abstracto dentro de la clase si o si tiene que ser una clase abstracta
    protected String valor;
    protected String nombre;

    private List<Validador> validadores;
    private List<String> errores;
    
    public ElementoForm(){
      this.validadores = new ArrayList<>();
      this.errores = new ArrayList<>();

    }

    public ElementoForm(String nombre){
      this();    //aca va ir la list de validadores y mensajes de error
      this.nombre = nombre;
    }

    public ElementoForm addValidador(Validador validador){
      this.validadores.add(validador);
      return this;
    }

    public List<String> getErrores(){
      return errores;
    }

    public void setValor(String valor){
      this.valor = valor;
    }


    public boolean esValido(){
      for(Validador v: validadores){
        if(!v.esValido(this.valor)){
            if(v instanceof MensajeFormateable) {
                this.errores.add(((MensajeFormateable) v).getMensajeFormateado(nombre));
            } else {
                this.errores.add(String.format(v.getMensaje(), nombre));
            }
        }
      }
      return this.errores.isEmpty(); // return this.errores.size(); esta es otra manera 
    }

    abstract public String dibujarHtml(); // los metodos abstractos no van con llave no tiene cuerpo

}
