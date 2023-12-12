package vendingmachine.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoldingAmount {

    private final Map<Coin, Integer> amountHeld;

    public HoldingAmount(Map<Coin, Integer> amountHeld) {
        this.amountHeld = amountHeld;
    }

    public static HoldingAmount from(List<Coin> coins) {
        Map<Coin, Integer> amountHeld = new HashMap<>();
        for (Coin coin : coins) {
            Integer value = amountHeld.getOrDefault(coin, 0);
            amountHeld.put(coin, value + 1);
        }
        return new HoldingAmount(amountHeld);
    }

    public int sum() {
        return amountHeld.keySet().stream()
                .mapToInt(coin -> coin.getAmount() * amountHeld.get(coin))
                .sum();
    }
}
