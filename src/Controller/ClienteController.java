package Controller;

import Entity.Cliente;
import Entity.Producto;
import Entity.Tienda;
import Model.ModeloCliente;
import Utiles.Utils;

import javax.swing.*;
import java.util.List;


public class ClienteController {



    public static ModeloCliente intanceModel(){
        return new ModeloCliente();
    }

    public static void insert(){
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del cliente: ");
        String apellido = JOptionPane.showInputDialog("Ingresa los apellidos del cliente: ");
        String email = JOptionPane.showInputDialog("Ingresa tu email: ");

        intanceModel().insert(new Cliente(nombre, apellido, email));
    }


    public static void getAll(){
        String lista = getAll(intanceModel().findAll());
        JOptionPane.showMessageDialog(null, lista);
    }

    public static String getAll(List<Object> list){
        String listaRegistros = "LISTA DE REGISTROS: \n";
        for(Object Temporal : list){
            Cliente objPaciente = (Cliente) Temporal;
            listaRegistros += objPaciente.toString() + "\n";
        }
        return listaRegistros;
    }

    public static void delete() {
        Object[] options = Utils.listToArray(intanceModel().findAll());
        Cliente clienteSelecionado = (Cliente) JOptionPane.showInputDialog(null, "Seleccionar Cliente a eliminar", "", JOptionPane.QUESTION_MESSAGE,null, options, options[0]);

        intanceModel().delete(clienteSelecionado);
    }

    public static void update(){
        Object[] options = Utils.listToArray(intanceModel().findAll());
        Cliente clienteSelecionado = (Cliente) JOptionPane.showInputDialog(null, "Seleccionar Cliente a Actualizar", "", JOptionPane.QUESTION_MESSAGE,null, options, options[0]);

        clienteSelecionado.setNombre(JOptionPane.showInputDialog(null, "Ingresa nuevo nomnbre: ", clienteSelecionado.getNombre()));
        clienteSelecionado.setApellido(JOptionPane.showInputDialog(null, "Ingresa nuevo apellido: ", clienteSelecionado.getApellido()));
        clienteSelecionado.setEmail(JOptionPane.showInputDialog(null, "Ingresa tu nuevo email", clienteSelecionado.getEmail()));


        intanceModel().update(clienteSelecionado);
    }





}
