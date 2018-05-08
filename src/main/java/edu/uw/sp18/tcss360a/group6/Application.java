package edu.uw.sp18.tcss360a.group6;

import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.*;
import edu.uw.sp18.tcss360a.group6.ui.BidderMenuPrompt;
import edu.uw.sp18.tcss360a.group6.ui.ContactPersonMenuPrompt;
import edu.uw.sp18.tcss360a.group6.ui.LoginPrompt;

/**
 * Run the Auction central interface and perform the necessary business logic.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class Application {

    private static Application instance;

    private Console console = new Console();

    private AuctionRepository auctionRepository;

    private BidRepository bidRepository;

    private UserRepository userRepository;

    private ItemRepository itemRepository;

    private boolean running = true;

    public Application() {
        this(true);
    }

    public Application(boolean saveDefaultsIfMissing) {
        instance = this;
        __init(saveDefaultsIfMissing);
    }

    public void start() {
        while (this.running) {
            // Context to use through lifetime of a user session
            Context context = new Context();
            // Prompts a user to login and retrieves valid user
            LoginPrompt loginPrompt = new LoginPrompt(context);
            loginPrompt.start();
            // Fetch the user from the context
            User user = context.get("user", User.class);

            this.console.printfln("Hello %s.", user.getUserName());
            // Prompt user with menu options
            if (user.getType() == UserType.BIDDER) {
                BidderMenuPrompt bidderMenuPrompt = new BidderMenuPrompt(context);
                bidderMenuPrompt.start();
            } else if (user.getType() ==  UserType.CONTACT_PERSON) {
                ContactPersonMenuPrompt contactMenuPrompt = new ContactPersonMenuPrompt(context);
                contactMenuPrompt.start();
            }
        }
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

    public BidRepository getBidRepository() {
        return bidRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public ItemRepository getItemRepository() { return itemRepository; }

    private void __init(boolean saveDefaultsIfMissing) {
        __loadRepositories(saveDefaultsIfMissing);
    }

    private void __loadRepositories(boolean saveDefaultsIfMissing) {
        this.auctionRepository = AuctionRepository.load(saveDefaultsIfMissing);
        this.itemRepository = ItemRepository.load(saveDefaultsIfMissing);
        this.bidRepository = BidRepository.load(saveDefaultsIfMissing);
        this.userRepository = UserRepository.load(saveDefaultsIfMissing);
    }

    public static void main(String... args) {
        new Application().start();
    }

    public static Application getInstance() {
        return instance;
    }
}