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
