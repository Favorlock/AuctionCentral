package edu.uw.sp18.tcss360a.group6;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * InterfaceLogin has methods to display a login message to a user and
 * a method that checks if that user is a valid user of the system.
 */
public class InterfaceLogin {


    public InterfaceLogin() {
    }

    /**
     *
     * @return String to welcome the user and prompt for their username
     */
    public String displayLogin() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date todaysDate = new Date();
        String welcomeMessage = "\nWelcome To Auction Central " +
                dateFormat.format(todaysDate) + " \nEnter your user name: ";
        return welcomeMessage;

    }

    /**
     * Check is the given String is a valid user in the passed in list of
     * bidders.
     *
     * @return true is a valid user, false otherwise
     */
    public boolean isValidUser(String userName,
                               List<Bidder> listOfBidders) {
        Boolean foundBidder = false;
        for (Bidder aBidder : listOfBidders) {
            if(aBidder.getUserName().equals(userName)) {
                foundBidder = true;
            }
        }
        return foundBidder;
    }

}
