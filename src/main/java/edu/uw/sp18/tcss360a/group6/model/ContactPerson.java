package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.annotations.Expose;
import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.AuctionSchedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
/**
 * Represents a ContactPerson user and the methods they are able to perform
 * adding inventory to auctions, scheduling auctions, and viewing items
 * they have submitted.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class ContactPerson extends AbstractUser {

    @Expose
    private long organizationId;

    private Organization organization;

    public ContactPerson(long id, long organizationId, String userName) {
        super(UserType.CONTACT_PERSON, id, userName);
        this.organizationId = organizationId;
    }

//    /**
//     * Validate if the specified auction can be scheduled into the overall auction
//     * schedule list while following scheduling rules.
//     *
//     * @param auctionsSchedule the overall auction schedule
//     * @param anAuction the auction to schedule
//     * @return true if possible to schedule an auction on this date
//     */
//    public boolean scheduleAnAuction(AuctionSchedule auctionsSchedule, Auction anAuction) {
//        return auctionsSchedule.scheduleAuction(anAuction);
//    }
//
//    /**
//     * Add an Item to the specified auction.
//     *
//     * @param auctionToAddItemTo the auction to add item to
//     * @param itemToAddToAuction the item to be added to the auction
//     */
//    public void addInventoryToAuction (Auction auctionToAddItemTo, Item itemToAddToAuction) {
//        auctionToAddItemTo.addItem(itemToAddToAuction);
//        ArrayList<Item> temporaryItems = new ArrayList<>();
//        if (submittedAuctionItems.get(auctionToAddItemTo) != null) {
//            temporaryItems = submittedAuctionItems.get(auctionToAddItemTo);
//            submittedAuctionItems.put(auctionToAddItemTo, temporaryItems);
//        } else {
//            temporaryItems.add(itemToAddToAuction);
//            submittedAuctionItems.put(auctionToAddItemTo, temporaryItems);
//        }
//    }
//
//    /**
//     * Get my items I've submitted in auctions.
//     *
//     * @return a map<auction, ArrayList<Item>> containing the auctions and items
//     */
//    public Map<Auction, ArrayList<Item>> viewAllAuctionsItemsISubmitted () {
//        return submittedAuctionItems;
//    }

    public long getOrganizationId() {
        return this.organizationId;
    }

    public Organization getOrganization() {
        if (this.organization == null) {
            this.organization = Application.getInstance().getOrganizationRepository().fetchAll().stream()
                    .filter(org -> org.getId() == this.organizationId)
                    .findFirst().orElse(null);
        }

        return this.organization;
    }
}
