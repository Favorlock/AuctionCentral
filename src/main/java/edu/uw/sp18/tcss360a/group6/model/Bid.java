package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.annotations.Expose;
import edu.uw.sp18.tcss360a.group6.Application;

import java.math.BigDecimal;

/**
 * Class used to represent a bid for an item in an auction.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
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

    private Bidder bidder; // Lazy loaded, use getBidder()

    private Auction auction; // Lazy loaded, use getAuction()

    public Bid() {
        super();
    }

    public Bid(long id, long bidderId, long auctionId, long itemId, BigDecimal bid) {
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

    public Bidder getBidder() {
        if (this.bidder == null) {
            this.bidder = Application.getInstance().getUserRepository().fetchAll().stream()
                    .filter(user -> user.getType() == UserType.BIDDER && user.getId() == this.bidderId)
                    .map(user -> (Bidder) user)
                    .findFirst().orElse(null);
        }

        return this.bidder;
    }

    public Auction getAuction() {
        if (this.auction == null) {
            this.auction = Application.getInstance().getAuctionRepository().fetchAll().stream()
                    .filter(a -> a.getId() == auctionId)
                    .findFirst().orElse(null);
        }

        return this.auction;
    }
}
