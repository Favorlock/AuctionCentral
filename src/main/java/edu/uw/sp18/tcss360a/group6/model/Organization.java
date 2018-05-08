package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.annotations.Expose;
import edu.uw.sp18.tcss360a.group6.Application;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Organization represents an Auction with the respective contact person.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class Organization {

    @Expose
    protected long id;

    @Expose
    private String name;

    private List<ContactPerson> contactPeople;

    private List<Auction> auctions;

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<ContactPerson> getContactPeople() {
        if (this.contactPeople == null) {
            this.contactPeople = Application.getInstance().getUserRepository().fetchAll().stream()
                    .filter(user -> user.getType() == UserType.CONTACT_PERSON)
                    .map(user -> (ContactPerson) user)
                    .filter(user -> user.getOrganizationId() == this.id)
                    .collect(Collectors.toList());
        }

        return this.contactPeople;
    }

    public List<Auction> getAuctions() {
        if (this.auctions == null) {
            this.auctions = Application.getInstance().getAuctionRepository().fetchAll().stream()
                    .filter(auction -> auction.getOrganizationId() == this.id)
                    .collect(Collectors.toList());
        }

        return this.auctions;
    }

    public Auction getCurrentAuction() {
        LocalDate now = LocalDate.now();
        return getAuctions().stream()
                .filter(auction -> auction.getStartDate().isEqual(now)
                        || auction.getStartDate().isAfter(now))
                .findFirst().orElse(null);
    }

    public Auction getAuctionWithinLastYear() {
        LocalDate now = LocalDate.now();
        return getAuctions().stream()
                .filter(auction -> auction.getStartDate().isAfter(now.minusYears(1)))
                .findFirst().orElse(null);
    }

    public boolean addAuction(Auction auction) {
        boolean added = false;
        if (getCurrentAuction() == null && getAuctionWithinLastYear() == null) {
            Application.getInstance().getAuctionRepository().add(auction);
            getAuctions().add(auction);
            added = true;
        }
        return added;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
