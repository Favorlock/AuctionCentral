package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.annotations.Expose;
import edu.uw.sp18.tcss360a.group6.Bootstrap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class used to represent an auction.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 4/30/2018
 */
public class Auction {

    public static int MAX_UPCOMING_AUCTIONS = 25;

    @Expose
    protected long id;

    @Expose
    private long organizationId;

    @Expose
    private LocalDate startDate;

    private Organization organization;

    private List<Item> inventory;

    public Auction() {
        super();
    }

    /**
     * Constructor used to create an auction object.
     *
     * @param startDate the date the auction takes place
     */
    public Auction(long organizationId, LocalDate startDate) {
        this.organizationId = organizationId;
        this.startDate = startDate;
    }

    /**
     * Constructor used to create an auction object.
     *
     * @param startDate the date the auction takes place
     */
    public Auction(long id, long organizationId, LocalDate startDate) {
        this(organizationId, startDate);
        this.id = id;

    }

    /**
     * Helper method used to add an item to the auction's inventory.
     *
     * @param item Item used to represent an item to be added to the inventory.
     */
    public boolean addItem(Item item) {
        boolean added = false;
        if (!isAtCapacity()) {
            Bootstrap.getInstance().getItemRepository().add(item);
            getInventory().add(item);
            added = true;
        }
        return added;
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
        LocalDate now = LocalDate.now();
        return now.isBefore(this.startDate);
    }

    /**
     * Check if there is less than the max number of items in the auction.
     * If we can add an item return true, otherwise return false.
     *
     * @return a boolean representing if the item can be added or not
     */
    public boolean isAtCapacity() {

        return getInventorySize() >= Bootstrap.getInstance().getSettingsRepository().fetch()
                .getInventoryCapacity();
    }

    /**
     * Returns the number of items in an auction's inventory.
     *
     * @return the number of items in this auction.
     */
    public int getInventorySize() {
        return getInventory().size();
    }

    /**
     * Returns the id number of an auction.
     *
     * @return the auction id
     */
    public long getId() {
        return id;
    }

    /**
     * Return the organization ID.
     *
     * @return long representing organization ID
     */
    public long getOrganizationId() {
        return organizationId;
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
     * Get the organization representing this auction.
     *
     * @return the organization representing this auction.
     */
    public Organization getOrganization() {
        if (this.organization == null) {
            this.organization = Bootstrap.getInstance().getOrganizationRepository().fetchAll().stream()
                    .filter(org -> org.getId() == this.organizationId)
                    .findFirst().orElse(null);
        }

        return this.organization;
    }

    /**
     * Get the items that are in this auction.
     *
     * @return List of type item that are the items in this auction
     */
    public List<Item> getInventory() {
        if (this.inventory == null) {
            this.inventory = Bootstrap.getInstance().getItemRepository().fetchAll().stream()
                    .filter(item -> item.getAuctionId() == this.id)
                    .collect(Collectors.toList());
        }

        return this.inventory;
    }

    /**
     * Get a list of items that the bidder can bid on in an auction
     * and has not already bid on in the past.
     * @param theBidder Bidder to check if has bids on item
     * @return list of items bidder can bid on
     */
    public List<Item> getItemsBidderCanBidOn(Bidder theBidder) {
        List<Item> items = this.getInventory();
        List<Item> biddableItems = new ArrayList<>();
        for(Item i : items) { //iterate list of all items in auction
            List<Bid> bidder = i.getPlacedBids();
            boolean canBid = true;
            for(Bid b : bidder) { //iterate list of all bids on each item
                if(b.getBidderId() == theBidder.getId()) {
                    canBid = false;
                }
            }
            if(canBid) {
                biddableItems.add(i);
            }
        }
        return biddableItems;
    }

    @Override
    public String toString() {
        String org = Bootstrap.getInstance().getOrganizationRepository().fetchAll().stream()
                .filter(organization -> organization.getId() == organizationId)
                .findFirst().orElse(null).getName();
        return "Start Date=" + startDate +
                ", Auction ID=" + id +
                ", Organization=" + org;

    }
}

