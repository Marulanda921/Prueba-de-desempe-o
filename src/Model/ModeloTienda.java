package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Tienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModeloTienda implements CRUD {
    @Override
    public Object insert(Object object) {
        return null;
    }

    @Override
    public List<Object> findAll() {
        //Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();

        //crear un array para llenar con los datos
        List<Object> listaTiendas  = new ArrayList<>();

        try {
            //Hacer el sql
            String sql = "SELECT * FROM tienda;";

            //preparar el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //Resultado de la consulta y trae todos los datos
            ResultSet resultSet = objPrepare.executeQuery();

            while (resultSet.next()){
                Tienda objTienda = new Tienda();
                objTienda.setId(resultSet.getInt("id"));
                objTienda.setNombre(resultSet.getString("nombre"));
                objTienda.setUbicacion(resultSet.getString("ubicacion"));

                listaTiendas.add(objTienda);
            }


        }catch (SQLException e) {
            System.out.println("Error:" + e.getMessage() );
        }
        ConfigDB.closeConnection();
        return listaTiendas;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }
}
