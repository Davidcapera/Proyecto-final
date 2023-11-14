
package com.mycompany.sistemadepedidos;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
public class ColaPedidos {
      private Queue<Pedido> pedidosPendientes = new LinkedList<>();

      // agregamos el onjeto pedido al final de la cola con el metodo offer
    public void agregarPedido(Pedido pedido) {
        pedidosPendientes.offer(pedido);
        JOptionPane.showMessageDialog(null, "Pedido de " + pedido.getNombre() + " recibido.", "Pedido Recibido", JOptionPane.INFORMATION_MESSAGE);
      
    }

    // utilizo el metodo poll para tomar el primer objeto pedido de la cola y eliminarlo es decir el ,mas viejo y retorno el objeto 
    public Pedido tomarPedido() {
        return pedidosPendientes.poll();
    }

    public boolean hayPedidosPendientes() {
        return !pedidosPendientes.isEmpty();
    }

}
