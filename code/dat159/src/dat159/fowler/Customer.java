package dat159.fowler;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        
        String name = getName();
        // Before extract method:
        // String result = "Rental Record for " + name + "\n";
        
        //After extract method:
        String result = header(name);
        
        
        while (rentals.hasMoreElements()) {

        	Rental each = (Rental) rentals.nextElement();

            double thisAmount = 0;
            
            // determine amount for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }
            
            
            
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() > 1) frequentRenterPoints ++;

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" +
                    String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        
        // Before extract variable:
        //result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        //result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        
        // After extract variable
        String footer1 = "Amount owed is " + String.valueOf(totalAmount) + "\n";
		String footer2 = "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		result += footer1;
		result += footer2;
        
        return result;
    }

    // Added after performing extract method
	private String header(String name) {
		return "Rental Record for " + name + "\n";
	}

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }
}
