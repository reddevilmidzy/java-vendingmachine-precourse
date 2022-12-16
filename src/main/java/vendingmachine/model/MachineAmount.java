package vendingmachine.model;

import java.util.List;

public class MachineAmount {
    private final Integer amount;

    public MachineAmount(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(Integer amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("보유 금액은 음수가 될 수 없습니다.");
        }
    }

    public List<Integer> makeCoin() {
        return CoinMaker.makeCoin(amount);
    }
}
