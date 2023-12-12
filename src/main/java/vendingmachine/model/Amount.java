package vendingmachine.model;

public class Amount {

    private final int amount;

    private Amount(int amount) {
        this.amount = amount;
    }

    public static Amount from(String value) {
        validate(value);
        return new Amount(Integer.parseInt(value));
    }

    private static void validate(String value) {
        //TODO: 검증
    }
}
