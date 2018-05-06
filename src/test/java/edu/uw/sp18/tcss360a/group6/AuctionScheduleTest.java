package edu.uw.sp18.tcss360a.group6;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

/**
 * Class used to represent auction schedule test.
 *
 * @author Group 6
 * @version 5/02/2018
 */
public class AuctionScheduleTest
{
    //Fields
    private static int MAX_NUMBER_OF_AUCTION_IN_A_DAY = 2;
    private AuctionSchedule schedule;

    @Before
    public void setUp()
    {
        this.schedule = new AuctionSchedule(MAX_NUMBER_OF_AUCTION_IN_A_DAY);

    }

//    @Test
//    public void canAddNewAuction_havingUnderTwoAuctionInThatDay_True()
//    {
//        LocalDate date = LocalDate.now().plusDays(1);
//        for(int i = 0; i < MAX_NUMBER_OF_AUCTION_IN_A_DAY; i++) {
//            this.schedule.scheduleAuction(new Auction(date));
//        }
//        assertTrue(this.schedule.isOpeningAvailable(date));
//    }
//
//    @Test
//    public void CanAddNewAuction_havingTwoAuctionInThatDay_False()
//    {
//        LocalDate date = LocalDate.now().plusDays(1);
//        for(int i = 0; i < MAX_NUMBER_OF_AUCTION_IN_A_DAY + 1; i++) {
//            this.schedule.scheduleAuction(new Auction(date));
//        }
//        assertFalse(this.schedule.isOpeningAvailable(date));
//    }
}

