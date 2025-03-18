package com.hashapp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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

    // A long string of 1000 'a' characters
    @Test
    public void testForLongString() {
        HashGenerator hg = new HashGenerator();
        String input = "a".repeat(1000);
        String hash = hg.computeDigest(input);
        assertNotNull(hash);
        assertFalse(hash.isEmpty());
    }

    @Test
    public void testForSpecialCharacters() {
        HashGenerator hg = new HashGenerator();
        String hash = hg.computeDigest("!@#$%^&*()_+-=[]{}|;':,.<>?/~`");
        assertNotNull(hash);
        assertFalse(hash.isEmpty());
    }

    @Test
    public void testForNumbersOnly() {
        HashGenerator hg = new HashGenerator();
        String hash = hg.computeDigest("1234567890");
        assertNotNull(hash);
        assertFalse(hash.isEmpty());
    }

    @Test
    public void testForKannadaCharacters() {
        HashGenerator hg = new HashGenerator();
        String hash = hg.computeDigest("ಹಲೋ ವರ್ಲ್ಡ್"); //
        assertNotNull(hash);
        assertFalse(hash.isEmpty());
    }

    @Test
    public void testForMixedCaseStrings() {
        HashGenerator hg = new HashGenerator();
        String hash1 = hg.computeDigest("HelloWorld");
        String hash2 = hg.computeDigest("helloworld");
        assertFalse(hash1.equals(hash2));
    }
}
