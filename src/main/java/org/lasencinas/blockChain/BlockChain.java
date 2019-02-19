package org.lasencinas.blockChain;

import org.lasencinas.transaction.Transaction;

import java.util.HashSet;
import java.util.Set;

public class BlockChain {

    Set<Transaction> blockChain = new HashSet<Transaction>();

    public void addOrigin(Transaction transaction) {
        blockChain.add(transaction);
    }

    public void summarize() {
        for (Transaction transaction : blockChain) {
            System.out.println(transaction.toString());
        }
    }
}
