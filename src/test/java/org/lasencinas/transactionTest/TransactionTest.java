package org.lasencinas.transactionTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.lasencinas.transaction.Transaction;
import org.lasencinas.wallet.Wallet;

public class TransactionTest {

    /**
     * Crear clase transaction
     */
    @Test
    public void constructor_test() {

        Transaction trx = new Transaction();
        assertNotNull(trx);

        Wallet wallet_1 = new Wallet();
        wallet_1.generateKeyPair();
        Wallet wallet_2 = new Wallet();
        wallet_2.generateKeyPair();

        trx = new Transaction("hash_1", "0", wallet_1.getAddress(), wallet_2.getAddress(), 20, "spam spam spam");
        assertNotNull(trx);
        assertTrue(trx.getpKey_sender().equals(wallet_1.getAddress()));
        assertTrue(trx.getpKey_recipient().equals(wallet_2.getAddress()));
        assertEquals(20, trx.getPigcoins(), 0);
        assertTrue(trx.getMessage().equals("spam spam spam"));
    }



}