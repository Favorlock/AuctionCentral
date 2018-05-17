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

    public int getAuctionCapacity() {
        Bootstrap bootstrap = Bootstrap.getInstance();
        SettingsRepository settingsRepository = bootstrap.getSettingsRepository();
        AuctionRepository auctionRepository = bootstrap.getAuctionRepository();

        return settingsRepository.fetch().getAuctionCapacity();
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

    /**
     * Method to cancel an auction. If an auction has no bids then delete
     * the auction. Return true if auction did delete otherwise false.
     *
     * @param anAuction the auction to try to cancel
     */
    public Boolean cancelAnAuction(Auction anAuction) { //TODO: is all relevant info deleted?
        boolean didDeleteAuction = false;
        if (anAuction.getInventorySize() == 0) {
            List<Auction> auctions = Bootstrap.getInstance().getAuctionRepository().fetchAll();
            for (Auction a : auctions) {
                if (a.getId() == anAuction.getId()) {
                    if(isThereBidsOnAuctionItems(a.getInventory())) {
                        Bootstrap.getInstance().getAuctionRepository().delete(a);
                        didDeleteAuction = true;
                    }
                    break;
                }
            }
        }
        return didDeleteAuction;
    }

    /**
     * Checks a list of items to see if there are bids on any items.
     * returns true if at least one Item in list has a bid.
     *
     * @param items a list of items in an auction
     * @return if any items in the list have bids
     */
    public Boolean isThereBidsOnAuctionItems(List<Item> items) {
        Boolean anyBidOnItems = false;
        for (Item item : items) {
            if (item.getPlacedBids().size() > 0) {
                anyBidOnItems = true;
            }
        }
        return anyBidOnItems;
    }

}
