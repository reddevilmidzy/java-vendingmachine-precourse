package vendingmachine.model;

public class Amount {

    private final int amount;

    private Amount(int amount) {
        this.amount = amount;
    }

    public static Amount from(String value) {
        int amount = validateAndConvert(value);
        return new Amount(amount);
    }

    private static int validateAndConvert(String value) {
        validateTypeAndRange(value);
        return Integer.parseInt(value);
    }

    private static void validateTypeAndRange(String value) {
        try {
            if (Integer.parseInt(value) < 0) {
                throw new IllegalArgumentException("0이상 입력해주세요.");
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("올바른 숫자가 아닙니다.");
        }
    }

    public boolean canChange(int coin) {
        return amount >= coin;
    }

    public boolean hasAmount() {
        return amount >= 10;
    }

    public Amount exchange(int coin) {
        return new Amount(amount - coin);
    }

    public Amount buyItem(Item item) {
        return new Amount(amount - item.getPrice());
    }

    public int getAmount() {
        return amount;
    }
}
