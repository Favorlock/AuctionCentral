package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.annotations.Expose;
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
     *
     * @param description String used to represent a brief description for Item object.
     * @param quantity    int used to represent how many of Item object are sold as one.
     * @param startBid    Bid used to represent the minimum bid accepted for Item object.
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
     * @param id    int used to represent the ID number for Item object.
     * @param description String used to represent a brief description for Item object.
     * @param quantity    int used to represent how many of Item object are sold as one.
     * @param startBid    Bid used to represent the minimum bid accepted for Item object.
     * @param condition the condition of the item
     * @param approximateSize the approximate size of the item
     * @param location the location the item is stored
     * @param comments comments on the item
     */
    public Item(
            long id,
            long auctionId,
            String description,
            int quantity,
            BigDecimal startBid,
            String condition,
            String approximateSize,
            String location,
            String comments) {
        this(auctionId, description, quantity, startBid, condition, approximateSize, location, comments);
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

    public long getId() {
        return id;
    }

    public long getAuctionId() {
        return auctionId;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getStartBid() {
        return startBid;
    }

    public Auction getAuction() {
        if (this.auction == null) {
            this.auction = ConsoleApplication.getInstance().getAuctionRepository().fetchAll().stream()
                    .filter(a -> a.getId() == this.auctionId)
                    .findFirst().orElse(null);
        }

        return this.auction;
    }

    public List<Bid> getPlacedBids() {
        if (this.placedBids == null) {
            this.placedBids = ConsoleApplication.getInstance().getBidRepository().fetchAll().stream()
                    .filter(bid -> bid.getAuctionId() == this.auctionId
                            && bid.getItemId() == this.id)
                    .collect(Collectors.toList());
        }

        return this.placedBids;
    }

    public Bid getCurrentBid() {
        return ConsoleApplication.getInstance().getBidRepository().fetchAll().stream()
                .filter(b -> b.getItemId() == this.id)
                .sorted(Comparator.comparing(Bid::getAmount))
                .findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", auctionId=" + auctionId +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", startBid=" + startBid +
                '}';
    }
}

