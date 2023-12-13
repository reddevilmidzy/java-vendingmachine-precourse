package vendingmachine.view;

import vendingmachine.model.Amount;
import vendingmachine.model.HoldingAmount;

public class OutputView {

    public static final String HOLDING_COIN_FORM = "%d원 - %d개%n";
    public static final String ERROR_FORM = "[ERROR] %s%n";
    public static final String INPUT_AMOUNT_FORM = "투입 금액: %s원%n";


    public void printHoldingCoins(HoldingAmount amount) {
        System.out.println("자판기가 보유한 동전");
        amount.forEach((coin, count) ->
                System.out.printf(HOLDING_COIN_FORM, coin.getAmount(), count));
        System.out.println();
    }

    public void printErrorMessage(Throwable throwable) {
        System.out.printf(ERROR_FORM, throwable.getMessage());
    }

    public void printCurrentInputAmount(Amount amount) {
        System.out.printf(INPUT_AMOUNT_FORM, amount.getAmount());
    }
}
