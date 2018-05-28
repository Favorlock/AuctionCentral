package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.annotations.Expose;
import edu.uw.sp18.tcss360a.group6.Bootstrap;

import java.math.BigDecimal;

/**
 * Class used to represent a amount for an item in an auction.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 4/30/2018
 */
public class Bid implements Comparable{

    @Expose
    protected long id;

    @Expose
    private long bidderId;

    @Expose
    private long auctionId;

    @Expose
    private long itemId;

    @Expose
    private BigDecimal amount;

    private Bidder bidder; // Lazy loaded, use getBidder()

    private Auction auction; // Lazy loaded, use getAuction()

    private Item item; // Lazy loaded, use getItem()

    public Bid() {
        super();

    }

    public Bid(long bidderId, long auctionId, long itemId, BigDecimal amount) {
        this.bidderId = bidderId;
        this.auctionId = auctionId;
        this.itemId = itemId;
        this.amount = amount;
        this.amount = this.amount.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public Bid(long id, long bidderId, long auctionId, long itemId, BigDecimal amount) {
        this(bidderId, auctionId, itemId, amount);
        this.id = id;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Get the Bidder for this Bid.
     *
     * @return the bidder of this bid.
     */
    public Bidder getBidder() {
        if (this.bidder == null) {
            this.bidder = Bootstrap.getInstance().getUserRepository().fetchAll().stream()
                    .filter(user -> user.getType() == UserType.BIDDER && user.getId() == this.bidderId)
                    .map(user -> (Bidder) user)
                    .findFirst().orElse(null);
        }

        return this.bidder;
    }

    /**
     * Get the auction that this bid resides in.
     *
     * @return the Auction this bid is in.
     */
    public Auction getAuction() {
        if (this.auction == null) {
            this.auction = Bootstrap.getInstance().getAuctionRepository().fetchAll().stream()
                    .filter(a -> a.getId() == auctionId)
                    .findFirst().orElse(null);
        }

        return this.auction;
    }

    /**
     * Get the item that this bid is for.
     *
     * @return the Item this bid is for
     */
    public Item getItem() {
        if (this.item == null) {
            this.item = Bootstrap.getInstance().getItemRepository().fetchAll().stream()
                    .filter(i -> i.getId() == this.itemId)
                    .findFirst().orElse(null);
        }

        return this.item;
    }

    @Override
    public String toString() {
        String itemName = Bootstrap.getInstance().getItemRepository().fetchAll().stream()
                .filter(item -> item.getId() == itemId)
                .findFirst().orElse(null).getDescription();
        this.amount = this.amount.setScale(2, BigDecimal.ROUND_HALF_UP);
        return "Bid ID=" + id +
                ", Item=" + itemName +
                ", Amount=" + amount +
                ", Auction ID=" + auctionId;

    }

    @Override
    public int compareTo(Object o) {
        int returnamt;
        Bid otherBid = (Bid)o;
        if (otherBid.getAuction().getStartDate().isBefore(this.getAuction().getStartDate())) {
            returnamt = 1;
        } else if (otherBid.getAuction().getStartDate().isAfter(this.getAuction().getStartDate())) {
            returnamt = -1;
        } else {
            returnamt = 0;
        }

        return returnamt;
    }
}

