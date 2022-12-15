package vendingmachine.controller;

import vendingmachine.View.InputView;
import vendingmachine.model.Product;

import java.util.List;

public class VendingMachineController {
    private final InputView inputView;

    public VendingMachineController() {
        this.inputView = new InputView();
    }

    public void run() {
        Integer vendingMachineAmount = inputView.inputVendingMachineAmount();
        //ToDO: 자판기 동전으로 변경
        List<Product> merchandises = inputView.inputMerchandise();
        Integer amount = inputView.inputAmount();
        //ToDo: 구매 가능할 떄까지 반복
        String ToBuyProduct = inputView.inputToBuyProduct();

    }
}
