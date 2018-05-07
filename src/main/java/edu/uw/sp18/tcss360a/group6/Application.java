package edu.uw.sp18.tcss360a.group6;

import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.*;
import edu.uw.sp18.tcss360a.group6.ui.LoginPrompt;

public class Application {

    private static Application instance;

    private AuctionRepository auctionRepository;
    private ItemRepository itemRepository;
    private BidRepository bidRepository;
    private UserRepository userRepository;
    private Console console;
    private User user;
    private String line;

    private boolean running = true;

    public void start() {
        __loadRepositories();

        console = new Console();

        while (this.running) {
            // Context to use through lifetime of a user session
            Context context = new Context();
            // Prompts a user to login and retrieves valid user
            LoginPrompt loginPrompt = new LoginPrompt(context);
            loginPrompt.start();
            // Fetch the user from the context
            this.user = context.get("user", User.class);

            // TODO: Make prompts for bidder/contact person along with option prompts

            bidderOptions();

            line = null;
            while (line == null)
                line = console.readLine();
            switch (line.toLowerCase()) {
                case "1":
                    console.printf("You have placed bids on items for the following auctions:\n");

                    bidderAssociatedAuctions();

                    console.printf("Enter 'b' to go back.\n");
                    line = console.readLine();
                    switch (line.toLowerCase()) {
                        case "b":
                            bidderOptions();
                            break;
                        default:
                            console.printf("Invalid selection...\n");
                    }

                    break;
                case "2":
                    console.printf("You have placed bids on the following items:\n");

                    bidderAssociatedItems();

                    console.printf("Enter 'b' to go back.\n");
                    line = console.readLine();
                    switch (line.toLowerCase()) {
                        case "b":
                            bidderOptions();
                            break;
                        default:
                            console.printf("Invalid selection...\n");
                    }

                    break;
                case "3":
                    console.printf("List of auctions you can bid on.\n");
                    console.printf("Select an auction to view its items:\n");

                    bidderOpenAuctions();
                    break;
                case "4":
                    console.printf("you chose option 4...\n");
                    break;
                default:
                    console.printf("Invalid selection...\n");
            }
        }
    }

    private void bidderOpenAuctions() {
        //output list of auctions bidder can bid on
        //CASE: user selected an item
        //itemsInAuction(auction);
        //include n+1) Back to main menu.
        //include n+2) Logout.
    }

    private void itemsInAuction(Auction theAuction) {
        //output list of items available in auction
        //include n+1) Back to main menu.
        //include n+2) Logout.
    }

    private void bidderAssociatedItems() {
        //output brief overview of all items user has placed bids on
        //include n+1) Back to main menu.
        //include n+2) Logout.
    }

    private void bidderAssociatedAuctions() {
        //output brief overview of all auctions user has placed bid in
        //include n+1) Back to main menu.
        //include n+2) Logout.

    }

    public void bidderOptions() {
        //display valid user options based on user
        console.printf("Choose an option\n");
        console.printf("1. View brief overview of all auctions I have placed bids in.\n");
        console.printf("2. View all items I have bid on in all auctions.\n");
        console.printf("3. View in brief all auctions I can bid on.\n");
        console.printf("4. Logout.\n");
    }

    public void contactOptions(Console console) {
        //display valid contact options
        console.printf("Choose an option\n");
        console.printf("1. View brief overview of items in my auctions.\n");
        console.printf("2. Submit auction request.\n");
        console.printf("3. Add inventory for auction.\n");
        console.printf("4. Logout.\n");

    }

    public void stop() {
        this.running = false;
    }

    public Console getConsole() {
        return console;
    }

    public AuctionRepository getAuctionRepository() {
        return auctionRepository;
    }

    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    public BidRepository getBidRepository() {
        return bidRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    private void __loadRepositories() {
        this.auctionRepository = AuctionRepository.load();
        this.itemRepository = ItemRepository.load();
        this.bidRepository = BidRepository.load();
        this.userRepository = UserRepository.load();
    }

    public static void main(String... args) {
        instance = new Application();
        instance.start();
    }

    public static Application getInstance() {
        return instance;
    }
}