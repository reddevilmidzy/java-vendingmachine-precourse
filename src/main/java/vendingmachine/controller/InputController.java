package vendingmachine.controller;

import java.util.List;
import vendingmachine.model.Amount;
import vendingmachine.model.Item;
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
                outputView.printErrorMessage(exception);
            }
        }
    }

    private Amount readAmount() {
        String value = inputView.readAmount();
        return Amount.from(value);
    }

    public List<Item> getItem() {
        while (true) {
            try {
                return readItem();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private List<Item> readItem() {
        String value = inputView.readItem();
        return Item.from(value);
    }
}
