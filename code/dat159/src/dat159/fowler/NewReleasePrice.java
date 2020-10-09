package dat159.fowler;

public class NewReleasePrice extends Price {

	public NewReleasePrice() {
		super(Movie.NEW_RELEASE);
	}

	public double amount(int daysRented) {
		return (double) (daysRented * 3);
	}

	int renterPoints(int daysRented) {
		int thisRenterPoints;
		if (daysRented > 1) {
			thisRenterPoints = 2;
		} else {
			thisRenterPoints = 1;
		}

		return thisRenterPoints;
	}

}
