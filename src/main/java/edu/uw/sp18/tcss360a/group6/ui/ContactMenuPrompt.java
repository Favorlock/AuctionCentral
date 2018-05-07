package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Application;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.User;

import java.util.List;

/**
 * Prompt the User with a valid list of selectable options.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class ContactMenuPrompt extends AbstractPrompt {

	private String line;
    public ContactMenuPrompt(Context context) {
        super(context);
    }

    @Override
    public boolean execute(Context context) {
    	boolean completed = false;
        Application application = Application.getInstance();
        Console console = application.getConsole();
        line = null;
        
        console.printf("Choose an option\n");
        console.printf("1. View brief overview of items in my auctions.\n");
        console.printf("2. Submit auction request.\n");
        console.printf("3. Add inventory for auction.\n");
        console.printf("4. Logout.\n");

        while (line == null) {
        	line = console.readLine();
        }
        Context theContext = new Context();
        switch (line.toLowerCase()) {
        
        case "1":
        	ContactItemsPrompt items = new ContactItemsPrompt(theContext);
        	items.start();
        	break;
        case "2":
        	AuctionRequestPrompt request = new AuctionRequestPrompt(theContext);
        	request.start();
        	break;
        case "3":
        	AddInventoryPrompt add = new AddInventoryPrompt(theContext);
        	add.start();
        	break;
        case "4":
        	completed = true;
        	break;
        }
        
        
        return completed;
    }
    
}