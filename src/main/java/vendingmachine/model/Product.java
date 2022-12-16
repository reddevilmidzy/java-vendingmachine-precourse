package vendingmachine.model;

import java.util.HashMap;
import java.util.Map;

public class Product {
    private static Map<String, Integer> productCount = new HashMap<>();
    private static Map<String, Integer> productPrice = new HashMap<>();
    private static int totalCount = 0;
    private static Integer minPrice = Integer.MAX_VALUE;
    private static final int MIN_PRICE = 100;
    private static final int PRICE_UNIT = 10;
    private final String name;
    private final int count;
    private final int price;

    public Product(String name, int price, int count) {
        this.name = name;
        validate(price);
        this.price = price;
        minPrice = Math.min(price, minPrice);
        productPrice.put(name, price);
        this.count = count;
        productCount.put(name, count);
        totalCount += count;
    }

    public static boolean canBuy(Integer amount) {
        return hasProduct() && hasMoneyToBuy(amount);
    }

    public static boolean hasProduct() {
        return totalCount > 0;
    }

    public static boolean hasMoneyToBuy(Integer amount) {
        return amount > minPrice;
    }

    public static Integer getPrice(String name) {
        return productPrice.get(name);
    }

    public static void buy(String name) {
        Integer leftProductCount = productCount.get(name);
        if (leftProductCount == null) {
            throw new IllegalArgumentException("해당 제품은 판매하지 않는 상품입니다.");
        }
        if (leftProductCount == 0) {
            throw new IllegalArgumentException("해당 제품은 품절되었습니다.");
        }
        productCount.put(name, productCount.get(name)-1);
        totalCount--;
    }

    public static Map<String, Integer> getProductCount() {
        return productCount;
    }
    private void validate(int price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException("상품 가격은 최소 100원부터 시작합니다.");
        }
        if (price % PRICE_UNIT != 0) {
            throw new IllegalArgumentException("상품은 10원으로 나누어 떨어져야 합니다.");
        }
    }
}
