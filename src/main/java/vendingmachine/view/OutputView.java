package vendingmachine.view;

import vendingmachine.model.HoldingAmount;

public class OutputView {

    public static final String HOLDING_COIN_FORM = "%d원 - %d개%n";

    public void printHoldingCoins(HoldingAmount amount) {
        System.out.println("자판기가 보유한 동전");
        amount.forEach((coin, count) ->
                System.out.printf(HOLDING_COIN_FORM, coin.getAmount(), count));
        System.out.println();
    }
}
