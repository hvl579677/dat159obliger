package dat159.fowler;

public class Rental {
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	public double amount() {
		return getMovie().amount(getDaysRented());
	}

	int renterPoints(int daysRented) {
		return getMovie().renterPoints(daysRented);
	}
}
