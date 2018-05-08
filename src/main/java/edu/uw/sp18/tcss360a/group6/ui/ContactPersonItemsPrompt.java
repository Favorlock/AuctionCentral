package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *  Display Items I have available in my auctions.
 *  View brief overview of items in my auctions.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/4/2018
 */
public class ContactPersonItemsPrompt extends AbstractPrompt {

	private String line;
    public ContactPersonItemsPrompt(Context context) {
        super(context);
    }

    @Override
    public boolean execute(Context context) {
        Application application = Application.getInstance();
        Console console = application.getConsole();

        User user = context.get("user", User.class);

        if (user.getType() == UserType.CONTACT_PERSON) {

            ContactPerson CPUser = (ContactPerson) user;
            Map<Auction, ArrayList<Item>> auctionItems = CPUser.viewAllAuctionsItemsISubmitted();

            if(auctionItems != null) { // & !auctionItems.isEmpty()

                for(Map.Entry<Auction, ArrayList<Item>> auction : auctionItems.entrySet()) {
                    console.printfln(auction.getKey().toString());
//                    for(Item item : auction.getValue()) {}
                }
            } else {
                console.printfln("You have not added any items in any auctions");
            }
        }
        
        return true;
    }
    
}
