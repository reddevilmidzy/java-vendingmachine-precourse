package vendingmachine.view;

import vendingmachine.model.Coin;

import java.util.Collections;
import java.util.List;

public class OutputView {
    public void printMachineHoldingMoney(List<Integer> machineHoldingMoney) {
        System.out.println("자판기가 보유한 동전");
        printMachineHoldingMoneySingle(machineHoldingMoney, Coin.COIN_500);
        printMachineHoldingMoneySingle(machineHoldingMoney, Coin.COIN_100);
        printMachineHoldingMoneySingle(machineHoldingMoney, Coin.COIN_50);
        printMachineHoldingMoneySingle(machineHoldingMoney, Coin.COIN_10);
    }

    public void printChanges(List<Integer> changes) {
        System.out.println("잔돈");
        printChangesSingle(changes, Coin.COIN_500);
        printChangesSingle(changes, Coin.COIN_100);
        printChangesSingle(changes, Coin.COIN_50);
        printChangesSingle(changes, Coin.COIN_10);
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
