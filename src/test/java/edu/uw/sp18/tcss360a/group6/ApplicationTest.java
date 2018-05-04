package edu.uw.sp18.tcss360a.group6;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationTest {

    @Before
    public void setUp() {
        Application.main();
    }

    @Test
    public void getInstance_NotNull_True() {
        assertNotNull(Application.getInstance());
    }

}
