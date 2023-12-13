package vendingmachine.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static vendingmachine.model.Item.PATTERN;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ItemTest {

    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20];[사이다,1000,]", "[[콜라,10,10]", "[]", "[콜라,100,10,10]"})
    @DisplayName("잘못된 상품 입력시 예외")
    void createInvalid(String value) {
        assertThatThrownBy(() ->
                Item.from(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20]", "[사이다,1000,10]", "[제로콜라,10000,1]"})
    @DisplayName("올바른 상품폼 확인")
    void createValid(String value) {

        boolean matches = PATTERN.matcher(value).matches();
        assertThat(matches).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"[콜라,99,10]", "[아아,3001,10]"})
    @DisplayName("상품 금액 검증 최소 100, 10으로 나누어 떨어지는지")
    void createMinPrice(String value) {
        assertThatThrownBy(() ->
                Item.from(value)).isInstanceOf(IllegalArgumentException.class);
    }
}