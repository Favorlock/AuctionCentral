package edu.uw.sp18.tcss360a.group6.model;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Class used to represent an item in an auction.
 *
 * @author Adam G. Cannon
 * @version 4/30/2018
 */
public class Item {

    //Global Variables
    private int idNumber;
    private BigDecimal minBid;
    private String description;
    private ArrayList<Bid> bids;

    /**
     * Constructor for Item object.
     *
     * @param idNumber    int used to represent the ID number for Item object.
     * @param description String used to represent a brief description for Item object.
     * @param startBid    Bid used to represent the minimum bid accepted for Item object.
     * @param quantity    int used to represent how many of Item object are sold as one.
     */
    Item(int idNumber, String description, BigDecimal startBid, int quantity) {

        //Initialize variables
        this.idNumber = idNumber;
        this.description = description;
        minBid = startBid;
    }

    /**
     * Helper method to check if incoming bid is greater then minimum accepted.
     *
     * @param theBid BigDecimal used to represent incoming bid.
     *
     * @return boolean used to represent whether incoming bid is greater.
     */
    public boolean isBidAmountAcceptable(BigDecimal theBid) {

        return (theBid.compareTo(minBid) >= 0);
    }

    /**
     * Setter method used to set a new bid.
     *
     * @param theBid Bid used to be the new bid price.
     */
    public void setNewBid(Bid theBid) {

        minBid = theBid.getBid();
    }

    /**
     * Helper method to add a bid to the item's record of bids.
     *
     * @param theBid
     */
    public void addBid(Bid theBid) {

        bids.add(theBid);
    }
}

