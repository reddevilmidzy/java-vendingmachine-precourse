package vendingmachine.View;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.Product;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String INDIVIDUAL_PRODUCT_SEPARATE = ";";

    public Integer inputVendingMachineAmount() {
        String input = readInput();
        return validateInteger(input);
    }

    public Integer inputAmount() {
        String input = readInput();
        return validateInteger(input);
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
}
