package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinMaker {
    public static List<Integer> makeCoin(Integer vendingMachineAmount) {
        List<Integer> result = new ArrayList<>();
        while (vendingMachineAmount != 0) {
            int coin = Randoms.pickNumberInList(Coin.getCoins());
            if (vendingMachineAmount - coin >= 0) {
                vendingMachineAmount -= coin;
                result.add(coin);
            }
        }
        return result;
    }
}
