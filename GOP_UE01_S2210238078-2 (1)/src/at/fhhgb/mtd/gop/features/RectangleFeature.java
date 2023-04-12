package at.fhhgb.mtd.gop.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;

public class RectangleFeature extends Feature<Rectangle> {
    public RectangleFeature(CanvasModel model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public void onMouseDrag(int x, int y) {
        if (!active)
            return;

        if (activeShape == null) {
            startX = x;
            startY = y;
            activeShape = new Rectangle(startX, startY, 0, 0);
            activeShape.setFillColor(model.getCurrentFillColor());
            activeShape.setStrokeColor(model.getCurrentStrokeColor());
            model.addShape(activeShape);
        } else {
            activeShape.setWidth(x - startX);
            activeShape.setHeight(y - startY);
        }
    }
}
