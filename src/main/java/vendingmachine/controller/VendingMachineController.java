package vendingmachine.controller;

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

    public void run() {
        Integer vendingMachineAmount = inputView.inputVendingMachineAmount();
        List<Integer> machineHoldingMoney = CoinMaker.makeCoin(vendingMachineAmount);
        System.out.println(machineHoldingMoney.toString());
        outputView.printMachineHoldingMoney(machineHoldingMoney);
        List<Product> merchandises = inputView.inputMerchandise();
        Integer amount = inputView.inputAmount();
        //ToDo: 구매 가능할 떄까지 반복
        String ToBuyProduct = inputView.inputToBuyProduct();
        outputView.printChanges(machineHoldingMoney);
    }
}
