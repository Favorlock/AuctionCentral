package edu.uw.sp18.tcss360a.group6;


import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * JUnit test class for auction.
 *
 * @author Adam G. Cannon
 * @version 5/1/2018
 */
public class AuctionTest {

    //Global Variables
    private static int MAX_NUMBER_OF_AUCTIONS = 10;
    private LocalDate auctionNotPassed;
    private LocalDate auctionDay;
    private LocalDate auctionPassed;
    private Auction auction;
    private Auction smallAuction;
    private Auction oneLessThanMaxItemsAuction;
    private Auction maxNumberOfItemsAuction;
    private Item cat;
    private BigDecimal catPrice;


    @Before
    public void setUp() {
        //Initialize variables
        auctionPassed = LocalDate.now().minusMonths(1);
        auctionDay = LocalDate.now();
        auctionNotPassed = LocalDate.now().plusMonths(1);
        catPrice = new BigDecimal(10);
        cat = new Item(01, "Cat", catPrice, 1);
        smallAuction = new Auction(auctionDay);

        oneLessThanMaxItemsAuction = new Auction(auctionDay);
        int numberOfAuctions = 1;
        while (numberOfAuctions < MAX_NUMBER_OF_AUCTIONS) {
            oneLessThanMaxItemsAuction.addAuctionItem(cat);
            numberOfAuctions++;
        }

        maxNumberOfItemsAuction = new Auction(auctionDay);
        numberOfAuctions = 0;
        while (numberOfAuctions < MAX_NUMBER_OF_AUCTIONS) {
            maxNumberOfItemsAuction.addAuctionItem(cat);
            numberOfAuctions++;
        }
    }

    @Test
    public void isAcceptingBids_bidBeforeAuctionDate_True() {
        auction = new Auction(auctionNotPassed);
        assertTrue(auction.isAcceptingBids());
    }

    @Test
    public void isAcceptingBids_bidOnAuctionDate_False() {
        auction = new Auction(auctionDay);
        assertFalse(auction.isAcceptingBids());
    }

    @Test
    public void isAcceptingBids_bidAfterAuctionDate_False() {
        auction = new Auction(auctionPassed);
        assertFalse(auction.isAcceptingBids());
    }

    @Test
    public void addAuctionItem_manyFewerItemsThanMaxAllowed_True() {
        smallAuction.addAuctionItem(cat);
        assertTrue(smallAuction.getItemsInAuctionCount() == 1);
    }

    @Test
    public void addAuctionItem_oneFewerItemThanMaxAllowed_True() {
        oneLessThanMaxItemsAuction.addAuctionItem(cat);
        assertTrue(oneLessThanMaxItemsAuction.getItemsInAuctionCount() == MAX_NUMBER_OF_AUCTIONS);
    }

    @Test
    public void addAuctionItem_exactNumberOfMaxItemsAllowed_False() {
        maxNumberOfItemsAuction.addAuctionItem(cat);
        assertFalse(maxNumberOfItemsAuction.getItemsInAuctionCount() == (MAX_NUMBER_OF_AUCTIONS + 1));
    }


}

