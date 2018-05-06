package edu.uw.sp18.tcss360a.group6;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class used to represent a bidder.
 *
 * @author Adam G. Cannon
 * @version 4/30/2018
 */
public class Bidder {

    /**
     * List<Bid> used to represent the bidHistory a bidder has placed.
     */
    private List<Bid> bidHistory = new ArrayList<Bid>();
    private String userName;
    private String phoneNumber;
    private String email;
    private String address;
    private String cardNumber;

    /**
     * Constructor to create a bidder object.
     *
     * @param userName   String used to represent the username in the bidder object.
     * @param phone      String used to represent the phone number in the bidder object.
     * @param email      String used to represent the email address in the bidder object.
     * @param address    String used to represent the physical address in the bidder object.
     * @param cardNumber String used to represent the credit card number in the bidder object.
     */
    Bidder(String userName, String phone, String email, String address, String cardNumber) {
        //Initialize variables
        this.userName = userName;
        this.phoneNumber = phone;
        this.email = email;
        this.address = address;
        this.cardNumber = cardNumber;
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
            Bid bid = new Bid(auction, this, item, bidAmount);
            this.bidHistory.add(bid);
            item.setNewBid(bid);
            item.addBid(bid);
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
        return auction.isAcceptingBids() && this.bidHistory.stream()
                .filter(bid -> bid.getAuction().equals(auction))
                .count() < 4;
    }

    /**
     * Helper method used to check if the bidder is allowed to bid.
     *
     * @return boolean used to represent whether the bidder can bid or not.
     */
    public boolean canBid() {
        long activeBids = this.bidHistory.stream()
                .filter(bid -> bid.getAuction().isAcceptingBids())
                .count();
        return activeBids < 10;
    }

    /**
     * Getter method used to return the bidder's complete bid history.
     *
     * @return List<Bid> used to represent the bidder's complete bid history.
     */
    public List<Bid> getBidHistory() {

        return this.bidHistory;
    }

    /**
     * Getter method used to return the bidder's auction specific bid history.
     *
     * @param auction Auction used to represent the auction to search for bid history.
     *
     * @return List<Bid> used to represent the bidder's auction specific bid history.
     */
    public List<Bid> getBids(Auction auction) {
        return this.bidHistory.stream()
                .filter(bid -> auction.equals(bid.getAuction()))
                .collect(Collectors.toList());
    }

    /**
     * Helper method used to add a bid to the bidders bid history.
     *
     * @param bid Bid used to represent the bid to be added.
     */
    public void addBid(Bid bid) {

        bidHistory.add(bid);
    }

}

