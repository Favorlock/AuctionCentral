package edu.uw.sp18.tcss360a.group6;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * JUnit test class for item.
 *
 * @author Adam G. Cannon
 * @version 5/1/2018
 */
public class ItemTest {

    private int GOLDRING_ID = 1;
    private int GOLDRING_START_BID = 10;
    private int GOLDRING_QTY = 1;
    private int EQUAL_BID = 10;
    private int GREATER_BID = 11;
    private int LESSER_BID = 9;

    private Item goldRing;
    private BigDecimal equalBid;
    private BigDecimal greaterBid;
    private BigDecimal lesserBid;

    @Before
    public void setUp() {

        goldRing = new Item(GOLDRING_ID, "Gold Ring", new BigDecimal(GOLDRING_START_BID), GOLDRING_QTY);
        equalBid = new BigDecimal(EQUAL_BID);
        greaterBid = new BigDecimal(GREATER_BID);
        lesserBid = new BigDecimal(LESSER_BID);
    }

    @Test
    public void isBidAmountAcceptable_equalToMinimumAccepted_True() {

        assertTrue(goldRing.isBidAmountAcceptable(equalBid));
    }

    @Test
    public void isBidAmountAcceptable_greaterThanMinimumAccepted_True() {

        assertTrue(goldRing.isBidAmountAcceptable(greaterBid));
    }

    @Test
    public void isBidAmountAcceptable_lessThanMinimumAccepted_False() {

        assertFalse(goldRing.isBidAmountAcceptable(lesserBid));
    }

}

