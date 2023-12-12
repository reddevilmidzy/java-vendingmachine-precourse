package vendingmachine;

import vendingmachine.controller.InputController;
import vendingmachine.controller.VendingMachineController;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputController inputController = new InputController(inputView, outputView);
        VendingMachineController vendingMachineController = new VendingMachineController(inputController, outputView);
        vendingMachineController.run();
    }
}
