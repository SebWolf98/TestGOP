package at.fhhgb.mtd.gop.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Vector3Test {
    @Test
    void getValues() {
        Vector3 vecOne= new Vector3();
        Vector3 vecTwo= new Vector3();
        assertArrayEquals(vecOne.getValues(), vecTwo.getValues());
    }
}
