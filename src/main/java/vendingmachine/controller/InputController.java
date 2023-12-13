package vendingmachine.controller;

import java.util.List;
import vendingmachine.model.Amount;
import vendingmachine.model.Item;
import vendingmachine.repository.ItemRepository;
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
        String value = inputView.readHoldingAmount();
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

    public Amount getInputAmount() {
        while (true) {
            try {
                return readInputAmount();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private Amount readInputAmount() {
        String value = inputView.readInputAmount();
        return Amount.from(value);
    }

    public Item getBuyItem() {
        while (true) {
            try {
                return readBuyItem();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private Item readBuyItem() {
        String value = inputView.readBuyItem();
        return ItemRepository.findByItemName(value);
    }
}
