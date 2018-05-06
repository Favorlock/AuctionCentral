package edu.uw.sp18.tcss360a.group6;

import com.google.gson.annotations.Expose;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Class used to represent an auction.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam , Evan
 * @version 4/30/2018
 */
public class Auction {

    /**
     * Constant specifying the max number of auctions allowed.
     */
    public static int ITEM_CAPACITY = 10;

    @Expose
    private long id;

    /**
     * The date and time the auction is scheduled to take
     * place on.
     */
    @Expose
    private LocalDate startDate;

    /**
     * ArrayList<> of inventory used to represent the inventory in the auction object.
     **/
    @Expose
    private ArrayList<Item> inventory;

    public Auction() {
        super();
    }

    /**
     * Constructor used to create an auction object.
     *
     * @param startDate the date the auction takes place
     */
    public Auction(long id, LocalDate startDate) {
        this.id = id;
        this.startDate = startDate;
        this.inventory = new ArrayList<>();
    }

    /**
     * Helper method used to add an item to the auction's inventory.
     *
     * @param theItem Item used to represent an item to be added to the inventory.
     */
    public void addItem(Item theItem) {
        this.inventory.add(theItem);
    }

    /**
     * Method used to check if the auction is accepting bids.
     *
     * @return boolean used to represent whether the auction is accepting bids.
     */
    public boolean isAcceptingBids() {
        return isBeforeMidnightOfStartDate();
    }

    /**
     * Returns whether the current date is before the start date
     * of the auction.
     *
     * @return true if the current date is before the start date
     */
    private boolean isBeforeMidnightOfStartDate() {
        return LocalDate.now().isBefore(this.startDate);
    }

    /**
     * Getter method used to return the auction's date.
     *
     * @return Date used to represent the date of the auction.
     */
    public LocalDate getStartDate() {
        return this.startDate;
    }

    /**
     * Add an item to the auction if possible.
     *
     * @param auctionItem the item to add to the auction
     */
    public void addAuctionItem(Item auctionItem) {
        if (!isAtCapacity()) {
            this.inventory.add(auctionItem);
        }
    }

    /**
     * Check if there is less than the max number of items in the auction.
     * If we can add an item return true, otherwise return false.
     *
     * @return a boolean representing if the item can be added or not
     */
    public boolean isAtCapacity() {

        return this.inventory.size() >= ITEM_CAPACITY;
    }

    /**
     * Getter method to return the number of items currently in this auction.
     *
     * @return the number of items in this auction.
     */
    public int getItemsInAuctionCount() {
        return this.inventory.size();
    }

    @Override
    public String toString() {
        return "Auction{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", inventory=" + inventory +
                '}';
    }
}

