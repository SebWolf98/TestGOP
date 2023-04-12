package at.fhhgb.mtd.gop.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.shapes.Line;

public class LineFeature extends Feature<Line> {
    public LineFeature(CanvasModel model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Line";
    }

    @Override
    public void onMouseDrag(int x, int y) {
        if (!active)
            return;

        if (activeShape == null) {
            startX = x;
            startY = y;
            activeShape = new Line(startX, startY, startX, startY);
            activeShape.setStrokeColor(model.getCurrentStrokeColor());
            model.addShape(activeShape);
        } else {
            activeShape.setXFrom(startX);
            activeShape.setYFrom(startY);
            activeShape.setXTo(x);
            activeShape.setYTo(y);
        }
    }
}
