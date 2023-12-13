package vendingmachine.repository;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.model.Amount;
import vendingmachine.model.Item;

public class ItemRepository {

    private long inventory = 0L;
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
        inventory += item.getQuantity();
    }

    public Item findByItemName(String name) {
        for (Item item : items) {
            if (item.sameName(name)) {
                return item;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 상품입니다.");
    }

    public boolean hasSomeItem() {
        return inventory > 0;
    }

    public boolean canBuySome(Amount amount) {
        //TODO: 람다로 변경
        for (Item item : items) {
            if (item.hasItem() && amount.getAmount() >= item.getPrice()) {
                return true;
            }
        }
        return false;
    }

    public void buyItem(Item item) {
        item.buyItem();
        inventory--;
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
