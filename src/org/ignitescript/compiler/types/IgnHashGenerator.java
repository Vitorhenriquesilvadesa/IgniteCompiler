package org.ignitescript.compiler.types;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class IgnHashGenerator {
    public static String next(Object o) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest((Integer.toString(o.hashCode()) + Long.toString(System.currentTimeMillis()).hashCode()).getBytes());
            StringBuilder sb = new StringBuilder();
            sb.append("@ign_");

            for (int i = 0; i < hashBytes.length; i+=(int) hashBytes.length/8) {
                sb.append(String.format("%02x", hashBytes[i]));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
