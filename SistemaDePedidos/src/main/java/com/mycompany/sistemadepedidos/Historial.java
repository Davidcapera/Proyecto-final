
package com.mycompany.sistemadepedidos;

import java.util.ArrayList;


public class Historial {
    
  private ArrayList<Pedido> pedidosListos = new ArrayList<>();
  
  public void agregarPedido(Pedido pedido){
      
      pedidosListos.add(pedido);
  }
  
  public ArrayList<Pedido> mostrarPedidos(){
      return pedidosListos;
  }
  
  public void eliminarHistorial(){
      pedidosListos.clear();
      
  }
    
}
