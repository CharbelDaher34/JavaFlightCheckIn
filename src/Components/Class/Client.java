/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components.Class;

/**
 *
 * @author user
 */
public class Client {
    private String passportNb;
    private int ID;
    private String firstName;
    private String lastName;
    private String password;
    private String tel;
    private Seat seat;

    public Client(String passportNb, int ID, String firstName, String lastName, String password, String tel, Seat seat) {
        this.passportNb = passportNb;
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.tel = tel;
        this.seat = seat;
    }

    public Client(String passportNb, int ID, String firstName, String lastName, String password, String tel) {
        this.passportNb = passportNb;
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.tel = tel;
    }



    public Client() {
    }

    public String getPassportNumber() {
        return passportNb;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNb = passportNumber;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    
}
