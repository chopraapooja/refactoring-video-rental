package com.twu.refactor;

import java.util.ArrayList;

/**
 * Created by poojar on 3/20/2015.
 */
public interface CustomerSummary {
    ArrayList<Rental> getRentalList();
    String getName();
}
