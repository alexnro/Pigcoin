package org.lasencinas.blockChainTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.lasencinas.blockChain.BlockChain;
import org.lasencinas.transaction.Transaction;
import org.lasencinas.wallet.Wallet;

public class BlockChainTest {

    @Test
    public void constructorTest() {
        BlockChain bc = new BlockChain();
        assertNotNull(bc);
    }

    @Test
    public void addOriginTransaction() {

        Wallet origin = new Wallet();
        origin.generateKeyPair();
        Wallet wallet_1 = new Wallet();
        wallet_1.generateKeyPair();

        BlockChain bc = new BlockChain();
        Transaction trx = new Transaction();
        trx = new Transaction("hash_1", "0", origin.getAddress(), wallet_1.getAddress(), 20, "pig things!");
        bc.addOrigin(trx);
        assertEquals(20, bc.getBlockChain().get(0).getPigcoins(), 0);
    }
}