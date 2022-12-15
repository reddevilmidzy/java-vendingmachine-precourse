package vendingmachine.view;

import vendingmachine.model.Coin;

import java.util.Collections;
import java.util.List;

public class OutputView {
    public void printMachineHoldingMoney(List<Integer> machineHoldingMoney) {
        System.out.println("자판기가 보유한 동전");
        System.out.println("500원 - " + Collections.frequency(machineHoldingMoney, Coin.COIN_500) + "개");
        System.out.println("100원 - " + Collections.frequency(machineHoldingMoney, Coin.COIN_100) + "개");
        System.out.println("50원 - " + Collections.frequency(machineHoldingMoney, Coin.COIN_50) + "개");
        System.out.println("10원 - " + Collections.frequency(machineHoldingMoney, Coin.COIN_10) + "개");
    }

    public void printChanges(List<Integer> changes) {
        System.out.println("잔돈");
        printChangesSingle(changes, Coin.COIN_500);
        printChangesSingle(changes, Coin.COIN_100);
        printChangesSingle(changes, Coin.COIN_50);
        printChangesSingle(changes, Coin.COIN_10);
    }

    private void printChangesSingle(List<Integer> changesAmount, Coin coin) {
        int changesCount = Collections.frequency(changesAmount, coin);
        if (changesCount >= 0) {
            System.out.println(coin + "원 - " + changesCount + "개");
        }
    }
}
