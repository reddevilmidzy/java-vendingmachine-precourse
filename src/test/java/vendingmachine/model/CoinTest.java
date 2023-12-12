package vendingmachine.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoinTest {


    @Test
    @DisplayName("코인 반환")
    void createCoinList() {
        List<Integer> allValue = Coin.findAllValue();

        assertThat(allValue.size()).isEqualTo(4);
    }
}