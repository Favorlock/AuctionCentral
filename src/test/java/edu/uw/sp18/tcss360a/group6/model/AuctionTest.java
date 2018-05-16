package edu.uw.sp18.tcss360a.group6.model;


import edu.uw.sp18.tcss360a.group6.ConsoleApplication;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * JUnit test class for auction.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class AuctionTest {

    private long auctionId;

    private long organizationId;

    private LocalDate futureDate;

    private LocalDate currentDate;

    private LocalDate pastDate;

    private String itemDescription;

    private int itemQuantity;

    private BigDecimal itemStartBid;

    private String condition;

    private String approximateSize;

    private String location;

    private String comments;

    @Before
    public void setUp() {
        new ConsoleApplication(false);
        this.auctionId = 0;
        this.organizationId = 0;
        this.pastDate = LocalDate.now().minusMonths(1);
        this.currentDate = LocalDate.now();
        this.futureDate = LocalDate.now().plusMonths(1);
        this.itemDescription = "Item";
        this.itemQuantity = 1;
        this.itemStartBid = BigDecimal.valueOf(1);
        this.condition = "";
        this.approximateSize = "";
        this.location = "";
        this.comments = "";
    }

    @Test
    public void isAtCapacity_addItemInCapacity_True(){
        Auction auction = new Auction(this.auctionId, this.organizationId, this.currentDate);
        assertTrue(auction.isAtCapacity());
    }

    @Test
    public void isAtCapacity_addItemOverCapacity_False() {
        Auction auction = new Auction(this.auctionId, this.organizationId, this.currentDate);
        assertFalse(auction.isAtCapacity());
    }

    @Test
    public void isAcceptingBids_bidBeforeAuctionDate_True() {
        Auction auction = new Auction(this.auctionId, this.organizationId, this.futureDate);
        assertTrue(auction.isAcceptingBids());
    }

    @Test
    public void isAcceptingBids_bidOnAuctionDate_False() {
        Auction auction = new Auction(this.auctionId, this.organizationId, this.currentDate);
        assertFalse(auction.isAcceptingBids());
    }

    @Test
    public void isAcceptingBids_bidAfterAuctionDate_False() {
        Auction auction = new Auction(this.auctionId, this.organizationId, this.pastDate);
        assertFalse(auction.isAcceptingBids());
    }

    @Test
    public void getInventorySize_AuctionInventoryEmpty_True() {
        Auction auction = new Auction(this.auctionId, this.organizationId, this.currentDate);
        assertTrue(auction.getInventorySize() == 0);
    }
/*
    @Test
    public void getInventorySize_AuctionFull_True() {
        Auction auction = new Auction(this.auctionId, this.organizationId, this.currentDate);
        addItemsToAuction(auction, Auction.INVENTORY_CAPACITY);
        assertTrue(auction.getInventorySize() == Auction.INVENTORY_CAPACITY);
    }

    @Test
    public void addItem_InventoryCapacity_True() {
        Auction auction = new Auction(this.auctionId, this.organizationId, this.currentDate);
        addItemsToAuction(auction, Auction.INVENTORY_CAPACITY - 1);
        assertTrue(addItemToAuction(auction, Auction.INVENTORY_CAPACITY - 1));
    }

    @Test
    public void addItem_InventoryCapacityPlusOne_False() {
        Auction auction = new Auction(this.auctionId, this.organizationId, this.currentDate);
        addItemsToAuction(auction, Auction.INVENTORY_CAPACITY );
        assertFalse(addItemToAuction(auction, Auction.INVENTORY_CAPACITY));
    }
*/
    private void addItemsToAuction(Auction auction, int count) {
        for (int i = 0; i < count; i++) {
            addItemToAuction(auction, i);
        }
    }

    private boolean addItemToAuction(Auction auction, int id) {
        boolean added = auction.addItem(new Item(
                id,
                this.auctionId,
                this.itemDescription,
                this.itemQuantity,
                this.itemStartBid,
                this.condition,
                this.approximateSize,
                this.location,
                this.comments));
        return added;
    }

}

