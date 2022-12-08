import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class StringUtilsTest {

    @Test
    void shouldReverseString() {
        String toBeReversed = "something";
        StringBuilder stringBuilder = new StringBuilder(toBeReversed);
        String reversedString = stringBuilder.reverse().toString();
        Assertions.assertEquals(StringUtils.reverse(toBeReversed),reversedString);
    }

    @ParameterizedTest
    @ValueSource(strings = {"malaYam", "", "an Absolute Random String With Odd Number 2597"})
    void isProperlyReversed(String string) {
        Assertions.assertEquals(StringUtils.reverse(string),new StringBuilder(string).reverse().toString());
    }

}