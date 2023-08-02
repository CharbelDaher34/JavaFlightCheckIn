/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components.Class;

import static Components.Main.client;
import static Components.Main.connection;
import static Components.Main.statement;
import static Components.Main.seatNumbers;
import java.io.File;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.xdevapi.Table;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.swing.text.JTextComponent;
/**
 *
 * @author user
 */
public class Helper {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/javadb?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Charbel@123";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load the MySQL JDBC driver class
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Create the connection
                connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                System.out.println("Connected to the database successfully.");
            } catch (ClassNotFoundException e) {
                System.err.println("Error: JDBC driver not found.");
            } catch (SQLException e) {
                System.err.println("Error: Failed to connect to the database.");
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Error: Failed to close the database connection.");
            }
        }
    }

    //given this.getContentPane() as argument, it clears the components of the form
    public static void clearForm(Container container) {
    for (Component component : container.getComponents()) {
        if (component instanceof JTextComponent) {
            ((JTextComponent) component).setText("");
        } else if (component instanceof JComboBox) {
            JComboBox<?> comboBox = (JComboBox<?>) component;
            if (comboBox.getItemCount() > 0) {
                comboBox.setSelectedIndex(0);
            }
        } else if (component instanceof JCheckBox) {
            ((JCheckBox) component).setSelected(false);
        } else if (component instanceof JRadioButton) {
            ((JRadioButton) component).setSelected(false);
        } else if (component instanceof Container) {
            clearForm((Container) component);
        }
    }
}

//    public static void clearForm(Container container) {
//        for (Component component : container.getComponents()) {
//            if (component instanceof JTextComponent) {
//                ((JTextComponent) component).setText("");
//            } else if (component instanceof JComboBox) {
//                ((JComboBox<?>) component).setSelectedIndex(0);
//            } else if (component instanceof JCheckBox) {
//                ((JCheckBox) component).setSelected(false);
//            } else if (component instanceof JRadioButton) {
//                ((JRadioButton) component).setSelected(false);
//            } else if (component instanceof Container) {
//                clearForm((Container) component);
//            }
//        }
//    }

    public static void storeExistingReservedSeats() {
        try {
            String query = "SELECT seatNo FROM reservation WHERE client_id = ?;";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(
                    1, client.getID());

            ResultSet resultSet = statement.executeQuery();

            // Process the ResultSet and add seat numbers to the set
            while (resultSet.next()) {
                String seatNo = resultSet.getString("seatNo");
                seatNumbers.add(seatNo);
                String aa = "";
                for (var s : seatNumbers) {
                    aa += s;
                }
            }
        } catch (Exception ex) {

        }
    }

    //hashing a string function
    public static String hashString(String input, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] hash = md.digest(input.getBytes());

            // Convert the byte array to a hexadecimal representation
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to check if any of the JTextFields is empty
    public static boolean isAnyFieldEmpty(JTextField... textFields) {
        for (JTextField textField : textFields) {
            if (textField.getText().trim().isEmpty()) {
                return true; // Found an empty field
            }
        }
        return false; // No empty fields
    }

    public static boolean isAnyFieldEmpty(Container container) {
        Component[] components = container.getComponents();
        ArrayList<JTextField> textFields = new ArrayList<>();

        for (Component component : components) {
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                textFields.add(textField);
            } else if (component instanceof Container) {
                boolean result = isAnyFieldEmpty((Container) component);
                if (result) {
                    return true;
                }
            }
        }

        for (JTextField textField : textFields) {
            if (textField.getText().trim().isEmpty()) {
                return true; // Found an empty field
            }
        }

        return false; // No empty fields
    }
public static void createPDF(String outputPath, String content) {
        //String outputPath = "C:" + File.separator + "Users" + File.separator + "user" +
        //              File.separator + "Desktop" + File.separator + "AntProject" +
        //          File.separator + client.getFirstName() + ".pdf";
        //  Helper.createPDF(outputPath, textArea.getText());
        String FILE_NAME = outputPath;
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
            document.open();
            Paragraph p = new Paragraph();
            p.add(content);
            document.add(p);
            document.close();
            JOptionPane.showMessageDialog(null, "pdf createed", "Seat Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
