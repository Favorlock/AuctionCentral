package edu.uw.sp18.tcss360a.group6;

import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.AuctionRepository;
import edu.uw.sp18.tcss360a.group6.model.BidRepository;
import edu.uw.sp18.tcss360a.group6.model.UserRepository;

public class Application {

    private static Application instance;

    private AuctionRepository auctionRepository;
    private BidRepository bidRepository;
    private UserRepository userRepository;

    private boolean running = true;

    public void start() {
        this.auctionRepository = AuctionRepository.load();
        this.bidRepository = BidRepository.load();
        this.userRepository = UserRepository.load();

        Console console = new Console();

        while (this.running) {
            //login the user
            InterfaceLogin login = new InterfaceLogin();
            String userName = "";
            while ( !(login.isValidUser(userName, this.userRepository.fetchAll())) ) {
                console.printf(login.displayLogin());
                userName = console.readLine();
            }

            //display valid user options based on user
            console.printf("Choose an option\n");
            console.printf("1. Exit\n");
            console.printf("2. option 2\n");

            String line = null;
            while (line == null)
                line = console.readLine();
            switch (line.toLowerCase()) {
                case "1":
                    stop();
                    break;
                case "2":
                    console.printf("you chose option 2...\n");
                    break;
                default:
                    console.printf("Invalid selection...\n");
            }
        }
    }

    public void stop() {
        this.running = false;
    }

    public BidRepository getBidRepository() {
        return bidRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public static void main(String... args) {
        instance = new Application();
        instance.start();
    }

    public static Application getInstance() {
        return instance;
    }
}
