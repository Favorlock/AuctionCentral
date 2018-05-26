package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.annotations.Expose;
import edu.uw.sp18.tcss360a.group6.Bootstrap;
import edu.uw.sp18.tcss360a.group6.ConsoleApplication;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class used to represent an item in an auction.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 4/30/2018
 */
public class Item {

    @Expose
    protected long id;

    @Expose
    private long auctionId;

    @Expose
    private String description;

    @Expose
    private int quantity;

    @Expose
    private BigDecimal startBid;

    @Expose
    private String condition;

    @Expose
    private String approximateSize;

    @Expose
    private String location;

    @Expose
    private String comments;

    private Auction auction;

    private List<Bid> placedBids;

    /**
     * Constructor for Item object.
     * @param auctionId long representing the auction ID
     * @param description String used to represent a brief description for
     *                    Item object.
     * @param quantity    int used to represent how many of Item object are
     *                   sold as one.
     * @param startBid    Bid used to represent the minimum bid accepted for
     *                   Item object.
     * @param condition the condition of the item
     * @param approximateSize the approximate size of the item
     * @param location the location the item is stored
     * @param comments comments on the item
     */
    public Item(
            long auctionId,
            String description,
            int quantity,
            BigDecimal startBid,
            String condition,
            String approximateSize,
            String location,
            String comments) {
        this.auctionId = auctionId;
        this.description = description;
        this.quantity = quantity;
        this.startBid = startBid;
        this.condition = condition;
        this.approximateSize = approximateSize;
        this.location = location;
        this.comments = comments;
    }

    /**
     * Constructor for Item object.
     *
     * @param itemId    int used to represent the ID number for Item object.
     * @param description String used to represent a brief description for
     *                    Item object.
     * @param quantity    int used to represent how many of Item object are
     *                    sold as one.
     * @param startBid    Bid used to represent the minimum bid accepted for
     *                   Item object.
     * @param condition the condition of the item
     * @param approximateSize the approximate size of the item
     * @param location the location the item is stored
     * @param comments comments on the item
     */
    public Item(
            long itemId,
            long auctionId,
            String description,
            int quantity,
            BigDecimal startBid,
            String condition,
            String approximateSize,
            String location,
            String comments) {
        this(auctionId, description, quantity, startBid, condition,
                approximateSize, location, comments);
        this.id = id;
    }

    /**
     * Helper method to check if incoming bid is greater then minimum accepted.
     *
     * @param theBid BigDecimal used to represent incoming bid.
     *
     * @return boolean used to represent whether incoming bid is greater.
     */
    public boolean isBidAmountAcceptable(BigDecimal theBid) {

        return (theBid.compareTo(startBid) >= 0);
    }

    /**
     * Setter method used to set a new bid.
     *
     * @param theBid Bid used to be the new bid price.
     */
    public void setNewBid(Bid theBid) {

        startBid = theBid.getAmount();
    }

    /**
     * Get the ID that represents this Item.
     * @return long the item ID
     */
    public long getId() {
        return id;
    }

    /**
     * Get a long returned that represents the Auction ID for the auction this
     * Item belongs to.
     * @return long representing the auction ID
     */
    public long getAuctionId() {
        return auctionId;
    }

    /**
     * Get a String description of the Item.
     * @return String a description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the quantity of this Item.
     * @return int representing the quantity of this Item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Get the starting bid for this Item.
     * @return BigDecimal representing the starting Bid.
     */
    public BigDecimal getStartBid() {
        return startBid;
    }

    /**
     * Get the Auction that this Item belongs to.
     *
     * @return Auction object that this item belongs to
     */
    public Auction getAuction() {
        if (this.auction == null) {
            this.auction = ConsoleApplication.getInstance().
                    getAuctionRepository().fetchAll().stream()
                    .filter(a -> a.getId() == this.auctionId)
                    .findFirst().orElse(null);
        }

        return this.auction;
    }

    /**
     * Get all of the bids that have been placed on this Item. Returns
     * a list of Bid objects.
     *
     * @return List<Bid> get list of current placed bids on the item
     */
    public List<Bid> getPlacedBids() {
        if (this.placedBids == null) {
            this.placedBids = ConsoleApplication.getInstance().
                    getBidRepository().fetchAll().stream()
                    .filter(bid -> bid.getAuctionId() == this.auctionId
                            && bid.getItemId() == this.id)
                    .collect(Collectors.toList());
        }

        return this.placedBids;
    }

    /**
     * Get the current bid on the Item.
     *
     * @return Bid object representing the current bid
     */
    public Bid getCurrentBid() {
        return ConsoleApplication.getInstance().getBidRepository().fetchAll().stream()
                .filter(b -> b.getItemId() == this.id)
                .sorted(Comparator.comparing(Bid::getAmount))
                .findFirst().orElse(null);
    }

    @Override
    public String toString() {

        return description +
                ", Quantity=" + quantity +
                ", Min Bid=" + startBid +
                ", Item ID='" + id + '\'' +
                ", Auction ID=" + auctionId ;

    }
}

