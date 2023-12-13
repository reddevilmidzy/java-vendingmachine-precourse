package vendingmachine.repository;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.model.Item;

//TODO: static 제거하는 방향으로
public class ItemRepository {

    private static List<Item> items = new ArrayList<>();

    private ItemRepository() {
    }

    public static void addItem(Item item) {
        items.add(item);
    }

    public static Item findByItemName(String name) {
        for (Item item : items) {
            if (item.sameName(name)) {
                return item;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 상품입니다.");
    }
}
