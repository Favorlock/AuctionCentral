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

    private Bidder bidder;
    private Auction auction;
    private LocalDate auctionDate;
    private Bid bid;
    private Item item;
    private BigDecimal itemStartPrice;
    private BigDecimal bidPrice;

    @Before
    public void setUp() {

        auctionDate = LocalDate.now().plusMonths(2);
        bidder = new Bidder("adam", "1234567890", "agc9@uw.edu", "1410 E 52nd ST, Tacoma WA", "1000100010001000");
        auction = new Auction(auctionDate);
        itemStartPrice = new BigDecimal(100);
        bidPrice = new BigDecimal(110);
        item = new Item(01, "Gold Ring", itemStartPrice, 1);
        bid = new Bid(auction, bidder, item, bidPrice);

    }

    @Test
    public void canBidInAuction_belowMaximumBids_True() {

        for (int i = 0; i < 3; i++) {
            bidder.addBid(bid);
        }
        assertTrue(bidder.canBid(auction));
    }

    @Test
    public void canBidInAuction_aboveMaximumBids_False() {


        for (int i = 0; i < 4; i++) {
            bidder.addBid(bid);
        }
        assertFalse(bidder.canBid(auction));
    }

    @Test
    public void canBid_belowMaximumBids_True() {

        for (int i = 0; i < 10; i++) {
            bidder.addBid(bid);
        }
        assertTrue(bidder.canBid());
    }

    @Test
    public void canBid_aboveMaximumBids_False() {
        for (int i = 0; i < 11; i++) {
            bidder.addBid(bid);
        }
        assertFalse(bidder.canBid());
    }
}
