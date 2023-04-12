package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements DrawableShape {
    protected Vector3 origin;
    protected Matrix3 transform;
    protected Color fill = Color.WHITE;
    protected Color stroke = Color.BLACK;

    public Shape(int x, int y) {
        this.origin = new Vector3(x, y, 0);
    }

    public Color getFillColor() {
        return fill;
    }

    public void setFillColor(Color fillColor) {
        this.fill = fillColor;
    }

    public Color getStrokeColor() {
        return stroke;
    }

    public void setStrokeColor(Color strokeColor) {
        this.stroke = strokeColor;
    }

    public void setTransform(Matrix3 transform) { this.transform = transform; }

    public void setOrigin(int x, int y) { this.origin = new Vector3(x, y, 0); }

    public Point getOrigin() {
        return new Point((int)origin.getValues()[0], (int)origin.getValues()[1]);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) { }
}
