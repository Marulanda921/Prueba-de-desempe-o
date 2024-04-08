import Controller.ClienteController;
import Controller.CompraController;
import Controller.ProductoController;
import Controller.TiendaController;
import Database.ConfigDB;
import Entity.Tienda;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        int option = 0, option2 = 0;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Administrar Tiendas
                    2. Administrar Productos
                    3. Administrar Clientes
                    4. Administrar Compras
                    5. salir
                                        
                    Ingresa una opcion: 
                    """));
            switch (option) {
                case 1:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar Tiendas
                                2. salir
                                                    
                                Ingresa una opcion: 
                                """));
                        switch (option2) {
                            case 1:
                                TiendaController.getAll();
                                break;
                        }
                    } while (option2 != 2);
                    break;
                case 2:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar Productos
                                2. Crear Productos
                                3. Eliminar Productos
                                4. Actualizar Productos 
                                5. salir
                                                    
                                Ingresa una opcion: 
                                            """));
                        switch (option2) {
                            case 1:
                                ProductoController.getAll();
                                break;
                            case 2:
                                ProductoController.insert();
                                break;
                            case 3:
                                ProductoController.delete();
                                break;
                            case 4:
                                ProductoController.update();
                                break;
                        }
                    } while (option2 != 5);
                    break;
                case 3:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar Clientes
                                2. Crear Clientes
                                3. Eliminar Clientes
                                4. Actualizar Clientes 
                                5. salir
                                                    
                                Ingresa una opcion: 
                                            """));
                        switch (option2) {
                            case 1:
                                ClienteController.getAll();
                                break;
                            case 2:
                                ClienteController.insert();
                                break;
                            case 3:
                                ClienteController.delete();
                                break;
                            case 4:
                                ClienteController.update();
                                break;
                        }

                    } while (option2 != 5);
                    break;
                case 4:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar Compras
                                2. Crear Compras
                                3. Eliminar Compras
                                4. Actualizar Compras
                                5. salir
                                                    
                                Ingresa una opcion: 
                                            """));
                        switch (option2) {
                            case 1:
                                CompraController.getAll();
                                break;
                            case 2:
                                CompraController.insert();
                                break;
                            case 3:
                                //ClienteController.delete();
                                break;
                            case 4:
                                //ClienteController.update();
                                break;
                        }

                    } while (option2 != 5);

                    }
        } while (option != 5);

    }
}