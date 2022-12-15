package vendingmachine.View;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final int COUNT_INDEX = 2;
    private static final int NAME_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final String CLOSING_PARENTHESIS = "]";
    private static final String INDIVIDUAL_PRODUCT_SEPARATE = ";";
    private static final String OPEN_PARENTHESIS = "[";
    private static final String PRODUCT_OPTION_SEPARATE = ",";

    public Integer inputVendingMachineAmount() {
        String input = readInput();
        return validateInteger(input);
    }

    public Integer inputAmount() {
        String input = readInput();
        return validateInteger(input);
    }

    public List<Product> inputMerchandise() {
        List<Product> result = new ArrayList<>();
        String input = readInput();
        List<String> merchandises = Arrays.asList(input.split(INDIVIDUAL_PRODUCT_SEPARATE));
        for (String merchandise : merchandises) {
            result.add(splitOption(merchandise));
        }
        return result;
    }

    private String readInput() {
        return Console.readLine();
    }

    private Integer validateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }

    private Product splitOption(String merchandise) {
        List<String> result = List.of(merchandise.replace(OPEN_PARENTHESIS, "")
                .replace(CLOSING_PARENTHESIS, "").split(PRODUCT_OPTION_SEPARATE));
        Integer price = validateInteger(result.get(PRICE_INDEX));
        Integer count = validateInteger(result.get(COUNT_INDEX));
        return new Product(result.get(NAME_INDEX), price, count);
    }
}
