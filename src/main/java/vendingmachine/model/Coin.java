package vendingmachine.model;

import java.util.ArrayList;
import java.util.Collections;
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

    public static List<Integer> getChange(List<Integer> machineHoldingMoney, Integer amount) {
        List<Integer> result = new ArrayList<>();
        Collections.sort(machineHoldingMoney);
        for (Integer coin : machineHoldingMoney) {
            if (amount / coin > 0) {
                result.add(coin);
                amount %= coin;
            }
        }
        return result;
    }

    public static int getAmount(Coin coin) {
        return coin.amount;
    }
}
