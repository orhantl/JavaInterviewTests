package easyKata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KataHalloweenTest {

    private KataHalloween kataHalloween = new KataHalloween();
    private String tricked = "Trick or treat!";
    private String thankYou =  "Thank you, strange uncle!";
    private int numberOfChildren = 3;

    @Test
    void should_return_trickOrTreat_when_there_is_a_bomb() {
        String[][] packets = {{"candy","apple","candy"},{"candy","candy"},{"candy","bomb","candy"}};
        String result = kataHalloween.trickOrTreat(numberOfChildren, packets);
        assertEquals(result, tricked);
    }

    @Test
    void should_each_child_has_one_packet() {
        String[][] packets = {{"candy","apple","candy"},{"candy","candy"}};
        String result = kataHalloween.trickOrTreat(numberOfChildren, packets);
        assertEquals(result, tricked);
    }

    @Test
    void should_return_trickOrTreat_when_there_is_less_than_two_candies_per_child() {
        String[][] packets = {{"candy","apple","candy"},{"candy","apple"},{"candy","candy"}};
        String result = kataHalloween.trickOrTreat(numberOfChildren, packets);
        assertEquals(result, tricked);
    }

    @Test
    void should_return_trickOrTreat_when_number_of_candies_is_unequal() {
        String[][] packets = {{"candy","apple","candy"},{"candy","apple", "candy", "candy", "candy"},{"candy","candy","candy"}};
        String result = kataHalloween.trickOrTreat(numberOfChildren, packets);
        assertEquals(result, tricked);
    }

    @Test
    void should_return_thank_you_strange_uncle() {
        String[][] packets = {{"candy","apple","candy"},{"candy","apple","candy"},{"candy","apple","candy"}};
        String result = kataHalloween.trickOrTreat(numberOfChildren, packets);
        assertEquals(result, thankYou);
    }
}