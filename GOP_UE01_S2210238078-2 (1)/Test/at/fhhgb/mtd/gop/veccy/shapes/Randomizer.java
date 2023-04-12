package at.fhhgb.mtd.gop.veccy.shapes;

import java.util.Random;

public class Randomizer {
    private static final Random random = new Random();

    public static int next() {
        return random.nextInt(-32, 32);
    }
    // copy this for positive numbers

    public static int next(int range) {
        return random.nextInt(-range, range);
    }
}
