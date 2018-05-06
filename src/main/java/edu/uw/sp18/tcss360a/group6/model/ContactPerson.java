package edu.uw.sp18.tcss360a.group6.model;

import edu.uw.sp18.tcss360a.group6.AuctionSchedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
/**
 *
 */
public class ContactPerson extends AbstractUser {

    private List<Auction> submittedAuctions = new ArrayList<Auction>();

    private Map<Auction, ArrayList<Item>> submittedAuctionItems = new HashMap<>();

    public ContactPerson(long id, String userName) {
        super(UserType.CONTACT_PERSON, id, userName);
    }

    /**
     *
     * @param auctionsSchedule
     */
    public boolean scheduleAnAuction(AuctionSchedule auctionsSchedule, Auction anAuction) {
        return auctionsSchedule.scheduleAuction(anAuction);
    }

    /**
     *
     * @param auctionToAddItemTo
     * @param itemToAddToAuction
     */
    public void addInventoryToAuction (Auction auctionToAddItemTo, Item itemToAddToAuction) {
        auctionToAddItemTo.addItem(itemToAddToAuction);
        ArrayList<Item> temporaryItems = new ArrayList<>();
        if (submittedAuctionItems.get(auctionToAddItemTo) != null) {
            temporaryItems = submittedAuctionItems.get(auctionToAddItemTo);
            submittedAuctionItems.put(auctionToAddItemTo, temporaryItems);
        } else {
            temporaryItems.add(itemToAddToAuction);
            submittedAuctionItems.put(auctionToAddItemTo, temporaryItems);
        }
    }

    /**
     *
     * @return
     */
    public Map<Auction, ArrayList<Item>> viewAllAuctionsItemsISubmitted () {
        return submittedAuctionItems;
    }
}
