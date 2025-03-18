package com.hashapp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class HashGeneratorTest {

    @Test
    public void testHash() {
        HashGenerator hg = new HashGenerator();
        String hash = hg.computeDigest("Hello World!");
        assertTrue(hash.equals("ed076287532e86365e841e92bfc50d8c"));
    }

    @Test
    public void testforNull() {
        HashGenerator hg = new HashGenerator();
        String hash = hg.computeDigest(null);
        assertTrue(hash.equals(""));
    }

    @Test
    public void testforEmptyString() {
        HashGenerator hg = new HashGenerator();
        String hash = hg.computeDigest("");
        assertTrue(hash.equals("d41d8cd98f00b204e9800998ecf8427e"));
    }
}
