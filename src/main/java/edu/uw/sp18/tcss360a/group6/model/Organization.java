package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.annotations.Expose;
import edu.uw.sp18.tcss360a.group6.Bootstrap;

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
            this.contactPeople = Bootstrap.getInstance()
                    .getUserRepository().fetchAll().stream()
                    .filter(user -> user.getType() == UserType.CONTACT_PERSON)
                    .map(user -> (ContactPerson) user)
                    .filter(user -> user.getOrganizationId() == this.id)
                    .collect(Collectors.toList());
        }

        return this.contactPeople;
    }

    /**
     * Fetch a list of all Auctions that this organization has submitted.
     * @return list of type auction
     */
    public List<Auction> getAuctions() {
        if (this.auctions == null) {
            this.auctions = Bootstrap.getInstance()
                    .getAuctionRepository().fetchAll().stream()
                    .filter(auction -> auction.getOrganizationId() == this.id)
                    .collect(Collectors.toList());
        }

        return this.auctions;
    }

    /**
     * Return the current auction for this organization if possible.
     * @return current organization auction
     */
    public Auction getCurrentAuction() {
        LocalDate now = LocalDate.now();
        return getAuctions().stream()
                .filter(auction -> auction.getStartDate().isEqual(now)
                        || auction.getStartDate().isAfter(now))
                .findFirst().orElse(null);
    }

    /**
     * Get the auction within the last year for this organization.
     * @return auction withing the last year
     */
    public Auction getAuctionWithinLastYear() {
        LocalDate now = LocalDate.now();
        return getAuctions().stream()
                .filter(auction -> auction.getStartDate()
                        .isAfter(now.minusYears(1)))
                .findFirst().orElse(null);
    }

    /**
     * Get if the auction schedule has an opening. Returns true if successful.
     * @return bool if auction opening
     */
    public boolean isAuctionScheduleOpeningAvailable() {
        return Bootstrap.getInstance().getAuctionRepository()
                .fetchFutureAuctions().size() < Bootstrap.getInstance().
                getSettingsRepository().fetch().getAuctionCapacity();
    }

    /**
     * Attempt to add an auction to the AuctionRepository if possible.
     * For example must not have more than allowable auctions on one day and
     * more than allowable within the year etc...
     * @param auction Auction object to Auction repository
     * @return True if the auction added
     */
    public boolean addAuction(Auction auction) {
        boolean added = false;
        if (isAuctionScheduleOpeningAvailable()
                && getCurrentAuction() == null
                && getAuctionWithinLastYear() == null
                && Bootstrap.getInstance().getAuctionRepository().
                fetchFutureAuctions().size() <= Auction.MAX_UPCOMING_AUCTIONS) {
            Bootstrap.getInstance().getAuctionRepository()
                    .add(auction);
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
