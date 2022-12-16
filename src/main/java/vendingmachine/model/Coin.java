package vendingmachine.model;

import java.util.ArrayList;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public static List<Integer> getCoins() {
        List<Integer> result = new ArrayList<>();
        for (Coin coin : Coin.values()) {
            result.add(coin.amount);
        }
        return result;
    }

    public static int getAmount(Coin coin) {
        return coin.amount;
    }
}
