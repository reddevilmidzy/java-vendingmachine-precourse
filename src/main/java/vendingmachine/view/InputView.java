package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readAmount() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String value = readLine();
        System.out.println();
        return value;
    }

    public String readItem() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String value = readLine();
        System.out.println();
        return value;
    }

    protected String readLine() {
        return Console.readLine();
    }
}
