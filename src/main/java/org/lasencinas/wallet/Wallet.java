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

    public generateKeyPair() {
        GenSig.generateKeyPair();
    }

    public void setAddress(PublicKey address) {
        this.address = address;
    }

    public void setsKey(PrivateKey sKey) {
        this.sKey = sKey;
    }

    public PublicKey getAddress() {
        return this.address;
    }

    public PrivateKey getsKey() {
        return this.sKey;
    }

    public void loadCoins(double bChain) {
        //TODO
    }
}
