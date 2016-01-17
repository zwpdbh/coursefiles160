import java.text.*;
import java.util.*;

/** application class for Customer.java
 * Lab 9 COMP160
 */

public class CruiseApp{
    
    public static void main(String[]args){
        //each Customer created with name, age, showed student ID card
        Customer[] customerList = {
            new Customer("Aaron Stott",17, true),
            new Customer("Betty Adams",17, false),
            new Customer("Corin Child",16, true),
            new Customer("Doris Stewart",25, true),
            new Customer("Edmond Cheyne",12, false),
            new Customer("Fiona Chaney",7, false),
            new Customer("Ged Still-Child",16, true),
            new Customer("Harry Adamson",20, false)
        };
        
//        Customer customer1 = new Customer("Aaron Stott",17, true);
//        Customer customer2 = new Customer("Betty Adams",17, false);
//        Customer customer3 = new Customer("Corin Child",16, true);
//        Customer customer4 = new Customer("Doris Stewart",25, true);
//        Customer customer5 = new Customer("Edmond Cheyne",12, false);
//        Customer customer6 = new Customer("Fiona Chaney",7, false);
//        Customer customer7 = new Customer("Ged Still-Child",16, true);
//        Customer customer8 = new Customer("Harry Adamson",20, false);
        
//        confirmBooking(customer1); 
//        confirmBooking(customer2); //and so on
              
            for (Customer customer: customerList) {
                confirmBooking(customer);
            }
            
            System.out.println("\n\nThe booked customers are:");
            for (Customer customer: customerList) {
                showBooked(customer);
            }
    }
    
    public static void confirmBooking(Customer customer) {
        final Double TICKET_PRICE = 56.0;
        final Double MEAL_PRICE = 30.0;
        double ticket, meal;
       
        if (customer.isChild() || customer.isStudent()) {
            ticket = TICKET_PRICE * 0.5;
        } else {
            ticket = TICKET_PRICE * 0.8;
        }
        
        if (customer.isChild()) {
            meal = MEAL_PRICE * 0.5;
        } else {
            meal = MEAL_PRICE * 0.9;
        }
        
        // Currency format 
        NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
        
        //System.out.println(customer.getName() + "\tTicket price:" + fmt.format(ticket) + "\tMeal price:" + fmt.format(meal) + "\tTotal price:" + fmt.format(meal + ticket));
        // Show customer's info and confirm booking
        System.out.println(customer.getName());
        System.out.println("Ticket price:\t" + fmt.format(ticket));
        System.out.println("Meal price:\t" + fmt.format(meal));
        System.out.println("Total price:\t" + fmt.format(meal + ticket));
        
        System.out.println("Confirm booking for " + customer.getName() + "(Y/N)");
        Scanner input = new Scanner(System.in);
        String booking = input.nextLine();
        if (booking.equalsIgnoreCase("Y")) {
            customer.setBooked();
            System.out.println("Booked\n");
        } else {
            System.out.println("Canceled\n");
        }
    }
    
    public static void showBooked(Customer customer) {
        if (customer.isBooked()) {
            System.out.println(customer.getName() + " is booked");
        } 
    }
}