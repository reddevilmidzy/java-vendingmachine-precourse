package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class HoldingAmount {

    private final Map<Coin, Integer> amountHeld;

    public HoldingAmount(Map<Coin, Integer> amountHeld) {
        this.amountHeld = amountHeld;
    }

    public static HoldingAmount from(List<Coin> coins) {
        Map<Coin, Integer> amountHeld = new LinkedHashMap<>();
        init(amountHeld);
        for (Coin coin : coins) {
            Integer value = amountHeld.get(coin);
            amountHeld.put(coin, value + 1);
        }
        return new HoldingAmount(amountHeld);
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
