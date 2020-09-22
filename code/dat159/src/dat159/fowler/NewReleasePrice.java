package dat159.fowler;

public class NewReleasePrice extends Price{

	public NewReleasePrice() {
		super(Movie.NEW_RELEASE);
	}
	
	public double amount(int daysRented) {
		return (double) (daysRented * 3);
	}
	
}
