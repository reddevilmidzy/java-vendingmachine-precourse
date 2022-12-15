package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.Product;

import java.util.ArrayList;
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
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String input = readInput();
        return validateInteger(input);
    }

    public Integer inputAmount() {
        System.out.println("투입 금액을 입력해 주세요.");
        String input = readInput();
        return validateInteger(input);
    }

    public List<Product> inputMerchandise() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        List<Product> result = new ArrayList<>();
        String input = readInput();
        String[] merchandises = input.split(INDIVIDUAL_PRODUCT_SEPARATE);
        for (String merchandise : merchandises) {
            result.add(splitOption(merchandise));
        }
        return result;
    }

    public String inputToBuyProduct() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        return readInput();
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
