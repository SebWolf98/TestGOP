package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line implements DrawableShape { //four ints to represent two endpoints of the line
    private int xFrom;
    private int yFrom;
    private int xTo;
    private int yTo;

    public Line(int xFrom, int yFrom, int xTo, int yTo) {
        //constructor
        this.xFrom = xFrom;
        this.yFrom = yFrom;
        this.xTo = xTo;
        this.yTo = yTo;
    }
    private Color fillColor;
    private Color strokeColor;

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

    //methods to calculate edges of the bounding box
    public int left() { return Math.min(xFrom, xTo); }
    //left edge is minimum of x coordiante etc
    public int right() { return Math.max(xFrom, xTo);  }
    //right edge is maximum of x coordinate
    public int top() { return Math.min(yFrom, yTo);  }
    public int bottom() { return Math.max(yFrom, yTo);  }

    public Rectangle boundingBox() { //method to return bounding box as rectangle
        return new Rectangle(
                this.left(),
                this.top(),
                this.right() - this.left(),
                this.bottom() - this.top());
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(this.strokeColor);
        graphicsContext.strokeLine(xFrom,yFrom,xTo,yTo);
    }

    public void setXFrom(int x) { this.xFrom = x; }
    public void setYFrom(int y) { this.yFrom = y; }
    public void setXTo(int x) { this.xTo = x; }
    public void setYTo(int y) { this.yTo = y; }
}
