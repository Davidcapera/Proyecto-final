
package com.mycompany.sistemadepedidos;

import java.util.Stack;
import javax.swing.JOptionPane;

public class PilaPedidos {
   
    private Stack<Pedido> pedidosListos = new Stack<>();

    /*public void procesarPedido(Pedido pedido) {
        System.out.println("Preparando " + pedido.getNombre());
        pedidosListos.push(pedido);
    }*/
    public void procesarPedido(Pedido pedido) {
    String mensaje = "Preparando " + pedido.getNombre();
    JOptionPane.showMessageDialog(null, mensaje, "Procesando Pedido", JOptionPane.INFORMATION_MESSAGE);
    pedidosListos.push(pedido);
}

    public Pedido servirPedido() {
        return pedidosListos.pop();
    }

    public boolean hayPedidosListos() {
        return !pedidosListos.isEmpty();
    }
}
    

