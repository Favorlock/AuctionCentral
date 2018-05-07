package edu.uw.sp18.tcss360a.group6;

import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.*;

public class Application {

    private static Application instance;

    private AuctionRepository auctionRepository;
    private BidRepository bidRepository;
    private UserRepository userRepository;

    private boolean running = true;

    public void start() {
        __loadRepositories();

        Console console = new Console();

        while (this.running) {
            //login the user
            LoginHandler loginHandler = new LoginHandler();
            String userName = "";
            while ( !(loginHandler.validateUser(userName, this.userRepository.fetchAll())) ) {
                console.printf(loginHandler.displayLogin());
                userName = console.readLine();
            }

            User user = loginHandler.getUser();

            bidderOptions(console);


            String line = null;
            while (line == null)
                line = console.readLine();
            switch (line.toLowerCase()) {
                case "1":
                    console.printf("you chose option 1...\n");
                    console.printf("Enter 'b' to go back\n");
                    line = console.readLine();
                    switch (line.toLowerCase()) {
                    case "b":
                    	bidderOptions(console);
                    	break;
                    default:
                    	console.printf("Invalid selection...\n");
                    }
                    break;
                case "2":
                    console.printf("you chose option 2...\n");
                    break;
                case "3":
                    console.printf("you chose option 2...\n");
                    break;
                case "4":
                    console.printf("you chose option 2...\n");
                    break;
                default:
                    console.printf("Invalid selection...\n");
            }
        }
    }

    public void bidderOptions(Console console) {
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

    public AuctionRepository getAuctionRepository() {
        return auctionRepository;
    }

    public BidRepository getBidRepository() {
        return bidRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    private void __loadRepositories() {
        this.auctionRepository = AuctionRepository.load();
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