/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components.Class;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author user
 */
public class Seat {

    private int flightNo;
    private String seatNo;
    private char seatClass;
    private String options;
    private Date departureDate;
    private Date arrivalDate;
    private String departurePlace;
    private String landingPlace;
    private Time departureTime;
    private Time arrivalTime;

    public Seat(int flightNo, String seatNo, char seatClass, String options, Date departureDate, Date arrivalDate, String departurePlace, String landingPlace, Time departureTime, Time arrivalTime) {
        this.flightNo = flightNo;
        this.seatNo = seatNo;
        this.seatClass = seatClass;
        this.options = options;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departurePlace = departurePlace;
        this.landingPlace = landingPlace;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Seat()
    {
        
    }

    public int getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public char getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(char seatClass) {
        this.seatClass = seatClass;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public String getLandingPlace() {
        return landingPlace;
    }

    public void setLandingPlace(String landingPlace) {
        this.landingPlace = landingPlace;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    
}
