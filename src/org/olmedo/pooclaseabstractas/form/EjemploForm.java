package org.olmedo.pooclaseabstractas.form;


import org.olmedo.pooclaseabstractas.form.elementos.*;
import org.olmedo.pooclaseabstractas.form.elementos.select.*;
import org.olmedo.pooclaseabstractas.form.validador.*;

import java.util.Arrays;
import java.util.List;


public class EjemploForm {
  public static void main(String[] args){
    
    InputForm username = new InputForm("username");
    username.addValidador(new RequeridoValidador());

    InputForm password = new InputForm("clave", "password");
    password.addValidador(new RequeridoValidador())
    .addValidador(new LargoValidador(6, 12));

    InputForm email = new InputForm("email", "email");
    email.addValidador(new RequeridoValidador())
      .addValidador(new EmailValidador());

    InputForm edad = new InputForm("edad", "number");
    edad.addValidador(new NumeroValidador());
    

    TextareaForm experiencia = new TextareaForm(9, 5, "exp");
    
    SelectForm lenguaje = new SelectForm("lenguaje");
    lenguaje.addValidador(new NoNuloValidador());

    lenguaje.addOpcion( new Opcion("1", "java"))
    .addOpcion(new Opcion("2", "Python").setSelected())
    .addOpcion(new Opcion("3", "javascript"))
    .addOpcion(new Opcion("4", "typescript"))
    .addOpcion(new Opcion("5", "PHP"));
    
    // Clase anonima: se usa para una sola ves algo simple
    ElementoForm saludar = new ElementoForm("saludo") {
      @Override
      public String dibujarHtml() { 
        return "<input disabled name='"+this.nombre+"' value=\"" +this.valor+ "\">";
      }
    };

    saludar.setValor("Hola que tal este campo esta desabilitado!");
    username.setValor("Jhonny Deep");
    password.setValor("123456");
    email.setValor("Jhnny131@correo.com");
    edad.setValor("23");
    experiencia.setValor("... mas de 10 anios de experiencia ...");



    List<ElementoForm> elementos = Arrays.asList(username,
        password,
        email,
        edad,
        experiencia,
        lenguaje,
        saludar);
    
    elementos.forEach(e -> { // este manera de forEach es lo mismo que la otra pero este viene integrada en la api
      System.out.println(e.dibujarHtml());
      System.out.println("<br>");
  
    });

    // aca validamos
    elementos.forEach(e -> {
      if(!e.esValido()){
        e.getErrores().forEach(System.out::println); //forEach(System.out::println); esto se llama medoto refenenciado en una expesion blanda
      }
    });

    /* ElementoForm el = new ElementoForm(){ // esto es una manera de crear una clase anonima se le dice asi porque
                                          // no tiene nombre no tiene archivo separado ni nada

      @Override
      public String dibujarHtml(){
        return null;
      }
    }; */

  }
}
