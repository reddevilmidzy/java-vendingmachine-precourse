package vendingmachine.controller;

import java.util.List;
import vendingmachine.model.Amount;
import vendingmachine.model.HoldingAmount;
import vendingmachine.model.Item;
import vendingmachine.service.Exchange;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private final InputController inputController;
    private final OutputView outputView;

    public VendingMachineController(InputController inputController, OutputView outputView) {
        this.inputController = inputController;
        this.outputView = outputView;
    }

    public void run() {
        Amount machineHoldingAmount = inputController.getMachineHoldingAmount();
        Exchange exchange = new Exchange();
        HoldingAmount holdingAmount = exchange.exchangeCoin(machineHoldingAmount);
        outputView.printHoldingCoins(holdingAmount);
        List<Item> items = inputController.getItem();
        Amount inputAmount = inputController.getInputAmount();
    }
}
