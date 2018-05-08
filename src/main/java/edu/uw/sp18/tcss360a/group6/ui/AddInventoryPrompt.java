package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.ContactPerson;
import edu.uw.sp18.tcss360a.group6.model.Item;
import java.math.BigDecimal;

/**
 * Add an inventory Item an Auction.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class AddInventoryPrompt extends AbstractPrompt {


    public AddInventoryPrompt(Context context) {
        super(context);
    }

    /**
     * Method used to execute the logic and prompting of add inventory prompt.
     * 
     * @boolean used to represent whether the prompt should return to previous
     * prompt.
     */
    @Override
    public boolean execute(Context context) {
    	Application application = Application.getInstance();
        Console console = application.getConsole();
        ContactPerson contact = context.get("user", ContactPerson.class);
        Auction auction = contact.getOrganization().getCurrentAuction();

        if (auction == null) {
            // TODO: No Active Auction
        } else {
            String description = null;
            int quantity = 0;
            String comments = null;
            String condition = null;
            String size = null;
            String location = null;
            BigDecimal startingBid = new BigDecimal(0);

            console.printfln("Please provide the requested information when prompted.");

            console.printfln("Description: ");
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

            console.printfln("Item condition:");
            while (condition == null) {
            	condition = console.readLine();
            }
            
            
            console.printfln("Approximate Size (enter dimensions in inches LxWxH):");
            while (size == null) {
            	size = console.readLine();
            }

            console.printfln("Additional Comments:");
            while (comments == null) {
            	comments = console.readLine();
            }
            

            console.printfln("Storage Location (is item big or small):");
            while (location == null) {
                location = console.readLine();
            }
            Item item = new Item(auction.getId(), description, quantity, startingBid, condition, size, location, comments);
            auction.addItem(item);
            console.printfln("The item has been added to your organization's auction.");
        }

        return true;
    }
    
}
