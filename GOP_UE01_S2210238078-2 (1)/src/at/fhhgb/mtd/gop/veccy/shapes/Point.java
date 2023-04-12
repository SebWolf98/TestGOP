package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Point implements DrawableShape {
    public int x;
    public int y;
    private Color fillColor;
    private Color strokeColor;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(Point point) {
        this.x += point.x;
        this.y += point.y;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public Point copy() {
        return new Point(this.x, this.y);
    }

    public boolean isInside(Rectangle rectangle) {
        return (
                this.x >= rectangle.left() &&
                        this.x <= rectangle.right() &&
                        this.y >= rectangle.top() &&
                        this.y <= rectangle.bottom());
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(this.strokeColor);
        graphicsContext.strokeLine(x, y, x, y);
    }

    public double[][] getCoordinates() {
        double[][] coordinates = new double[2][4];
        coordinates[0][0] = x + 1;
        coordinates[1][0] = y;
        coordinates[0][1] = x;
        coordinates[1][1] = y + 1;
        coordinates[0][2] = x - 1;
        coordinates[1][2] = y;
        coordinates[0][3] = x;
        coordinates[1][3] = y - 1;

        return coordinates;
    }
}
