package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModeloCliente  implements CRUD {

    @Override
    public Object insert(Object object) {
        //Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();

        //Parseamos el objeto
        Cliente objClient = (Cliente) object;

        try {
            //Crear la consulta
            String sql = "INSERT INTO cliente (nombre,apellido,email) VALUES (?,?,?);";

            //preparar el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //Setear los valores
            objPrepare.setString(1, objClient.getNombre());
            objPrepare.setString(2, objClient.getApellido());
            objPrepare.setString(3, objClient.getEmail());


            //Ejecutar la consulta
            objPrepare.execute();

            //Obtener las llaves generadas
            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()){
                objClient.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "Se inserto con exito");


        }catch (SQLException e) {
            System.out.println("Eroror: " + e.getMessage());
        }
        //Cerrar la conexion
        ConfigDB.closeConnection();
        return objClient;
    }

    @Override
    public List<Object> findAll() {
        //Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();

        //crear un array para llenar con los datos
        List<Object> listaClientes  = new ArrayList<>();

        try {
            //Hacer el sql
            String sql = "SELECT * FROM cliente;";

            //preparar el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //Resultado de la consulta y trae todos los datos
            ResultSet resultSet = objPrepare.executeQuery();

            while (resultSet.next()){
                Cliente objCliente = new Cliente();
                objCliente.setId(resultSet.getInt("id"));
                objCliente.setNombre(resultSet.getString("nombre"));
                objCliente.setApellido(resultSet.getString("apellido"));
                objCliente.setEmail(resultSet.getString("email"));
                listaClientes.add(objCliente);
            }


        }catch (SQLException e) {
            System.out.println("Error:" + e.getMessage() );
        }
        //CERRAMOS LA CONEXION Y RETORNAMOS LA LISTA
        ConfigDB.closeConnection();
        return listaClientes;
    }

    @Override
    public boolean delete(Object object) {
        //Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();

        //parsear el objeto a tipo cliente
        Cliente objCliente = (Cliente) object;

        //Booleano para saber si se elimina
        boolean borrado = false;

        try {
            //Hacer la consulta
            String sql = "DELETE FROM cliente WHERE id =?";

            //preparar el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //añadir valores a los parentesis
            objPrepare.setInt(1, objCliente.getId());

            //Filas afectadas
            int rowsAfected = objPrepare.executeUpdate();

            if (rowsAfected > 0){
                borrado = true;
                JOptionPane.showMessageDialog(null,"Datos eliminados Correctamente");
            }

        }catch (SQLException e){
            System.out.println("Error:" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return borrado;
    }

    @Override
    public boolean update(Object object) {
        //Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();

        //parsear el objeto a tipo Cliente
        Cliente objCliente = (Cliente) object;

        //Booleano para saber si se elimina
        boolean Actualizado = false;

        try {
            //Hacer la consulta
            String sql = "UPDATE cliente SET nombre =?, apellido =?, email =? WHERE id=?;";
            //preparar el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //añadir valores a los parentesis
            objPrepare.setString(1, objCliente.getNombre());
            objPrepare.setString(2, objCliente.getApellido());
            objPrepare.setString(3, objCliente.getEmail());
            objPrepare.setInt(4, objCliente.getId());

            //Filas afectadas
            int rowsAfected = objPrepare.executeUpdate();

            if (rowsAfected > 0){
                Actualizado = true;
                JOptionPane.showMessageDialog(null,"Datos actualizados Correctamente");
            }

        }catch (SQLException e){
            System.out.println("Error:" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return Actualizado;
    }
}
