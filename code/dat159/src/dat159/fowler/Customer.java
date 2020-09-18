package dat159.fowler;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String _name;
	private List<Rental> myRentals = new ArrayList<Rental>();

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental rental) {
		myRentals.add(rental);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;

		String name = getName();

		// After extract method:
		String result = header(name);

		for (Rental each : myRentals) {

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
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints++;

			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}

		frequentRenterPoints = 0;
		for (Rental each : myRentals) {
			// add frequent renter points
			frequentRenterPoints++;
			 
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints++;

		}

		result += footer(totalAmount, frequentRenterPoints);

		return result;
	}

	// Added after performing extract method
	private String header(String name) {
		return "Rental Record for " + name + "\n";
	}

	private String footer(double totalAmount, int frequentRenterPoints) {
		String footer1 = "Amount owed is " + String.valueOf(totalAmount) + "\n";
		String footer2 = "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return footer1 + footer2;
	}

}
