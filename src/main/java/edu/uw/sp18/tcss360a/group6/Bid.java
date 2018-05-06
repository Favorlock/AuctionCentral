package edu.uw.sp18.tcss360a.group6;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

/**
 * Class used to represent a bid for an item in an auction.
 *
 * @author Adam G. Cannon
 * @version 4/30/2018
 */
public class Bid {

    @Expose
    private long id;

    @Expose
    private long bidderId;

    @Expose
    private long auctionId;

    @Expose
    private long itemId;

    @Expose
    private BigDecimal bid;

    Bid(long id, long bidderId, long auctionId, long itemId, BigDecimal bid) {
        this.id = id;
        this.bidderId = bidderId;
        this.auctionId = auctionId;
        this.itemId = itemId;
        this.bid = bid;
    }

    public String toString() {
        String outputString = "Bidder ID: " + bidderId + "\n"
                + "Item ID: " + itemId + "\n"
                + "Bid: " + bid.doubleValue() + "\n";
        return outputString;
    }

    public long getId() {
        return this.id;
    }

    public long getBidderId() {
        return this.bidderId;
    }

    public long getAuctionId() {
        return this.auctionId;
    }

    public long getItemId() {
        return this.itemId;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

}

