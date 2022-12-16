package vendingmachine.controller;

import vendingmachine.model.Coin;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;
import vendingmachine.model.CoinMaker;
import vendingmachine.model.Product;

import java.util.List;

public class VendingMachineController {
    private final InputView inputView;
    private final OutputView outputView;

    public VendingMachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        Integer vendingMachineAmount = inputView.inputVendingMachineAmount();
        List<Integer> machineHoldingMoney = CoinMaker.makeCoin(vendingMachineAmount);
        outputView.printMachineHoldingMoney(machineHoldingMoney);
        List<Product> merchandises = inputView.inputMerchandise();
        Integer amount = inputView.inputAmount();
        run(machineHoldingMoney, amount);
    }

    private void run(List<Integer> machineHoldingMoney, Integer amount) {
        while (Product.canBuy(amount)) {
            outputView.printAmount(amount);
            String toBuyProduct = inputView.inputToBuyProduct();
            Product.buy(toBuyProduct);
            amount -= Product.getPrice(toBuyProduct);
        }
        giveChange(machineHoldingMoney, amount);
    }

    private void giveChange(List<Integer> machineHoldingMoney, Integer amount) {
        outputView.printAmount(amount);
        List<Integer> change = Coin.getChange(machineHoldingMoney, amount);
        outputView.printChanges(change);
    }
}
