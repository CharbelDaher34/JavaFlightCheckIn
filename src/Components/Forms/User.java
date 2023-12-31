/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Components.Forms;

import Components.Class.Helper;
import Components.Class.Seat;
import Components.Class.seatComparator;

import static Components.Main.client;
import static Components.Main.connection;
import static Components.Main.seatNumbers;
import static Components.Main.statement;
import java.awt.Component;
import java.awt.List;
import static java.lang.System.in;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;

/**
 *
 * @author user
 */
public class User extends javax.swing.JFrame {
//reservedSeat for the selected seat to book

    private String reservedSeat = "";
    //price of each ticket
    private Map<Character, Integer> ticketPricesByFirstLetter = new HashMap<>();
    //booked seats before paying
    private Set<String> pendingSeats = new HashSet<>();
    private Vector<Seat> seatsList = new Vector<>();

    /**
     * Creates new form User
     */
    public User() {
        initComponents();
        fillComboBox();

        updateDb();
        ticketPricesByFirstLetter.put('P', 1500);
        ticketPricesByFirstLetter.put('B', 3000);
        ticketPricesByFirstLetter.put('F', 5000);
        ticketPricesByFirstLetter.put('S', 10000);
        ticketPricesByFirstLetter.put('E', 800);
        fillTable2();
        //Store the existing reservation for the current client uponlogin
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        javax.swing.JTable jTable1 = new javax.swing.JTable();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JButton Back = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        seatTable = new javax.swing.JTable();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JButton book = new javax.swing.JButton();
        javax.swing.JButton reciept = new javax.swing.JButton();
        flightNo = new javax.swing.JComboBox<>();
        javax.swing.JScrollPane jScrollPane3 = new javax.swing.JScrollPane();
        seatsToDelete = new javax.swing.JTable();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JButton delete = new javax.swing.JButton();

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Components/Forms/Bundle"); // NOI18N
        jLabel1.setText(bundle.getString("User.jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        Back.setText(bundle.getString("User.Back.text")); // NOI18N
        Back.setName("Back"); // NOI18N
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        seatTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "flightNo", "seatNo", "class", "options", "departureDate", "departureTime", "departurePlace", "arrivalDate", "arrivalTime", "landingPlace"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        seatTable.setName("seatTable"); // NOI18N
        seatTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seatTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(seatTable);

        jLabel2.setText(bundle.getString("User.jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        book.setText(bundle.getString("User.book.text")); // NOI18N
        book.setName("book"); // NOI18N
        book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookActionPerformed(evt);
            }
        });

        reciept.setText(bundle.getString("User.reciept.text")); // NOI18N
        reciept.setName("reciept"); // NOI18N
        reciept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recieptActionPerformed(evt);
            }
        });

        flightNo.setName("flightNo"); // NOI18N
        flightNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightNoActionPerformed(evt);
            }
        });

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        seatsToDelete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "flightNo", "seatNo", "class", "options", "departureDate", "departureTime", "departurePlace", "arrivalDate", "arrivalTime", "landingPlace"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        seatsToDelete.setName("seatsToDelete"); // NOI18N
        seatsToDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seatsToDeleteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(seatsToDelete);

        jLabel3.setText(bundle.getString("User.jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(bundle.getString("User.jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        delete.setText(bundle.getString("User.delete.text")); // NOI18N
        delete.setName("delete"); // NOI18N
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(flightNo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(109, 109, 109)
                        .addComponent(jLabel3)
                        .addGap(183, 183, 183)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(delete)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Back)
                            .addGap(641, 641, 641))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(book, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(reciept, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(1298, 1298, 1298))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(544, 544, 544)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(333, 333, 333)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(flightNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reciept)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(book)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Back))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(delete)))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
