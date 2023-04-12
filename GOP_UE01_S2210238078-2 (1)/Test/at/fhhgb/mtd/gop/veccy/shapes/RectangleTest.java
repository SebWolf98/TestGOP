package at.fhhgb.mtd.gop.veccy.shapes;

import org.junit.jupiter.api.Test;
import org.w3c.dom.css.Rect;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    void area() {
        int x = Randomizer.next();
        int y = Randomizer.next();
        int w = Randomizer.next();
        int h = Randomizer.next();

        Rectangle rectangle = new Rectangle(x, y, w, h);

        assertEquals(w * h, rectangle.area());
    }

    @Test
    void boundingBox() {
        int x = Randomizer.next();
        int y = Randomizer.next();
        int w = Randomizer.next();
        int h = Randomizer.next();

        Rectangle rectangle = new Rectangle(x, y, w, h);
        Rectangle boundingBox = rectangle.boundingBox();

        assertEquals(x, boundingBox.left());
        assertEquals(x + w, boundingBox.right());
        assertEquals(y, boundingBox.top());
        assertEquals(y + h, boundingBox.bottom());
    }

    @Test
    void isOverlapping() {
        int x = Randomizer.next();
        int y = Randomizer.next();
        int w = Randomizer.next() + 1;
        int h = Randomizer.next() + 1;
        Point inside = new Point(x, y);
        Point outside = new Point(x - 1, y - 1);

        Rectangle rectangle = new Rectangle(x, y, w, h);

        assertTrue(inside.isInside(rectangle));
        assertFalse(outside.isInside(rectangle));
    }
}