package at.fhhgb.mtd.gop.veccy.shapes;

import org.junit.jupiter.api.Test;
import org.w3c.dom.css.Rect;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    @Test
    void area() {
        int x = Randomizer.next();
        int y = Randomizer.next();
        int r = Randomizer.next();

        Circle circle = new Circle(x, y, r);

        assertEquals(Math.PI * r * 2, circle.area());
    }

    @Test
    void boundingBox() {
        int x = Randomizer.next();
        int y = Randomizer.next();
        int r = Randomizer.next();

        Circle circle = new Circle(x, y, r);
        Rectangle boundingBox = circle.boundingBox();

        assertEquals(x - r, boundingBox.left());
        assertEquals(x + r, boundingBox.right());
        assertEquals(y - r, boundingBox.top());
        assertEquals(y + r, boundingBox.bottom());
        assertEquals(r * r, boundingBox.area());
    }
}