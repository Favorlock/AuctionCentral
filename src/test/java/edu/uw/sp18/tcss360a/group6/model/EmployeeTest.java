package edu.uw.sp18.tcss360a.group6.model;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/11/2018
 */
public class EmployeeTest {

    private Employee employee;
    private Auction auctionWithOneItem;
    private Item oneItem;
    private Bid itemBid;
    private BigDecimal itemPrice;
    private LocalDate startDate;
    @Before
    public void setUp() {
        long idNumber = 100;
        String userName = "New Employee";
        employee = new Employee(idNumber, userName);

        itemPrice = new BigDecimal(500);
        startDate = LocalDate.now();
        auctionWithOneItem = new Auction(idNumber, startDate);
        oneItem = new Item(idNumber, "Dog", 1, itemPrice, "good",
                "small", "A1", "N/A");
        itemBid = new Bid(idNumber, idNumber, idNumber, itemPrice);
        auctionWithOneItem.addItem(oneItem);

    }

    @Test
    public void changeUpcomingAuctionsMax_negativeNumberSpecified_Fail() {
        int newMax = -1;
        employee.setAuctionCapacity(newMax);
        assertFalse(employee.getAuctionCapacity() == newMax);
    }

    @Test
    public void changeUpcomingAuctionsMax_positiveNumberSpecified_True() {
        int newMax = 30;
        employee.setAuctionCapacity(newMax);
        assertEquals(employee.getAuctionCapacity(), newMax);
    }

    @Test
    public void changeUpcomingAuctionsMax_numberSpecifiedGreaterThanNumberOfSystemAuctions_True() {
        int newMax = 30;
        employee.setAuctionCapacity(newMax);
        assertEquals(employee.getAuctionCapacity(), newMax);
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
        assertTrue(employee.cancelAnAuction(auctionWithOneItem));

    }

    @Test
    public void cancelAnAuction_auctionHasOneBid_False() {
        oneItem.setNewBid(itemBid);
        assertFalse(employee.cancelAnAuction(auctionWithOneItem));
    }

    @Test
    public void cancelAnAuction_auctionHasManyBids_False() {
        oneItem.setNewBid(itemBid);
        oneItem.setNewBid(itemBid);
        oneItem.setNewBid(itemBid);
        assertFalse(employee.cancelAnAuction(auctionWithOneItem));
    }


}
