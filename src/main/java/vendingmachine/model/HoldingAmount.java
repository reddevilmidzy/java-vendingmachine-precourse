package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class HoldingAmount {

    private final Map<Coin, Integer> amountHeld;

    private HoldingAmount(Map<Coin, Integer> amountHeld) {
        this.amountHeld = amountHeld;
    }

    public static HoldingAmount amountHeldFrom(List<Coin> coins) {
        Map<Coin, Integer> amountHeld = new LinkedHashMap<>();
        init(amountHeld);
        for (Coin coin : coins) {
            Integer value = amountHeld.get(coin);
            amountHeld.put(coin, value + 1);
        }
        return new HoldingAmount(amountHeld);
    }

    public HoldingAmount changes(Amount amount) {
        Map<Coin, Integer> result = new LinkedHashMap<>();
        if (sum() < amount.getAmount()) {
            containsAll(result);
            return new HoldingAmount(result);
        }
        changesGreedy(amount, result);
        return new HoldingAmount(result);
    }

    private void changesGreedy(Amount amount, Map<Coin, Integer> result) {
        int currentAmount = amount.getAmount();
        for (Coin coin : amountHeld.keySet()) {
            if (amountHeld.get(coin) == 0) {
                continue;
            }
            int tmp = coin.getAmount() * amountHeld.get(coin);
            if (currentAmount >= tmp) {
                result.put(coin, amountHeld.get(coin));
                currentAmount -= tmp;
                continue;
            }
            result.put(coin, currentAmount / coin.getAmount());
            currentAmount %= coin.getAmount();
        }
    }

    private void containsAll(Map<Coin, Integer> result) {
        for (Coin coin : amountHeld.keySet()) {
            if (amountHeld.get(coin) > 0) {
                result.put(coin, amountHeld.get(coin));
            }
        }
    }


    public static HoldingAmount changesFrom(Amount amount) {
        Map<Coin, Integer> changes = new LinkedHashMap<>();
        init(changes);
        int currentAmount = amount.getAmount();
        for (Coin coin : Coin.values()) {
            if ((currentAmount / coin.getAmount()) > 0) {
                changes.put(coin, currentAmount % coin.getAmount());
                currentAmount %= coin.getAmount();
            }
        }

        return new HoldingAmount(changes);
    }

    private static void init(Map<Coin, Integer> amountHeld) {
        amountHeld.put(Coin.COIN_500, 0);
        amountHeld.put(Coin.COIN_100, 0);
        amountHeld.put(Coin.COIN_50, 0);
        amountHeld.put(Coin.COIN_10, 0);
    }

    public int sum() {
        return amountHeld.keySet().stream()
                .mapToInt(coin -> coin.getAmount() * amountHeld.get(coin))
                .sum();
    }

    public void forEach(BiConsumer<? super Coin, ? super Integer> action) {
        amountHeld.forEach(action);
    }
}
