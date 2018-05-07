package edu.uw.sp18.tcss360a.group6.model;

import edu.uw.sp18.tcss360a.group6.Application;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class used to represent a bidder.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class Bidder extends AbstractUser {

    private List<Bid> placedBids; // Lazy loaded, use getPlacedBids()

    /**
     * Constructor to create a bidder object.
     *
     * @param userName   String used to represent the username in the bidder object.
     */
    public Bidder(long id, String userName) {
        super(UserType.BIDDER, id, userName);
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
     * Getter method used to return the bidder's auction specific bid history.
     *
     * @param auction Auction used to represent the auction to search for bid history.
     *
     * @return List<Bid> used to represent the bidder's auction specific bid history.
     */
    public List<Bid> getPlacedBids(Auction auction) {
        return getPlacedBids().stream()
                .filter(bid -> bid.getAuctionId() == auction.getId())
                .collect(Collectors.toList());
    }

    public List<Bid> getPlacedBids() {
        if (this.placedBids == null) {
            this.placedBids = Application.getInstance().getBidRepository()
                    .fetchAll().stream()
                    .filter(bid -> bid.getBidderId() == getId())
                    .collect(Collectors.toList());
        }

        return this.placedBids;
    }

}
