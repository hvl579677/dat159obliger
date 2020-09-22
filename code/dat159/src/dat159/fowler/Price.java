package dat159.fowler;

public abstract class Price {

	private int _priceCode;

	public Price(int priceCode) {
		_priceCode = priceCode;
	}

	public int priceCode() {
		return _priceCode;
	}

	abstract double amount(int daysRented);

	int renterPoints(int daysRented) {
		return 1;
	}

}
