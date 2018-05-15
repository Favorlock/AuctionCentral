package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.ConsoleApplication;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Add an inventory Item an Auction.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class PlaceBidPrompt extends AbstractPrompt {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^([+-]?[0-9]\\d*|0)$");

    public PlaceBidPrompt(Context context) {
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
    	ConsoleApplication application = (ConsoleApplication) ConsoleApplication.getInstance();
        Console console = application.getConsole();
        Bidder bidder = context.get("user", Bidder.class);
        Auction auction = context.get("auction", Auction.class);
        Item item = context.get("item", Item.class);

        BigDecimal amount = BigDecimal.ZERO;
        BigDecimal currentAmount = item.getStartBid();
        Bid currentBid = item.getCurrentBid();
        if (currentBid != null) {
            currentAmount = currentBid.getAmount();
        }

        console.printfln(
                "Please provide the requested information when "
                        + "prompted.");

        while (amount.compareTo(currentAmount) < 1) {
            console.printfln("Amount: ");
            String line = null;
            while (line == null) {
                line = console.readLine();
            }

            Matcher matcher = INTEGER_PATTERN.matcher(line);
            if (matcher.matches()) {
                amount = new BigDecimal(line);
            }
        }

        boolean placed = bidder.addBid(amount, item, auction);
        if (placed) {
            console.printfln("Your bid has been placed!");
        } else {
            console.println("Your bid could not be placed.");
        }

        return true;
    }
    
}
