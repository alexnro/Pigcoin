package org.lasencinas.transaction;

import java.security.PublicKey;

public class Transaction {

    private String hash = null;
    private String prev_hash = null;
    private PublicKey pKey_sender = null;
    private PublicKey pKey_recipient = null;
    private int pigcoins = 0;
    private String message = null;
    private byte[] signature = null;

    public Transaction(){}

    public Transaction(String hash, String prev_hash, PublicKey pKey_sender, PublicKey pKey_recipient, int pigcoins, String message) {
        this.hash = hash;
        this.prev_hash = prev_hash;
        this.pKey_sender = pKey_sender;
        this.pKey_recipient = pKey_recipient;
        this.pigcoins = pigcoins;
        this.message = message;
    }

    public String getHash() {
        return this.hash;
    }

    public String getPrev_hash() {
        return this.prev_hash;
    }

    public PublicKey getpKey_sender() {
        return this.pKey_sender;
    }

    public PublicKey getpKey_recipient() {
        return this.pKey_recipient;
    }

    public int getPigcoins() {
        return this.pigcoins;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        String toString = "\nhash = " + getHash() +
                            "\nprev_hash = " + getPrev_hash() +
                            "\npKey_sender = " + getpKey_sender().hashCode() +
                            "\npKey_recipient = " + getpKey_recipient().hashCode() +
                            "\npigcoins = " + getPigcoins() +
                            "\nmessage = " + getMessage();
        return toString;
    }
}
