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
        ContactPerson contact = context.get("user", ContactPerson.class);
        Auction auction = contact.getOrganization().getCurrentAuction();

        if (auction == null) {
            // TODO: No Active Auction
        } else {
            String line = null;
            String description = null;
            int quantity = 0;
            String comments = null;
            String condition = null;
            String size = null;
            String location = null;
            Auction activeAuction;

            BigDecimal startingBid = new BigDecimal(0);

            console.printfln("Please provide the requested information when prompted.");
            console.printfln("Description");

            while (description == null) {
                description = console.readLine();
            }

            console.printfln("Quantity (greater than 0):");

            while (quantity == 0) {
                quantity = Integer.parseInt(console.readLine());
            }
            

            console.printfln("Starting bid (greater than 0):");
            while (startingBid.equals(0)) {
                startingBid = BigDecimal.valueOf(Double.parseDouble(console.readLine()));
            }

            console.printfln("Condition:");
            while (condition == null) {
            	condition = console.readLine();
            }
            
            
            console.printfln("Approximate Size:");
            while (size == null) {
            	size = console.readLine();
            }

            console.printfln("Additional Comments:");
            while (comments == null) {
            	comments = console.readLine();
            }
            


            console.printfln("Storage Location:");
            Item item = new Item(auction.getId(), description, quantity, startingBid, condition, size, location, comments);
            auction.addItem(item);
            console.printfln("The item has been added to your organization's auction.");
        }

        return true;
    }
    
}
