package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public double[][] getCoordinates() {
        Vector3[] p = new Vector3[64];

        // create step iterated circle
        int j = 0;
        double n = 0;
        double step = 2 * Math.PI / p.length;
        do {
            p[j++] = new Vector3(
                    origin.x() + radius * Math.cos(n),
                    origin.y() + radius * Math.sin(n),
                    0
            );
            n += step;
        } while(j < p.length);

        // transform, if set and possible.
        if (transform != null) {
            Matrix3 back = TransformFactory.createTranslation(-(int)origin.x(), -(int)origin.y());
            Matrix3 forth = TransformFactory.createTranslation((int)origin.x(), (int)origin.y());

            for (int i = 0; i < p.length; i++) {
                // vt = Mb * Mt * Mf * vp
                p[i] = back.mult(transform.mult(forth.mult(p[i])));
            }
        }

        // convert to double array
        double[][] d = new double[3][p.length];
        for (int i = 0; i < p.length; i++) {
            double[] v = p[i].getValues();
            d[0][i] = v[0];
            d[1][i] = v[1];
            d[2][i] = v[2];
        }
        return d;
    }

    // int doesn't make sense here, sorry.
    public double area() {
        return Math.PI * this.radius * 2;
    }

    public int left() { return (int)this.origin.x() - this.radius; }
    public int right() { return (int)this.origin.x() + this.radius; }
    public int top() { return (int)this.origin.y() - this.radius; }
    public int bottom() { return (int)this.origin.y() + this.radius; }

    public Rectangle boundingBox() {
        return new Rectangle(
                this.left(),
                this.top(),
                this.right() - this.left(),
                this.bottom() - this.top());
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = getCoordinates();
        graphicsContext.setStroke(stroke);
        graphicsContext.setFill(fill);
        graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
