package vendingmachine.controller;

import vendingmachine.model.Amount;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class InputController {

    private final InputView inputView;
    private final OutputView outputView;


    public InputController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Amount getMachineHoldingAmount() {
        while (true) {
            try {
                return readAmount();
            } catch (IllegalArgumentException exception) {
                //TODO: 예외 메시지 출력
            }
        }
    }

    private Amount readAmount() {
        String value = inputView.readAmount();
        return Amount.from(value);
    }
}
