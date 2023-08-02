/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components.Class;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
public class seatComparator implements Comparator<Seat> {

    private Map<Character, Integer> ticketPricesByFirstLetter = new HashMap<>();

    public seatComparator(Map<Character, Integer> ticketPricesByFirstLetter) {
        this.ticketPricesByFirstLetter = ticketPricesByFirstLetter;
    }

    @Override
    public int compare(Seat s1, Seat s2) {
        ticketPricesByFirstLetter.put('P', 1500);
        ticketPricesByFirstLetter.put('B', 3000);
        ticketPricesByFirstLetter.put('F', 5000);
        ticketPricesByFirstLetter.put('S', 10000);
        ticketPricesByFirstLetter.put('E', 800);
        // Implement the comparison logic here
        // Compare obj1 and obj2 based on the desired criteria

        // For example, if YourClass has an integer field called 'fieldToCompare':
        return Integer.compare(ticketPricesByFirstLetter.get(s1.getSeatClass()), ticketPricesByFirstLetter.get(s2.getSeatClass()));

        // If YourClass has a String field called 'fieldToCompare':
        // return obj1.getFieldToCompare().compareTo(obj2.getFieldToCompare());
        // You can compare other fields or use more complex comparison logic as needed.
        // Remember to return -1, 0, or 1 based on whether obj1 is less than, equal to, or greater than obj2.
    }
}
