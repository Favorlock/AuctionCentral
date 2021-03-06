package edu.uw.sp18.tcss360a.group6.model;

import edu.uw.sp18.tcss360a.group6.Bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class used to represent a bidder.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class Bidder extends AbstractUser {

    /**
     * The maximum number of placed bids on items in a given auction.
     */
    private static final int MAX_BIDS_PER_AUCTION = 8;

    /**
     * The maximum number of active placed bids for all auctions.
     */
    private static final int MAX_ACTIVE_BIDS = 12;

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
    public boolean addBid(BigDecimal bidAmount, Item item, Auction auction) {
        boolean placed = false;
        if (canBid() && canBid(auction) && item.isBidAmountAcceptable(bidAmount)) {
            Bid bid = new Bid(this.id, auction.getId(), item.getId(), bidAmount);
            Bootstrap.getInstance().getBidRepository().add(bid);
            getPlacedBids().add(bid);
            placed = true;
        }
        return placed;
    }

    /**
     * Helper method used to check if bidder is allowed to bid in an auction.
     *
     * @param auction Auction used to represent the auction the bidder wants to bid in.
     *
     * @return boolean used to represent whether a bidder is allowed to bid in the given auction.
     */
    public boolean canBid(Auction auction) {

        return auction.isAcceptingBids() && getPlacedBids().stream()
                .filter(bid -> bid.getAuction().getId() == auction.getId())
                .count() < MAX_BIDS_PER_AUCTION;
    }

    /**
     * Helper method used to check if the bidder is allowed to bid.
     *
     * @return boolean used to represent whether the bidder can bid or not.
     */
    public boolean canBid() {
        return getPlacedBids().stream()
                .filter(bid -> bid.getAuction().isAcceptingBids())
                .count() < MAX_ACTIVE_BIDS;
    }

    /**
     * Get the id for this bidder.
     * @return id for this bidder long type
     */
    public long getID() {
        return this.id;
    }

    /**
     * Get a list of all of the Auctions that I can place a bid in.
     * @return a List<Auction> that I can bid in
     */
    public List<Auction> getAuctionsICanBidIn() {
        Bootstrap bootstrap = new Bootstrap();
        List<Auction> auctions = new ArrayList<>();
        for (Auction anAuction : bootstrap.getInstance().getAuctionRepository()
                .fetchFutureAuctions()) {
            if(this.canBid(anAuction)) {
                auctions.add(anAuction);
            }
        }
        return auctions;
    }

    /**
     * The method use to check if a bid available to cancel.
     * @param aBid is a bid bidder wants to cancel
     * @return boolean whether the bid can cancel or not.
     */
    public boolean cancelBid(Bid aBid) {
        boolean didCancelBid = false;
        Bootstrap bootstrap = new Bootstrap();
        List<Bid> bids = bootstrap.getBidRepository().fetchAll();
        for(Bid b : bids) {
            if(b.getId() == aBid.getId()) {
                bootstrap.getBidRepository().delete(aBid);
                didCancelBid = true;
                break;
            }
        }
        return didCancelBid;
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

    /**
     * Get the all bids that this bidder placed in all auctions.
     * @return list of type Bid
     */
    public List<Bid> getPlacedBids() {
        return Bootstrap.getInstance().getBidRepository()
                .fetchAll().stream()
                .filter(bid -> bid.getBidderId() == getId()).sorted()
                .collect(Collectors.toList());
    }

    /**
     * Get the items that this Bidder has placed bids on in a specified
     * auction.
     * @param auction an Auction to get bids on
     * @return a list of items in the auction
     */
    public List<Item> getPlacedBidItems(Auction auction) {
        return getPlacedBidItems().stream()
                .filter(item -> item.getAuctionId() == auction.id)
                .collect(Collectors.toList());
    }

    /**
     * Get the list of Items that his bidder has placed bids on.
     * @return list of Item
     */
    private List<Item> getPlacedBidItems() {
        return getPlacedBids().stream().map(bid -> bid.getItem()).collect(Collectors.toList());
    }

    /**
     * Get the list of Auctions that this bidder has placed bids in.
     * @return list of Auction
     */
    public List<Auction> getPlacedBidAuctions() {
        return getPlacedBids().stream()
                .map(bid -> bid.getAuction())
                .distinct()
                .collect(Collectors.toList());
    }

}

