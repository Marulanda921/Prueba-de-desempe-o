package Controller;

import Entity.Cliente;
import Entity.Compra;
import Entity.Producto;
import Model.ModeloCompra;
import Utiles.Utils;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public class CompraController {

    public static ModeloCompra intanciaModelo() {
        return new ModeloCompra();
    }


        public static void insert () {
            Date date = java.sql.Date.valueOf(JOptionPane.showInputDialog("inserta la fecha de tu compra: "));
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Inserta la cantidad de productos"));

            //como devuelve un arreglo de un generico se le pone OBJECT[*
            Object[] opcionClientes = Utils.listToArray(ClienteController.intanceModel().findAll());
            Object[] opcionProductos = Utils.listToArray(ProductoController.intanceModel().findAll());


            Cliente ClienteSelecionado = (Cliente) JOptionPane.showInputDialog(null,
                    "Seleccione el Cliente",
                    "",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionClientes,
                    opcionClientes[0]
            );

            Producto ProductoSelecionado = (Producto) JOptionPane.showInputDialog(null,
                    "Seleccione el producto",
                    "",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionProductos,
                    opcionProductos[0]
            );

            //AQUI SE INSERTA TODO

            intanciaModelo().insert(new Compra(ClienteSelecionado.getId(), ProductoSelecionado.getId(), date, cantidad, ClienteSelecionado, ProductoSelecionado, null));
            JOptionPane.showMessageDialog(null, "el producto se inserto correctamente");


        }


    public static void getAll() {
        String lista = getAll(intanciaModelo().findAll());
        JOptionPane.showMessageDialog(null, lista);
    }

    public static String getAll(List<Object> list) {
        String listaRegistros = "LISTA DE REGISTROS: \n";
        for (Object Temporal : list) {
            Compra objReservacion = (Compra) Temporal;
            listaRegistros += objReservacion.toString() + "\n";
        }
        return listaRegistros;

    }



    }


