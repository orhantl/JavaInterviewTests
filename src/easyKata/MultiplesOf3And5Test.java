package easyKata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplesOf3And5Test {
    @Test
    public void test() {
        assertEquals(23, new MultiplesOf3And5().solution(10));
        assertEquals(0, new MultiplesOf3And5().solution(-23));
        //assertEquals(23, new MultiplesOf3And5().solution(10));
    }


}