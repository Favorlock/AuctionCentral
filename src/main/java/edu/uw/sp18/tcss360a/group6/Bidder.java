package edu.uw.sp18.tcss360a.group6;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used to represent a bidder.
 *
 * @author Adam G. Cannon
 * @version 4/30/2018
 */
public class Bidder {

    @Expose
    private long id;

    @Expose
    private String userName;

    @Expose
    private List<Long> placedBids = new ArrayList<>();

    public Bidder() {
        super();
    }

    /**
     * Constructor to create a bidder object.
     *
     * @param userName   String used to represent the username in the bidder object.
     */
    public Bidder(long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    /**
     * Method used to place a bid
     *
     * @param bidAmount Bid used to represent a bid from a bidder.
     * @param item      Item used to represent an item in an auction.
     * @param auction   Aution used to represent an auction.
     */
    public void placeBid(BigDecimal bidAmount, Item item, Auction auction) {
        //Perform checks
        if (canBid() && canBidInAuction(auction) && item.isBidAmountAcceptable(bidAmount)) {
            // TODO:
//            Bid bid = new Bid(auction, this, item, bidAmount);
//            this.placedBids.add(bid);
//            item.setNewBid(bid);
//            item.addBid(bid);
        }
    }

    /**
     * Helper method used to check if bidder is allowed to bid in an auction.
     *
     * @param auction Auction used to represent the auction the bidder wants to bid in.
     *
     * @return boolean used to represent whether a bidder is allowed to bid in the given auction.
     */
    public boolean canBidInAuction(Auction auction) {
        // TODO
//        return auction.isAcceptingBids() && this.placedBids.stream()
//                .filter(bid -> bid.getAuction().equals(auction))
//                .count() < 4;
        return false;
    }

    /**
     * Helper method used to check if the bidder is allowed to bid.
     *
     * @return boolean used to represent whether the bidder can bid or not.
     */
    public boolean canBid() {
        // TODO
//        long activeBids = this.placedBids.stream()
//                .filter(bid -> bid.getAuction().isAcceptingBids())
//                .count();
//        return activeBids < 10;
        return false;
    }

    /**
     * Getter method used to return the bidder's complete bid history.
     *
     * @return List<Bid> used to represent the bidder's complete bid history.
     */
    public List<Long> getPlacedBids() {
        return this.placedBids;
    }

    /**
     * Getter method used to return the bidder's auction specific bid history.
     *
     * @param auction Auction used to represent the auction to search for bid history.
     *
     * @return List<Bid> used to represent the bidder's auction specific bid history.
     */
    public List<Bid> getBids(Auction auction) {
        // TODO
//        return this.placedBids.stream()
//                .filter(bid -> auction.equals(bid.getAuction()))
//                .collect(Collectors.toList());
        return null;
    }

    /**
     * Helper method used to add a bid to the bidders bid history.
     *
     * @param bid Bid used to represent the bid to be added.
     */
    public void addBid(Bid bid) {
        placedBids.add(bid.getId());
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

}

