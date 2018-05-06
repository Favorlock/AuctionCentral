package edu.uw.sp18.tcss360a.group6;

import java.awt.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

import edu.uw.sp18.tcss360a.group6.model.AuctionRepository;
import edu.uw.sp18.tcss360a.group6.model.BidRepository;
import edu.uw.sp18.tcss360a.group6.model.BidderRepository;

public class Application {

	
    private static Application instance;
    private int selection;
    private java.util.List<Integer> auctionOverview;
	private BidderRepository bidderRepository;
	private BidRepository bidRepository;
	private AuctionRepository auctionRepository;
    
    public void start() {
        TextIO textIO = TextIoFactory.getTextIO();
        
        String user = textIO.newStringInputReader()
                .read(new StringBuilder()
                        .append("Welcome to Auction Central, please enter your username\n")
                        .toString());


        
        selectionPrompt(textIO);
        switch (selection) {
        	case 1:
        		
                overViewPrompt(textIO);
        		break;
        	case 2:
        		
        		break;
        	case 3:
        		
        		break;
        	case 4:
        		
        		break;
        }

        textIO.dispose();
    }

    private void selectionPrompt(TextIO theTextIO) {
        selection = theTextIO.newIntInputReader()
                .withMinVal(1)
                .withMaxVal(4)
                .read(new StringBuilder()
                        .append("What would you like to do?\n")
                        .append("1) View brief overview of all auctions I have placed bids in\n")
                        .append("2) View all items I have bid on in all auctions\n")
                        .append("3) View in brief all auctions I can bid on\n")
                        .append("4) Logout\n")
                        .toString());
        
	}

	private void overViewPrompt(TextIO theTextIO) {
    	
		String[] associatedAuctions = new String[3];
		associatedAuctions[0] = "yup";
		associatedAuctions[1] = "nope";
		associatedAuctions[2] = "maybe";
				auctionOverview = theTextIO.newIntInputReader()
        		.withMinVal(1)
        		.withMaxVal(4)
        		.readList(associatedAuctions);
	}

	public static void main(String... args) {
        instance = new Application();
        instance.start();
    }

    public static Application getInstance() {
        return instance;
    }
}
