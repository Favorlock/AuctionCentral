package edu.uw.sp18.tcss360a.group6.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/11/2018
 */
public class ContactPersonTest {
    ContactPerson contactPerson;
    long contactPersonID;
    long contactPersonOrganizationID;
    String contactPersonUserName;
    @Before
    public void setUp() {
        contactPersonID = 1;
        contactPersonOrganizationID = 1;
        contactPersonUserName = "Joseph";
        contactPerson = new ContactPerson(contactPersonID,
                contactPersonOrganizationID, contactPersonUserName);

    }

    @Test
    public void getOrganizationID_testRightID_True() {
        assertEquals(contactPersonOrganizationID, contactPerson.getOrganizationId());
    }
    @Test
    public void getOrganizationID_testWrongID_false() {
        assertNotEquals(contactPersonOrganizationID, contactPerson.getOrganizationId());
    }

    @Test
    public void getOrganization_testGettingRightOrganizationName_True() {
        assertEquals("UNICEF", contactPerson.getOrganization().getName());
    }

}
