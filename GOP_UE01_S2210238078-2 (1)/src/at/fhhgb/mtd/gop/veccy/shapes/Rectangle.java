package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    private int width;
    private int height;

    //constructor
    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    //method to calculate the area
    public int area() {
        return this.width * this.height;
    }

    //return the 4 edges of the rectangle
    public int left() { return (int)this.origin.x() - width / 2; }
    public int right() { return (int)this.origin.x() + width / 2; }
    public int top() { return (int)this.origin.y() - height / 2; }
    public int bottom() { return (int)this.origin.y() + height / 2; }

    private double[][] getCoordinates() {

        // create v3 array
        Vector3[] p = new Vector3[] {
                new Vector3(left(), top(), 0),
                new Vector3( right(), top(), 0 ),
                new Vector3( right(), bottom(), 0 ),
                new Vector3( left(), bottom(), 0 )
        };

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
            // xyz, index
            d[0][i] = v[0];
            d[1][i] = v[1];
            d[2][i] = v[2];
        }
        return d;
    }

    //return rectangle representing boundingBox
    public Rectangle boundingBox() {
        return new Rectangle(
                this.left(),
                this.top(),
                this.right() - this.left(),
                this.bottom() - this.top());
    }

    //array for the 4 boundary points of the rectangle
    public Point[] getBoundaryPoints() {
        return new Point[] {
                new Point(this.left(), this.top()),
                new Point(this.right(), this.top()),
                new Point(this.right(), this.bottom()),
                new Point(this.left(), this.bottom()),
        };
    }


    public boolean isOverlapping(Rectangle other) {
        // get the 4 boundary points to test whether one of them is inside the boundary box of this rectangle
        Point[] points = this.getBoundaryPoints();

        for (Point point : points) {
            // as soon as one of the points is inside our rectangle, we return true.
            if (point.isInside(this))
                return true;
        }

        return false;
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

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
