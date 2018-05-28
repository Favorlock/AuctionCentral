package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.annotations.Expose;

/**
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class Settings {

    @Expose
    private int auctionCapacity;

    @Expose
    private int inventoryCapacity;

    public int getAuctionCapacity() {
        return this.auctionCapacity;
    }

    public void setAuctionCapacity(int auctionCapacity) {
        this.auctionCapacity = auctionCapacity;
    }

    public int getInventoryCapacity() {
        return this.inventoryCapacity;
    }

    public void setInventoryCapacity(int inventoryCapacity) {
        this.inventoryCapacity = inventoryCapacity;
    }
}
