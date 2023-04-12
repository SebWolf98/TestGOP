package at.fhhgb.mtd.gop.math;

public class TransformFactory {
    public static Matrix3 createTranslation(int deltaX, int deltaY) {
        return new Matrix3(
                new Vector3(1, 0, deltaX),
                new Vector3(0, 1, deltaY),
                new Vector3(0, 0, 1)
        );
    }

    public static Matrix3 createRotation(double radians) {
        return new Matrix3(
                new Vector3(Math.cos(radians), -Math.sin(radians), 0),
                new Vector3(Math.sin(radians), Math.cos(radians), 0),
                new Vector3(0, 0, 1)
        );
    }

    public static Matrix3 createHorizontalMirroring() {
        return new Matrix3(
                new Vector3(-1, 0, 0),
                new Vector3(0, 1, 0),
                new Vector3(0, 0, 1)
        );
    }

    public static Matrix3 createVerticalMirroring() {
        return new Matrix3(
                new Vector3(1, 0, 0),
                new Vector3(0, -1, 0),
                new Vector3(0, 0, 1)
        );
    }

    public static Matrix3 createScaling(double factorX, double factorY) {
        return new Matrix3(
                new Vector3(factorX, 0, 0),
                new Vector3(0, factorY, 0),
                new Vector3(0, 0, 1)
        );
    }
}
