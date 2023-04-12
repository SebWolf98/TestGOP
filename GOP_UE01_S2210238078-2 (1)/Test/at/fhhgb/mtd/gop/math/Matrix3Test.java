package at.fhhgb.mtd.gop.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix3Test {

    @Test
    void testMatrixMult() {
        double[][] values1 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        double[][] values2 = {{9.0, 8.0, 7.0}, {6.0, 5.0, 4.0}, {3.0, 2.0, 1.0}};
        Matrix3 matrix1 = new Matrix3(values1);
        Matrix3 matrix2 = new Matrix3(values2);
        Matrix3 expectedResult = new Matrix3(new double[][]{{30.0, 24.0, 18.0}, {84.0, 69.0, 54.0}, {138.0, 114.0, 90.0}});
        Matrix3 result = matrix1.mult(matrix2);
        assertArrayEquals(expectedResult.getValues(), result.getValues());
    }

    @Test
    void testMatrixVectorMult() {
        double[][] values = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        Matrix3 matrix = new Matrix3(values);
        Vector3 vector = new Vector3(new double[]{1.0, 2.0, 3.0});
        Vector3 expectedResult = new Vector3(new double[]{14.0, 32.0, 50.0});
        Vector3 result = matrix.mult(vector);
        assertArrayEquals(expectedResult.getValues(), result.getValues());
    }

    @Test
    void testGetValues() {
        double[][] values = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        Matrix3 matrix = new Matrix3(values);
        assertArrayEquals(values, matrix.getValues());
    }
}