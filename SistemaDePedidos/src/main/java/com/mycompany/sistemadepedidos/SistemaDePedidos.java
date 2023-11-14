
package com.mycompany.sistemadepedidos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SistemaDePedidos {

    public static void main(String[] args) {
        ColaPedidos colaPedidos = new ColaPedidos();
        PilaPedidos pilaPedidos = new PilaPedidos();
        Historial   historial= new Historial();

        int opcion;
        do {
            String menu = """
                          Sistema de Pedidos
                          
                          1. Agregar Pedido
                          2. Procesar Pedidos
                          3. Mostrar Pedidos Listos
                          4. Mostrar historial
                          5. eliminar historial
                          6. Salir""";

            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1 -> {
                    String nombrePedido = JOptionPane.showInputDialog("Ingrese el nombre del pedido:");
                    colaPedidos.agregarPedido(new Pedido(nombrePedido));
                }
                case 2 -> {
                    JOptionPane.showMessageDialog(null, "Procesando pedidos:", "Procesando Pedidos", JOptionPane.INFORMATION_MESSAGE);
                    while (colaPedidos.hayPedidosPendientes()) {
                        Pedido pedido = colaPedidos.tomarPedido();
                        pilaPedidos.procesarPedido(pedido);
                        historial.agregarPedido(pedido);
                    }
                }
                case 3 -> {
                    while (pilaPedidos.hayPedidosListos()) {
                        Pedido pedido = pilaPedidos.servirPedido();
                        JOptionPane.showMessageDialog(null, "Pedido listo para servir: \n" + pedido.getNombre());
                        
                        
                    }
                }
                case 6 -> JOptionPane.showMessageDialog(null, "Saliendo del programa...", "Salir", JOptionPane.INFORMATION_MESSAGE);
                case 4 -> {
                    ArrayList<Pedido> historialPedidos = historial.mostrarPedidos();
                    String historialMsg = "Historial de Pedidos:\n";
                    
                    for (int i = 0; i < historialPedidos.size(); i++) {
                        Pedido pedido = historialPedidos.get(i);
                        historialMsg += pedido.getNombre()+"\n";
                    }
                    
                    JOptionPane.showMessageDialog(null, historialMsg, "Historial", JOptionPane.INFORMATION_MESSAGE);
                }
                case 5 -> {
                    historial.eliminarHistorial();
                    JOptionPane.showMessageDialog(null, "Historial eliminado.", "Eliminar Historial", JOptionPane.INFORMATION_MESSAGE);
                }
                default -> JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción válida.");
            }

        } while (opcion != 6);
    }
}
    

