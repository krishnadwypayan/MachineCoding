package service;

import model.Wallet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Krishna Kota on 11/05/21
 */
public class Offer1 implements IOfferService {

    private Map<Wallet, Object> locks = new ConcurrentHashMap<>();

    @Override
    public void offer(Wallet from, Wallet to) {
        if (from.getBalance() == to.getBalance()) {
            synchronized (locks.computeIfAbsent(from, k -> new Object())) {
                from.credit(10);
            }
            synchronized (locks.computeIfAbsent(to, k -> new Object())) {
                to.credit(10);
            }
        }
    }
}
