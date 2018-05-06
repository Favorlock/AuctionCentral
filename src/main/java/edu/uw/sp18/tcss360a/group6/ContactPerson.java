package edu.uw.sp18.tcss360a.group6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
/**
 *
 */
public class ContactPerson extends Bidder {

    private List<Auction> myAuctions = new ArrayList<Auction>();
    private Map<Auction, ArrayList<Item>> myAuctionItems = new HashMap<>();

    public ContactPerson(String userName, String phoneNumber, String email, String address,
                         String cardNumber) {
        super(userName, phoneNumber, email, address, cardNumber);

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
        if (myAuctionItems.get(auctionToAddItemTo) != null) {
            temporaryItems = myAuctionItems.get(auctionToAddItemTo);
            myAuctionItems.put(auctionToAddItemTo, temporaryItems);
        } else {
            temporaryItems.add(itemToAddToAuction);
            myAuctionItems.put(auctionToAddItemTo, temporaryItems);
        }
    }

    /**
     *
     * @return
     */
    public Map<Auction, ArrayList<Item>> viewAllAuctionsItemsISubmitted () {
        return myAuctionItems;
    }
}
