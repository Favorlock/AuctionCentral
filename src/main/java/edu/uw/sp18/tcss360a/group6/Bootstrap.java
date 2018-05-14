package edu.uw.sp18.tcss360a.group6;

import edu.uw.sp18.tcss360a.group6.model.*;

public class Bootstrap {

    private static Bootstrap instance;

    private OrganizationRepository organizationRepository;

    private AuctionRepository auctionRepository;

    private BidRepository bidRepository;

    private UserRepository userRepository;

    private ItemRepository itemRepository;

    public Bootstrap() {
        this(true);
    }

    public Bootstrap(boolean saveDefaultsIfMissing) {
        instance = this;
        __init(saveDefaultsIfMissing);
    }

    public OrganizationRepository getOrganizationRepository() {
        return organizationRepository;
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

    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    private void __init(boolean saveDefaultsIfMissing) {
        __loadRepositories(saveDefaultsIfMissing);
    }

    private void __loadRepositories(boolean saveDefaultsIfMissing) {
        this.organizationRepository = OrganizationRepository.load(saveDefaultsIfMissing);
        this.auctionRepository = AuctionRepository.load(saveDefaultsIfMissing);
        this.itemRepository = ItemRepository.load(saveDefaultsIfMissing);
        this.bidRepository = BidRepository.load(saveDefaultsIfMissing);
        this.userRepository = UserRepository.load(saveDefaultsIfMissing);
    }

    public static Bootstrap getInstance() {
        return instance;
    }
}
