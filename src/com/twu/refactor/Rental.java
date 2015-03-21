package com.twu.refactor;

public class Rental {

    private Movie movie;
    private final int MIN_VALIDITY = 1;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return  "\t" + this.getMovie().getTitle() + "\t" + String.valueOf(this.getAmount()) + "\n";
    }

    public boolean isUnderBonusScheme() {
        return (this.getMovie().getPriceCode() == Movie.NEW_RELEASE) && this.getDaysRented() > MIN_VALIDITY;
    }

    double getAmount() {
        double thisAmount = 0d;
        switch (getMovie().getPriceCode()) {
        case Movie.REGULAR:
            thisAmount += 2;
            if (getDaysRented() > 2)
                thisAmount += (getDaysRented() - 2) * 1.5;
            break;
        case Movie.NEW_RELEASE:
            thisAmount += getDaysRented() * 3;
            break;
        case Movie.CHILDRENS:
            thisAmount += 1.5;
            if (getDaysRented() > 3)
                thisAmount += (getDaysRented() - 3) * 1.5;
            break;

        }
        return thisAmount;
    }
}