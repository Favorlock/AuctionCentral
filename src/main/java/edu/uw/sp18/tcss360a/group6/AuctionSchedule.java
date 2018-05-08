package edu.uw.sp18.tcss360a.group6;

import edu.uw.sp18.tcss360a.group6.model.Auction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class represents auction schedule available.
 * Overview of all auctions scheduled.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class AuctionSchedule {
    //fields
    private List<Auction> auctions = new ArrayList<Auction>();
    private final int capacity;
    private int month;
    private int day;
    private int year;

    /**
     * This class gets auction submitted date.
     * @param month is month of new auction.
     * @param day is day of new auction.
     * @param year is year of new auction.
     */
    public void AuctionSubmitted(int month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }
    /**
     * Auction schedule constructor.
     *
     * @param capacity is how much auctions can have in a day.
     */
    public AuctionSchedule(int capacity) {
        this.capacity = capacity;
    }
    /**
     * Checks if an opening is available on a given date.
     *
     * @param date the date to check
     *
     * @return true if less than 2 auctions are scheduled on the date
     */
    public boolean isOpeningAvailable(LocalDate date) {
        return this.auctions.stream()
                .filter(auction ->  auction.getStartDate().equals(date))
                .count() < capacity;
    }

    /**
     * Returns a list of upcoming auctions.
     *
     * @return list of upcoming auctions
     */

    public List<Auction> getUpcomingAuctions(){
        return this.auctions.stream()
                .filter(auction -> auction.getStartDate()
                        .isAfter(LocalDate.now()))
                .collect(Collectors.toList());
    }
    /**
     * Schedules an auction if possible.
     *
     * @param auction the auction to schedule
     *
     * @return true if the auction was scheduled
     */
    public boolean scheduleAuction(Auction auction) {
        if(isOpeningAvailable(auction.getStartDate())) {
            this.auctions.add(auction);
            return true;
        }
        return false;
    }
}

