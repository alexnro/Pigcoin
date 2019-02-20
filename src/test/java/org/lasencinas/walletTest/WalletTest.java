package org.lasencinas.walletTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;
import org.lasencinas.blockChain.BlockChain;
import org.lasencinas.transaction.Transaction;
import org.lasencinas.wallet.Wallet;

public class WalletTest {

    @Test
    public void constructor_test() {
        Wallet wallet = new Wallet();
        assertNotNull(wallet);
    }

    @Test
    public void generate_key_pair_test() {
        Wallet wallet = new Wallet();
        assertNotNull(wallet);
        wallet.generateKeyPair();
        assertNotNull(wallet.getAddress());
        assertNotNull(wallet.getSKey());
    }

    @Test
    public void generateSk_test() {
        // problema al testear Gava desde Junit => hacerlo desde main App
        // wallet.generateSk("gelpiorama@gmail.com");
    }

    @Test
    public void total_pigcoins_input_y_output_test() {

        Wallet origin = new Wallet();
        origin.generateKeyPair();
        Wallet wallet_1 = new Wallet();
        wallet_1.generateKeyPair();
        Wallet wallet_2 = new Wallet();
        wallet_2.generateKeyPair();

        BlockChain bChain = new BlockChain();
        Transaction trx = new Transaction("hash_1", "0", origin.getAddress(), wallet_1.getAddress(), 20, "a flying pig!");
        bChain.addOrigin(trx);
        trx = new Transaction("hash_2", "1", origin.getAddress(), wallet_2.getAddress(), 10, "pig things!");
        bChain.addOrigin(trx);

        wallet_1.loadCoins(bChain);
        assertEquals(20, wallet_1.getTotal_input(), 0);
        assertEquals(0, wallet_1.getTotal_output(), 0);
        assertEquals(20, wallet_1.getBalance(), 0);

        wallet_2.loadCoins(bChain);
        assertEquals(10, wallet_2.getTotal_input(), 0);
        assertEquals(0, wallet_2.getTotal_output(), 0);
        assertEquals(10, wallet_2.getBalance(), 0);

        // una wallet que no existe
        Wallet wallet_3 = new Wallet();
        wallet_3.generateKeyPair();
        wallet_3.loadCoins(bChain);
        assertEquals(0, wallet_3.getTotal_input(), 0);
        assertEquals(0, wallet_3.getTotal_output(), 0);
        assertEquals(0, wallet_3.getBalance(), 0);
    }

    @Test
    public void load_input_transactions_test() {

        Wallet origin = new Wallet();
        origin.generateKeyPair();
        Wallet wallet_1 = new Wallet();
        wallet_1.generateKeyPair();
        Wallet wallet_2 = new Wallet();
        wallet_2.generateKeyPair();
        Wallet wallet_3 = new Wallet();
        wallet_3.generateKeyPair();

        BlockChain bChain = new BlockChain();
        Transaction trx = new Transaction("hash_1", "0", origin.getAddress(), wallet_1.getAddress(), 20, "a flying pig!");
        bChain.addOrigin(trx);
        trx = new Transaction("hash_2", "1", origin.getAddress(), wallet_2.getAddress(), 10, "pig things!");
        bChain.addOrigin(trx);

        wallet_1.loadInputTransactions(bChain);
        assertTrue(wallet_1.getInputTransactions().size() == 1);
        assertTrue(wallet_1.getInputTransactions().get(0).getPigcoins() == 20);

        wallet_2.loadInputTransactions(bChain);
        assertTrue(wallet_2.getInputTransactions().size() == 1);
        assertTrue(wallet_2.getInputTransactions().get(0).getPigcoins() == 10);

        wallet_3.loadInputTransactions(bChain);
        assertTrue(wallet_3.getInputTransactions().size() == 0);
    }

    @Test
    public void collect_coins_test() {

        Wallet origin = new Wallet();
        origin.generateKeyPair();
        Wallet wallet = new Wallet();
        wallet.generateKeyPair();

        BlockChain bChain = new BlockChain();
        Transaction transaction = new Transaction("hash_1", "0", origin.getAddress(), wallet.getAddress(), 20, "a flying pig!");
        assertTrue(transaction.getHash().equals("hash_1"));
        bChain.addOrigin(transaction);
        transaction = new Transaction("hash_2", "1", origin.getAddress(), wallet.getAddress(), 10, "pig things!");
        assertTrue(transaction.getHash().equals("hash_2"));
        bChain.addOrigin(transaction);

        wallet.loadInputTransactions(bChain);
        assertTrue(wallet.getInputTransactions().size() == 2);
        assertTrue(wallet.getInputTransactions().get(0).getPigcoins() == 20);
        assertTrue(wallet.getInputTransactions().get(1).getPigcoins() == 10);

        wallet.loadCoins(bChain);
        assertEquals(30, wallet.getTotal_input(), 0);
        assertEquals(0, wallet.getTotal_output(), 0);
        assertEquals(30, wallet.getBalance(), 0);
    }

    @Test
    public void send_transaction_test() {

        Wallet origin = new Wallet();
        origin.generateKeyPair();
        Wallet wallet_1 = new Wallet();
        wallet_1.generateKeyPair();
        Wallet wallet_2 = new Wallet();
        wallet_2.generateKeyPair();

        BlockChain bChain = new BlockChain();
        Transaction transaction = new Transaction("hash_1", "0", origin.getAddress(), wallet_1.getAddress(), 20, "a flying pig!");
        bChain.addOrigin(transaction);
        transaction = new Transaction("hash_2", "1", origin.getAddress(), wallet_2.getAddress(), 10, "pig things!");
        bChain.addOrigin(transaction);

        wallet_1.loadCoins(bChain);
        assertEquals(20, wallet_1.getTotal_input(), 0);
        assertEquals(0, wallet_1.getTotal_output(), 0);
        assertEquals(20, wallet_1.getBalance(), 0);
        wallet_1.loadInputTransactions(bChain);
        assertTrue(wallet_1.getInputTransactions().size() == 1);

        wallet_2.loadCoins(bChain);
        assertEquals(10, wallet_2.getTotal_input(), 0);
        //assertEquals(0, wallet_2.getTotal_input(), 0);
        assertEquals(10, wallet_2.getBalance(), 0);
        wallet_2.loadInputTransactions(bChain);
        assertTrue(wallet_2.getInputTransactions().size() == 1);
    }
}