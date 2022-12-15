package vendingmachine.model;

public class Product {
    private static final int MIN_PRICE = 100;
    private static final int PRICE_UNIT = 10;
    private String name;
    private int price;
    private int count;

    public Product(String name, int price, int count) {
        this.name = name;
        validate(price);
        this.price = price;
        this.count = count;
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
