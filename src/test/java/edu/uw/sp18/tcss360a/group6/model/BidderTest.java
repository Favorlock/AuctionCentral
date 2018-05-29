package edu.uw.sp18.tcss360a.group6.model;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
    private List<Auction> auctionCanBidIn = new ArrayList<>();
    private List<Bid> bidPlaced = new ArrayList<>();
    private List<Item> itemBidPlaced = new ArrayList<>();
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
        auctionCanBidIn.add(auction);
        bidPlaced.add(bid);
        minBid = new BigDecimal(110);
        item = new Item(itemId,auctionId, itemDescription, itemQuantity,
                minBid, itemCondition, itemApproximateSize, itemLocation,
                itemComment);
        bid = new Bid(bidderId, auctionId, itemId, amount);
        itemBidPlaced.add(item);
    }

    @Test
    public void addBid_testCanPlaceABid_True(){
        assertTrue(bidder.addBid(amount,item,auction));
    }

    @Test
    public void addBid_testCannotPlaceABid_False(){
        assertFalse(bidder.addBid(amount,item,auction));
    }

    @Test
    public void canBidInAuction_belowMaximumBids_True() {
        for (int i = 0; i < 7; i++) {
            bidder.addBid(amount, item, auction);
        }
        assertTrue(bidder.canBid(auction));
    }

    @Test
    public void canBidInAuction_aboveMaximumBids_False() {
        for (int i = 0; i < 8; i++) {
            bidder.addBid(amount, item, auction);
        }
        assertFalse(bidder.canBid(auction));
    }

    @Test
    public void canBid_belowMaximumBids_True() {
        for (int i = 0; i < 12; i++) {
            bidder.addBid(amount, item, auction);
        }
        assertTrue(bidder.canBid());
    }

    @Test
    public void canBid_aboveMaximumBids_False() {
        for (int i = 0; i < 13; i++) {
            bidder.addBid(amount, item, auction);
        }
        assertFalse(bidder.canBid());
    }

    @Test
    public void getAuctionsICanBidIn_getRightAuctionICanBidIn_True(){
        assertEquals(auctionCanBidIn, bidder.getAuctionsICanBidIn());
    }

    @Test
    public void getAuctionsICanBidIn_getWrongAuctionICannotBidIn_False(){
        assertNotEquals(auctionCanBidIn, bidder.getAuctionsICanBidIn());
    }

    @Test
    public void cancelBid_testCanCancelABid_True() {
        assertTrue(bidder.cancelBid(bid));
    }

    @Test
    public void cancelBid_testCannotCancelABid_False() {
        assertFalse(bidder.cancelBid(bid));
    }

    @Test
    public void getPlacedBids_getAllRightBidsPlaced_True(){
        assertEquals(bidPlaced, bidder.getPlacedBids());
    }

    @Test
    public void getPlacedBids_getWrongBidsPlaced_False(){
        assertNotEquals(bidPlaced, bidder.getPlacedBids());
    }

}
