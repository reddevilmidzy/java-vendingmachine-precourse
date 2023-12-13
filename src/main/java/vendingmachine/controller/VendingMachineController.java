package vendingmachine.controller;

import java.util.List;
import vendingmachine.model.Amount;
import vendingmachine.model.HoldingAmount;
import vendingmachine.model.Item;
import vendingmachine.repository.ItemRepository;
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
        ItemRepository itemRepository = new ItemRepository();
        registerItem(itemRepository, items);
        Amount inputAmount = inputController.getInputAmount();

        /**
         * 종료 조건
         * 1. 남은 금액이 상품의 최저 가격 낮음
         * 2. 모든 상품이 소진된 경우
         *
         * 예외 조건
         * 1. 사용자가 구매하려는 물건이 가지고 있는 돈보다 큰경우
         * IllegalStatusException
         */
        while (itemRepository.hasSomeItem() && itemRepository.canBuySome(inputAmount)) {
            outputView.printCurrentInputAmount(inputAmount);
            Item item = inputController.getBuyItem(itemRepository);
            inputAmount = inputAmount.buyItem(item);
            itemRepository.buyItem(item);

            System.out.println(itemRepository);

        }
    }

    private void registerItem(ItemRepository itemRepository, List<Item> items) {
        for (Item item : items) {
            itemRepository.addItem(item);
        }
    }
}
