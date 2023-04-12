package at.fhhgb.mtd.gop.veccy.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @Test
    void PointTesting(){
        Point p = new Point(0,0);
        Point p2 = new Point(0,0);

        assertTrue(p.equals(p2));
    }
}