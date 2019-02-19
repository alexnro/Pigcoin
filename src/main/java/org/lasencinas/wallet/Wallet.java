package org.lasencinas.wallet;

import org.lasencinas.blockChain.BlockChain;
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
        return this.total_input;
    }

    public double getTotal_output() {
        return this.total_output;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setTotal_input(double total_input) {
        this.total_input += total_input;
    }

    public void setTotal_output(double total_output) {
        this.total_output += total_output;
    }

    public void setBalance(double balance) {
        this.balance += getTotal_input() - getTotal_output();
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

    public void loadCoins(BlockChain bChain) {
        for(Transaction transaction : bChain.getBlockChain()) {
            if(transaction.getpKey_recipient() == this.getAddress()) {
                total_input += transaction.getPigcoins();
            } else if(transaction.getpKey_sender() == this.getAddress()) {
                total_output += transaction.getPigcoins();
            }
        }
        balance += total_input - total_output;
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