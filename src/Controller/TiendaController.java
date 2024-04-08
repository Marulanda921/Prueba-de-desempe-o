package Controller;

import Entity.Tienda;
import Model.ModeloTienda;

import javax.swing.*;
import java.util.List;

public class TiendaController {



    public static ModeloTienda instanciaModelo(){
        return new ModeloTienda();
    }

    public static void getAll(){
        String lista = getAll(instanciaModelo().findAll());
        JOptionPane.showMessageDialog(null, lista);
    }

    public static String getAll(List<Object> list){
        String listaRegistros = "LISTA DE REGISTROS: \n";
        for(Object Temporal : list){
            Tienda objPaciente = (Tienda) Temporal;
            listaRegistros += objPaciente.toString() + "\n";
        }
        return listaRegistros;
    }

}
