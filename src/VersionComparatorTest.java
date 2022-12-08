import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class VersionComparatorTest {

    Comparator<String> vnc = new VersionComparator();

    @Test
    void compareVersionNumber() {
        assertTrue(vnc.compare("14", "14.0") == 0);
        assertTrue(vnc.compare("15", "14") > 0);
        assertTrue(vnc.compare("15.1", "14.13.10") > 0);
        assertTrue(vnc.compare("15.1", "15.1.0") == 0);
        assertTrue(vnc.compare("15.1.1", "14.13.10") > 0);
        assertTrue(vnc.compare("14.13", "14.10.55") > 0);
        assertTrue(vnc.compare("14.13.10", "14.10.55") > 0);
        assertTrue(vnc.compare("14.10.55", "14.10.20") > 0);
        assertTrue(vnc.compare("14.10.20", "14.10.20") == 0);
        assertTrue(vnc.compare("14.10.20.20", "14.10.20.20") == 0);
    }

}