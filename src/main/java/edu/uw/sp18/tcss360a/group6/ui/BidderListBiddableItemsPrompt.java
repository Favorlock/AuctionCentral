package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.ConsoleApplication;
import edu.uw.sp18.tcss360a.group6.Context;
import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.Bid;
import edu.uw.sp18.tcss360a.group6.model.Bidder;
import edu.uw.sp18.tcss360a.group6.model.Item;

import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BidderListBiddableItemsPrompt extends AbstractPrompt {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^([+-]?[0-9]\\d*|0)$");

    public BidderListBiddableItemsPrompt(Context context) {
        super(context);
    }

    @Override
    public boolean execute(Context context) {
        boolean completed = false;
        ConsoleApplication application = (ConsoleApplication) ConsoleApplication.getInstance();
        Console console = application.getConsole();
        Bidder bidder = context.get("user", Bidder.class);
        Auction auction = context.get("auction", Auction.class);

        List<Long> bidItemIds = bidder.getPlacedBids().stream()
                .map(Bid::getItemId)
                .distinct()
                .collect(Collectors.toList());
        List<Item> items = auction.getInventory().stream()
                .filter(item -> !bidItemIds.contains(item.getId()))
                .collect(Collectors.toList());

        int i = 1;
        console.printfln("Items you can bid on:");
        for(Item item : items) {
            Bid bid = item.getCurrentBid();
            console.printfln("%s. ID: %d, Description: %s, Current Bid: %s, Quantity:"
                            + " %d",
                    i++,
                    item.getId(),
                    item.getDescription(),
                    DECIMAL_FORMAT.format(bid == null ? item.getStartBid() : bid.getAmount()),
                    item.getQuantity());
        }

        int lastItemOption = i - 1;
        int mainMenuOption = i++;
        console.printfln("%d. Main Menu.", mainMenuOption);
        console.printfln("Choose an option.");

        String selection = console.readLine();
        Matcher matcher = INTEGER_PATTERN.matcher(selection);
        if (matcher.matches()) {
            int option = Integer.parseInt(selection);
            if (option > 0 && option <= i - 1) {
                if (option <= lastItemOption) {
                    Item item = items.get(option - 1);
                    Context nextContext = new Context(context, "user", "auction");
                    nextContext.set("item", item);
                    PlaceBidPrompt placeBidPrompt = new PlaceBidPrompt(nextContext);
                    placeBidPrompt.start();
                }

                completed = true;
            }
        }

        return completed;
    }
}
