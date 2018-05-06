package edu.uw.sp18.tcss360a.group6;

import java.math.BigDecimal;

/**
 * Class used to represent a bid for an item in an auction.
 *
 * @author Adam G. Cannon
 * @version 4/30/2018
 */
public class Bid {

    private Auction auction;
    private BigDecimal bid;
    private Bidder bidder;
    private Item item;

    Bid(Auction theAuction, Bidder theBidder, Item theItem, BigDecimal theBid) {

        auction = theAuction;
        bid = theBid;
        bidder = theBidder;
        item = theItem;
    }

    public BigDecimal getBid() {

        return bid;
    }

    public void setStart(BigDecimal theBid) {

        bid = theBid;
    }

    public String toString() {

        String outputString = "Bidder: " + bidder + "\n" + "Item: " + item + "\n" + "Bid: " + bid.doubleValue() + "\n";
        return outputString;
    }

    public Auction getAuction() {

        return auction;
    }

}

