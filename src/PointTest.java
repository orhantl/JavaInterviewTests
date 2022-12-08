import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void checkDistance() {
        Point p1 = new Point(8, 2, 6);
        Point p2 = new Point(8, 6, 3);

        // compare return an int, 0 if it is equal
        assertTrue(Double.compare(5, p1.distance(p2)) == 0);
        assertTrue(Double.compare(5, p2.distance(p1)) == 0);
    }
}