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

		String name = getName();

		// After extract method:
		String result = header(name);

		for (Rental each : myRentals) {
			double thisAmount = amountFor(each);
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
		}
		
		double totalAmount = totalAmount(this.myRentals);
		
		int frequentRenterPoints = frequentRenterPoints(this.myRentals);

		result += footer(totalAmount, frequentRenterPoints);

		return result;
	}

	private double totalAmount(Iterable<Rental> myRentals1) {
		double totalAmount = 0;
		for (Rental each : myRentals1) {
			double thisAmount = amountFor(each);
			totalAmount += thisAmount;
		}
		return totalAmount;
	}

	private double amountFor(Rental rental) {
		double thisAmount = 0;

		// determine amount for each line
		switch (rental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (rental.getDaysRented() > 2)
				thisAmount += (rental.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += rental.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (rental.getDaysRented() > 3)
				thisAmount += (rental.getDaysRented() - 3) * 1.5;
			break;
		}
		return thisAmount;
	}

	private int frequentRenterPoints(List<Rental> myRentals1) {
		int frequentRenterPoints = 0;
		for (Rental each : myRentals1) {
			frequentRenterPoints++;

			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints++;
		}
		return frequentRenterPoints;
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
