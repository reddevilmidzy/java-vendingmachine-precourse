package vendingmachine.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Item {

    public static final String ITEM_FORM = "\\[[ㄱ-ㅎ가-힣A-Za-z0-9]+,[0-9]+,[0-9]+]";
    public static final Pattern PATTERN = Pattern.compile(ITEM_FORM);

    private final String name;
    private final int price;
    private int quantity;

    private Item(String value) {
        String[] splitItem = value.substring(1, value.length() - 2).split(",");
        this.name = splitItem[0];
        int priceValue = validateAndConvert(splitItem[1]);
        validatePrice(priceValue);
        this.price = validateAndConvert(splitItem[1]);
        this.quantity = validateAndConvert(splitItem[2]);
    }

    private void validatePrice(int priceValue) {
        if (priceValue < 100 || priceValue % 10 != 0) {
            throw new IllegalArgumentException("올바른 범위의 숫자가 아닙니다.");
        }
    }

    public static List<Item> from(String value) {
        validateSeparator(value);
        List<String> paddedItem = Arrays.stream(value.split(";"))
                .toList();
        List<Item> result = new ArrayList<>();
        for (String item : paddedItem) {
            validateItemForm(item);
            result.add(new Item(item));
        }
        return result;
    }

    private static void validateSeparator(String value) {
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        }
        if (value.startsWith(";") || value.endsWith(";")) {
            throw new IllegalArgumentException("잘못된 구분자 위치입니다.");
        }
        if (value.contains(";;")) {
            throw new IllegalArgumentException("잘못된 구분자입니다.");
            //TODO: 상품 종류 제한 고려하기
        }
    }

    private static void validateItemForm(String value) {
        if (value.contains("[[") || value.contains("]]")) {
            throw new IllegalArgumentException("올바른 상품 폼이 아닙니다.");
        }
        if (value.contains(",,")) {
            throw new IllegalArgumentException("올바른 상품 폼이 아닙니다.");
        }
        if (!PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("올바른 상품 폼이 아닙니다.");
        }
    }

    private Integer validateAndConvert(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("올바른 숫자가 아닙니다.");
        }
    }

    @Override
    public String toString() {
        return "ItemName=" + name + " price=" + price + " quantity=" + quantity;
    }
}