//        if (flightNo.getSelectedItem() == null) {
//            JOptionPane.showMessageDialog(null, "ba3");
//
//            dispose();
//            LoginFrm.show();
//        }
        seatsList = new Vector<>();
        pendingSeats = new HashSet();
        reservedSeat = "";
        fillComboBox();
        updateDb();
        Helper.clearForm(this.getContentPane());
        dispose();
        Login LoginFrm = new Login();

        LoginFrm.show();
    }//GEN-LAST:event_BackActionPerformed

    private void seatTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seatTableMouseClicked
        DefaultTableModel tableModel = (DefaultTableModel) seatTable.getModel();
        int selectedRow = seatTable.getSelectedRow();
        reservedSeat = tableModel.getValueAt(selectedRow, 1).toString(); // Assuming seatNo is in the second column (index 1)

    }//GEN-LAST:event_seatTableMouseClicked

    private void bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookActionPerformed
        PreparedStatement preparedStatement = null;
        if (reservedSeat == "") {
            JOptionPane.showMessageDialog(null, "choose a seat first");

            return;
        }
        try {
            String selectQuery = "SELECT COUNT(*) FROM reservation WHERE seatNo = ?";
            preparedStatement = connection.prepareStatement(selectQuery);

            preparedStatement.setString(1, reservedSeat);

// Execute the SELECT query
            ResultSet resultSet = preparedStatement.executeQuery();

// Move the ResultSet cursor to the first row
            if (resultSet.next()) {
                // Retrieve the count value from the first column
                int count = resultSet.getInt(1);

                // Check if the count of rows is greater than 0
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "Already Booked");
                    return;
                }
            }
        } catch (Exception e) {

        }
        // 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
        pendingSeats.add(reservedSeat);
        try {
            Seat seat = new Seat();

            String selectQuery = "SELECT * FROM seat WHERE seatNo = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, reservedSeat);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Move the ResultSet cursor to the first row
            if (resultSet.next()) {
                seat = new Seat();
                seat.setFlightNo(resultSet.getInt("flightNo"));
                seat.setSeatNo(resultSet.getString("seatNo"));
                seat.setSeatClass(resultSet.getString("class").charAt(0));
                seat.setOptions(resultSet.getString("options"));
                seat.setDepartureDate(resultSet.getDate("departureDate"));
                seat.setArrivalDate(resultSet.getDate("arrivalDate"));
                seat.setDeparturePlace(resultSet.getString("departurePlace"));
                seat.setLandingPlace(resultSet.getString("landingPlace"));
                seat.setDepartureTime(resultSet.getTime("departureTime"));
                seat.setArrivalTime(resultSet.getTime("arrivalTime"));
            } else {

            }
            seatsList.add(seat);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Seat added successfully");
        fillComboBox();
        flightNo.setSelectedItem(reservedSeat);
        reservedSeat = "";
        updateDb();

    }//GEN-LAST:event_bookActionPerformed


    private void recieptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recieptActionPerformed

        if (seatsList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Book First at least a ticket!");

            return;
        }
        seatComparator comparator = new seatComparator(ticketPricesByFirstLetter);

        // Apply the comparator to sort the list of seats
        Collections.sort(seatsList, comparator);
        int money = 0;
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.append("Name: " + client.getFirstName() + " " + client.getLastName() + "\n");
        textArea.append("tel: " + client.getTel() + "\n");
        textArea.append("ID: " + client.getID() + "\n");
        textArea.append("passport number: " + client.getPassportNumber() + "\n\n\nTickets Bought:\n");
        for (Seat seat : seatsList) {
            textArea.append("Flight No: " + seat.getFlightNo() + "\n");
            textArea.append("Seat No: " + seat.getSeatNo() + "\n");
            textArea.append("Class: " + seat.getSeatClass() + "\n");
            textArea.append("Options: " + seat.getOptions() + "\n");
            textArea.append("Departure Date: " + seat.getDepartureDate() + "\n");
            textArea.append("Departure Time: " + seat.getDepartureTime() + "\n");
            textArea.append("Departure Place: " + seat.getDeparturePlace() + "\n");
            textArea.append("Arrival Date: " + seat.getArrivalDate() + "\n");
            textArea.append("Arrival Time: " + seat.getArrivalTime() + "\n");
            textArea.append("Landing Place: " + seat.getLandingPlace() + "\n");
            textArea.append("Price: " + ticketPricesByFirstLetter.get(seat.getSeatClass()) + "\n");
            textArea.append("Price with tax: " + ticketPricesByFirstLetter.get(seat.getSeatClass()) * 1.11 + "\n");

            textArea.append("\n"); // Separate each seat information
            money += ticketPricesByFirstLetter.get(seat.getSeatClass());
        }
        textArea.append("Total Price: " + money + "\n");
        textArea.append("Total Price with tax: " + money * 1.11 + "\n");

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(600, 400));
        JOptionPane.showMessageDialog(null, scrollPane, "Seat Information", JOptionPane.INFORMATION_MESSAGE);

        if (JOptionPane.showConfirmDialog(null, "Wanna Book?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            String insertQuery = "INSERT INTO reservation (seatNo, client_id) VALUES (?, ?)";

            // Iterate over the seatList and insert each seat number into the reservation table
            String batata = "\n";
            for (Seat tmp : seatsList) {
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

                    String reservedSeat = tmp.getSeatNo();
                    preparedStatement.setString(1, reservedSeat);
                    preparedStatement.setInt(2, client.getID());

                    // Execute the insert query for each seat number
                    int rowsInserted = preparedStatement.executeUpdate();

                    if (rowsInserted > 0) {
                        batata += "-" + reservedSeat + "\n";                        // You can also show a success message if needed

                    } else {

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(User.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }
            String outputPath = "C:" + File.separator + "Users" + File.separator + "user"
                    + File.separator + "Desktop" + File.separator + "AntProject"
                    + File.separator + "Invoices"
                    + File.separator + client.getFirstName() + ".pdf";
            String relPath = "Invoices" + File.separator + client.getFirstName() + ".pdf";

            Helper.createPDFRel(relPath, textArea.getText());

            JOptionPane.showMessageDialog(null, "Those seats are entered successfuly to the DB:\n" + batata, "Seat Information", JOptionPane.INFORMATION_MESSAGE);
            seatsList = new Vector<>();
            pendingSeats = new HashSet();

            fillComboBox();
            updateDb();
            Helper.clearForm(this.getContentPane());
            dispose();
            Login LoginFrm = new Login();

            LoginFrm.show();

        } else {
            seatsList = new Vector<>();
            pendingSeats = new HashSet();
            fillComboBox();

            updateDb();

        }

    }//GEN-LAST:event_recieptActionPerformed

    private void flightNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightNoActionPerformed
        updateDb();        // TODO add your handling code here:
    }//GEN-LAST:event_flightNoActionPerformed
    private String resDel;
    private String selectedSeatNo;
    private int selectedID;
    private void seatsToDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seatsToDeleteMouseClicked

        int selectedRow = seatsToDelete.getSelectedRow();
        if (selectedRow >= 0) { // Make sure a row is selected
            selectedSeatNo = seatsToDelete.getValueAt(selectedRow, 3).toString();
            selectedID = Integer.parseInt(seatsToDelete.getValueAt(selectedRow, 2).toString());
            // The indexes 2 and 3 correspond to "ID" and "Seat No" columns in the JTable.
        }

    }//GEN-LAST:event_seatsToDeleteMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            String deleteQuery = "DELETE FROM reservation WHERE seatNo = ? AND client_id = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setString(1, selectedSeatNo);
            deleteStatement.setInt(2, selectedID);

            int rowsAffected = deleteStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Row deleted successfully.");
                // Update the JTable or other UI components after the delete operation if needed.
                fillTable2();
            } else {
                JOptionPane.showMessageDialog(null, "No matching rows found for deletion.");
            }
            fillComboBox();
            updateDb();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle the SQLException appropriately, such as showing an error message to the user.
            // Example: JOptionPane.showMessageDialog(null, "An error occurred while deleting the row.");
        } // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed
    public void fillTable2() {
        try {
            Statement statement = connection.createStatement();

            String sqlQuery = "SELECT c.firstName, c.lastName, c.ID, r.seatNo, s.flightNo "
                    + "FROM reservation r "
                    + "JOIN seat s ON r.seatNo = s.seatNo "
                    + "JOIN client c ON r.client_id = c.ID "
                    + "WHERE r.client_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            // Bind the client ID to the placeholder
            preparedStatement.setInt(1, client.getID());
            ResultSet resultSet = preparedStatement.executeQuery();

            String[] columnNames = {"First Name", "Last Name", "ID", "Seat No", "Flight No"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            // Populate the table model with data from the resultSet
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int ID = resultSet.getInt("ID");
                String seatNo = resultSet.getString("seatNo");
                int flightNo = resultSet.getInt("flightNo");

                // Add the data as a row to the table model
                tableModel.addRow(new Object[]{firstName, lastName, ID, seatNo, flightNo});
            }
            seatsToDelete.setModel(tableModel);

        } catch (SQLException ex) {
            Logger.getLogger(editReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateDb() {
        if (flightNo.getSelectedItem() == null) {
            return;
        }
        if (flightNo.getSelectedIndex() == -1) {

            return;
        }
        Set<String> seatNumbers = new HashSet<>();
        DefaultTableModel model = (DefaultTableModel) seatTable.getModel();
        model.setRowCount(0); // Set the row count to 0 to remove all rows
        try {
            String selectQuery = "SELECT seatNo FROM reservation";
            Statement statement = connection.createStatement();

            // Execute the SELECT query
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Loop through the result set and add seatNo values to the Set
            while (resultSet.next()) {
                String seatNo = resultSet.getString("seatNo");
                seatNumbers.add(seatNo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String selectQuery = "SELECT * FROM seat WHERE flightNo = ?";

            // Prepare the SELECT query
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, (int) flightNo.getSelectedItem()); // Set the value for the parameter (flightNo)

            // Execute the query and get the ResultSet
            ResultSet resultSet = preparedStatement.executeQuery();

            DefaultTableModel seatTableModel = (DefaultTableModel) seatTable.getModel();
            seatTableModel.setRowCount(0);
            // Process and display the data (you can add it to a table)
            while (resultSet.next()) {
                String seatNooo = resultSet.getString("seatNo");

                if (!seatNumbers.contains(seatNooo) && !pendingSeats.contains(seatNooo)) {

                    int flightNoo = resultSet.getInt("flightNo");
                    String seatNoo = resultSet.getString("seatNo");
                    String seatClasss = resultSet.getString("class");
                    String optionss = resultSet.getString("options");
                    java.sql.Date departureDatee = resultSet.getDate("departureDate");
                    java.sql.Time departureTimee = resultSet.getTime("departureTime");
                    String departurePlacee = resultSet.getString("departurePlace");
                    java.sql.Date arrivalDatee = resultSet.getDate("arrivalDate");
                    java.sql.Time arrivalTimee = resultSet.getTime("arrivalTime");
                    String landingPlacee = resultSet.getString("landingPlace");
                    Vector<Object> row = new Vector<>();
                    row.add(flightNoo);
                    row.add(seatNoo);
                    row.add(seatClasss);
                    row.add(optionss);
                    row.add(departureDatee);
                    row.add(departureTimee);
                    row.add(departurePlacee);
                    row.add(arrivalDatee);
                    row.add(arrivalTimee);
                    row.add(landingPlacee);
                    // Add the data to your Java table (e.g., JTable)
                    seatTableModel.addRow(row);
                }
            }

        } catch (Exception e) {

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(User.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });

    }

    public void fillComboBox() {
        try {
            String selectQuery = "SELECT DISTINCT flightNo FROM seat";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            flightNo.removeAllItems();

            while (resultSet.next()) {
                int tmp = resultSet.getInt("flightNo");
                flightNo.addItem(tmp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Vector<Integer> intVector = new Vector<>();

        for (int i = 0; i < flightNo.getItemCount(); i++) {
            int item = (int) flightNo.getItemAt(i);
            flightNo.setSelectedItem(item);

            updateDb();
            if (seatTable.getRowCount() == 0) {
                // Remove the current value of the JComboBox named "class"
                int selectedIndex = flightNo.getSelectedIndex();
                if (selectedIndex != -1) {
                    intVector.add(item);
                }
            }
            // Do something with the integer item
        }
        for (Integer element : intVector) {
            // Remove the current element from the combo box
            flightNo.removeItem(element);
        }

        // Perform any operations on the value as needed
    }

    // Set the selected index after populating the combo box

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<Integer> flightNo;
    public javax.swing.JTable seatTable;
    public javax.swing.JTable seatsToDelete;
    // End of variables declaration//GEN-END:variables
}
