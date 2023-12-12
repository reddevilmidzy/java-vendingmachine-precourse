package vendingmachine.controller;

import vendingmachine.model.Amount;
import vendingmachine.model.HoldingAmount;
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
        Amount amount = inputController.getMachineHoldingAmount();
        Exchange exchange = new Exchange();
        HoldingAmount holdingAmount = exchange.exchangeCoin(amount);
        outputView.printHoldingCoins(holdingAmount);

    }
}
