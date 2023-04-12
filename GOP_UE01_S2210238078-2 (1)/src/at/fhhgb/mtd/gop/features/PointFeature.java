package at.fhhgb.mtd.gop.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.shapes.Point;

public class PointFeature extends Feature<Point> {
    public PointFeature(CanvasModel model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Point";
    }

    @Override
    public void onMouseDrag(int x, int y) {
        // can't drag anything with a point can we
    }
}
