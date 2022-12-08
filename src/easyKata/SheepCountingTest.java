package easyKata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SheepCountingTest {

    @Test
    public void testSomething() {
        assertEquals("", SheepCounting.countingSheep(0));
        assertEquals("1 sheep...", SheepCounting.countingSheep(1));
        assertEquals("1 sheep...2 sheep...", SheepCounting.countingSheep(2));
        assertEquals("1 sheep...2 sheep...3 sheep...", SheepCounting.countingSheep(3));
    }
}