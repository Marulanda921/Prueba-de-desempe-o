package Controller;

import Entity.Producto;
import Entity.Tienda;
import Model.ModeloProducto;
import Utiles.Utils;

import javax.swing.*;
import java.util.List;

public class ProductoController {


    public static ModeloProducto intanceModel(){
        return new ModeloProducto();
    }


    public  static void insert(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
        float precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del producto: "));
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad en stock: "));

        Object[] opcionesTiendas = Utils.listToArray(TiendaController.instanciaModelo().findAll());

        Tienda objTienda = (Tienda) JOptionPane.showInputDialog(null, "Seleccione una Tienda", "", JOptionPane.QUESTION_MESSAGE, null, opcionesTiendas, opcionesTiendas[0]);

        //TIENE QUE LLEVAR UN OBJETO
        //1. nombre
        //2. precio
        //3. ID tienda
        //4. objTienda

        intanceModel().insert(new Producto(nombre,precio, objTienda.getId(), stock, objTienda));
    }


    public static void getAll(){
        String list = getAll(intanceModel().findAll());
        JOptionPane.showMessageDialog(null, list);
    }

    public static String getAll(List<Object> list){
        String listString = "Lista de registros \n";

        for(Object Temporal : list){
            Producto objProdcuto = (Producto) Temporal;
            listString += objProdcuto.toString() + "\n";
        }
        return listString;
    }


    public static void delete(){
        Object[] Opciones = Utils.listToArray(intanceModel().findAll());
        Producto objProducto = (Producto) JOptionPane.showInputDialog(null, "Seleccione un Producto a Eliminar", "", JOptionPane.QUESTION_MESSAGE, null, Opciones, Opciones[0]);
        intanceModel().delete(objProducto);
    }



    public static void update(){
        Object[] options = Utils.listToArray(intanceModel().findAll());
        Producto productoSeleccionado = (Producto) JOptionPane.showInputDialog(null, "Seleccionar producto a Actualizar", "", JOptionPane.QUESTION_MESSAGE,null, options, options[0]);

        productoSeleccionado.setNombre(JOptionPane.showInputDialog(null, "Ingresa nuevo producto: ", productoSeleccionado.getNombre()));
        productoSeleccionado.setPrecio(Float.parseFloat((JOptionPane.showInputDialog(null, "Ingresa nuevo apellido: ", productoSeleccionado.getPrecio()))));
        productoSeleccionado.setStock( Integer.parseInt(JOptionPane.showInputDialog(null, "Dame la cantidad de stock", productoSeleccionado.getStock())));



        intanceModel().update(productoSeleccionado);
    }
















    /*
    public static void update(){


        Object[] Opciones = Utils.listToArray(intanceModel().findAll());

        Producto objProducto = (Producto) JOptionPane.showInputDialog(null, "Seleccione un Producto a editar", "", JOptionPane.QUESTION_MESSAGE, null, Opciones, Opciones[0]);
        String nombre = JOptionPane.showInputDialog( null, "Ingrese el nombre del producto: ", objProducto.getNombre());
        float precio = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese el precio del producto: ", objProducto.getPrecio()));
        int stock = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad en stock: ", objProducto.getStock()));

        Object[] opcionesTienda= Utils.listToArray(TiendaController.instanciaModelo().findAll());

        Tienda objTienda = (Tienda) JOptionPane.showInputDialog(null, "Seleccione un tienda", "", JOptionPane.QUESTION_MESSAGE, null, opcionesTienda, opcionesTienda[0]);

        //Instanciamos y creamos el nuevo Producto
        intanceModel().update(new Producto(nombre,precio,objProducto.getId(), stock, objTienda));

    }
*/

}
