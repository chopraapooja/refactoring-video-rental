package com.twu.refactor;


import java.util.ArrayList;

/**
 * Created by poojar on 3/20/2015.
 */
public class CustomerStatement {
    CustomerSummary cSummary;
    private final int BONUS = 2;
    private final int REGULAR_POINTS = 1;

    CustomerStatement(CustomerSummary cSummary) {
        this.cSummary = cSummary;
    }

    public String asText() {
        String result = getHeader();
        ArrayList<Rental> rentalList = cSummary.getRentalList();
        for (Rental each : rentalList) {
            result += each.toString();
        }
        result += getFooter(calculateTotalAmt(rentalList), calculateFRPoints(rentalList));
        return result;
    }

    private String getFooter(double totalAmount, int frequentRenterPoints) {
        String result = "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }

    private String getHeader() {
        return "Rental Record for " + cSummary.getName() + "\n";
    }

    private double calculateTotalAmt(ArrayList<Rental> rentalList) {
        double totalAmt = 0d;
        for(Rental each : rentalList) { totalAmt += each.getAmount(); }
        return totalAmt;
    }

    private int calculateFRPoints(ArrayList<Rental> rentalList) {
        int frequentRenterPoints = 0;
        for(Rental each : rentalList) { frequentRenterPoints += (each.isUnderBonusScheme()) ? BONUS : REGULAR_POINTS;}
        return frequentRenterPoints;
    }
}
