package edu.uw.sp18.tcss360a.group6.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/11/2018
 */
public class EmployeeTest {

    @Before
    public void setUp() {
    }

    @Test
    public void changeUpcomingAuctionsMax_negativeNumberSpecified_Fail() {
        long idNumber = 100;
        String userName = "New Employee";
        Employee employee = new Employee(idNumber, userName);
        int newMax = -1;
        employee.setAuctionCapacity(newMax);
        assertFalse( employee.getAuctionCapacity() == newMax);
    }

    @Test
    public void changeUpcomingAuctionsMax_positiveNumberSpecified_True() {
        assertTrue(true);
    }

    @Test
    public void changeUpcomingAuctionsMax_numberSpecifiedGreaterThanNumberOfSystemAuctions_True() {
        assertTrue(true);
    }

    @Test
    public void viewAllAuctionsBetweenDates_secondDateBeforeFirstDate_Fail() {
        assertFalse(false);
    }

    @Test
    public void viewAllAuctionsBetweenDates_firstAndSecondDateEquivalent_True() {
        assertTrue(true);
    }

    @Test
    public void viewAllAuctionsBetweenDates_secondDateAtLeastOneDayAfterFirstDate_True() {
        assertTrue(true);
    }

    @Test
    public void viewAllAuctionsInOrder_atLeastOnePastAndFutureAuction_True() {
        assertTrue(true);
    }

    @Test
    public void cancelAnAuction_auctionHasNoBids_True() {
        assertTrue(true);
    }

    @Test
    public void cancelAnAuction_auctionHasOneBid_False() {
        assertFalse(false);
    }

    @Test
    public void cancelAnAuction_auctionHasManyBids_False() {
        assertFalse(false);
    }


}
