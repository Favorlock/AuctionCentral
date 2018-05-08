package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.annotations.Expose;
import edu.uw.sp18.tcss360a.group6.Application;

import java.math.BigDecimal;

/**
 * Class used to represent a amount for an item in an auction.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 4/30/2018
 */
public class Bid {

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

    public Item getItem() {
        if (this.item == null) {
            this.item = Application.getInstance().getItemRepository().fetchAll().stream()
                    .filter(i -> i.getId() == this.itemId)
                    .findFirst().orElse(null);
        }

        return this.item;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", bidderId=" + bidderId +
                ", auctionId=" + auctionId +
                ", itemId=" + itemId +
                ", amount=" + amount +
                "}\n";
    }
}

