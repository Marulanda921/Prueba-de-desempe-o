package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Producto;
import Entity.Tienda;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModeloProducto implements CRUD {

    @Override
    public Object insert(Object object) {
        //Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();

        //Crear un objeto de tipo producto
        Producto objProducto = (Producto) object;

        try {
            //Crear la consulta
            String sql = "INSERT INTO producto (nombre,precio,id_tienda,stock ) VALUES (?,?,?,?);";

            //preparar el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //Setear los valores
            objPrepare.setString(1, objProducto.getNombre());
            objPrepare.setFloat(2, objProducto.getPrecio());
            objPrepare.setInt(3, objProducto.getIdTIenda());
            objPrepare.setInt(4, objProducto.getStock());

            //Ejecutar la consulta
            objPrepare.execute();

            //Obtener las llaves generadas
            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()){
                objProducto.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "Se inserto con exito");


        }catch (SQLException e) {
            System.out.println("Eroror: " + e.getMessage());
        }
        //Cerrar la conexion
        ConfigDB.closeConnection();
        return objProducto;
    }

    @Override
    public List<Object> findAll() {
        //Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();

        //crear un array para llenar con los datos
        List<Object> listaProductos  = new ArrayList<>();

        try {
            //Escribir sql
            //EN ESTE CASO QUIERO TRAER TAMBIEN LA INFORMACION DE LA TABLA LA tienda PARA QUE QUEDE UNIDA
            String sql = "SELECT * FROM producto\n" +
                    "INNER JOIN tienda ON tienda.id = producto.id_tienda;";

            //Preparar el statement
            PreparedStatement objprepare = objConnection.prepareStatement(sql);

            //Ejecutar el statement Y Obtener los resultados
            ResultSet objResult = objprepare.executeQuery();

            while (objResult.next()) {
                //Objeto para llenar
                Producto objProducto = new Producto();

                //como la entidad producto guarda un objeto tienda
                Tienda objTienda = new Tienda();


                objProducto.setId(objResult.getInt("producto.id"));
                objProducto.setNombre(objResult.getString("producto.nombre"));
                objProducto.setPrecio(objResult.getFloat("producto.precio"));
                objProducto.setIdTIenda(objResult.getInt("producto.id_tienda"));
                objProducto.setStock(objResult.getInt("producto.stock"));


                objTienda.setId(objResult.getInt("tienda.id"));
                objTienda.setNombre(objResult.getString("tienda.nombre"));
                objTienda.setUbicacion(objResult.getString("tienda.ubicacion"));

                //PARA GUARDAR LOS VALORES QUE SETEAMOS EN EL OBJtienda usamos los getters y setters de la entidad
                objProducto.setObjTienda(objTienda);

                listaProductos.add(objProducto);
            }



        }catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return listaProductos;
    }

    @Override
    public boolean delete(Object object) {
        //Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();

        //parsear el objeto a tipo producto
        Producto objMedico = (Producto) object;

        //Saber si se esta borrando
        boolean borrado = false;

        try {
            String sql = "DELETE FROM producto WHERE id = ?;";

            //prepare Statement
            PreparedStatement objprepare = objConnection.prepareStatement(sql);

            //Setear los parametros o darle valor a los signos de interrgacion
            objprepare.setInt(1,objMedico.getId());

            //Ejecutar el statement
            objprepare.execute();

            //Obtener las llaves generadas
            int rowsAfected = objprepare.executeUpdate();

            if (rowsAfected > 0) borrado = true;

            JOptionPane.showMessageDialog(null, "Se borró con exito");

        }catch (SQLException e){
            System.out.println("Error" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return borrado;
    }


    @Override
    public boolean update(Object object) {
        //Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();

        //parsear el objeto a tipo producto
        Producto objProdcuto = (Producto) object;

        //Saber si se esta actualizando
        boolean actualizado = false;

        try {
            //Hacer la sentencia
            String sql = "UPDATE producto SET nombre=?, precio=?, id_tienda=?, stock = ? WHERE id = ?;";

            //prepare statement
            PreparedStatement objprepare = objConnection.prepareStatement(sql);

            //Setear los parametros o darle valor a los signos de interrgacion
            objprepare.setString(1,objProdcuto.getNombre());
            objprepare.setFloat(2,objProdcuto.getPrecio());
            objprepare.setInt(3,objProdcuto.getIdTIenda());
            objprepare.setInt(4,objProdcuto.getStock());
            objprepare.setInt(5,objProdcuto.getId());



            //Obtener las llaves generadas
            int rowsAfected = objprepare.executeUpdate();

            if (rowsAfected > 0) actualizado = true;

            JOptionPane.showMessageDialog(null, "Se actualizó con exito");

        }catch (SQLException e){
            System.out.println("Error" + e.getMessage());

        }
        ConfigDB.closeConnection();
        return actualizado;
    }
}
