package at.fhhgb.mtd.gop.veccy.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    @Test
    void boundingBox() {
        Line line = new Line(4, 8, -2, 16);
        Rectangle boundingBox = line.boundingBox();
        assertEquals(48, boundingBox.area());
        assertEquals(-2, boundingBox.left()); // xFrom is farther to the right, so .left() should be -2, not 4.
        assertEquals(8, boundingBox.top());
        assertEquals(4, boundingBox.right());
        assertEquals(16, boundingBox.bottom());
    }
}