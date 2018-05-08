package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.ContactPerson;
import edu.uw.sp18.tcss360a.group6.model.Item;
import edu.uw.sp18.tcss360a.group6.model.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class AddInventoryPrompt extends AbstractPrompt {


    public AddInventoryPrompt(Context context) {
        super(context);
    }

    @Override
    public boolean execute(Context context) {
    	Application application = Application.getInstance();
        Console console = application.getConsole();

        String line = null;
        String description = null;
        int quantity = 0;
        Auction activeAuction;
        
        BigDecimal startingBid = new BigDecimal(0);
        
        console.printfln("Please provide the requested information when prompted.");
        console.printfln("Description");
        
        while (line == null) {
            description = console.readLine();
        }
        
        console.printfln("Quantity:");
        
        while (line == null) {
            quantity = Integer.parseInt(console.readLine());
        }
        
        console.printfln("Starting bid:");
        while (line == null) {
            startingBid = BigDecimal.valueOf(Double.parseDouble(console.readLine()));
        }

        //activeAuction = context.get("user", ContactPerson.class).getOrganization().getActiveAuction();
        //int auctionId = activeAuction.getId();
        //Item newItem = new Item(auctionId, description, quantity, startingBid);
        //context.get("user", ContactPerson.class).addInventoryToAuction(activeAuction, newItem);
        console.printfln("The item has been added to your organization's auction.");
        return true;
    }
    
}
