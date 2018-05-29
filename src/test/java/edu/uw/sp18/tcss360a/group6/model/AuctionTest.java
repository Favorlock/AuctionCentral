package edu.uw.sp18.tcss360a.group6.model;


import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;

import static org.junit.Assert.*;

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

    private LocalDate startDate;

    private long itemId;

    private String itemDescription;

    private int itemQuantity;

    private BigDecimal itemStartBid;

    private String condition;

    private String approximateSize;

    private String location;

    private String comments;

    private Item item;

    private Bidder bidder;

    private long bidderId;

    private String bidderUsername;

    private List<Item> inventory = new ArrayList<>();

    private List<Item> itemsCanBid = new ArrayList<>();

    @Before
    public void setUp() {
        this.auctionId = 0;
        this.organizationId = 0;
        this.pastDate = LocalDate.now().minusMonths(1);
        this.currentDate = LocalDate.now();
        this.futureDate = LocalDate.now().plusMonths(1);
        this.startDate = LocalDate.now().plusDays(1);
        this.itemId = 123;
        this.itemDescription = "Item";
        this.itemQuantity = 1;
        this.itemStartBid = BigDecimal.valueOf(1);
        this.condition = "";
        this.approximateSize = "";
        this.location = "";
        this.comments = "";
        bidderId = 23;
        bidderUsername = "Tam";
        bidder = new Bidder(bidderId,bidderUsername);
        item = new Item(itemId,auctionId, itemDescription, itemQuantity,
                itemStartBid, condition,approximateSize, location, comments);
        inventory.add(item);
        itemsCanBid.add(item);
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
    public void getInventorySize_auctionInventoryEmpty_True() {
        Auction auction = new Auction(this.auctionId, this.organizationId, this.currentDate);
        assertTrue(auction.getInventorySize() == 0);
    }

    @Test
    public void addItem_testCanAddItemInAuctionInventory_True() {
        Auction auction = new Auction(this.auctionId, this.organizationId, this.futureDate);
        Item item = new Item(itemId,auctionId, itemDescription, itemQuantity,
                itemStartBid, condition,approximateSize, location, comments);
        assertTrue(auction.addItem(item));
    }

    @Test
    public void addItem_testCannotAddItemInAuctionInventory_False() {
        Auction auction = new Auction(this.auctionId, this.organizationId, this.futureDate);
        item = new Item(itemId,auctionId, itemDescription, itemQuantity,
                itemStartBid, condition,approximateSize, location, comments);
        assertFalse(auction.addItem(item));
    }

    @Test
    public void getInventorySize_getRightInventorySize_True(){
        Auction auction = new Auction(this.auctionId, this.organizationId, this.futureDate);
        assertEquals(inventory.size(),auction.getInventorySize() );
    }

    @Test
    public void getInventorySize_getWrongInventorySize_False(){
        Auction auction = new Auction(this.auctionId, this.organizationId, this.futureDate);
        assertNotEquals(inventory.size(),auction.getInventorySize() );
    }

    @Test
    public void getOrganizationId_getRightOrganizationIDTrue(){
        Auction auction = new Auction(this.auctionId, this.organizationId, this.futureDate);
        assertEquals(organizationId,auction.getOrganizationId());
    }

    @Test
    public void getOrganizationId_getWrongOrganizationIDFalse(){
        Auction auction = new Auction(this.auctionId, this.organizationId, this.futureDate);
        assertNotEquals(organizationId,auction.getOrganizationId());
    }

    @Test
    public void getStartDate_getRightStartDate_True(){
        Auction auction = new Auction(this.auctionId, this.organizationId, this.startDate);
        assertEquals(startDate, auction.getStartDate());
    }

    @Test
    public void getStartDate_getWrongStartDate_False(){
        Auction auction = new Auction(this.auctionId, this.organizationId, this.startDate);
        assertNotEquals(startDate, auction.getStartDate());
    }

    @Test
    public void getInventory_getRightItemListInAuction_True() {
        Auction auction = new Auction(this.auctionId, this.organizationId, this.futureDate);
        assertEquals(inventory, auction.getInventory());
    }

    @Test
    public void getInventory_getRightItemListInAuction_False() {
        Auction auction = new Auction(this.auctionId, this.organizationId, this.futureDate);
        assertNotEquals(inventory, auction.getInventory());
    }

    @Test void getItemsBidderCanBidOn_True(){
        Auction auction = new Auction(this.auctionId, this.organizationId, this.futureDate);
        assertEquals(itemsCanBid,auction.getItemsBidderCanBidOn(bidder) );
    }

    @Test void getItemsBidderCanBidOn_False(){
        Auction auction = new Auction(this.auctionId, this.organizationId, this.futureDate);
        assertNotEquals(itemsCanBid,auction.getItemsBidderCanBidOn(bidder) );
    }

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

