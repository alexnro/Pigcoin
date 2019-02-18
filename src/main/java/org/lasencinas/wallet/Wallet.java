package org.lasencinas.wallet;

import org.lasencinas.genSig.GenSig;
import org.lasencinas.transaction.Transaction;

import java.security.PrivateKey;
import java.security.PublicKey;

public class Wallet {

    private PublicKey address = null;
    private PrivateKey sKey = null;
    private double total_input = 0;
    private double total_output = 0;
    private double balance = 0;
    private Transaction inputTransactions = null;
    private Transaction outputTransactions = null;

    public double getTotal_input() {
        return total_input;
    }

    public double getTotal_output() {
        return total_output;
    }

    public double getBalance() {
        return balance;
    }

    public void generateKeyPair() {
        setAddress(GenSig.generateKeyPair().getPublic());
        setSK(GenSig.generateKeyPair().getPrivate());
    }

    public void setAddress(PublicKey address) {
        this.address = address;
    }

    public void setSK(PrivateKey sKey) {
        this.sKey = sKey;
    }

    public PublicKey getAddress() {
        return this.address;
    }

    public PrivateKey getSKey() {
        return this.sKey;
    }

    public void loadCoins() {
        //TODO
    }

    public void loadInputTransactions() {
        //TODO
    }

    public void sendCoins() {
        //TODO
    }

    @Override
    public String toString() {
        String toString = "\nWallet = " + getAddress().hashCode() +
                            "\nTotal input = " + getTotal_input() +
                            "\nTotal output = " + getTotal_output() +
                            "\nBalance = " + getBalance() + "\n";
        return toString;
    }
}
