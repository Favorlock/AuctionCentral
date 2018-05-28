package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.annotations.Expose;
import edu.uw.sp18.tcss360a.group6.Bootstrap;

/**
 * Represents a ContactPerson user and the methods they are able to perform
 * adding inventory to auctions, scheduling auctions, and viewing items
 * they have submitted.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class ContactPerson extends AbstractUser {

    @Expose
    private long organizationId;

    private Organization organization;

    public ContactPerson(long id, long organizationId, String userName) {
        super(UserType.CONTACT_PERSON, id, userName);
        this.organizationId = organizationId;
    }

    /**
     * Get the organizationId for this contact person.
     * @return organizationId of this contact person
     */
    public long getOrganizationId() {
        return this.organizationId;
    }

    /**
     * Get the contact persons organization from the organization repository.
     * @return the Organization for this contact person
     */
    public Organization getOrganization() {
        if (this.organization == null) {
            this.organization = Bootstrap.getInstance().getOrganizationRepository().fetchAll().stream()
                    .filter(org -> org.getId() == this.organizationId)
                    .findFirst().orElse(null);
        }

        return this.organization;
    }
}
