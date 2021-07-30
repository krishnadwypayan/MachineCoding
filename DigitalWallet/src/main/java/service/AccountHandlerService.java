package service;

import exceptions.AccountNotFoundException;
import exceptions.InvalidAmountException;
import model.Statement;
import model.Transaction;
import model.Wallet;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Krishna Kota on 11/05/21
 */
public class AccountHandlerService {

    private Map<String, Wallet> accounts = new HashMap<>();
    private Map<String, Object> locks = new ConcurrentHashMap<>();
    private IOfferService offerService;

    public AccountHandlerService(IOfferService offerService) {
        this.offerService = offerService;
    }

    public Wallet createWallet(String name, double balance) {
        if (accounts.containsKey(name)) {
            accounts.put(name, new Wallet(balance));
        }
        return accounts.get(name);
    }

    public void transferMoney(String from, String to, double amount) throws AccountNotFoundException, InvalidAmountException {
        Wallet fromWallet = accounts.get(from);
        Wallet toWallet = accounts.get(to);
        if (fromWallet == null || toWallet == null) {
            throw new AccountNotFoundException();
        }

        if (fromWallet.getBalance() < amount || amount < 0.0001) {
            throw new InvalidAmountException();
        }

        synchronized (locks.computeIfAbsent(from, k -> new Object())) {
            fromWallet.debit(amount);
        }
        synchronized (locks.computeIfAbsent(to, k -> new Object())) {
            toWallet.credit(amount);
        }

        Transaction transaction = new Transaction(from, to, amount);
        fromWallet.getStatement().getTransactions().add(transaction);
        toWallet.getStatement().getTransactions().add(transaction);

        offerService.offer(fromWallet, toWallet);
    }

    public Statement getStatement(String name) throws AccountNotFoundException {
        Wallet wallet = accounts.get(name);
        if (wallet == null) {
            throw new AccountNotFoundException();
        }

        return wallet.getStatement();
    }

    public void getOverview() {
        for (String key : accounts.keySet()) {
            System.out.println(key + " " + accounts.get(key).getBalance());
        }
    }

    public void offer2() {
        PriorityQueue<Wallet> pq = new PriorityQueue<>((a, b) -> {
            int asz = a.getStatement().getTransactions().size();
            int bsz = b.getStatement().getTransactions().size();
            if (asz == bsz) {
                if (a.getBalance() == b.getBalance()) {
                    return b.getCreatedAt().compareTo(a.getCreatedAt());
                }
                return Double.compare(b.getBalance(), a.getBalance());
            }
            return bsz - asz;
        });

        for (String key : accounts.keySet()) {
            pq.offer(accounts.get(key));
        }

        int[] offer = {10, 5, 2};
        int o = 0;
        for (int i = 0; i < Math.min(pq.size(), 3); i++) {
            Wallet wallet = pq.poll();
            wallet.credit(offer[o++]);
        }
    }
}
