/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Components;

import Components.Class.Client;
import Components.Class.Helper;
import static Components.Class.Helper.hashString;
import Components.Forms.Admin;
import Components.Forms.CheckExistence;
import Components.Forms.CreateProfile;
import Components.Forms.Login;
import Components.Forms.User;
import Components.Forms.Admin;
import Components.Forms.editReservation;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String args[]) {

        //<editor-fold desc="Creating the tables">
//        Connection connection = Helper.getConnection();
//        Statement statement = null;
        String createSeatQuery = "CREATE TABLE IF NOT EXISTS seat ("
                + "flightNo INT NOT NULL,"
                + "seatNo VARCHAR(10) NOT NULL,"
                + "class CHAR(1) NOT NULL,"
                + "options VARCHAR(100),"
                + "    departureDate DATE NOT NULL,\n"
                + "    departureTime TIME NOT NULL,\n"
                + "    departurePlace VARCHAR(100) NOT NULL,\n"
                + "    arrivalDate DATE NOT NULL,\n"
                + "    arrivalTime TIME NOT NULL,\n"
                + "    landingPlace VARCHAR(100) NOT NULL,\n"
                + "PRIMARY KEY (seatNo)"
                + ");";
        String createClientQuery = "CREATE TABLE IF NOT EXISTS client ("
                + "passportNb VARCHAR(10) NOT NULL UNIQUE,"
                + "ID INT PRIMARY KEY AUTO_INCREMENT,"
                + "firstName VARCHAR(20) NOT NULL,"
                + "lastName VARCHAR(20) NOT NULL,"
                + "password VARCHAR(64),"
                + "tel VARCHAR(8),"
                + "emailAddress VARCHAR(30) UNIQUE"
                + ");";

        String createReservationQuery = "CREATE TABLE IF NOT EXISTS reservation ("
                + "    seatNo VARCHAR(10) NOT NULL UNIQUE,\n"
                + "    client_id INT NOT NULL ,\n"
                + "    FOREIGN KEY (seatNo) REFERENCES seat(seatNo),\n"
                + "    FOREIGN KEY (client_id) REFERENCES client(ID)\n"
                + ");";

        String createTableSQL = "CREATE TABLE IF NOT EXISTS `admin` ("
                + "passportNb VARCHAR(10) NOT NULL UNIQUE,"
                + "ID INT PRIMARY KEY AUTO_INCREMENT,"
                + "firstName VARCHAR(20) NOT NULL,"
                + "lastName VARCHAR(20) NOT NULL,"
                + "password VARCHAR(64),"
                + "tel VARCHAR(8),"
                + "emailAddress VARCHAR(30)"
                + ");";
        String insertAdminSQL = "INSERT IGNORE INTO `admin` (passportNb, firstName, lastName, password, tel, emailAddress) "
                + "VALUES ('CD1', 'Charbel', 'Daher', '031e3bc9e098ca3aabfff7f221f5c486f1e264bf5244436343efd246f41ac05d', '70435237', 'a');";

        String insertClientSQL = "INSERT IGNORE INTO `client` (passportNb, firstName, lastName, password, tel, emailAddress) "
                + "VALUES "
                + "('CD1', 'Charbel', 'Daher', '031e3bc9e098ca3aabfff7f221f5c486f1e264bf5244436343efd246f41ac05d', '70435237', 'a'); ";

        //Creates the 3 tables
        //Client has a foreign key to seat
        //Reservation has 2 foreign keys to seat and client
        try {
            // Create a Statement object
            statement = connection.createStatement();
            statement.execute(createSeatQuery);
            System.out.println("Table 'seat' created successfully.");
            statement.execute(createClientQuery);
            System.out.println("Table 'client' created successfully.");

            statement.execute(createReservationQuery);
            System.out.println("Table 'Reservation' created successfully.");
            statement.execute(createTableSQL);
            System.out.println("'admin' table created successfully!");

            statement.execute(insertAdminSQL);
            System.out.println("Data inserted into 'admin' table successfully!");

            statement.execute(insertClientSQL);
            System.out.println("Data inserted into 'client' table successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        //</editor-fold>
    CheckExistence CheckExistenceFrm = new CheckExistence();

    CheckExistenceFrm.show ();
}
    public static Connection connection = Helper.getConnection();
    public static Statement statement = null;
    public static Client client = new Client();
    public static Set<String> seatNumbers = new HashSet<>();
}
