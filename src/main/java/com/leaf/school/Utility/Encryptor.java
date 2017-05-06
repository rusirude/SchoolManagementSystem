package com.leaf.school.Utility;
/**
 * @Author : Rusiru De Silva
 */

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;


@Component
public class Encryptor {

    private static final String ALGORITHM = "SHA-256";
    public static final String CHARSET = "UTF-8";

    public String getHashCode(String inputValue) {
        String hashValue = null;
        if (inputValue != null && !inputValue.isEmpty()) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
                hashValue = String.format(Locale.US, "%x", new BigInteger(1, messageDigest.digest(inputValue.getBytes(CHARSET))));
            } catch (Exception e) {
                System.out.println("hash-" + e);//todo Rusiru
            }
        }
        return hashValue;
    }
}
