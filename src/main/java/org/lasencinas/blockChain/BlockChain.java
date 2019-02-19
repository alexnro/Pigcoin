package org.lasencinas.blockChain;

import org.lasencinas.transaction.Transaction;

import java.util.*;

public class BlockChain {

    List<Transaction> blockChain = new LinkedList<>();

    public void addOrigin(Transaction transaction) {
        blockChain.add(transaction);
    }

    public void summarize() {
        for (Transaction transaction : blockChain) {
            System.out.println(transaction.toString());
        }
    }

    public void summarize(int position) {
        System.out.println(blockChain.get(position));
    }
}
