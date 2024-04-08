package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

        //INICIO UN OBJETO TIPO CONNECTION EN VALOR NULO, CON ESTE VOY A VALIDAD SI SE ESTABLECE O NO UNA CONEXION
        public static Connection objectConnection = null;


        //Se inicia el metodo para iniciar la conexion
        public static Connection openConnection() {
            try {
                //Driver de la conexion
                Class.forName("com.mysql.jdbc.Driver");

                //Parametros de la conexion
                String url = "jdbc:mysql://uioyvckg0uqurao8:oGDQoekzu5l3pUm9tzkz@bzlugahewzacffv9hwqe-mysql.services.clever-cloud.com:3306/bzlugahewzacffv9hwqe";
                String user = "uioyvckg0uqurao8";
                String password = "oGDQoekzu5l3pUm9tzkz";

                //Se crea la conexion y se le meten los parametros
                objectConnection = DriverManager.getConnection(url, user, password);
                System.out.println("Conexion establecida con exito");


            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("Driver no instalado: " + e.getMessage());
            }
            //se retorna hacia el objConexion el resultado
            return objectConnection;
        }


        //Se inicia el metodo para cerrar la conexion
        public static void closeConnection() {
            try {
                if (objectConnection != null) {
                    objectConnection.close();
                }

                System.out.println("Me desconecte perfectamente");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }

        }

    }

