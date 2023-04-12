package at.fhhgb.mtd.gop.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;

public class CircleFeature extends Feature<Circle> {
    public CircleFeature(CanvasModel model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public void onMouseDrag(int x, int y) {
        if (!active)
            return;

        if (activeShape == null) {
            startX = x;
            startY = y;
            activeShape = new Circle(startX, startY, 0);
            activeShape.setFillColor(model.getCurrentFillColor());
            activeShape.setStrokeColor(model.getCurrentStrokeColor());
            model.addShape(activeShape);
        } else {
            activeShape.setRadius((int) Math.sqrt((x - startX) * (x - startX) + (y - startY) * (y - startY)));
        }
    }
}
