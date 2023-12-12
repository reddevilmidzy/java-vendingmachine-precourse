package vendingmachine.model;

import java.util.Arrays;
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
    public static List<Integer> findAllValue() {
        return Arrays.stream(Coin.values())
                .map(coin -> coin.amount)
                .toList();
    }

    public static Coin fromAmount(int amount) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.amount == amount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getAmount() {
        return amount;
    }
}
