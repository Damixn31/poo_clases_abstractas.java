package org.olmedo.pooclaseabstractas.form.elementos;

import org.olmedo.pooclaseabstractas.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.List;

public class SelectForm extends ElementoForm {
  private List<Opcion> opciones; // el Opcion viene de la clase asi que lo tengo que importar

  public SelectForm(String nombre){
    super(nombre);
    this.opciones = new ArrayList<Opcion>();  //aca inicializar
  }

  public SelectForm(String nombre, List<Opcion> opciones){
    super(nombre);
    this.opciones = opciones;
  }

  public SelectForm addOpcion(Opcion opcion){ // para no andar escribiendod de forma encadenada le damos el tipo de retorno en debe de ser void le pasamos la clase
    this.opciones.add(opcion); // esto es para agregar elementos a la listas
    return this;
  }
    

  @Override 
  public String dibujarHtml(){
    StringBuilder sb = new StringBuilder("<select ");
    sb.append("name='")
      .append(this.nombre)
      .append("'>");

    for(Opcion opcion: this.opciones){
      sb.append("\n<option value='")
        .append(opcion.getValor())
        .append("'");
      if(opcion.isSelected()){
        sb.append(" selected");
        this.valor = opcion.getValor();
      }
      sb.append(">").append(opcion.getNombre())
        .append("</option>");
    }
    sb.append("</select>");
    return sb.toString();
  }
}
