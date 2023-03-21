package org.swing.demomysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Marcos Miranda
 */
public class App {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            String cadenaConexion = "jdbc:mysql://localhost:3306/sakila?user=root&password=IESJJCM2023";
            Connection con = DriverManager.getConnection(cadenaConexion);
            Statement stmt = con.createStatement();

            // inserta un dato
            // stmt.executeUpdate("INSERT INTO `sakila`.`actor` (`actor_id`, `first_name`, `last_name`, `last_update`) VALUES ('202', 'Marcos', 'Miranda', '2006-02-15 04:34:33');");
            
            // Borra un dato
            //stmt.executeUpdate("DELETE FROM `sakila`.`actor` WHERE `actor_id`='201';");
            
            //Visualiza resultados
            ResultSet rs = stmt.executeQuery("SELECT * from actor ORDER BY first_name");

            //aqui creamos variables y damos valores
            while (rs.next()) {
                String nombre = rs.getString("first_name");
                String apellido = rs.getString("last_name");
                System.out.println("Nombre :" + nombre + " Apellido :" + apellido);
            }

            con.close();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

}
