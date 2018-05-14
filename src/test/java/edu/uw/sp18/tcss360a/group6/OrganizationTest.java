package edu.uw.sp18.tcss360a.group6;

import import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.Organization;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrganizationTest {
    private long auctionId;

    private long organizationId;

    private LocalDate futureDate;

    @Before
    public void setUp() {
        new Application(false);
        this.auctionId = 0;
        this.organizationId = 0;
        this.futureDate = LocalDate.now().plusMonths(1);
    }
    @Test
    public void isAuctionScheduleOpeningAvailable_addAuctionInCapacity_True(){
        Organization organization = new Organization();
        assertTrue(organization.isAuctionScheduleOpeningAvailable());
    }

    @Test
    public void isAuctionScheduleOpeningAvailable_addAuctionOverCapacity_False(){
        Organization organization = new Organization();
        assertFalse(organization.isAuctionScheduleOpeningAvailable());
    }

    @Test
    public void addAuction_addAuctionInAuctionRepository_True(){
        Organization organization = new Organization();
        Auction auction = new Auction(this.auctionId, this.organizationId, this.futureDate);
        assertTrue(organization.addAuction(auction));
    }

    @Test
    public void addAuction_addAuctionOverAuctionRepository_False(){
        Organization organization = new Organization();
        Auction auction = new Auction(this.auctionId, this.organizationId, this.futureDate);
        assertFalse(organization.addAuction(auction));
    }
}
