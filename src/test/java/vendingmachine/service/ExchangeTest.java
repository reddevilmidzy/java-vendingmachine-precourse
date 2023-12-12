package vendingmachine.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.model.Amount;
import vendingmachine.model.HoldingAmount;

class ExchangeTest {

    @Test
    @DisplayName("동전 교환")
    void createExchange() {
        //given
        Exchange exchange = new Exchange();
        Amount amount = Amount.from("1210");

        //when
        HoldingAmount holdingAmount = exchange.exchangeCoin(amount);

        //then
        int sum = holdingAmount.sum();
        assertThat(sum).isEqualTo(1210);
    }
}