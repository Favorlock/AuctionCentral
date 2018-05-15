package edu.uw.sp18.tcss360a.group6.model;

import edu.uw.sp18.tcss360a.group6.Bootstrap;

import java.time.LocalDate;
import java.util.List;

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
     * @param id       employees user identification number
     * @param userName String representation of the employee name
     */
    public Employee(long id, String userName) {
        super(UserType.EMPLOYEE, id, userName);
    }

    /*
    As an employee of AuctionCentral, I want to change the maximum number of upcoming auctions that can be accepted by the system.
        The maximum number of upcoming auctions must be a positive integer.
            A non-positive integer is specified: fail
            A positive integer is specified
            A positive integer is specified that is greater than the number of existing auctions in the system
    */

    /**
     * Change the maximum amount of auctions that the system allows to be
     * scheduled at one time.
     *
     * @param newAuctionMax integer specifying proposed new amount of auction allowed
     */
    public void setAuctionCapacity(final int newAuctionMax) {
        Bootstrap bootstrap = Bootstrap.getInstance();
        SettingsRepository settingsRepository = bootstrap.getSettingsRepository();
        AuctionRepository auctionRepository = bootstrap.getAuctionRepository();

        if (newAuctionMax > 0 && newAuctionMax > auctionRepository.fetchFutureAuctions().size()) {
            settingsRepository.fetch().setAuctionCapacity(newAuctionMax);
            settingsRepository.save();
        }
    }

    /*
    As an employee of AuctionCentral, I want a view in brief of all auctions that take place between any two dates, inclusive.
        The second date is earlier than the first date : fail
        The first and second dates are the same
        The second date is at least one day later than the second date
     */

    /**
     * View all auctions between a two set inclusive dates.
     *
     * @param firstDate  the starting date
     * @param secondDate the ending date
     */
    public List<Auction> viewAllAuctionsBetweenDates(LocalDate firstDate, LocalDate secondDate) {
        //TODO:
//        if (firstDate.getStartDate().isBefore(secondDate.getStartDate()) ||
//                firstDate.getStartDate().isEqual(secondDate.getStartDate())) {
//            return Bootstrap.getInstance().getAuctionRepository().fetchAll().stream().
//                    filter(auction-> auction.getStartDate().isAfter(firstDate) &&
//                    auction.getStartDate().isBefore(secondDate)).collect(collectors.toList());
//        }
        return null;
    }

    /**
     * If the auction has at least one auction in the past and one auction in
     * the future return a list of auctions, otherwise return null.
     *
     * @return a list of all auctions in chronological order
     */
    public List<Auction> viewAllAuctionsInOrder() {
        if (Bootstrap.getInstance().getAuctionRepository().
                fetchFutureAuctions().size() > 1) {
            return Bootstrap.getInstance().getAuctionRepository().
                    fetchAllInChronologicalOrder();
        }
        return null;
    }

    /*
    As an employee of AuctionCentral, I want to cancel an auction.
        No auction can be cancelled that has any bids
            The auction has no bids
            The auction has one bid : fail
            The auction has many more than one bid : fail
     */

    /**
     * Method to cancel an auction. If an auction has no bids then can cancel
     * the auction.
     *
     * @param anAuction the auction to try to cancel
     */
    public void cancelAnAuction(Auction anAuction) {
//        if(auction has no bids) { //TODO: get if auction has any bids
//            delete the auction
//        }
    }


}
