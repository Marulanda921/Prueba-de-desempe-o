package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Cliente;
import Entity.Compra;
import Entity.Producto;
import Entity.Tienda;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModeloCompra implements CRUD {

    @Override
    public Object insert(Object object) {
            //Abrir la conexion
            Connection objConnection = ConfigDB.openConnection();
            //parsear el objeto a tipo Compra
            Compra objCompra = (Compra) object;

            try {
                //hacer la consulta
                String sql = "INSERT INTO compra (id_cliente ,id_producto,fecha_compra,cantidad) VALUES (?,?,?,?)";

                //preparar el statement
                PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

                //setear los parametros
                objPrepare.setInt(1, objCompra.getIdCliente());
                objPrepare.setInt(2, objCompra.getIdProducto());
                objPrepare.setDate(3, objCompra.getFechaCompra());
                objPrepare.setInt(4, objCompra.getCantidad());


                //ejecutar el statement
                objPrepare.execute();

                //obtener el id de la cita
                ResultSet objResult = objPrepare.getGeneratedKeys();

                while (objResult.next()){
                    objCompra.setId(objResult.getInt(1));
                }
                JOptionPane.showMessageDialog(null,"Se han insertado los datos");

            }catch (SQLException e){
                System.out.println("Error:" + e.getMessage());
            }
            ConfigDB.closeConnection();
            return objCompra;
    }

    @Override
    public List<Object> findAll() {
        //Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();

        //crear un array para llenar con los datos
        List<Object> listaProductos  = new ArrayList<>();

        try {
            //Escribir sql
            //EN ESTE CASO QUIERO TRAER TAMBIEN LA INFORMACION DE LAS TABLA PARA QUE QUEDE UNIDA
            String sql = "SELECT * FROM compra \n" +
                    "INNER JOIN producto on producto.id = compra.id_cliente\n" +
                    "INNER JOIN tienda on tienda.id = producto.id_tienda\n" +
                    "INNER JOIN cliente on cliente.id = compra.id_cliente;";

            //Preparar el statement
            PreparedStatement objprepare = objConnection.prepareStatement(sql);

            //Ejecutar el statement Y Obtener los resultados
            ResultSet objResult = objprepare.executeQuery();

            while (objResult.next()) {
                //Objeto para llenar
                Compra objCompra = new Compra();
                Producto objProducto = new Producto();
                Cliente objCliente = new Cliente();
                Tienda objTienda = new Tienda();


                objCompra.setId(objResult.getInt("compra.id"));
                objCompra.setId(objResult.getInt("compra.id_cliente"));
                objCompra.setIdProducto(objResult.getInt("compra.id_producto"));
                objCompra.setFechaCompra(objResult.getDate("compra.fecha_compra"));
                objCompra.setCantidad(objResult.getInt("compra.cantidad"));


                objProducto.setId(objResult.getInt("producto.id"));
                objProducto.setNombre(objResult.getString("producto.nombre"));
                objProducto.setPrecio(objResult.getFloat("producto.precio"));
                objProducto.setIdTIenda(objResult.getInt("producto.id_tienda"));
                objProducto.setStock(objResult.getInt("producto.stock"));


                objTienda.setId(objResult.getInt("tienda.id"));
                objTienda.setNombre(objResult.getString("tienda.nombre"));
                objTienda.setUbicacion(objResult.getString("tienda.ubicacion"));

                objCliente.setId(objResult.getInt("cliente.id"));
                objCliente.setNombre(objResult.getString("cliente.nombre"));
                objCliente.setApellido(objResult.getString("cliente.apellido"));
                objCliente.setEmail(objResult.getString("cliente.email"));


                //PARA GUARDAR LOS VALORES QUE SETEAMOS los getters y setters de la entidad
                objCompra.setObjProducto(objProducto);
                objCompra.setObjTienda(objTienda);
                objCompra.setObjCliente(objCliente);


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
        return false;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }
}
