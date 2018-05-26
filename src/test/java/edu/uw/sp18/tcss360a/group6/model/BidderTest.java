package edu.uw.sp18.tcss360a.group6.model;

import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.Bid;
import edu.uw.sp18.tcss360a.group6.model.Bidder;
import edu.uw.sp18.tcss360a.group6.model.Item;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class BidderTest {

    private String userName;
    private Bidder bidder;
    private long bidderId;
    private Auction auction;
    private long auctionId;
    private LocalDate auctionDate;
    private Bid bid;
    private Item item;
    private String itemDescription;
    private long itemId;
    private int itemQuantity;
    private String itemCondition;
    private String itemApproximateSize;
    private String itemLocation;
    private String itemComment;
    private BigDecimal minBid;
    private BigDecimal amount;
    @Before
    public void setUp() {
        this.userName ="Adam";
        this.bidderId = 1234;
        this.auctionId = 12345;
        this.itemId = 40;
        this.itemDescription ="RoseVase";
        this.itemQuantity = 1;
        this.itemCondition ="Good";
        this.itemApproximateSize = "10x5";
        this.itemLocation ="Italy";
        this.itemComment ="n/a";
        amount = new BigDecimal(1);
        auctionDate = LocalDate.now().plusMonths(2);
        bidder = new Bidder(bidderId,userName);
        auction = new Auction();
        minBid = new BigDecimal(110);
        item = new Item(itemId,auctionId, itemDescription, itemQuantity,
                minBid, itemCondition, itemApproximateSize, itemLocation,
                itemComment);
        bid = new Bid(bidderId, auctionId, itemId, amount);
    }

    @Test
    public void canBidInAuction_belowMaximumBids_True() {
        for (int i = 0; i < 3; i++) {
            bidder.addBid(amount, item, auction);
        }
        assertTrue(bidder.canBid(auction));
    }

    @Test
    public void canBidInAuction_aboveMaximumBids_False() {
        for (int i = 0; i < 4; i++) {
            bidder.addBid(amount, item, auction);
        }
        assertFalse(bidder.canBid(auction));
    }

    @Test
    public void canBid_belowMaximumBids_True() {
        for (int i = 0; i < 10; i++) {
            bidder.addBid(amount, item, auction);
        }
        assertTrue(bidder.canBid());
    }

    @Test
    public void canBid_aboveMaximumBids_False() {
        for (int i = 0; i < 11; i++) {
            bidder.addBid(amount, item, auction);
        }
        assertFalse(bidder.canBid());
    }
}
