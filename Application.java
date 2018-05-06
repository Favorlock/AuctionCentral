package edu.uw.sp18.tcss360a.group6;

import java.util.List;
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
    private List<Long> auctionIds;
    private Bidder bidder;
    
    public void start() {
        TextIO textIO = TextIoFactory.getTextIO();
        
        String user = textIO.newStringInputReader()
                .read(new StringBuilder()
                        .append("Welcome to Auction Central, please enter your username\n")
                        .toString());

		final String finalUserName = user;
        bidder = this.bidderRepository.fetchAll().stream()
                .filter(b -> b.getUserName() != null && b.getUserName().equalsIgnoreCase(finalUserName))
                .findFirst().orElse(null);
        auctionIds = this.bidRepository.fetchAll().stream()
                .filter(bid -> bid.getBidderId() == bidder.getId())
                .map(Bid::getAuctionId)
                .collect(Collectors.toList());
        


        
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


		List<String> auctions = this.auctionRepository.fetchAll().stream()
                .map(Auction::toString)
                .collect(Collectors.toList());
    	
		String[] associatedAuctions = new String[auctions.size() + 2];
		associatedAuctions[0] = "Auctions that you have placed bids in:";
		for(int i = 0; i < auctions.size(); i++) {
		 
		}
		associatedAuctions[auctions.size() + 1] = "Please enter selection: ";
				int j = auctions.size();
				auctionOverview = theTextIO.newIntInputReader()
        		.withMinVal(1)
        		.withMaxVal(j)
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
