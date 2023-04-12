package at.fhhgb.mtd.gop.math;

public class Vector3 {
    private double[] values;

    public double x() { return values[0]; }
    public double y() { return values[1]; }
    public double z() { return values[2]; }

    // Initializes values with {0.0, 0.0, 1.0}
    public Vector3() {
        values = new double[]{0.0, 0.0, 1.0};
    }

    public Vector3(double x, double y, double z) {
        values = new double[] { x, y, z, };
    }

    public Vector3(double[] values) {
        this.values = new double[3];
        for (int i = 0; i < values.length && i < 3; i++) {
            this.values[i] = values[i];
        }
    }

    public Vector3(Vector3 vector) {
        this(vector.values);
    }

    public double[] getValues() {
        return values;
    }
}
