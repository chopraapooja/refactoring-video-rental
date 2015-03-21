package com.twu.refactor;

import java.util.ArrayList;

public class Customer implements CustomerSummary{

    private final int MIN_VALIDITY = 1;
    private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();
    private final int BONUS = 2;
    private final int REGULAR_POINTS = 1;

    public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

    public ArrayList<Rental> getRentalList() {
        return (ArrayList<Rental>) rentalList.clone();
    }

    public String getName() {
		return name;
	}

	public String generateStatement() {
        CustomerStatement stmt = new CustomerStatement(this);
        return stmt.asText();
    }

    private String getHeader() {
        return "Rental Record for " + getName() + "\n";
    }

    private double calculateTotalAmt(ArrayList<Rental> rentalList) {
        double totalAmt = 0d;
        for(Rental each : rentalList) { totalAmt += each.getAmount(); }
        return totalAmt;
    }

    private int calculateFRPoints(ArrayList<Rental> rentalList) {
        int frequentRenterPoints = 0;
        for(Rental each : rentalList) { frequentRenterPoints += (isUnderBonusScheme(each)) ? BONUS : REGULAR_POINTS;}
        return frequentRenterPoints;
    }

    private boolean isUnderBonusScheme(Rental each) {
        return (each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > MIN_VALIDITY;
    }

    private String getFooter(double totalAmount, int frequentRenterPoints) {
        String result = "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }
}
