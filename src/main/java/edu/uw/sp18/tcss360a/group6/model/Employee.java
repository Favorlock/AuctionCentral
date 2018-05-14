package edu.uw.sp18.tcss360a.group6.model;

import edu.uw.sp18.tcss360a.group6.Bootstrap;

import java.time.LocalDate;

/**
 * Class used to represent an Employee of Auction Central.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/11/2018
 */
public class Employee extends AbstractUser {

    /**
     * Construct a new employee.
     *
     * @param id employees user identification number
     * @param userName String representation of the employee name
     */
    public Employee (long id, String userName) {
        super(UserType.EMPLOYEE, id, userName);
    }

    /*
    As an employee of AuctionCentral, I want to change the maximum number of upcoming auctions that can be accepted by the system.
        The maximum number of upcoming auctions must be a positive integer.
            A non-positive integer is specified: fail
            A positive integer is specified
            A positive integer is specified that is greater than the number of existing auctions in the system
    */
    public void changeUpcomingAuctionsMax(final int newAuctionMax, Auction auctions) {
        if(newAuctionMax > 0 && newAuctionMax > Bootstrap.getInstance().getAuctionRepository().fetchFutureAuctions().size()) {
            LocalDate now = LocalDate.now();

            if (auctions.getStartDate().isAfter(now)) {
                auctions.setAuctionCapacity(newAuctionMax);
            }
        }
    }

    /*
    As an employee of AuctionCentral, I want a view in brief of all auctions that take place between any two dates, inclusive.
        The second date is earlier than the first date : fail
        The first and second dates are the same
        The second date is at least one day later than the second date
     */
    public void viewAllAuctionsBetweenDates(Auction date1, Auction date2) {
        if (date1.getStartDate().isBefore(date2.getStartDate()) ||
                date1.getStartDate().isEqual(date2.getStartDate())) {
           //TODO: get the auctions between dates

        }
    }

    /*
    As an employee of AuctionCentral, I want a view in brief in chronological order of all auctions, past, present, and future.
        There exists at least one auction in the past and at least one auction in the future.
     */
    public void viewAllAuctionsInOrder() {

    }

    /*
    As an employee of AuctionCentral, I want to cancel an auction.
        No auction can be cancelled that has any bids
            The auction has no bids
            The auction has one bid : fail
            The auction has many more than one bid : fail
     */
    public void cancelAnAuction(Auction anAuction) {
//        if(auction has no bids) { //TODO: get if auction has any bids
//            delete the auction
//        }
    }


}
