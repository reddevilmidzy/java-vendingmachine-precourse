package vendingmachine.view;

import vendingmachine.model.Coin;

import java.util.Collections;
import java.util.List;

public class OutputView {
    public void printMachineHoldingMoney(List<Integer> machineHoldingMoney) {
        System.out.println("자판기가 보유한 동전");
        for (Coin coin : Coin.values()) {
            printMachineHoldingMoneySingle(machineHoldingMoney, coin);
        }
    }

    public void printChanges(List<Integer> changes) {
        System.out.println("잔돈");
        for (Coin coin : Coin.values()) {
            printChangesSingle(changes, coin);
        }
    }
    
    private void printMachineHoldingMoneySingle(List<Integer> machineHoldingMoney, Coin coin) {
        int coinCount = Coin.getAmount(coin);
        System.out.println(coinCount + "원 - " + Collections.frequency(machineHoldingMoney, coinCount) + "개");
    }

    private void printChangesSingle(List<Integer> changesAmount, Coin coin) {
        int changesCount = Collections.frequency(changesAmount, Coin.getAmount(coin));
        if (changesCount >= 0) {
            System.out.println(coin + "원 - " + changesCount + "개");
        }
    }
}
