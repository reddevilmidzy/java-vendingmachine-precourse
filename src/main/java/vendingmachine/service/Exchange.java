package vendingmachine.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import vendingmachine.model.Amount;
import vendingmachine.model.Coin;
import vendingmachine.model.HoldingAmount;

public class Exchange {

    public HoldingAmount exchangeCoin(Amount amount) {
        List<Integer> allValue = Coin.findAllValue();
        List<Coin> result = new ArrayList<>();
        while (amount.hasAmount()) {
            int coinAmount = pickRandom(allValue);
            if (amount.canChange(coinAmount)) {
                result.add(Coin.fromAmount(coinAmount));
                amount = amount.exchange(coinAmount);
            }
        }
        return HoldingAmount.from(result);
    }

    private int pickRandom(List<Integer> candidate) {
        return Randoms.pickNumberInList(candidate);
    }
}
