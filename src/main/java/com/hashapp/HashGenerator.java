package com.hashapp;

import java.security.MessageDigest;

/**
 * Hello world!
 *
 */
public class HashGenerator {

    public String computeDigest(String input) {
        // generate md5 hash of input string
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HashGenerator hg = new HashGenerator();
        System.out.println(hg.computeDigest("Hello World!"));
    }
}